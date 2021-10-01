package com.vimal.mynote.ui.home
//
//import androidx.annotation.Keep
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.vimal.mynote.ui.BaseViewModel
//import dagger.hilt.android.lifecycle.HiltViewModel
//import javax.inject.Inject
//
//@HiltViewModel
//class HomeViewModel @Inject constructor() : BaseViewModel() {
//
//    private val _notes = MutableLiveData<List<Note>>()
//    val notes: LiveData<List<Note>> = _notes
//
//    val onSelectNote: (Note) -> Unit = {
//
//    }
//
//    init {
//        val notes = listOf(
//            HomeViewModel.Note(
//                heading = "Note 1",
//                description = "description 1",
//                lastEditedOn = "Yesterday 12:55 PM"
//            ),
//            HomeViewModel.Note(
//                heading = "Note 2",
//                description = "description 2",
//                lastEditedOn = "Today 1:03 AM"
//            ),
//            HomeViewModel.Note(
//                heading = "Note 3",
//                description = "description 3",
//                lastEditedOn = "1 Hour Ago"
//            )
//        )
//        _notes.value = notes
//    }
//
//    @Keep
//    class Note(
//        var heading: String? = null,
//        var description: String? = null,
//        var lastEditedOn: String? = null,
//    )
//}