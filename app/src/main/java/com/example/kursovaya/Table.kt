package com.example.kursovaya

import android.content.ContentValues
import android.database.Cursor
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun Table(navController:NavController) {
    val query = "SELECT * FROM RESULTS;"
    val cursor: Cursor = db.rawQuery(query, null)
    var results = buildString {
        while (cursor.moveToNext()) {
            var name = cursor.getString(1)
            var minut: Int = cursor.getInt(2)
            var sec: Double = cursor.getDouble(3)
            append("$name $minut:${sec.toInt()} \n")
            Log.d(//логирование
                "P11", "NAME: $name MINUT: $minut SEC:$sec\n!"
            )
        }
    }
    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Column {
            Text(results, modifier = Modifier.verticalScroll(ScrollState(1)),color=Color.White)
            Button(onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(Color.Gray)) {
                Text(text = "Вернуться")
            }
        }
    }
}


fun SaveInTable(name:String,minut:Int,sec:Double){
    db.execSQL("CREATE TABLE IF NOT EXISTS RESULTS (id INTEGER PRIMARY KEY, name TEXT, minute INTEGER, sec INTEGER )")
    val query= "SELECT * FROM RESULTS;"
    val cursor: Cursor = db.rawQuery(query, null)
    var id1:Int=0
    RESULT.res = 0
    while (cursor.moveToNext()) {
        if (name == cursor.getString(1)) {
            id1=cursor.getInt(0)
            RESULT.res = 1
            RESULT.name = cursor.getString(1)
            RESULT.minut = cursor.getInt(2)
            RESULT.sec = cursor.getDouble(3)
            break
        }
    }
    if (RESULT.res == 1) {
        db.delete("RESULTS", "id = ?", arrayOf("$id1"));
    }
    val cv: ContentValues = ContentValues()
    cv.put("name", RESULT.name)
    cv.put("minute", minut)
    cv.put("sec",sec.toInt())
    db.insert("RESULTS", null, cv)
}

object RESULT{
    var res=0
    var name=NAME
    var minut=0
    var sec=0.0
}