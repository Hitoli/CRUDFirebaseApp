package com.example.notesprojectwithfirebase.Notes_Feature.domain.usecaseImpl

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepo.NoteRepository
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.DeleteNotesUseCase
import javax.inject.Inject

class DeleteNotesUseCaseImpl @Inject constructor(val noterepo:NoteRepository):DeleteNotesUseCase {
    override suspend fun invoke(ID: String) {
        noterepo.deleteNote(ID)
    }
}