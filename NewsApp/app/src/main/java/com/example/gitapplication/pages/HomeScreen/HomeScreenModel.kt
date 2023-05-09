package com.example.gitapplication.pages.HomeScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gitapplication.RoomDatabase.NewsBO
import com.example.gitapplication.RoomDatabase.NewsDAO

open class HomeScreenModel: ViewModel() {
    lateinit var dao: NewsDAO
    lateinit var uiList : MutableState<List<NewsBO>>
    lateinit var dbList : MutableList<NewsBO>
    var filterValue:String by mutableStateOf("")
}