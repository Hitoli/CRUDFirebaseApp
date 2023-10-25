package com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase



interface DeleteNotesUseCase {
    suspend operator fun invoke(ID:String)
}