package com.example.notesprojectwithfirebase.Notes_Feature.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.EditScreen.EditorScreen
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.navigation.navUtils.Screens
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.viewmodel.NoteViewModel
import com.example.notesprojectwithfirebase.Screens.HomeScreen


@Composable
fun navNotesApp(navController: NavHostController) {
    val viewmodel = hiltViewModel<NoteViewModel>()
    val Notesstate by viewmodel.noteList.collectAsState()
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route){
        composable(Screens.HomeScreen.route){
            HomeScreen(Notesstate){
                navController.navigate(Screens.EditorScreen.route)
            }
        }
        composable(Screens.EditorScreen.route){
            EditorScreen(onClickBack = {
                navController.navigateUp()
            }, onReturnBack = {
                viewmodel.saveNoteViewModel(it)
            })
        }



    }

}