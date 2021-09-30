package com.vimal.mynote.ui.splash

import com.vimal.mynote.data.repositories.SplashViewRepository
import com.vimal.mynote.ui.BaseViewModel
import com.vimal.mynote.ui.MainDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: SplashViewRepository) :
    BaseViewModel() {

    init {
        Observable.timer(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                gotoNextScreen()
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