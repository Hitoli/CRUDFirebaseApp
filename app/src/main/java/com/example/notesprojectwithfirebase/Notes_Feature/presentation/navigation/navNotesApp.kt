package com.example.notesprojectwithfirebase.Notes_Feature.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    var NotesById: MutableState<NoteDataFirebase?>

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(Screens.HomeScreen.route) {
            HomeScreen(Notesstate, onClick = {
                navController.navigate(Screens.EditorScreen.route)
            }, onDeleteClick = { ID ->
                viewmodel.deleteNoteViewModel(ID)
            }, onSelectClick = { noteId ->
                //navController.navigate(Screens.EditorScreen.route+"/$noteId")
            })

        }
        composable(Screens.EditorScreen.route) {
            val noteID:String = remember{
                 it.arguments?.getString("noteId")?:""
            }

            EditorScreen(onClickBack = {
                navController.navigateUp()
            }, onReturnBack = {
                viewmodel.saveNoteViewModel(it)
            }, onReceiveArguments = {
                viewmodel.getNoteViewModel(noteID)
                NotesById = viewmodel.note
                NotesById.value
            })
        }


    }

}