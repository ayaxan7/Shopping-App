package eu.testing.compui

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import eu.testing.compui.ui.theme.*

@Composable
fun homePage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
    ) {
        // Toolbar at the top of the screen
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(darkPink),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            buttons(icon = R.drawable.align_left_svgrepo_com, tint = Color.White, toast = "Navbar Clicked")
            Text(
                text = "Shoppers' Stop",
                modifier = Modifier.padding(vertical = 10.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            buttons(icon = R.drawable.search_alt_2_svgrepo_com, tint = Color.White,toast="Search Clicked")
        }

        // Scrolling content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            for (i in 0 until 10){
                RowOfItems(
                    icon1 = R.drawable.align_left_svgrepo_com,
                    title1 = "White Shirt",
                    icon2 = R.drawable.search_alt_2_svgrepo_com,
                    title2 = "Black Shirt"
                )
                RowOfItems(
                    icon2 = R.drawable.align_left_svgrepo_com,
                    title2 = "White Shirt",
                    icon1 = R.drawable.search_alt_2_svgrepo_com,
                    title1 = "Black Shirt"
                )
            }
            }


    }
}

@Composable
fun RowOfItems(@DrawableRes icon1:Int,
               title1:String,
               @DrawableRes icon2:Int,
                title2:String)
{
Row(modifier=Modifier.padding(vertical=10.dp)
    .fillMaxWidth().padding(horizontal = 36.dp),
    horizontalArrangement = Arrangement.SpaceBetween){
    items(icon = icon1, title = title1)
    items(icon = icon2, title = title2)
    }
}
@Composable
fun items(
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
                buttons(icon = R.drawable.shopping_cart_outline_svgrepo_com, tint = darkPink ,toast="Added to cart")
            }
        }
}
@Composable
fun buttons(
    @DrawableRes icon: Int,
    tint: Color = Color.Unspecified,
    toast:String
) {
    var context= LocalContext.current
    IconButton(onClick = { Toast.makeText(context,"${toast}",Toast.LENGTH_SHORT).show() }) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.padding(vertical = 10.dp),
            tint = tint
        )
    }
}
