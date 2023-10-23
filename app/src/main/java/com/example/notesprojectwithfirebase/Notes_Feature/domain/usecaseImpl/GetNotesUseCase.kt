package com.example.notesprojectwithfirebase.Notes_Feature.domain.usecaseImpl

import com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.repository.noteRepo.NoteRepository
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.GetNotesUseCase
import javax.inject.Inject

class GetNotesUseCaseImpl @Inject constructor(val noteRepository: NoteRepository):GetNotesUseCase {
    override fun invoke(): List<NoteDataFirebase> {
        return noteRepository.getNotesFromDataSource()
    }

}