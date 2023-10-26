package com.example.notesprojectwithfirebase.Notes_Feature.domain.usecaseImpl

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepo.NoteRepository
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.SearchNoteUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchNotesUseCaseImpl @Inject constructor(val noteRepo:NoteRepository):SearchNoteUseCase {
    override suspend fun invoke(title:String): Flow<List<NoteDataFirebase>> {
        return noteRepo.searchNote(title)
    }

}