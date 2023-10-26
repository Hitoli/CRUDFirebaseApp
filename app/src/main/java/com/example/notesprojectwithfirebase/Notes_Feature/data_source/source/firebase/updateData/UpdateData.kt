package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.updateData

import android.os.Build
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UpdateData() {
    fun UpdateData(dataValue:NoteDataFirebase){
        val dataBase =
            FirebaseDatabase.getInstance().getReference("NotesStoringData").child(Build.DEVICE)
        dataBase.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for(data in snapshot.children){
                    if(data.exists()){
                        if(data.child(dataValue.id!!).exists()){
                            dataBase.child(dataValue.id!!).setValue(dataValue)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}