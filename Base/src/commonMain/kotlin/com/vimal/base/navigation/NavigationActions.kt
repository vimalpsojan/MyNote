package com.vimal.base.navigation

interface NavigationActions<T> {
    val navigateTo: (destination:T, singleTop: Boolean, popUpTo: T?) -> Unit
    val upPress: () -> Unit
}