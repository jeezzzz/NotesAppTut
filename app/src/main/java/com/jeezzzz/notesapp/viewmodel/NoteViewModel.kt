package com.jeezzzz.notesapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.jeezzzz.notesapp.database.NoteDatabase
import com.jeezzzz.notesapp.model.Note
import com.jeezzzz.notesapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NoteRepository

    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
    }

    fun addNote(note: Note) = viewModelScope.launch {
        repository.upsertNote(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return repository.getAllNotes()
    }
    fun searchNote(query: String?) = repository.searchNote(query)
}
