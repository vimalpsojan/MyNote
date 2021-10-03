package com.vimal.base.viewmodel

import com.vimal.base.models.Event
import com.vimal.base.models.LoadingMessageData
import com.vimal.base.models.MessageData
import com.vimal.base.navigation.NavigationActions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class ComposeBaseViewModel<Navigation> {

    lateinit var navigationActions: NavigationActions<Navigation>

    private val _loading = MutableStateFlow<Event<LoadingMessageData>?>(null)
    val loading = _loading.asStateFlow()

    private val _infoMessage = MutableStateFlow<Event<MessageData>?>(null)
    val infoMessage = _infoMessage.asStateFlow()

    fun navigate(destination: Navigation, singleTop: Boolean = false, popUpTo: Navigation? = null) {
        navigationActions.navigateTo(destination, singleTop, popUpTo)
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