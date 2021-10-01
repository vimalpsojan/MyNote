package com.vimal.mynote.ui.splash

import com.vimal.mynote.data.repositories.SplashViewRepository
import com.vimal.core.viewmodel.BaseViewModel
import com.vimal.core.vnavigation.MainDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: SplashViewRepository) :
    BaseViewModel() {

    init {
        CoroutineScope(Dispatchers.IO).launch {
            delay(TimeUnit.SECONDS.toMillis(3))
            withContext(Dispatchers.Main){
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