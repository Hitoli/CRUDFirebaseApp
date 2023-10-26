package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getData

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import kotlinx.coroutines.flow.Flow

interface GetDataInter {
    fun getFirebaseData() : Flow<List<NoteDataFirebase>>
    fun getOrderedFirebaseData(title:String) : Flow<List<NoteDataFirebase>>
}