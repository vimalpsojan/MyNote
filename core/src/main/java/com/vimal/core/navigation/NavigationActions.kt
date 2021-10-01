package com.vimal.core.navigation

interface NavigationActions<T> {
    val navigateTo: (T,singleTop:Boolean,popUpTo:T?) -> Unit
    val upPress: () -> Unit
}