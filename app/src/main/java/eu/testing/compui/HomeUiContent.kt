package eu.testing.compui

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import eu.testing.compui.toolbar.DrawerContent
import eu.testing.compui.toolbar.TopBar
import eu.testing.compui.ui.theme.*

@Composable
fun HomePage(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            DrawerContent(navController = navController, drawerState = drawerState)
        }
    ) {
        TopBar(
            drawerState = drawerState,
            title = "Shoppers' Stop",
            rightButton = R.drawable.search_alt_2_svgrepo_com
        )
        // Scrolling content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp)
                .verticalScroll(rememberScrollState())
        ) {
            for (i in 0 until 10) {
                RowOfItems(
                    icon1 = R.drawable.green_shoe,
                    title1 = "Green Shoe",
                    icon2 = R.drawable.red_shoe,
                    title2 = "Red Shoe",
                    navController = navController
                )
                RowOfItems(
                    icon1 = R.drawable.red_shoe,
                    title1 = "Red Shoe",
                    icon2 = R.drawable.green_shoe,
                    title2 = "Green Shoe",
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowOfItems(
    @DrawableRes icon1: Int,
    title1: String,
    @DrawableRes icon2: Int,
    title2: String,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .padding(horizontal = 36.dp)
            .clickable {
                navController.navigate("product_details")
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Items(icon = icon1, title = title1)
        Items(icon = icon2, title = title2)
    }
}

@Composable
fun Items(
    @DrawableRes icon: Int,
    title: String,
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .border(2.dp, Color.White, shape = RoundedCornerShape(16.dp))
            .background(White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        // Column to hold Image and Text vertically
        Column(
            modifier = Modifier.padding(16.dp), // Padding inside the card
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .width(56.dp)
                    .height(56.dp)
            )
            Text(
                text = title,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Buttons(
                icon = R.drawable.shopping_cart_outline_svgrepo_com,
                tint = darkPink,
//                toast = "Added to cart"
            )
        }
    }
}

@Composable
fun Buttons(
    @DrawableRes icon: Int,
    tint: Color = Color.Unspecified,

//    toast: String
) {
    val navController= rememberNavController()
    val context = LocalContext.current
//    val click =
//        if (icon == R.drawable.logout_svgrepo_com) FirebaseAuth.getInstance().signOut() else null
    IconButton(onClick = {
        try {
            if (icon == R.drawable.logout_svgrepo_com) {
                FirebaseAuth.getInstance().signOut()
                navController.navigate("login")
            }
            else if(icon == R.drawable.search_alt_2_svgrepo_com) {
                Log.d("Search", "Search clicked")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("FireabaseAuth", "User laready logged out")
        }
    }) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.padding(vertical = 10.dp),
            tint = tint
        )
    }
}
