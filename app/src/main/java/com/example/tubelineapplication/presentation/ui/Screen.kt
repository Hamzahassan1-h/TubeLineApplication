package com.example.tubelineapplication.presentation.ui

sealed class Screen (val route: String){
    data object TubeListScreen: Screen("Tube_list")
}