package com.example.notesprojectwithfirebase.Notes_Feature.presentation.NotesScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.Consts.ConstantsOfProject
import com.example.notesprojectwithfirebase.R

@Composable
fun NotesNotAvailableScreen() {
    Image(
        painter = painterResource(id = R.drawable.rafiki),
        contentDescription = ConstantsOfProject.HomeScreenNotesIcon,
        modifier = Modifier.size(350.dp)
    )
    Spacer(modifier = Modifier.padding(8.dp))

    Text(
        text = ConstantsOfProject.HomeScreenNotesIconTagLine,
        color = Color.White,
        fontSize = 20.sp
    )
}