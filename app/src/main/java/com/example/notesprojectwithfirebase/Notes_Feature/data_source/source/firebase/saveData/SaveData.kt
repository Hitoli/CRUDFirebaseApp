package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.saveData

import android.os.Build
import android.util.Log
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getDataByID.GetDataByID
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getDataByID.GetDataByIDInter
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.updateData.UpdateData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

private const val TAG = "VALUESTOREDINFIREBASE"

class SaveData @Inject constructor() : SaveDataInter {
    override fun SaveFirebaseData(dataValue: NoteDataFirebase) {
        val dataBase =
            FirebaseDatabase.getInstance().getReference("NotesStoringData").child(Build.DEVICE)
        val idpush = dataBase.push().key ?: ""
        dataBase.child(idpush).setValue(
            NoteDataFirebase(
                id = idpush,
                title = dataValue.title,
                content = dataValue.content,
                timeStamp = dataValue.timeStamp
            )
        ).addOnCanceledListener {
            Log.e(TAG, "addOnCanceledListener")
        }.addOnFailureListener {
            Log.e(TAG, it.localizedMessage ?: "")
        }.addOnSuccessListener {
            Log.i(TAG, "setData: $it")
        }
    }
}