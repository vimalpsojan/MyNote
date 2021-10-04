package com.vimal.mynote.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*
import kotlin.system.exitProcess

class NavigationController(route:String) {
//    data class Navigation(val path: String, val renderFunction: @Composable () -> Unit)

    private val destinations = ArrayList<String>()
    private val backStack = Stack<String>()

    private var lastPath:String?=null

    private val _navigation = MutableStateFlow<String>(route)
    val navigation = _navigation.asStateFlow()

    fun add(nav: String) {
        if (destinations.any { it == nav }) {
            return
        }
        destinations.add(nav)
    }


    fun navigate(path: String, param: Any? = null, addToBackStack: Boolean = true, clearTO: String? = null) {
        lastPath?.let {
            backStack.push(path)
        }
        lastPath = null
        val nav = findNavigation(path)
        clearTO?.let {
            while (!backStack.empty() && backStack.pop()!=it);
        }
        if(addToBackStack){
            lastPath = path
        }
        _navigation.value = nav
    }

    fun backNav(){
        if(backStack.empty()){
            exitProcess(0)
        }else{
            _navigation.value =findNavigation(backStack.pop())
        }
    }

    private fun findNavigation(path:String):String{
        return destinations.firstOrNull { it == path } ?: throw PathNotFoundException(path)
    }

    class DuplicatePathException(path:String) : Exception("Path Already Exists $path")
    class PathNotFoundException(path:String) : Exception("Path Don't Exists $path")
}