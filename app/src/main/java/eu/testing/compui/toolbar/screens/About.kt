package eu.testing.compui.toolbar.screens

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import eu.testing.compui.R
import eu.testing.compui.toolbar.DrawerContent
import eu.testing.compui.toolbar.TopBar

@Composable
fun FeedBack(navController: NavController){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val name = remember { mutableStateOf("") }
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            DrawerContent(navController = navController, drawerState = drawerState)
        }
    ) {
        TopBar(
            drawerState = drawerState,
            title = "FeedBack",
            rightButton = R.drawable.logout_svgrepo_com
        )
    }
}