package com.example.newsapp.Pages.ViewScreen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gitapplication.R
import com.example.gitapplication.pages.ViewScreen.ViewScreenVM

@Composable
fun ViewScreen(navController: NavController, vm:ViewScreenVM,returnValue:Long?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .width(20.dp)//checking
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {Log.d("tag","$returnValue")
        Text( text =
        if (returnValue!=0L){
                    stringResource(R.string.sucessfully_posted_message)
                }
        else{
            stringResource(R.string.failed_Posting_Message)
        } , fontSize = 35.sp,modifier=Modifier.padding(bottom = 15.dp)

        )

        Button(onClick = {
            vm.navigateToHome(navController)
        },
            colors=ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {
            Text(
                text = stringResource(R.string.navigation_back_to_homeScreen),
                Modifier.padding(10.dp)
            )
        }
    }
}