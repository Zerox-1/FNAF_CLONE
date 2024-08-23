package com.example.kursovaya

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kursovaya.R

var NAME:String=""
var Position=0
var LeftClosed=0
var RightClosed=0
var LeftLight=0
var RightLight=0
var tacking_b=0
var Battarey =100.0
var Minut =0
var Sec=0.0
@Composable
fun MainMenu(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.mainmenu),
            contentScale = ContentScale.Crop,
            contentDescription = "Главное меню",
            modifier = Modifier
                .fillMaxSize()
                .offset(0.dp, 0.dp)

        )
        Button(
            onClick = { navController.navigate(Marshroutes.route5) },
            modifier = Modifier.background(Color.Transparent).width(120.dp).offset(37.dp,110.dp).alpha(0.0f)
        ){
        }
        Button(
            onClick = { navController.navigate(Marshroutes.route6)},
            modifier = Modifier.background(Color.Transparent).width(130.dp).offset(37.dp,160.dp).alpha(0.0f)
        ){
        }
        Button(
            onClick = {navController.navigate(Marshroutes.route3)  },
            modifier = Modifier.background(Color.Transparent).width(120.dp).offset(37.dp,215.dp).alpha(0.0f)
        ){
        }
        Button(
            onClick = { System.exit(0) },
            modifier = Modifier.background(Color.Transparent).width(120.dp).offset(37.dp,270.dp).alpha(0.0f)
        ){
        }
    }
}