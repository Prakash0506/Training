package com.example.gitapplication.RoomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.gitapplication.RoomDatabase.NewsBO

@Dao
interface NewsDAO {

    @Query("SELECT * FROM NewsData ")
    suspend fun getAllNews(): List<NewsBO>

    @Insert(onConflict = REPLACE)
    suspend fun addnewsData(data: NewsBO): Long
}