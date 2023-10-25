package com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase

interface GetNotesByIDUseCase {
    suspend operator fun invoke(ID:String):NoteDataFirebase?
}