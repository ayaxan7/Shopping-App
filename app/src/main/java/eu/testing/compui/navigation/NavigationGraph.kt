package eu.testing.compui.navigation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
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
import eu.testing.compui.toolbar.screens.FeedBack
import eu.testing.compui.toolbar.screens.Settings

@Composable
fun NavigationGraph() {
    val user=FirebaseAuth.getInstance().currentUser
    val navController = rememberNavController()
    val start=if (user==null) "login" else "home"
    // Observe the navigation changes
    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { controller, destination, _ ->
            val currentRoute = destination.route
            Log.d("NavigationGraph", "User: $user, Current screen: $currentRoute")
        }
    }
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomePage(navController=navController)
        }
        composable("feedback") {
            FeedBack(navController=navController)
        }
        composable("login") {
            SignInScreen(navController=navController,signInViewModel = SignInViewModel())
        }
        composable("signup") {
            SignUpScreen(navController=navController, signUpViewModel = SignUpViewModel())
        }
        composable("settings") {
            Settings(navController=navController)
        }
    }
}
