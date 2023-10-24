package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getData

import android.os.Build
import android.util.Log
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class GetData @Inject constructor() : GetDataInter {

    override fun getFirebaseData(): Flow<List<NoteDataFirebase>> {

            return callbackFlow {
                Log.e("datastoredvalueinfirebase", "GET DATA STARTED")

                val db = FirebaseDatabase.getInstance()
                    .getReference("NotesStoringData").child(Build.DEVICE)
                val listener = db.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val notesList = snapshot.children.mapNotNull { noteSnapshot ->
                            noteSnapshot.getValue(NoteDataFirebase::class.java)
                        }
                        trySend(notesList)
                    }

                    override fun onCancelled(error: DatabaseError) {
                        close(error.toException())
                    }
                })

                awaitClose {
                    db.removeEventListener(listener)
                }
            }


    }
}