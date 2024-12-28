package eu.testing.compui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import eu.testing.compui.HomePage
import eu.testing.compui.toolbar.screens.Settings

@Composable
fun AboutPage() {
    TODO("Not yet implemented")
}

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomePage(navController=navController)
        }
        composable("settings") {
            Settings(navController=navController)
        }
    }
}
