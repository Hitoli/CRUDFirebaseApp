package com.example.notesprojectwithfirebase.Notes_Feature.domain.usecaseImpl

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepoImpl.NoteRepositoyImplementation
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.SaveNoteUseCase
import javax.inject.Inject

class SaveNoteUseCaseImple @Inject constructor(val noterepo: NoteRepositoyImplementation): SaveNoteUseCase {
    override suspend fun invoke(noteDataFirebase: NoteDataFirebase) {
        noterepo.insertNote(noteDataFirebase)
    }
}