package com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase

interface SaveNoteUseCase {
    suspend operator fun invoke(noteDataFirebase: NoteDataFirebase)
}