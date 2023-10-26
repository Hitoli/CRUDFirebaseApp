package com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import kotlinx.coroutines.flow.Flow

interface SearchNoteUseCase {
        suspend operator fun invoke(title:String): Flow<List<NoteDataFirebase>>
}