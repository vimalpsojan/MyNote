package com.vimal.mynote.ui.splash

import androidx.lifecycle.ViewModel
import com.vimal.mynote.data.repositories.SplashViewRepository
import com.vimal.mynote.ui.MainDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: SplashViewRepository) :
    ViewModel() {
    private val _navigate = MutableStateFlow("")
    val navigate: StateFlow<String> = _navigate.asStateFlow()

    init {
        Observable.timer(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                gotoNextScreen()
            }
    }

    private fun gotoNextScreen() {
        _navigate.update {
            if (repository.isLoginUser())
                MainDestinations.HOME
            else
                MainDestinations.LOGIN
        }
    }
}