package com.vimal.base.models

open class MessageData constructor() {

    var titleStr: String? = null
    var messageStr: String? = null
    var positiveButtonStr: String? = null
    var negativeButtonStr: String? = null
    var neutralButtonStr: String? = null
    var positiveAction: (() -> Unit)? = null
    var negativeAction: (() -> Unit)? = null
    var triggerActionOnDismiss: Boolean = false
    var canDismiss: Boolean = true
    var autoDismiss: Boolean = true

    fun getTitle(): String? {
        return titleStr
    }

    fun getMessage(): String? {
        return messageStr
    }

    fun getPositiveButton(): String? {
        return positiveButtonStr
    }

    fun getNegativeButton(): String? {
        return negativeButtonStr
    }

    fun getNeutralButton(): String? {
        return neutralButtonStr
    }

}