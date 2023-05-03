package com.example.newsapp.Pages.ViewScreen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gitapplication.pages.ViewScreen.ViewScreenVM

@Composable
fun ViewScreen(navController: NavController, vm:ViewScreenVM,returnValue:Long?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {Log.d("tag","$returnValue")
        Text( text =
        if (returnValue!=0L){"Successfully Posted !"}
        else{
            "Posting Failed!"
        } , fontSize = 35.sp,modifier=Modifier.padding(bottom = 15.dp)

        )

        Button(onClick = {
            vm.navigateToHome(navController)
        },
            colors=ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {
            Text(
                text = " Back to home",
                Modifier.padding(10.dp)
            )
        }
    }
}