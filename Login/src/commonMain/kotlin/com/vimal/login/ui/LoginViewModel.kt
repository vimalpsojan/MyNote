package com.vimal.login.ui

import com.vimal.base.models.MessageData
import com.vimal.base.threading.Background
import com.vimal.core.navigation.MainDestinations
import com.vimal.core.viewmodel.BaseViewModel
import com.vimal.login.data.repositories.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginViewModel constructor(private val repository: LoginRepository) : BaseViewModel() {

    private val _userName = MutableStateFlow("")
    val userName = _userName.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _enableLogin = MutableStateFlow(false)
    val enableLogin = _enableLogin.asStateFlow()

    val onUserName: (String) -> Unit = { userName: String ->
        _userName.value = userName
        validate(showUserNameError = true)
    }

    val onPassword: (String) -> Unit = { password: String ->
        _password.value = password
        validate(showPassWordError = true)
    }

    private fun validate(showUserNameError: Boolean = false, showPassWordError: Boolean = false) {
        _enableLogin.value =
            validateUserName(showUserNameError) && validatePassword(showPassWordError)
    }

    private fun validateUserName(showError: Boolean = false): Boolean {
        return _userName.value.isNotBlank() && (_userName.value.length ?: 0) >= 5
    }

    private fun validatePassword(showError: Boolean = false): Boolean {
        return _password.value.isNotBlank() && (_password.value.length ?: 0) >= 5
    }

    val onLogin: () -> Unit = {
        val userName = _userName.value
        val password = _password.value
        if (userName.isNotBlank() && password.isNotBlank()) {
            callLoginAPI(userName, password)
        }
    }

    private fun callLoginAPI(userName: String, password: String) {
        showLoading("Loading")
        CoroutineScope(Background).launch {
            try {
                val date = repository.login(userName, password)
                withContext(Dispatchers.Main) {
                    if (date.isSuccess) {
                        navigate(
                            destination = MainDestinations.HOME,
                            singleTop = true,
                            popUpTo = MainDestinations.MAIN
                        )
                    }else{
                        hideLoading()
                        showInfoMessage(getMessage(true))
                    }
                }
            }catch (ex:Exception){
                ex.printStackTrace()
                withContext(Dispatchers.Main){
                    hideLoading()
                    showInfoMessage(getMessage(false))
                }
            }
        }
    }

    fun getMessage(isLoginFail:Boolean): MessageData {
        val messageData = MessageData()
        messageData.autoDismiss = isLoginFail
        messageData.titleStr = if(isLoginFail) "Login Failed" else "Failed"
        messageData.messageStr = if(isLoginFail) "Wrong Username or Password"  else "Network Error"
        if(!isLoginFail){
            messageData.positiveButtonStr = "Try Again"
            messageData.positiveAction = onLogin
        }
        return messageData
    }
}