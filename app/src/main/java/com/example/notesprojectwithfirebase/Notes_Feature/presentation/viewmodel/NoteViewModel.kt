package com.example.notesprojectwithfirebase.Notes_Feature.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesprojectwithfirebase.Notes_Feature.data.data_source.source.firebase.noteDataFirebase.NoteDataFirebase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.GetNotesUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.SaveNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(val getNotesUseCas: GetNotesUseCase, val saveNoteUseCas:SaveNoteUseCase):ViewModel() {

    init {
        getNotesViewModel()
    }

    private val _noteList :MutableList<NoteDataFirebase> = mutableListOf()
    val noteList:MutableList<NoteDataFirebase> = _noteList

    fun getNotesViewModel(){
        getNotesUseCas.invoke().forEach {
            _noteList.add(it)
        }

    }

    fun saveNoteViewModel(noteDataFirebase: NoteDataFirebase){
        viewModelScope.launch {
            saveNoteUseCas.invoke(noteDataFirebase)
        }
    }

}