package com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.source.firebase.getData

import android.os.Build
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetData @Inject constructor(): GetDataInter {

    private val datafromfirebase= mutableListOf<NoteDataFirebase>()
    val _datafromfirebase = datafromfirebase
    override fun GetFirebaseData() {
            Log.e("datastoredvalueinfirebase","GET DATA STARTED")

            val datagetter = FirebaseDatabase.getInstance()
                .getReference("NotesStoringData").child(Build.DEVICE)
         //   val data = datagetter.snapshots
        datagetter.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (datastoredvalue in snapshot.children){

                        val datas: NoteDataFirebase? = datastoredvalue.
                        getValue(NoteDataFirebase::class.java)
                        datas?.let{datafromfirebase.add(it)}

                        Log.e("datastoredvalueinfirebase",datastoredvalue.toString())
                        Log.e("datastoredvalueinfirebase",datas.toString())
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

//            viewModelScope.launch {
//                data.collectLatest {
//                    _listOfNotes.value = listOf()
//                    _listOfNotes.value += (it.value as? HashMap<*, String>)?.values ?: listOf()
//                    Log.i(TAG, "collectLatest: ${it.value}")
//                }
//            }
            /*     datagetter.addValueEventListener(object:ValueEventListener{

                     override fun onDataChange(snapshot: DataSnapshot) {
                         Log.e("datastoredvalueinfirebase","Inside VALUE ENVENT")

                         val datafromfirebase = mutableListOf<String>()
                         if (snapshot.exists()){
                             for (datastoredvalue in snapshot.children){

                                 val datas = datastoredvalue.value
                                 datas?.let{datafromfirebase.add(it.toString())}

                                 Log.e("datastoredvalueinfirebase",datastoredvalue.toString())
                                 Log.e("datastoredvalueinfirebase",datas.toString())
                             }
                             datareceivedfirebase = datafromfirebase
                             Log.e("datastoredvalueinfirebases",datareceivedfirebase.toString())

                             Log.e("datastoredvalueinfirebase","YesSnapshot")
                         }else{
                             Log.e("datastoredvalueinfirebase","NoSanpshot")

                         }
                     }

                     override fun onCancelled(error: DatabaseError) {
                         TODO("Not yet implemented")
                     }

                 })*/

        }
}