package com.example.gitapplication.pages.HomeScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeScreenVM(context: Context) :HomeScreenModel() {
    init {

        newsBO
        dao
        allList
        tempList
    }
}

    class VMFactory<T>(private val factory: () -> T): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val newT = factory()
            return newT as T
        }
    }
