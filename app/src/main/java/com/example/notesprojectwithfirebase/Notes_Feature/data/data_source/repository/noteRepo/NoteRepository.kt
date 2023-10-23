package com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.repository.noteRepo

import com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotesFromDataSource(): List<NoteDataFirebase>
    suspend fun getNoteByID(ID:Int): NoteDataFirebase?
    suspend fun insertNote(noteDataFirebase: NoteDataFirebase)
    suspend fun deleteNote(noteDataFirebase: NoteDataFirebase)
}