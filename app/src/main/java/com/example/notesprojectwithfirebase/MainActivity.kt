package com.example.notesprojectwithfirebase

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.EditScreen.EditorSaveDialog
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.EditScreen.EditorScreen
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.navigation.navNotesApp
import com.example.notesprojectwithfirebase.ui.theme.NotesProjectWithFirebaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesProjectWithFirebaseTheme {
                // A surface container using the 'background' color from the theme
                val navHostController:NavHostController = rememberNavController()
                navNotesApp(navController = navHostController)

            }
        }
    }
}



@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun GreetingPreview() {
    NotesProjectWithFirebaseTheme {
        EditorSaveDialog()
    }
}