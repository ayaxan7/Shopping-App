package eu.testing.compui.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
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
    Column(
        modifier = Modifier
        .fillMaxHeight()
            .width(300.dp)
            .background(
                color = darkPink
            )
            .padding(top=56.dp)
    ) {
        Text(
            text = "Home",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    scope.launch { navController.navigate("home") }
                },
//            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = "Settings",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    scope.launch { navController.navigate("settings") }
                },
//            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = "About",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    scope.launch { drawerState.close() }
                },
//            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )
    }
}
