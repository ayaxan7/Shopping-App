package eu.testing.compui.toolbar.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import eu.testing.compui.toolbar.DrawerContent
import eu.testing.compui.toolbar.TopBar

@Composable
fun Settings(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            DrawerContent(navController = navController, drawerState = drawerState)
        }
    ) {
        TopBar(drawerState = drawerState, title = "Settings")
    }
//    Text(
//        text = "Settings",
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    )
}