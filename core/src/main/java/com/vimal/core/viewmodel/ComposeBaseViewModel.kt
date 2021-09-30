package com.vimal.core.viewmodel

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vimal.core.R
import com.vimal.core.models.Event
import com.vimal.core.models.LoadingMessageData
import com.vimal.core.models.MessageData
import com.vimal.core.ui.NavigationActions

abstract class ComposeBaseViewModel<Navigation> : ViewModel() {

    lateinit var navigationActions: NavigationActions<Navigation>

    private val loadingLiveData = MutableLiveData<Event<LoadingMessageData>>()
    val loading: LiveData<Event<LoadingMessageData>> = loadingLiveData

    private val infoMessageLiveData = MutableLiveData<Event<MessageData>>()
    val infoMessage: LiveData<Event<MessageData>> = infoMessageLiveData

    fun navigate(destination: Navigation, singleTop:Boolean=false, popUpTo:Navigation?=null) {
        navigationActions.navigateTo(destination,singleTop,popUpTo)
    }

    fun onBackPress() {
        navigationActions.upPress()
    }

    fun showInfoMessage(message: MessageData) {
        infoMessageLiveData.value = Event(message)
    }

    fun showLoading(@StringRes message: Int = R.string.loading) {
        val messageData = LoadingMessageData()
        messageData.isLoading = true
        messageData.messageRes = message
        showLoading(messageData)
    }

    fun hideLoading() {
        val messageData = LoadingMessageData()
        messageData.isLoading = false
        showLoading(messageData)
    }

    open fun showLoading(message: LoadingMessageData) {
        loadingLiveData.value = Event(message)
    }
}