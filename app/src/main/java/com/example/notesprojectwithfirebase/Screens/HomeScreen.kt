package com.example.notesprojectwithfirebase.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.notesprojectwithfirebase.Consts.ConstantsOfProject
import com.example.notesprojectwithfirebase.R
import com.example.notesprojectwithfirebase.ui.theme.Background1
import com.example.notesprojectwithfirebase.ui.theme.ButtonBackground1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }, modifier = Modifier
            .padding(8.dp), containerColor = ButtonBackground1) {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = ConstantsOfProject.HomeScreenAdd,
                tint = Color.White, modifier = Modifier.size(20.dp))
        }
    }, containerColor = Background1) {
        val pad =it
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Background1)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){


                Text(text = ConstantsOfProject.HomeScreenTitle, color = Color.White, fontSize = 32.sp)

                Row(modifier = Modifier.padding(8.dp)){

                    Box(modifier = Modifier
                        .background(ButtonBackground1, shape = RoundedCornerShape(24))
                        .padding(12.dp)
                        .clickable { /*TODO*/ }){
                        Icon(painter = painterResource(id = R.drawable.search),
                            contentDescription = ConstantsOfProject.HomeScreenSearch,
                            tint = Color.White, modifier = Modifier.size(20.dp))
                    }

                    Spacer(modifier = Modifier.padding(8.dp))


                    Box(modifier = Modifier
                        .background(ButtonBackground1, shape = RoundedCornerShape(24))
                        .padding(12.dp)
                        .clickable { /*TODO*/ }){
                        Icon(painter = painterResource(id = R.drawable.info_outline),
                            contentDescription = ConstantsOfProject.HomeScreenInfo,
                            tint = Color.White, modifier = Modifier.size(20.dp))
                    }
                }


            }

            Column(modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 24.dp)
                ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Image(
                    painter = painterResource(id = R.drawable.rafiki),
                    contentDescription =ConstantsOfProject.HomeScreenNotesIcon,
                    modifier = Modifier.size(350.dp))
                Spacer(modifier = Modifier.padding(8.dp))

                Text(text = ConstantsOfProject.HomeScreenNotesIconTagLine, color = Color.White, fontSize = 20.sp)



            }





        }
    }


}
