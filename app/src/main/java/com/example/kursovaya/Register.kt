package com.example.kursovaya

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Black), contentAlignment = Alignment.Center) {
        Column {
            var message by remember {
                mutableStateOf("")
            }
            Text(text = "Введите свое имя",color=Color.White )
            TextField(value = message, onValueChange = { newText -> message = newText }, colors =TextFieldDefaults.textFieldColors(textColor = Color.White) )
            NAME=message
            Button(
                onClick = {
                    navController.navigate(Marshroutes.route2) {
                        popUpTo(Marshroutes.route5) {
                            inclusive = true
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Gray)
            ) { Text(text = "Подтвердить")}
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register1(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black), contentAlignment = Alignment.Center) {
        Column {
            var message by remember {
                mutableStateOf("")
            }
            Text(text = "Введите свое имя",color=Color.White )
            TextField(value = message, onValueChange = { newText -> message = newText }, colors =TextFieldDefaults.textFieldColors(textColor = Color.White) )
            NAME=message
            Button(
                onClick = {  navController.navigate(Marshroutes.route7) {
                    popUpTo(Marshroutes.route6) {
                        inclusive = true
                    }
                }},
                colors = ButtonDefaults.buttonColors(Color.Gray)
            ){ Text(text = "Подтвердить")}
        }
    }
}