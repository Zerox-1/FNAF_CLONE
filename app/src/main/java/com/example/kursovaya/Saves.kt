package com.example.kursovaya

import android.content.ContentValues
import android.content.Context.MODE_PRIVATE
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import java.util.ArrayList

@Composable
fun GetSave(name1:String,navController: NavController) {
    db.execSQL("CREATE TABLE IF NOT EXISTS SAVES (id INTEGER PRIMARY KEY, name TEXT, pos INTEGER,bat INTEGER,minute INTEGER,sec INTEGER )")
    val query: String = "SELECT * FROM SAVES;"
    val cursor: Cursor = db.rawQuery(query, null)
    while (cursor.moveToNext()) {
        if (name1 == cursor.getString(1)) {
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
        Box( modifier = Modifier.fillMaxSize().background(Color.Black),contentAlignment = Alignment.Center) {
            Column {
                Text(text = "Найдено сохранение!",color=Color.White)
                Button(onClick = { navController.navigate(Marshroutes.route4) }, colors = ButtonDefaults.buttonColors(Color.Gray)) {
                    Text("Подтвердить")
                }
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize().background(Color.Black), contentAlignment = Alignment.Center) {
            Column {
                Text(text = "Cохранение не найдено!",color=Color.White)
                Button(onClick = { navController.navigate(Marshroutes.route2) }, colors = ButtonDefaults.buttonColors(Color.Gray)) {
                    Text("Подтвердить")
                }
            }
        }
    }
}

object Saves1{
    var save:Int=0
    var name:String=""
    var pos: Int=0
    var bat: Double=0.0
    var minut: Int=0
    var sec: Double=0.0
}