package com.example.tubelineapplication.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tubelineapplication.presentation.TubeList.components.TubeListScreen
import com.example.tubelineapplication.presentation.ui.theme.TubeLineApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TubeLineApplicationTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "tube_list"
                    ) {
                        composable(route = "tube_list") {
                            TubeListScreen(navController = navController)
                        }
                        composable(
                            route = "tube_details/{tubeId}",
                            arguments = listOf(navArgument("tubeId") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val tubeId = backStackEntry.arguments?.getString("tubeId")
                        }
                    }
                }
            }
        }
    }
}
