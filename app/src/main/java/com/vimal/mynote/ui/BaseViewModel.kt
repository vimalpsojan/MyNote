package com.vimal.mynote.ui

import com.vimal.core.viewmodel.ComposeBaseViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ComposeBaseViewModel<MainDestinations>() {
    private val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun Disposable.add(){
        compositeDisposable.add(this)
    }
}