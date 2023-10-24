package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notesprojectwithfirebase.ui.theme.BlueMunsell
import com.example.notesprojectwithfirebase.ui.theme.Emerald
import com.example.notesprojectwithfirebase.ui.theme.Fandango
import com.example.notesprojectwithfirebase.ui.theme.Maize
import com.example.notesprojectwithfirebase.ui.theme.Sandybrown

@Entity
data class Note(
    @PrimaryKey val id:Int?=null,
    val title:String,
    val content:String,
    val timeStamp:String,
    val color:Int,
){
    companion object{
        val colorInt = listOf(Sandybrown, Maize, Emerald, BlueMunsell, Fandango)
    }

}
