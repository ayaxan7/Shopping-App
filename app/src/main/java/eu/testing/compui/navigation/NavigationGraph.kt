package eu.testing.compui.navigation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import eu.testing.compui.HomePage
import eu.testing.compui.auth.signin.SignInScreen
import eu.testing.compui.auth.signin.SignInViewModel
import eu.testing.compui.auth.signup.SignUpScreen
import eu.testing.compui.auth.signup.SignUpViewModel
import eu.testing.compui.stepcounter.StepCounter
import eu.testing.compui.toolbar.screens.FeedBack
import eu.testing.compui.toolbar.screens.Settings


sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    data object FeedBack : BottomNavItem("feedback", Icons.Default.Warning, "FeedBack")
    data object Settings : BottomNavItem("settings", Icons.Default.Settings, "Settings")
    data object Steps : BottomNavItem("steps", Icons.Default.AddCircle, "StepCounter")
}

@Composable
fun NavigationGraph() {
    val user=FirebaseAuth.getInstance().currentUser
    val navController = rememberNavController()
//    val start=if (user==null) "signup" else "home"
    // Observe the navigation changes
    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { controller, destination, _ ->
            val currentRoute = destination.route
            Log.d("NavigationGraph", "User: $user, Current screen: $currentRoute")
        }
    }
    Scaffold (bottomBar = { BottomNavBar(navController) }){innerPadding ->
        NavHost(navController = navController, startDestination = BottomNavItem.Home.route, modifier = Modifier.padding(innerPadding)) {
            composable(BottomNavItem.Home.route) {
                HomePage(navController = navController)
            }
            composable(BottomNavItem.Steps.route) {
                StepCounter(navController=navController)
            }
            composable(BottomNavItem.FeedBack.route) {
                FeedBack(navController = navController)
            }
            composable("login") {
                SignInScreen(navController = navController, signInViewModel = SignInViewModel())
            }
            composable("signup") {
                SignUpScreen(navController = navController, vm = SignUpViewModel())
            }
            composable(BottomNavItem.Settings.route) {
                Settings(navController = navController)
            }
        }
    }
}
