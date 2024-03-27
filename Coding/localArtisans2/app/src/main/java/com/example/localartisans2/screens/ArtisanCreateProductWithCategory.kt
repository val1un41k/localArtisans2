package com.example.localartisans2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.localartisans2.screens.app.components.ButtonComponent
import com.example.localartisans2.screens.app.components.HeadingTextComponentWithLogOut
import com.example.localartisans2.screens.app.components.myTextFireldContent

@Composable
fun ArtisansProductCategoryProfile () {
    Surface(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            HeadingTextComponentWithLogOut(value = "Artisan's Product Category Profile")

            //TODO Create TextComponent ArtisanNameFromLogin
            myTextFireldContent(labelValue = "Artisan's Name & Surname")
            //TODO Create Component SelectCategoryDropbox
            Spacer(modifier = Modifier.height(10.dp))
            Text("Select Category")

            myTextFireldContent(labelValue = "Product Item Name")
            myTextFireldContent(labelValue = "Product Item Description")
            myTextFireldContent(labelValue = "Product Item Price (EUR)")
            myTextFireldContent(labelValue = "Product Item Discounted Price (EUR")
            //TODO Create ProductQuantityDropbox
            Text("Product Quantity on hand")

            Text("Product Item Picture")
            ButtonComponent(value ="Upload Picture")

            Spacer(modifier = Modifier.height(10.dp))
            ButtonComponent(value = "Create Product Item Record")
        }
    }
}