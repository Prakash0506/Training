package com.example.gitapplication

import HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gitapplication.pages.HomeScreen.HomeScreenVM
import com.example.gitapplication.pages.HomeScreen.VMFactory
import com.example.gitapplication.ui.theme.GitApplicationTheme
import com.example.newsapp.Pages.CreateScreen.CreateScreen
import com.example.newsapp.Pages.CreateScreen.CreateScreenVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreenSetup()
                }
            }
        }
    }
}

@Composable
fun ScreenSetup() {
    val context = LocalContext.current
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination ="HomeScreen",

        ) {
        composable("HomeScreen")
        {
//            HomeScreen(navController, vm = viewModel(factory = HomeScreenVM.VMFactory {
//                HomeScreenVM(context)
//            }))

            HomeScreen(navController = navController, vm = viewModel(
                factory = VMFactory{
                    HomeScreenVM(context)
                }
            ))
        }
        composable("CreateScreen")
        {
//            HomeScreen(navController, vm = viewModel(factory = HomeScreenVM.VMFactory {
//                HomeScreenVM(context)
//            }))

            CreateScreen(navController = navController, viewModel = viewModel(
                factory = VMFactory{
                    CreateScreenVM(context )
                }
            ))
        }
    }
}

