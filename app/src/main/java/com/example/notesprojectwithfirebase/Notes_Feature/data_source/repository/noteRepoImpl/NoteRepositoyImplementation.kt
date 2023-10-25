package com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepoImpl

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getData.GetData
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getData.GetDataInter
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.saveData.SaveData
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepo.NoteRepository
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.deleteData.deleteData
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getDataByID.GetDataByIDInter
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.saveData.SaveDataInter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoyImplementation @Inject constructor(
    val getData: GetDataInter,
    val saveData: SaveDataInter, val deleteData:deleteData, val getDataById:GetDataByIDInter):
    NoteRepository {
    override fun getNotesFromDataSource(): Flow<List<NoteDataFirebase>> {
        return getData.getFirebaseData()
    }

    override suspend fun getNoteByID(ID: String): NoteDataFirebase? {
        return getDataById.GetDataByID(ID)
    }

    override suspend fun insertNote(noteDataFirebase: NoteDataFirebase) {
        saveData.SaveFirebaseData(noteDataFirebase)
    }

    override suspend fun deleteNote(ID: String) {
        deleteData.deleteNote(ID)
    }
}