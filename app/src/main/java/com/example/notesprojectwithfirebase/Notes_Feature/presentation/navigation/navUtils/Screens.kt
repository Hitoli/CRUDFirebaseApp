package com.example.notesprojectwithfirebase.Notes_Feature.presentation.navigation.navUtils

sealed class Screens(val route:String){
    object EditorScreen:Screens("EditorScreen")

    object HomeScreen:Screens("HomeScreen")
}