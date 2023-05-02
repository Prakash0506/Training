package com.example.gitapplication.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsBO::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun NewsDAO() : NewsDAO
    companion object {
        private var INSTANCE : NewsDatabase? = null
        fun getInstance(context : Context) : NewsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder( context.applicationContext,
                        NewsDatabase::class.java, "Credential_database" ).build()
                    INSTANCE = instance }
                return instance
            }
        }
    }
}