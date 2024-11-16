package eu.testing.compui

import androidx.annotation.DrawableRes

object Data {
    class Demo(
        @DrawableRes var img:Int,
        var name:String,
//        var desc:String,
//        var price:String,
//        var rating:String
    )
    var DataList= listOf(
        Demo(
            R.drawable.green_shoe,
            name="Green Shoe",
//            desc="This is a green shoe",
//            price="$100",
//            rating="4.5"
        ),
        Demo(
            R.drawable.red_shoe,
            name="Red Shoe",
//            desc="This is a red shoe",
//            price="$100",
//            rating="3.5"
        )
    )
}