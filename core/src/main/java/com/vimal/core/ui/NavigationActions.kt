package com.vimal.core.ui

interface NavigationActions<T> {
    val navigateTo: (T) -> Unit
    val upPress: () -> Unit
}