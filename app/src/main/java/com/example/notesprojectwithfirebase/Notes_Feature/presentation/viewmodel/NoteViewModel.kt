package com.example.notesprojectwithfirebase.Notes_Feature.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.DeleteNotesUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.GetNotesByIDUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.GetNotesUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.SaveNoteUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.SearchNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNotesUseCas: GetNotesUseCase,
    private val saveNoteUseCas: SaveNoteUseCase,
    private val deleteNotesUseCase: DeleteNotesUseCase,
    private val getNotesByIDUseCase: GetNotesByIDUseCase,
    private val searchNoteUseCase: SearchNoteUseCase
) : ViewModel() {


    private val _noteList = MutableStateFlow<List<NoteDataFirebase>>(emptyList())
    val noteList = _noteList.asStateFlow()

    private val _NoteId = mutableStateOf("")
    var NoteId = _NoteId.value

    private val _note : MutableState<NoteDataFirebase?> = mutableStateOf(NoteDataFirebase(id="",title = "",content = "",timeStamp = ""))
    var note: MutableState<NoteDataFirebase?> = _note

    init {
        getNotesViewModel()
    }



    fun getNotesViewModel() {
        viewModelScope.launch {
            _noteList.emitAll(getNotesUseCas.invoke())
        }


    }

    fun saveNoteViewModel(noteDataFirebase: NoteDataFirebase) {
        viewModelScope.launch {
            saveNoteUseCas.invoke(noteDataFirebase)
        }
    }

    fun deleteNoteViewModel(ID:String){
        viewModelScope.launch {
            deleteNotesUseCase.invoke(ID)
        }
    }

    fun getNoteViewModel(ID:String){
        viewModelScope.launch {
         note.value= async {
             Log.e( "Getdatabyid Note Viewmodel",getNotesByIDUseCase.invoke(ID).toString())

             getNotesByIDUseCase.invoke(ID)
          }.await()
        }

    }

    fun searchNoteViewModel(title:String){
        viewModelScope.launch {
            _noteList.emitAll(searchNoteUseCase.invoke(title))
            Log.e("NOTELIST",_noteList.value.toString())
        }
    }


}