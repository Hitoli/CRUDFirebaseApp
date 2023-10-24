package com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepo

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotesFromDataSource(): Flow<List<NoteDataFirebase>>
    suspend fun getNoteByID(ID:Int): NoteDataFirebase?
    suspend fun insertNote(noteDataFirebase: NoteDataFirebase)
    suspend fun deleteNote(noteDataFirebase: NoteDataFirebase)
}