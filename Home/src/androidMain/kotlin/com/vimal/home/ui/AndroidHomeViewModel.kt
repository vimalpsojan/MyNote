package com.vimal.home.ui

import com.vimal.core.viewmodel.AppAndroidViewModel

class AndroidHomeViewModel constructor(viewModel: HomeViewModel): AppAndroidViewModel<HomeViewModel>(viewModel) {

    val onSelectNote: (HomeViewModel.Note) -> Unit = viewModel.onSelectNote
    val notes = viewModel.notes

}