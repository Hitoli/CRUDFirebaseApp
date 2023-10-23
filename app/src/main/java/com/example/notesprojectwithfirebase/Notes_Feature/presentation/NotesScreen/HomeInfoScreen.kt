package com.example.notesprojectwithfirebase.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.notesprojectwithfirebase.Notes_Feature.utils.Consts.ConstantsOfProject
import com.example.notesprojectwithfirebase.ui.theme.ButtonBackground1


@Composable
fun InfoDialog() {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = ButtonBackground1,
        ) {
            Box(
                contentAlignment = Alignment.Center,modifier = Modifier.padding(vertical = 20.dp, horizontal = 48.dp)
            ){
                Column(modifier = Modifier) {
                    Row(modifier = Modifier) {
                        Text(text = ConstantsOfProject.DialogScreen1)
                        Spacer(modifier = Modifier.padding(16.dp))
                        Text(text = ConstantsOfProject.DialogScreen1A, textAlign = TextAlign.End)
                    }
                    Row(modifier = Modifier) {
                        Text(text = ConstantsOfProject.DialogScreen2)
                        Spacer(modifier = Modifier.padding(16.dp))
                        Text(text = ConstantsOfProject.DialogScreen2A, textAlign = TextAlign.End)
                    }
                    Row(modifier = Modifier) {
                        Text(text = ConstantsOfProject.DialogScreen3)
                        Spacer(modifier = Modifier.padding(16.dp))
                        Text(text = ConstantsOfProject.DialogScreen3A, textAlign = TextAlign.End)
                    }
                    Row(modifier = Modifier) {
                        Text(text = ConstantsOfProject.DialogScreen4)
                        Spacer(modifier = Modifier.padding(16.dp))
                        Text(text = ConstantsOfProject.DialogScreen4A, textAlign = TextAlign.End)
                    }
                    Row(modifier = Modifier) {
                        Text(text = ConstantsOfProject.DialogScreen5)
                        Spacer(modifier = Modifier.padding(16.dp))
                        Text(text = ConstantsOfProject.DialogScreen5A, textAlign = TextAlign.End)
                    }
                }
            }

        }

    }

}