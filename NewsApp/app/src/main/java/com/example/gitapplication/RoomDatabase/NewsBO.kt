package com.example.gitapplication.RoomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NewsData")
data class NewsBO(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "title")
    var title:String,

    var description:String,

    var dataPicker : String,

    var Category : String,


)
