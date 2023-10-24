package com.example.notesprojectwithfirebase.Notes_Feature.data_source.di

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepo.NoteRepository
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepoImpl.NoteRepositoyImplementation
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getData.GetData
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getData.GetDataInter
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.GetNotesUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.SaveNoteUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecaseImpl.GetNotesUseCaseImpl
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecaseImpl.SaveNoteUseCaseImple
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NotesDI {


    @Module
    @InstallIn(SingletonComponent::class)
    interface NoteMod{
        @Binds
        @Singleton
        fun provideNoteRepo(noteRepositoyImplementation: NoteRepositoyImplementation): NoteRepository

        @Binds
        @Singleton
        fun provideGetNoteUsecase(getNotesUseCaseImpl: GetNotesUseCaseImpl):GetNotesUseCase

        @Binds
        @Singleton
        fun provideGetData(getData: GetData):GetDataInter

        @Binds
        @Singleton
        fun provideSaveNoteUsecase(saveNoteUsecaseImpl: SaveNoteUseCaseImple):SaveNoteUseCase
    }

}