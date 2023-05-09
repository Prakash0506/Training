package com.example.newsapp.Pages.CreateScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun CreateScreen(navController: NavHostController, viewModel: CreateScreenVM) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp)
            .verticalScroll(rememberScrollState(), enabled = true),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "CREATE NEWS")
        //title
        OutlinedTextField(
            value = viewModel.title,
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color(0xFF6066FF)),
            placeholder = {
                Text(
                    text = "enter title", color = Color(0xFFBEBEBF)
                )
            },
//            enabled = viewModel.isFieldsEnabled,
            onValueChange = { titlee ->
                viewModel.setTitleNews(titlee)
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 27.dp)
        )
        if (viewModel.titleCheck) {
            Text(text = "enter title")
        }
//desc
        OutlinedTextField(
            value = viewModel.description,
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color(0xFF6066FF)),
            placeholder = {
                Text(
                    text = "enter description", color = Color(0xFFBEBEBF)
                )
            },
//            enabled = viewModel.isFieldsEnabled,
            onValueChange = { des ->
                viewModel.setDescriptionNews(des)
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 27.dp)
        )
        if (viewModel.descriptionCheck) {
            Text(text = "enter description")
        }
//date
        OutlinedTextField(
            value = viewModel.date,
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color(0xFF6066FF)),
            placeholder = {
                Text(
                    text = "enter date", color = Color(0xFFBEBEBF)
                )
            },
//            enabled = viewModel.isFieldsEnabled,
            onValueChange = { datee ->
                viewModel.setNewsDate(datee)
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 27.dp)
        )
        if (viewModel.dateCheck) {
            Text(text = "enter date")
        }

//category
        Box(

            Modifier
                .padding(top = 27.dp)
                .clickable { viewModel.showMenu = !viewModel.showMenu }
        ) {
            OutlinedTextField(
                value = viewModel.category,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(
                        0xFF6066FF
                    )
                ),
                onValueChange = { category ->
//                viewModel.category = category
                }, enabled = false,
                label = {
                    Text(text = "category")
                },
                shape = RoundedCornerShape(10.dp), trailingIcon = {
                    Icon(imageVector = Icons.Default.ArrowDropDown, "contentDescription",
                        Modifier.clickable { viewModel.showMenu = !viewModel.showMenu })
                },
                modifier = Modifier
                    .fillMaxWidth()
//                    .padding(top = 27.dp)

            )
        }

        DropdownMenu(
            expanded = viewModel.showMenu,
            onDismissRequest = { viewModel.showMenu = false },
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 17.dp, start = 17.dp)
                .width(with(LocalDensity.current)
                { 200.dp })
                .align(Alignment.End)
                .background(color = Color.Transparent)

        )
        {

            var category = Category.values()
            category.forEach() {
                DropdownMenuItem(onClick = {
                    viewModel.category = it.name
                    viewModel.showMenu = false

                }) {
                    Text(text = it.name)
                }
            }
        }

        if (viewModel.categoryCheck) {
            Text(text = "enter category")
        }

        Button(onClick = {
//            viewModel.create(navController)
            viewModel.onClick(navController)
        }, modifier = Modifier.padding(top = 27.dp)) {
            Text(text = "Create")
        }
        Text(text = "Go Back",
            modifier = Modifier.clickable {
                navController.navigate("HomeScreen")
            })


    }


}


enum class Category(val str: String) {
    Trending("Hello there"),
    Local("hkjgvcdxcv"),
    Sports("jkghyfdt")
}