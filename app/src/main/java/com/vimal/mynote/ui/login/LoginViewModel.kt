package com.vimal.mynote.ui.login
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.vimal.mynote.data.repositories.LoginRepository
//import com.vimal.mynote.ui.BaseViewModel
//import com.vimal.mynote.ui.MainDestinations
//import dagger.hilt.android.lifecycle.HiltViewModel
//import javax.inject.Inject
//
//@HiltViewModel
//class LoginViewModel @Inject constructor(private val repository: LoginRepository) :
//    BaseViewModel() {
//
//    private val _userName = MutableLiveData<String>()
//    val userName: LiveData<String> = _userName
//
//    private val _password = MutableLiveData<String>()
//    val password: LiveData<String> = _password
//
//    private val _enableLogin = MutableLiveData<Boolean>().apply { value = false }
//    val enableLogin: LiveData<Boolean> = _enableLogin
//
//    val onUserName: (String) -> Unit = { userName: String ->
//        _userName.value = userName
//        validate(showUserNameError = true)
//    }
//
//    val onPassword: (String) -> Unit = { password: String ->
//        _password.value = password
//        validate(showPassWordError = true)
//    }
//
//    private fun validate(showUserNameError: Boolean = false, showPassWordError: Boolean = false) {
//        _enableLogin.value =
//            validateUserName(showUserNameError) && validatePassword(showPassWordError)
//    }
//
//    private fun validateUserName(showError: Boolean = false): Boolean {
//        return !_userName.value.isNullOrBlank() && _userName.value?.length ?: 0 >= 5
//    }
//
//    private fun validatePassword(showError: Boolean = false): Boolean {
//        return !_password.value.isNullOrBlank() && _password.value?.length ?: 0 >= 5
//    }
//
//    val onLogin: () -> Unit = {
//        val userName = _userName.value
//        val password = _password.value
//        if (!userName.isNullOrBlank() && !password.isNullOrBlank()) {
//            callLoginAPI(userName, password)
//        }
//    }
//
//    private fun callLoginAPI(userName: String, password: String) {
//        showLoading()
//        repository.login(userName, password).subscribe({
//            hideLoading()
//            navigate(
//                destination = MainDestinations.HOME,
//                singleTop = true,
//                popUpTo = MainDestinations.MAIN
//            )
//        }, {
//            hideLoading()
//        }).add()
//    }
//}