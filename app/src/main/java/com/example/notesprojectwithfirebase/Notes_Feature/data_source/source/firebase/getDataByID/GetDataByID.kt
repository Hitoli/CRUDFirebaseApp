package com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getDataByID

import android.os.Build
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GetDataByID @Inject constructor() : GetDataByIDInter {

    override suspend fun GetDataByID(id: String): NoteDataFirebase? {
        return suspendCoroutine {continuation ->
            Log.e("VALUESEXISTSCONTENT","GET DATA FUNCTION STARTED")
            var note:NoteDataFirebase?= NoteDataFirebase(id = "123",title = "44",content = "44", timeStamp ="77")
            val dataBaseID =
                FirebaseDatabase.getInstance()
                    .getReference("NotesStoringData").child(Build.DEVICE)
            Log.e("VALUESEXISTSCONTENT", dataBaseID.get().toString())
            dataBaseID.addValueEventListener(object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.e("VALUESEXISTSCONTENT", "VAlueEnventilisteneer")

                    for(data in snapshot.children){
                        Log.e("VALUESEXISTSCONTENT", data.value.toString())

                        if (snapshot.child(id).exists()){
                            Log.e("VALUESEXISTSCONTENT", snapshot.child(id).value.toString())
                            note = snapshot.child(id).getValue(NoteDataFirebase::class.java)
                            Log.e("VALUESEXISTSCONTENT", note.toString())
                            break
                        }
                    }
                   // continuation.resume(note)

                }

                override fun onCancelled(error: DatabaseError) {
                    /*TODO*/
                }

            })
            Log.e("VALUESEXISTSCONTENT", mutableStateOf(note).toString())


        }
        }


}