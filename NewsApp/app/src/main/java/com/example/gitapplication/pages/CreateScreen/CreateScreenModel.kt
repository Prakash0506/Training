package com.example.newsapp.Pages.CreateScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

open class CreateScreenModel:ViewModel() {

    var title by mutableStateOf("")

    var description by mutableStateOf("")

    var date by mutableStateOf("")

    var category by mutableStateOf("")

    var titleCheck by mutableStateOf(false)

    var descriptionCheck by mutableStateOf(false)

    var dateCheck by mutableStateOf(false)

    var categoryCheck by mutableStateOf(false)

}