package com.example.newsapp.Pages.CreateScreen

import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateScreenVM(context: Context): CreateScreenModel() {
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

//                val newsBO = NewsBO(
//                    assetName = assetName,
//                    assetDesc = assetDesc,
//                    assetStatus = selectedOption,
//                    assetOwner = assetOwner,
//                    assetPrice = assetPrice
//                )
//                val result = assetDAO.insertData(assetBO)
//                if (result != -1L) {
//                    isCreated = true
//                    withContext(Dispatchers.Main) {
//                        navController.popBackStack()
//                        navController.navigate("View")
//                    }
//                }
                withContext(Dispatchers.Main) {
                    navController.popBackStack()
                    navController.navigate("View")
                }
            } catch (e: Exception) {
                Log.d("create exception", e.toString())
            }
        }
    }
}