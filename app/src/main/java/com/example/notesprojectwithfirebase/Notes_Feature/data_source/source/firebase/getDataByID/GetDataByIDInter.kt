package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getDataByID

import androidx.compose.runtime.MutableState
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase

interface GetDataByIDInter {
    suspend fun GetDataByID(ID:String): NoteDataFirebase?
}