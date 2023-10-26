package com.example.notesprojectwithfirebase.Notes_Feature.presentation.EditScreen


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.presentation.Consts.ConstantsOfProject
import com.example.notesprojectwithfirebase.R
import com.example.notesprojectwithfirebase.ui.theme.ButtonBackground1

// What does visibility Icon does no idea
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditorScreen(
    onClickBack: () -> Unit,
    onReturnBack: (noteDataFirebase: NoteDataFirebase) -> Unit,
    onReceiveArguments:() -> NoteDataFirebase?,
) {
    val currenttime: Long = System.currentTimeMillis() / 60000



    var isTitleHintVisible by remember { mutableStateOf("") }
    var isContentHintVisible by remember { mutableStateOf("") }

    if(onReceiveArguments()?.id!="000") {
        isContentHintVisible = onReceiveArguments()?.content!!
        isTitleHintVisible = onReceiveArguments()?.title!!
        Log.e("VALUESEXISTSEDitor000", isTitleHintVisible)
        Log.e("VALUESEXISTS000", isContentHintVisible)
    }


    val FirebaseDatabaseTitle = remember {
        mutableStateOf(isTitleHintVisible)
    }
    val FirebaseDatabaseContent = remember {
        mutableStateOf(isContentHintVisible)
    }
    Log.e("VALUESEXISTSEDitor", isTitleHintVisible)
    Log.e("VALUESEXISTS", isContentHintVisible)



    var isDialogSaveOpen by remember {
        mutableStateOf(false)
    }
    var isSaveButton by remember {
        mutableStateOf(false)
    }



    Scaffold(topBar = {
        TopAppBar(
            modifier = Modifier.padding(16.dp),
            title = { Text(text = "") },
            navigationIcon = {
                Box(modifier = Modifier
                    .background(ButtonBackground1, shape = RoundedCornerShape(24))
                    .padding(16.dp)
                    .clickable { onClickBack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_left),
                        contentDescription = ConstantsOfProject.HomeScreenInfo,
                        tint = Color.White, modifier = Modifier.size(20.dp)
                    )
                }

            },
            actions = {
                if (!isSaveButton) {
                    Box(modifier = Modifier
                        .background(ButtonBackground1, shape = RoundedCornerShape(24))
                        .padding(16.dp)
                        .clickable { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.visibility),
                            contentDescription = ConstantsOfProject.HomeScreenInfo,
                            tint = Color.White, modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Box(modifier = Modifier
                        .background(ButtonBackground1, shape = RoundedCornerShape(24))
                        .padding(16.dp)
                        .clickable { isDialogSaveOpen = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.save),
                            contentDescription = ConstantsOfProject.HomeScreenInfo,
                            tint = Color.White, modifier = Modifier.size(20.dp)
                        )
                    }
                } else {
                    Box(modifier = Modifier
                        .background(ButtonBackground1, shape = RoundedCornerShape(24))
                        .padding(16.dp)
                        .clickable { isSaveButton = false }) {
                        Icon(
                            painter = painterResource(id = R.drawable.mode),
                            contentDescription = ConstantsOfProject.HomeScreenInfo,
                            tint = Color.White, modifier = Modifier.size(20.dp)
                        )
                    }
                }
            })
    }) {
        val pad = it
        if (isDialogSaveOpen) {
            Dialog(onDismissRequest = { isDialogSaveOpen = false }) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = ButtonBackground1,
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(vertical = 20.dp, horizontal = 48.dp)
                    ) {
                        Column(modifier = Modifier) {
                            Icon(
                                painter = painterResource(id = R.drawable.info_outline),
                                contentDescription = ConstantsOfProject.HomeScreenInfo,
                                tint = Color.White, modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.padding(20.dp))
                            Text(text = "Save Changes!", textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.padding(20.dp))
                            Row(modifier = Modifier) {
                                Button(
                                    onClick = {
                                        isSaveButton = false
                                        isDialogSaveOpen = false
                                    }, colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Red,
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text(text = "Discard", textAlign = TextAlign.Center)
                                }
                                Spacer(modifier = Modifier.padding(20.dp))
                                Button(
                                    onClick = {
                                        isSaveButton = true
                                        isDialogSaveOpen = false
                                        onReturnBack(
                                            NoteDataFirebase(
                                                id = "",
                                                title = FirebaseDatabaseTitle.value,
                                                content = FirebaseDatabaseContent.value,
                                                timeStamp = currenttime.toString()
                                            )
                                        )
                                    }, colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Green,
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text(text = "Save", textAlign = TextAlign.Center)
                                }
                            }
                        }
                    }

                }

            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(pad)
        ) {
            BasicTextField(value = FirebaseDatabaseTitle.value?:"Enter Title",
                onValueChange = { Value ->
                    FirebaseDatabaseTitle.value = Value

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 24.sp, fontWeight = FontWeight.Medium, color = Color.White
                ),
                cursorBrush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2193b0),
                        Color(0xFF6dd5ed)
                    )
                ),
                enabled = !isSaveButton
                )


            Spacer(modifier = Modifier.size(16.dp))

            BasicTextField(value = FirebaseDatabaseContent.value?:"Enter Content",
                onValueChange = { Value ->
                    FirebaseDatabaseContent.value = Value
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.White
                ),
                cursorBrush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2193b0),
                        Color(0xFF6dd5ed)
                    )
                ),
                enabled = !isSaveButton
            )

        }
    }


}

