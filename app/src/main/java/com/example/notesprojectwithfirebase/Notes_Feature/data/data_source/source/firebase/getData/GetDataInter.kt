package com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.source.firebase.getData

import com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import kotlinx.coroutines.flow.Flow

interface GetDataInter {
    fun GetFirebaseData()
}