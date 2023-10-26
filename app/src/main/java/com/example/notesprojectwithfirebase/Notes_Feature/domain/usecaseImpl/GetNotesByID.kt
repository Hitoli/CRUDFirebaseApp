package com.example.notesprojectwithfirebase.Notes_Feature.domain.usecaseImpl

import android.util.Log
import androidx.compose.runtime.MutableState
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepo.NoteRepository
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.GetNotesByIDUseCase
import javax.inject.Inject

class GetNotesByID @Inject constructor(val noteRepo:NoteRepository ) :GetNotesByIDUseCase {
    override suspend fun invoke(ID: String): NoteDataFirebase? {
        Log.e( "Getdatabyid Note Usecase",noteRepo.getNoteByID(ID).toString())
        return noteRepo.getNoteByID(ID)
    }
}