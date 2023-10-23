package com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase

import com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.source.firebase.noteDataFirebase.NoteDataFirebase

interface GetNotesUseCase {
    operator fun invoke():List<NoteDataFirebase>
}