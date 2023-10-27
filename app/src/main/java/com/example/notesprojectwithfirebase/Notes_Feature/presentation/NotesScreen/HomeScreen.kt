package com.example.notesprojectwithfirebase.Screens

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.Consts.ConstantsOfProject
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.NotesScreen.NoteSearchNotAvailableScreen
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.NotesScreen.NotesNotAvailableScreen
import com.example.notesprojectwithfirebase.R
import com.example.notesprojectwithfirebase.ui.theme.Background1
import com.example.notesprojectwithfirebase.ui.theme.ButtonBackground1
import com.example.notesprojectwithfirebase.ui.theme.Fandango

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    ListOfNotes: List<NoteDataFirebase>,
    onClick: () -> Unit,
    onDeleteClick: (ID: String?) -> Unit,
    onSelectClick: (ID: String?) -> Unit,

) {

    val ListofSearchNotes = remember { mutableStateOf(listOf<NoteDataFirebase>()) }

    var isDialogOpen by remember {
        mutableStateOf(false)
    }
    var areNoteAvailable by remember {
        mutableStateOf(false)
    }
    var areSearchNote by remember {
        mutableStateOf("")
    }
    var isSearchOpen by remember {
        mutableStateOf(false)
    }
    var showClearButton by remember { mutableStateOf(false) }
    var longPressDetected by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf("") }


    DisposableEffect(areSearchNote) {
        ListofSearchNotes.value = emptyList()
        onDispose { /* TODO */ }
    }





    Scaffold(topBar = {
        TopAppBar(modifier = Modifier.padding(16.dp),
            title = { Text(text = "Notes", fontSize = 28.sp) },
            actions = {
                Box(modifier = Modifier
                    .background(ButtonBackground1, shape = RoundedCornerShape(24))
                    .padding(16.dp)
                    .clickable {
                        isSearchOpen = true
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = ConstantsOfProject.HomeScreenSearch,
                        tint = Color.White, modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Box(modifier = Modifier
                    .background(ButtonBackground1, shape = RoundedCornerShape(24))
                    .padding(16.dp)
                    .clickable { isDialogOpen = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.info_outline),
                        contentDescription = ConstantsOfProject.HomeScreenInfo,
                        tint = Color.White, modifier = Modifier.size(20.dp)
                    )
                }
            })
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = { onClick() },
            contentColor = ButtonBackground1,
            containerColor = Background1,
            modifier = Modifier.shadow(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add),
                tint = Color.White,
                modifier = Modifier.size(16.dp),
                contentDescription = "ADD FLOATING BUTTON"
            )
        }

    }) {
        val pad = it

        if (ListOfNotes.isNotEmpty()) {
            areNoteAvailable = true
        }
        if(!isSearchOpen){
            ListofSearchNotes.value = emptyList()
        }

        if (isDialogOpen) {
            Dialog(onDismissRequest = {
                isDialogOpen = false
            }) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = ButtonBackground1,
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(vertical = 20.dp, horizontal = 48.dp)
                    ) {
                        Column(modifier = Modifier) {
                            Row(modifier = Modifier) {
                                Text(text = ConstantsOfProject.DialogScreen1)
                                Spacer(modifier = Modifier.padding(16.dp))
                                Text(
                                    text = ConstantsOfProject.DialogScreen1A,
                                    textAlign = TextAlign.End
                                )
                            }
                            Row(modifier = Modifier) {
                                Text(text = ConstantsOfProject.DialogScreen2)
                                Spacer(modifier = Modifier.padding(16.dp))
                                Text(
                                    text = ConstantsOfProject.DialogScreen2A,
                                    textAlign = TextAlign.End
                                )
                            }
                            Row(modifier = Modifier) {
                                Text(text = ConstantsOfProject.DialogScreen3)
                                Spacer(modifier = Modifier.padding(16.dp))
                                Text(
                                    text = ConstantsOfProject.DialogScreen3A,
                                    textAlign = TextAlign.End
                                )
                            }
                            Row(modifier = Modifier) {
                                Text(text = ConstantsOfProject.DialogScreen4)
                                Spacer(modifier = Modifier.padding(16.dp))
                                Text(
                                    text = ConstantsOfProject.DialogScreen4A,
                                    textAlign = TextAlign.End
                                )
                            }
                            Row(modifier = Modifier) {
                                Text(text = ConstantsOfProject.DialogScreen5)
                                Spacer(modifier = Modifier.padding(16.dp))
                                Text(
                                    text = ConstantsOfProject.DialogScreen5A,
                                    textAlign = TextAlign.End
                                )
                            }
                        }
                    }

                }

            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, bottom = 40.dp, start = 24.dp, end = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!areNoteAvailable) {
                // Screen if no notes are found
                NotesNotAvailableScreen()
            } else {
                if (isSearchOpen) {


                    LazyColumn {
                        ListOfNotes.forEach { Note ->
                            val trimmedSearchNote = areSearchNote.trim()
                            val trimmedNoteTitle = Note.title?.trim()
                            if (trimmedNoteTitle == (trimmedSearchNote)) {
                                ListofSearchNotes.value = ListofSearchNotes.value + Note
                            }
                        }



                        items(ListofSearchNotes.value) { note ->
                            Box(
                                modifier = Modifier
                                    .background(Fandango)
                                    .combinedClickable(onLongClick = {
                                        selectedIndex = note.id ?: "000"
                                        longPressDetected = true
                                    }, onClick = {
                                        longPressDetected = false
                                        onSelectClick(note.id ?: "000")
                                    }
                                    )) {
                                if (selectedIndex == note.id && longPressDetected) {
                                    Box(
                                        modifier = Modifier
                                            .background(Color.Red)
                                            .padding(30.dp)
                                            .fillMaxWidth()
                                            .combinedClickable(onLongClick = {
                                                onDeleteClick(selectedIndex)
                                                longPressDetected = true
                                            }, onClick = {
                                                longPressDetected = false

                                            }
                                            )) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.delete),
                                            contentDescription = ConstantsOfProject.HomeScreenInfo,
                                            tint = Color.White, modifier = Modifier
                                                .size(40.dp)
                                                .align(Alignment.Center)
                                        )
                                    }
                                } else {

                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .combinedClickable(onLongClick = {
                                            selectedIndex = note.id ?: ""
                                            longPressDetected = true
                                        }, onClick = {
                                            longPressDetected = false
                                            onSelectClick(note.id ?: "000")
                                        }
                                        )
                                        .padding(end = 32.dp)
                                        .clickable {
                                            onSelectClick(selectedIndex)
                                        }) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(16.dp)
                                                .combinedClickable(onLongClick = {
                                                    selectedIndex = note.id ?: ""
                                                    longPressDetected = true

                                                }, onClick = {
                                                    longPressDetected = false
                                                    onSelectClick(note.id)
                                                }
                                                )
                                                .padding(end = 32.dp),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                text = note.title!!,
                                                style = MaterialTheme.typography.headlineMedium,
                                                color = MaterialTheme.colorScheme.onSurface,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Spacer(modifier = Modifier.size(30.dp))
                                            Text(
                                                text = note.content!!,
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = MaterialTheme.colorScheme.onSurface,
                                                maxLines = 10,
                                                overflow = TextOverflow.Ellipsis
                                            )

                                        }
                                    }

                                }


                            }
                            Spacer(modifier = Modifier.size(30.dp))

                        }
                    }
                } else {
                    LazyColumn {
                        items(ListOfNotes) { note ->
                            var colorOnNotes by remember{
                                mutableStateOf(NoteDataFirebase.colorInt.random())
                            }
                            Box(
                                modifier = Modifier
                                    .background(colorOnNotes, shape = RoundedCornerShape(10.dp))
                                    .combinedClickable(onLongClick = {
                                        selectedIndex = note.id ?: "000"
                                        longPressDetected = true
                                    }, onClick = {
                                        longPressDetected = false
                                        onSelectClick(note.id?:"000")
                                    }
                                    )) {
                                if (selectedIndex == note.id && longPressDetected) {
                                    Box(
                                        modifier = Modifier
                                            .background(Color.Red)
                                            .padding(30.dp)
                                            .fillMaxWidth()
                                            .combinedClickable(onLongClick = {
                                                onDeleteClick(selectedIndex)
                                                longPressDetected = true
                                            }, onClick = {
                                                longPressDetected = false

                                            }
                                            )) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.delete),
                                            contentDescription = ConstantsOfProject.HomeScreenInfo,
                                            tint = Color.White, modifier = Modifier
                                                .size(40.dp)
                                                .align(Alignment.Center)
                                        )
                                    }
                                } else {

                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .combinedClickable(onLongClick = {
                                            selectedIndex = note.id ?: ""
                                            longPressDetected = true
                                        }, onClick = {
                                            longPressDetected = false
                                            onSelectClick(note.id)
                                        }
                                        )
                                        .padding(end = 32.dp)
                                        ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(16.dp)
                                                .combinedClickable(onLongClick = {
                                                    selectedIndex = note.id ?: ""
                                                    longPressDetected = true

                                                }, onClick = {
                                                    longPressDetected = false
                                                    onSelectClick(note.id)
                                                }
                                                )
                                                .padding(end = 32.dp),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                text = note.title!!,
                                                style = MaterialTheme.typography.headlineMedium,
                                                color = Color.Black,
                                                fontSize = 25.sp,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis,
                                                textAlign = TextAlign.Center
                                            )
                                            Spacer(modifier = Modifier.size(30.dp))
                                            Text(
                                                text = note.content!!,
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontSize = 18.sp,
                                                color = Color.Black,
                                                maxLines = 10,
                                                overflow = TextOverflow.Ellipsis,
                                                textAlign = TextAlign.Center
                                            )

                                        }
                                    }

                                }


                            }
                            Spacer(modifier = Modifier.size(30.dp))

                        }
                    }
                }

            }

        }
    }
    if (isSearchOpen) {
        if(ListofSearchNotes.value.isEmpty() ||areSearchNote.isEmpty() && isSearchOpen){
            NoteSearchNotAvailableScreen()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Background1)
                .padding(16.dp)
        ) {
            OutlinedTextField(value = areSearchNote, onValueChange = {
                areSearchNote = it
            }, modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    showClearButton = true
                }, leadingIcon = {
                IconButton(onClick = {
                    Log.e("areSearchNote", ListofSearchNotes.toString())
                    Log.e("areSearchNote", areSearchNote)

                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "SEARCH",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }, trailingIcon = {
                AnimatedVisibility(
                    visible = showClearButton,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    IconButton(onClick = {

                        isSearchOpen = false
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.close),
                            contentDescription = "SEARCH",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }, colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.White, focusedBorderColor = Color.White
            ), placeholder = {
                Text(text = "Search...", color = Color.White)
            })
        }
    }

}





