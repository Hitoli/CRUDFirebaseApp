package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.saveData

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase

interface SaveDataInter {
    fun SaveFirebaseData(dataValue: NoteDataFirebase)
}