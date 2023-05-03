package com.example.newsapp.Pages.ViewScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gitapplication.pages.ViewScreen.ViewScreenVM

@Composable
fun ViewScreen(navController: NavController, vm:ViewScreenVM) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Go Back",
            modifier = Modifier.clickable {
                vm.navigateToHome(navController)
            })
    }
}