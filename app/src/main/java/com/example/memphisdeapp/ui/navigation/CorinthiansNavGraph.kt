package com.example.memphisdeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.memphisdeapp.data.CorinthiansRepository
import com.example.memphisdeapp.ui.CorinthiansScreen
import com.example.memphisdeapp.ui.CorinthiansViewModel
import com.example.memphisdeapp.ui.CorinthiansViewModelFactory
import com.example.memphisdeapp.ui.SplashScreen

@Composable
fun CorinthiansNavGraph(navController: NavHostController, corinthiansRepository: CorinthiansRepository) {
    val viewModel: CorinthiansViewModel = viewModel(factory = CorinthiansViewModelFactory(corinthiansRepository))

    NavHost(navController, startDestination = "splashScreen") {
        composable("splashScreen") { SplashScreen(navController) }
        composable("corinthiansScreen") { CorinthiansScreen(viewModel) }
    }
}
