package com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.source.firebase.saveData

import android.os.Build
import android.util.Log
import com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

private const val TAG = "VALUESTOREDINFIREBASE"
class SaveData @Inject constructor() {
    fun SaveFirebaseData(dataValue: NoteDataFirebase){
        val dataBase = FirebaseDatabase.getInstance().getReference("NotesStoringData").child(Build.DEVICE)
        val id = dataBase.push().key ?: ""
        dataBase.child(id).setValue(dataValue).addOnCanceledListener {
            Log.e(TAG,"addOnCanceledListener")
        }.addOnFailureListener{
            Log.e(TAG,it.localizedMessage ?: "")
        }.addOnSuccessListener {
            Log.i(TAG, "setData: $it")
        }
    }
}