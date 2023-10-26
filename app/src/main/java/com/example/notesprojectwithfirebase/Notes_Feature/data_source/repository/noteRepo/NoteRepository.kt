package com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepo

import androidx.compose.runtime.MutableState
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotesFromDataSource(): Flow<List<NoteDataFirebase>>
    suspend fun getNoteByID(ID:String): NoteDataFirebase?
    suspend fun insertNote(noteDataFirebase: NoteDataFirebase)
    suspend fun deleteNote(ID:String )
    suspend fun searchNote(title:String):Flow<List<NoteDataFirebase>>
}