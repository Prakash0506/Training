package com.example.gitapplication.pages.HomeScreen

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitapplication.RoomDatabase.NewsBO
import com.example.gitapplication.RoomDatabase.NewsDatabase

class HomeScreenVM(context: Context) :HomeScreenModel() {
    init {

        newsBO= NewsBO(0,"","","","")
        var db=NewsDatabase.getInstance(context)
        dao=db.credentialDAO()
        uiList= mutableStateOf(emptyList())
        dbList= mutableListOf()

    }
     fun addNews(){

     }

    fun filterNews(category:String){

    }

}

    class VMFactory<T>(private val factory: () -> T): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val newT = factory()
            return newT as T
        }
    }
