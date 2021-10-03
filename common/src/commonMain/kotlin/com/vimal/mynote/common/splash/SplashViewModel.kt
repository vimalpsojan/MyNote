package com.vimal.mynote.common.splash

import com.vimal.base.threading.Background
import com.vimal.base.threading.Main
import com.vimal.core.navigation.MainDestinations
import com.vimal.core.viewmodel.BaseViewModel
import com.vimal.mynote.common.data.repositories.SplashViewRepository
import kotlinx.coroutines.*
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class SplashViewModel constructor(private val repository: SplashViewRepository) : BaseViewModel() {
    init {
        CoroutineScope(Background).launch {
            delay(Duration.seconds(3).inWholeMilliseconds)
            withContext(Main){
                gotoNextScreen()
            }
        }
    }

    private fun gotoNextScreen() {
        navigate(
            destination = if (repository.isLoginUser()) MainDestinations.HOME else MainDestinations.LOGIN,
            singleTop = true,
            popUpTo = MainDestinations.MAIN
        )
    }
}