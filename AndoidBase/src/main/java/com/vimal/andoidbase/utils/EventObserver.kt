package com.vimal.andoidbase.utils

import androidx.lifecycle.Observer
import com.vimal.andoidbase.models.Event

/**
 * An [Observer] for [Event]s, simplifying the pattern of checking if the [Event]'s content has
 * already been handled.
 *
 * [onEventUnhandledContent] is *only* called if the [Event]'s contents has not been handled.
 */
//TODO Change for State Flow
class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.get()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}