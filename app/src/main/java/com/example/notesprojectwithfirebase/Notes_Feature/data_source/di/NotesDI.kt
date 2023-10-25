package com.example.notesprojectwithfirebase.Notes_Feature.data_source.di

import com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepo.NoteRepository
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.repository.noteRepoImpl.NoteRepositoyImplementation
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.deleteData.DeleteDataImpl
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.deleteData.deleteData
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getData.GetData
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getData.GetDataInter
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getDataByID.GetDataByID
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.getDataByID.GetDataByIDInter
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.saveData.SaveData
import com.example.notesprojectwithfirebase.Notes_Feature.data_source.source.firebase.saveData.SaveDataInter
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.DeleteNotesUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.GetNotesByIDUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.GetNotesUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecase.SaveNoteUseCase
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecaseImpl.DeleteNotesUseCaseImpl
import com.example.notesprojectwithfirebase.Notes_Feature.domain.usecaseImpl.GetNotesByID
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
    interface NoteMod {
        @Binds
        @Singleton
        fun provideNoteRepo(noteRepositoyImplementation: NoteRepositoyImplementation): NoteRepository

        @Binds
        @Singleton
        fun provideGetNoteUsecase(getNotesUseCaseImpl: GetNotesUseCaseImpl): GetNotesUseCase

        @Binds
        @Singleton
        fun provideGetData(getData: GetData): GetDataInter

        @Binds
        @Singleton
        fun provideSaveData(saveData: SaveData): SaveDataInter

        @Binds
        @Singleton
        fun provideDeleteData(deleteDataImpl: DeleteDataImpl): deleteData

        @Binds
        @Singleton
        fun provideGetDataByID(getDataByID: GetDataByID): GetDataByIDInter


        @Binds
        @Singleton
        fun provideSaveNoteUsecase(saveNoteUsecaseImpl: SaveNoteUseCaseImple): SaveNoteUseCase

        @Binds
        @Singleton
        fun provideDeleteNoteUsecase(deleteNotesUseCaseImpl: DeleteNotesUseCaseImpl): DeleteNotesUseCase

        @Binds
        @Singleton
        fun provideGetNoteByIDUsecase(getNotesByID: GetNotesByID): GetNotesByIDUseCase

    }

}