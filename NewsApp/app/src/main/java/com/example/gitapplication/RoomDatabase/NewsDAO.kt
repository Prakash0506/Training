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
    suspend fun getAllNews():List<NewsBO>

    @Insert(onConflict = REPLACE)
    suspend fun addnewsData(data: NewsBO) : Long

//    @Delete
//    suspend fun deleteUserCredential(data: NewsBO): Int
//
//    @Update
////    @Query("UPDATE UserCredential SET  WHERE id = :id")
//    suspend fun updateCredential(data : NewsBO) : Int
//
//    @Query("SELECT * FROM NewsData WHERE id == :primaryId")
//    suspend fun getUserByID(primaryId: Int) : NewsBO
//
//    @Query("SELECT * FROM NewsData WHERE title LIKE '%' || :key || '%'  or " +
//            "emailId  LIKE '%' || :key || '%' or url  LIKE '%' || :key || '%' ")
//    suspend fun searchUserByUserId(key: String) : List<NewsBO>
}
//or emailId = :key or url = :key