package com.vimal.home.ui

import androidx.annotation.Keep
import com.vimal.core.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    private val _notes = MutableStateFlow(ArrayList<Note>().toList())
    val notes  = _notes.asStateFlow()

    val onSelectNote: (Note) -> Unit = {

    }

    init {
        val notes = listOf(
            HomeViewModel.Note(
                heading = "Note 1",
                description = "description 1",
                lastEditedOn = "Yesterday 12:55 PM"
            ),
            HomeViewModel.Note(
                heading = "Note 2",
                description = "description 2",
                lastEditedOn = "Today 1:03 AM"
            ),
            HomeViewModel.Note(
                heading = "Note 3",
                description = "description 3",
                lastEditedOn = "1 Hour Ago"
            )
        )
        _notes.value = notes
    }

    @Keep
    class Note(
        var heading: String? = null,
        var description: String? = null,
        var lastEditedOn: String? = null,
    )
}