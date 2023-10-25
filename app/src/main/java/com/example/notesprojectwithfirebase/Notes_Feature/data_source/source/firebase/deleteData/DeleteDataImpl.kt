package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.deleteData

import android.os.Build
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class DeleteDataImpl @Inject constructor() : deleteData {
    override fun deleteNote(ID: String) {
        val datadelete =
            FirebaseDatabase.getInstance().getReference("NotesStoringData").child(Build.DEVICE)
        datadelete.child(ID).removeValue()
    }
}