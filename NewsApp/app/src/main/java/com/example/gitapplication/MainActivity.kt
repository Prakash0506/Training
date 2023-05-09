package com.example.gitapplication

import HomeScreen
import android.os.Bundle
import android.view.WindowManager
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
import com.example.gitapplication.pages.ViewScreen.ViewScreenVM
import com.example.gitapplication.ui.theme.GitApplicationTheme
import com.example.newsapp.Pages.CreateScreen.CreateScreen
import com.example.newsapp.Pages.CreateScreen.CreateScreenVM
import com.example.newsapp.Pages.ViewScreen.ViewScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
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
            HomeScreen(navController = navController, vm = viewModel(
                factory = VMFactory{
                    HomeScreenVM(context)
                }
            ))
        }
        composable("CreateScreen")
        {
            CreateScreen(navController = navController, viewModel = viewModel(
                factory = VMFactory{
                    CreateScreenVM(context )
                }
            ))
        }

        composable("ViewScreen?long={long}", arguments = listOf(navArgument("long") {
            type = NavType.LongType
            defaultValue = 0L
        })) {
            ViewScreen(navController, vm = viewModel(factory = VMFactory {
                ViewScreenVM()
            }), it.arguments?.getLong("long") ?: 0L)
        }
    }
}

