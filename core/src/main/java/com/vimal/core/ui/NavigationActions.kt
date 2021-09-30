package com.vimal.core.ui

interface NavigationActions<T> {
    val navigateTo: (T,singleTop:Boolean,popUpTo:T?) -> Unit
    val upPress: () -> Unit
}