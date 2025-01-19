package eu.testing.compui.stepcounter

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController

@Composable
fun StepCounter(navController: NavController) {
    val context = LocalContext.current
    val stepCountListener = remember { StepCountListener(context) }  // Initialize sensor listener
    LaunchedEffect(Unit) {
        stepCountListener.startListening()
//        delay(100) // Allow time for an event
//        stepCountListener.stopListening() // Stop listening to prevent unnecessary updates
//        stepCountListener.startListening() // Restart for real-time updates
    }
    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        LaunchedEffect(Unit) { stepCountListener.startListening() }  // Start listening when UI loads
        Text("Step Counter: ${stepCountListener.steps.value}")  // Display real-time step count
    }
}

