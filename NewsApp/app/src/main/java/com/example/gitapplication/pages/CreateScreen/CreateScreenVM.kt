package com.example.newsapp.Pages.CreateScreen

import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.gitapplication.RoomDatabase.NewsBO
import com.example.gitapplication.RoomDatabase.NewsDAO
import com.example.gitapplication.RoomDatabase.NewsDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateScreenVM(
    context: Context,
    dao: NewsDAO = NewsDatabase.getInstance(context).NewsDAO(),
): CreateScreenModel() {

    init {
        try {
            this.dao = dao
        } catch (e: Exception) {
            Log.d("init", "init:$e ")
        }
    }

    fun setTitleNews(titlee: String) {
        try {
            title = titlee
            titleCheck = false
        } catch (e: Exception) {
            Log.d("exception", e.message.toString())
        }
    }

    fun setDescriptionNews(des: String) {
        try {
            description = des
            descriptionCheck = false
        } catch (e: Exception) {
            Log.d("exception", e.message.toString())
        }
    }

    fun setNewsDate(datee: String) {
        try {
            date = datee
            dateCheck = false
        } catch (e: Exception) {
            Log.d("exception", e.message.toString())
        }
    }

    fun setNewsCategory(cat: String) {
        try {
            showMenu = true
            category = cat
            categoryCheck = false
        } catch (e: Exception) {
            Log.d("exception", e.message.toString())
        }
    }
    fun onClick(navController: NavHostController){
        titleCheck= title.isEmpty()
        descriptionCheck= description.isEmpty()
        dateCheck = date.isEmpty()
        categoryCheck=category.isEmpty()

        if(!titleCheck && !descriptionCheck && !dateCheck && !categoryCheck)
        {
            create(navController)
        }
    }

    //create
    fun create(navController: NavHostController) {
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val newsBO = NewsBO(
                    title = title,
                    description = description,
                    data = date,
                    Category = category
                )

                val result = dao.addnewsData(newsBO)
                Log.d("value","$result")
                if (result != -1L) {
                    withContext(Dispatchers.Main) {
                        navController.popBackStack()
                        navController.navigate("ViewScreen?long=$result")
                    }
                    Log.d("result", "NewsList: $result")
                }
            } catch (e: Exception) {
                Log.d("createUser", "NewsList: $e")
            }
        }
    }
}