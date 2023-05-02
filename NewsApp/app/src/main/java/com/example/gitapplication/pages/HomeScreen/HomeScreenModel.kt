package com.example.gitapplication.pages.HomeScreen

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.gitapplication.RoomDatabase.NewsBO
import com.example.gitapplication.RoomDatabase.NewsDAO

open class HomeScreenModel: ViewModel() {
    lateinit var newsBO: NewsBO
    lateinit var dao: NewsDAO
    lateinit var allList : MutableState<List<NewsBO>>
    lateinit var tempList : MutableState<List<NewsBO>>
}