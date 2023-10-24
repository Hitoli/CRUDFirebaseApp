package com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepoImpl

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getData.GetData
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getData.GetDataInter
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.saveData.SaveData
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepo.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoyImplementation @Inject constructor(
    val getData: GetDataInter,
    val saveData: SaveData):
    NoteRepository {
    override fun getNotesFromDataSource(): Flow<List<NoteDataFirebase>> {
        return getData.getFirebaseData()
    }

    override suspend fun getNoteByID(ID: Int): NoteDataFirebase? {
        TODO("Not yet implemented")
    }

    override suspend fun insertNote(noteDataFirebase: NoteDataFirebase) {
        saveData.SaveFirebaseData(noteDataFirebase)
    }

    override suspend fun deleteNote(noteDataFirebase: NoteDataFirebase) {
        TODO("Not yet implemented")
    }
}