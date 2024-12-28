package eu.testing.compui.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import eu.testing.compui.Buttons
import eu.testing.compui.R
import eu.testing.compui.ui.theme.White
import eu.testing.compui.ui.theme.darkPink
import kotlinx.coroutines.launch

@Composable
fun TopBar(drawerState: DrawerState,title:String) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
    ) {
        // Toolbar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(darkPink),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                scope.launch {
                    if (drawerState.isClosed) drawerState.open() else drawerState.close()
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.align_left_svgrepo_com),
                    contentDescription = "Open Drawer",
                    tint = Color.White
                )
            }
            Text(
                text = title,
                modifier = Modifier.padding(vertical = 10.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Buttons(
                icon = R.drawable.search_alt_2_svgrepo_com,
                tint = Color.White,
                toast = "Search Clicked"
            )
        }
    }
}