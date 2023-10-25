package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getDataByID

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase

interface GetDataByIDInter {
    fun GetDataByID(ID:String):NoteDataFirebase?
}