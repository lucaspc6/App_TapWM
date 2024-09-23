package com.example.memphisdeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.memphisdeapp.data.AppContainer
import com.example.memphisdeapp.ui.navigation.CorinthiansNavGraph
import com.example.memphisdeapp.ui.theme.MemphisDeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemphisDeAppTheme {

                val appContainer = AppContainer(applicationContext)
                val corinthiansRepository = appContainer.corinthiansRepository
                val navController = rememberNavController()
                CorinthiansNavGraph(navController = navController, corinthiansRepository = corinthiansRepository)
            }
        }
    }
}
