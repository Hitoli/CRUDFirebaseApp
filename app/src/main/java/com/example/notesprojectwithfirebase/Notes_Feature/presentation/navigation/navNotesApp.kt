package com.example.notesprojectwithfirebase.Notes_Feature.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.EditScreen.EditorScreen
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.navigation.navUtils.Screens
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.viewmodel.NoteViewModel
import com.example.notesprojectwithfirebase.Screens.HomeScreen


@Composable
fun navNotesApp(navController: NavHostController) {
    val viewmodel = hiltViewModel<NoteViewModel>()
    val Notesstate by viewmodel.noteList.collectAsState()
    val NoteList:MutableList<NoteDataFirebase> = mutableListOf()
    var NotesById = remember {
        mutableStateOf(NoteDataFirebase())
    }

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(Screens.HomeScreen.route) {
            HomeScreen(Notesstate, onClick = {
                navController.navigate(Screens.EditorScreen.route+ "/000")
            }, onDeleteClick = { ID ->
                viewmodel.deleteNoteViewModel(ID!!)
            }, onSelectClick = { noteId ->
                Log.e("VALUESEXISTS", noteId.toString())
                navController.navigate(Screens.EditorScreen.route + "/${noteId}")

            }, onSearchClick = {title->
                NoteList.clear()
                viewmodel.noteList.value.forEach {
                    if(it.title ==title ){
                        NoteList.add(it)
                    }
                }
                Log.e("NoteList", NoteList.toString())
               NoteList

            }, onClearSearchClick = {
                NoteList.clear()
                Log.e("NoteList", NoteList.toString())
            })

        }
        composable(Screens.EditorScreen.route + "/{id}?",
            arguments = listOf(navArgument("id") {
                type = NavType.StringType
                defaultValue = ""
                nullable = true
            }
            )) {
            val noteID: String = remember {
                it.arguments?.getString("id") ?: ""
            }

            EditorScreen(onClickBack = {
                navController.navigateUp()
            }, onReturnBack = {
                viewmodel.saveNoteViewModel(it)
            }, onReceiveArguments = {
                Log.e("VALUESEXISTS", noteID.toString())
                viewmodel.noteList.value.forEach {
                    if (it.id == noteID) {
                        Log.e("VALUESEXISTSISD", it.id.toString())
                        NotesById.value = it
                    }
                }
                if(noteID=="000"){
                    NotesById.value = NoteDataFirebase(id="", title = "",content = "", timeStamp = "")
                }
                Log.e("Navigation getting Note by ID", viewmodel.note.toString())
                Log.e("Navigation getting Note by ID", NotesById.value.toString())
                NotesById.value
            })

        }

    }

}