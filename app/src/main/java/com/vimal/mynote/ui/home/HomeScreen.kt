package com.vimal.mynote.ui.home
//
//import android.content.res.Configuration
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.foundation.shape.CornerSize
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.material.MaterialTheme.typography
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.tooling.preview.Devices
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.google.accompanist.insets.systemBarsPadding
//import com.vimal.mynote.R
//import com.vimal.mynote.ui.theme.MyNoteTheme
//import com.vimal.mynote.ui.utils.InsetAwareTopAppBar
//import com.vimal.mynote.ui.utils.isScrolled
//
//@Composable
//fun HomeScreen(
//    viewModel: HomeViewModel,
//    scaffoldState: ScaffoldState = rememberScaffoldState()
//) {
//    val notes by viewModel.notes.observeAsState()
//    HomeScreen(
//        notes = notes,
//        onSelectNote = viewModel.onSelectNote,
//        scaffoldState = scaffoldState
//    )
//}
//
//@Composable
//fun HomeScreen(
//    notes: List<HomeViewModel.Note>?,
//    onSelectNote: (HomeViewModel.Note) -> Unit,
//    scaffoldState: ScaffoldState
//) {
//    val scrollState = rememberLazyListState()
//    Scaffold(
//        scaffoldState = scaffoldState,
//        snackbarHost = { SnackbarHost(hostState = it, modifier = Modifier.systemBarsPadding()) },
//        topBar = {
//            val title = stringResource(id = R.string.app_name)
//            InsetAwareTopAppBar(
//                title = {
//                    Row(
//                        horizontalArrangement = Arrangement.Center,
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(bottom = 4.dp, top = 10.dp)
//                    ) {
//                        Icon(
//                            painter = painterResource(R.drawable.ic_notes),
//                            contentDescription = title,
//                            tint = MaterialTheme.colors.onBackground,
//                            modifier = Modifier
//                        )
//                        Text(
//                            text = title,
//                            textAlign = TextAlign.Center,
//                            modifier = Modifier
//                        )
//                    }
//                },
//                backgroundColor = MaterialTheme.colors.surface,
//                elevation = if (!scrollState.isScrolled) 0.dp else 4.dp
//            )
//        }
//    ) { innerPadding ->
//        val modifier = Modifier.padding(innerPadding)
//        notes?.let { notes ->
//            LazyColumn(
//                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
//                modifier = modifier.fillMaxSize()
//            ) {
//                items(items = notes, itemContent = { note ->
//                    NoteItem(note = note, Modifier.clickable {
//                        onSelectNote(note)
//                    })
//                })
//            }
//        }
//    }
//}
//
//@Composable
//fun NoteItem(note: HomeViewModel.Note, modifier: Modifier = Modifier) {
//    Card(
//        modifier = Modifier
//            .padding(horizontal = 8.dp, vertical = 8.dp)
//            .fillMaxWidth(),
//        elevation = 2.dp,
//        shape = RoundedCornerShape(corner = CornerSize(16.dp))
//    ) {
//        Column(
//            modifier = modifier
//                .padding(16.dp)
//                .fillMaxWidth()
//        ) {
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text(text = note.heading ?: "", style = typography.h6)
//                Text(text = note.lastEditedOn ?: "", style = typography.overline)
//            }
//            Text(
//                text = note.description ?: "",
//                style = typography.caption,
//                maxLines = 2,
//                overflow = TextOverflow.Ellipsis
//            )
//        }
//    }
//}
//
//
//@Preview("Home Screen")
//@Preview("Home Screen (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Preview("Home Screen (big font)", fontScale = 1.5f)
//@Preview("Home Screen (large screen)", device = Devices.PIXEL_C)
//@Composable
//fun PreviewSplashScreen() {
//    MyNoteTheme {
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
//        HomeScreen(notes = notes, onSelectNote = {}, scaffoldState = rememberScaffoldState())
//    }
//}