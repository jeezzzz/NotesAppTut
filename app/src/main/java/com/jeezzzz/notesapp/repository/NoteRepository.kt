package com.jeezzzz.notesapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.jeezzzz.notesapp.database.NoteDAO
import com.jeezzzz.notesapp.database.NoteDatabase
import com.jeezzzz.notesapp.model.Note

class NoteRepository(val dao: NoteDAO) {

    suspend fun upsertNote(note: Note) {
        return dao.upsertNote(note)
    }
    suspend fun deleteNote(note: Note) = dao.deleteNote(note)

    fun getAllNotes(): LiveData<List<Note>> {
        return dao.getAllNotes()
    }
    fun searchNote(query: String?) = dao.searchNote(query)
}