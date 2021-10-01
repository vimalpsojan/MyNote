package com.vimal.andoidbase.viewmodel

import androidx.lifecycle.ViewModel
import com.vimal.andoidbase.models.Event
import com.vimal.andoidbase.models.LoadingMessageData
import com.vimal.andoidbase.models.MessageData
import com.vimal.andoidbase.navigation.NavigationActions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class ComposeBaseViewModel<Navigation> : ViewModel() {

    lateinit var navigationActions: NavigationActions<Navigation>

    private val _loading = MutableStateFlow<Event<LoadingMessageData>?>(null)
    val loading = _loading.asStateFlow()

    private val _infoMessage = MutableStateFlow<Event<MessageData>?>(null)
    val infoMessage = _infoMessage.asStateFlow()

    fun navigate(destination: Navigation, singleTop:Boolean=false, popUpTo:Navigation?=null) {
        navigationActions.navigateTo(destination,singleTop,popUpTo)
    }

    fun onBackPress() {
        navigationActions.upPress()
    }

    fun showInfoMessage(message: MessageData) {
        _infoMessage.value = Event(message)
    }

    fun showLoading(message: String) {
        val messageData = LoadingMessageData()
        messageData.isLoading = true
        showLoading(messageData)
    }

    fun hideLoading() {
        val messageData = LoadingMessageData()
        messageData.isLoading = false
        showLoading(messageData)
    }

    open fun showLoading(message: LoadingMessageData) {
        _loading.value = Event(message)
    }

}