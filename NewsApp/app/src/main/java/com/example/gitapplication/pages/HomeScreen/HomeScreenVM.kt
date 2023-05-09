package com.example.gitapplication.pages.HomeScreen

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.gitapplication.RoomDatabase.NewsBO
import com.example.gitapplication.RoomDatabase.NewsDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeScreenVM(context: Context) : HomeScreenModel() {
    init {

        var db = NewsDatabase.getInstance(context)
        dao = db.NewsDAO()
        uiList = mutableStateOf(emptyList())
        dbList = mutableListOf()

    }


    fun navigateToCreateScreen(navController: NavController) {
        navController.navigate("CreateScreen")
    }

    fun filterNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                when (category) {
                    "Trending" -> {
                        filterValue = category
                        val trendingNews = dbList.filter {
                            (category == it.Category)
                        }
                        uiList.value = trendingNews

                    }
                    "Local" -> {
                        filterValue = category

                        val localNews = dbList.filter {
                            (category == it.Category)
                        }
                        uiList.value = localNews
                    }
                    "Sports" -> {
                        filterValue = category

                        val sportsnews = dbList.filter {
                            (category == it.Category)
                        }
                        uiList.value = sportsnews

                    }
                    "All" -> {
                        filterValue = category

                        getAllNewsData()
                    }
                    else -> {}
                }
            } catch (e: Exception) {
                Log.d("exception", "filterNews: $e")
            }

        }
    }

    fun getAllNewsData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                var result = dao.getAllNews()
                Log.d("dataBo", "getAllNews: $result")
                if (result != null) {

                    uiList.value = result
                    dbList = uiList.value.toMutableList()
                }
            } catch (e: Exception) {
                Log.d("exception", "exception :$e ")
            }
        }
    }

}

class VMFactory<T>(private val factory: () -> T) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val newT = factory()
        return newT as T
    }
}
