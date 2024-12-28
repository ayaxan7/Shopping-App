package eu.testing.compui.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import eu.testing.compui.ui.theme.darkPink
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(navController: NavController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    ModalDrawerSheet() {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(300.dp)
                .background(
                    color = darkPink
                )
                .verticalScroll(rememberScrollState())

        ) {
            Spacer(Modifier.height(12.dp))
            Text(
                "Main Menu",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.titleLarge
            )
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text("Home") },
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                selected = false,
                onClick = {
                    scope.launch {
                        drawerState.close()
                        navController.navigate("home")
                    }
                }
            )
            NavigationDrawerItem(
                label = { Text("Settings") },
                icon = { Icon(Icons.Outlined.Settings, contentDescription = "Settings") },
                selected = false,
                onClick = {
                    scope.launch { drawerState.close() }
                    navController.navigate("settings")
                }
            )
            NavigationDrawerItem(
                label = { Text("About") },
                icon = { Icon(Icons.Outlined.Warning, contentDescription = "Settings") },
                selected = false,
                onClick = {
                    scope.launch { drawerState.close() }
                    navController.navigate("feedback")
                }
            )
        }
    }
}
