package com.example.gitapplication.pages.ViewScreen

import androidx.navigation.NavController
import androidx.navigation.NavHostController

class ViewScreenVM : ViewScreenModel(){

    fun navigateToHome(navController : NavController){
        navController.navigate("HomeScreen")
    }


}