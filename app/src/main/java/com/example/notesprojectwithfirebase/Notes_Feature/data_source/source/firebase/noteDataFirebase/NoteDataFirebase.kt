package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase

import androidx.room.PrimaryKey
import com.example.notesprojectwithfirebase.ui.theme.BlueMunsell
import com.example.notesprojectwithfirebase.ui.theme.Emerald
import com.example.notesprojectwithfirebase.ui.theme.Fandango
import com.example.notesprojectwithfirebase.ui.theme.Maize
import com.example.notesprojectwithfirebase.ui.theme.Sandybrown
import com.google.firebase.database.Exclude

data class NoteDataFirebase(
    @Exclude
    val id:Int?=null,
    var title:String?="",
    val content:String?="",
    val timeStamp:String?="",
){
    companion object{
        val colorInt = listOf(Sandybrown, Maize, Emerald, BlueMunsell, Fandango)
    }

}

