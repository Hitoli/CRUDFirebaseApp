package com.example.notesprojectwithfirebase.Notes_Feature.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.DeleteNotesUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.GetNotesByIDUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.GetNotesUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.SaveNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    val getNotesUseCas: GetNotesUseCase,
    val saveNoteUseCas: SaveNoteUseCase,
    val deleteNotesUseCase: DeleteNotesUseCase,
    val getNotesByIDUseCase: GetNotesByIDUseCase
) : ViewModel() {


    private val _noteList = MutableStateFlow<List<NoteDataFirebase>>(emptyList())
    val noteList = _noteList.asStateFlow()

    private val _note = mutableStateOf<NoteDataFirebase?>(NoteDataFirebase())
    var note = _note

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
            withContext(Dispatchers.IO) {
                note.value = getNotesByIDUseCase.invoke(ID)
            }
        }

    }


}