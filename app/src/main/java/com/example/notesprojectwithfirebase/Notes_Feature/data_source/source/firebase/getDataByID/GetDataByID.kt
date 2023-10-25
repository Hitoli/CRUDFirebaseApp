package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getDataByID

import android.os.Build
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class GetDataByID @Inject constructor() : GetDataByIDInter {

    override fun GetDataByID(ID: String): NoteDataFirebase? {
        var notes:NoteDataFirebase? = NoteDataFirebase()
        val dataBaseID =
            FirebaseDatabase.getInstance().getReference("NoteStoringData").child(Build.DEVICE)
        dataBaseID.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(data in snapshot.children){
                    if (snapshot.child(ID).exists()){
                        notes = snapshot.getValue(NoteDataFirebase::class.java)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return notes
    }
}