package com.jeezzzz.notesapp.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jeezzzz.notesapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDAO

    companion object {
        fun getDatabase(context: Context): NoteDatabase {
            return Room.databaseBuilder(context, NoteDatabase::class.java, "note_database").build()
        }
    }

//    companion object {
//        @Volatile
//        private var INSTANCE: NoteDatabase? = null
//
//        fun getDtabase(context: Context): NoteDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    NoteDatabase::class.java,
//                    "note_database"
//                ).build()
//                Log.d("hello","instance created")
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
}
