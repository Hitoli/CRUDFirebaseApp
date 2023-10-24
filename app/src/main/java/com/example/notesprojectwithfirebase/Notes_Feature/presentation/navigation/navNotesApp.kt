package com.example.notesprojectwithfirebase.Notes_Feature.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.EditScreen.EditorSaveDialog
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.EditScreen.EditorScreen
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.navigation.navUtils.Screens
import com.example.notesprojectwithfirebase.Screens.HomeScreen


@Composable
fun navNotesApp(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route){
        composable(Screens.HomeScreen.route){
            HomeScreen(){
                navController.navigate(Screens.EditorScreen.route)
            }
        }
        composable(Screens.EditorScreen.route){
            EditorScreen(){
                navController.navigate(Screens.HomeScreen.route)
            }
        }
        composable(Screens.EditorNoteSaveScreen.route){
            EditorSaveDialog()
        }


    }

}