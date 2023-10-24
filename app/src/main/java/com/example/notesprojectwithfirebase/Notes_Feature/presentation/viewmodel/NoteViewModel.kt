package com.example.notesprojectwithfirebase.Notes_Feature.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.GetNotesUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.SaveNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(val getNotesUseCas: GetNotesUseCase, val saveNoteUseCas:SaveNoteUseCase):ViewModel() {



    private val _noteList = MutableStateFlow<List<NoteDataFirebase>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        getNotesViewModel()
    }

    fun getNotesViewModel(){
        viewModelScope.launch {
           _noteList.emitAll(getNotesUseCas.invoke())
        }


    }

    fun saveNoteViewModel(noteDataFirebase: NoteDataFirebase){
        viewModelScope.launch {
            saveNoteUseCas.invoke(noteDataFirebase)
        }
    }



}