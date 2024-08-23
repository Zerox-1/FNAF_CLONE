package com.example.kursovaya

import android.content.ContentValues
import android.database.Cursor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun SetSave(Name1: String,pos1:Int,bat1: Double,minut1:Int,sec1:Double,navController: NavController) {
    val query= "SELECT * FROM SAVES;"
    val cursor: Cursor = db.rawQuery(query, null)
    var id1:Int=0
    Saves1.save = 0
    while (cursor.moveToNext()) {
        if (Name1 == cursor.getString(1)) {
            id1=cursor.getInt(0)
            Saves1.save = 1
            Saves1.name = cursor.getString(1)
            Saves1.pos = cursor.getInt(2)
            Saves1.bat = cursor.getDouble(3)
            Saves1.minut = cursor.getInt(4)
            Saves1.sec = cursor.getDouble(5)
            break
        }
    }
    if (Saves1.save == 1) {
        Box (modifier = Modifier.fillMaxSize().background(Color.Black),contentAlignment = Alignment.Center){
            Column {
                Text(text = "Найдено сохранение! Перезаписать?",color= Color.White)
                Row {
                    Button(onClick = {
                        db.delete("SAVES", "id = ?", arrayOf("$id1"));
                        val cv: ContentValues = ContentValues()
                        cv.put("name", Name1)
                        cv.put("pos", pos1)
                        cv.put("bat", bat1)
                        cv.put("minute", minut1)
                        cv.put("sec", sec1)
                        db.insert("SAVES", null, cv)
                        ;navController.navigate(Marshroutes.route1)
                    } ,
                        colors = ButtonDefaults.buttonColors(Color.Gray)) {
                        Text("Подтвердить")
                    }
                    Button(onClick = {navController.navigate(Marshroutes.route1)} ,
                        colors = ButtonDefaults.buttonColors(Color.Gray)) {
                        Text("Нет")
                    }
                }
            }
        }
    }
    else {
        val cv: ContentValues = ContentValues()
        cv.put("name",Name1)
        cv.put("pos",pos1)
        cv.put("bat",bat1)
        cv.put("minute",minut1)
        cv.put("sec",sec1)
        db.insert("SAVES",null,cv)
        navController.navigate(Marshroutes.route1)
    }
}