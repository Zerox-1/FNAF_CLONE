package com.example.kursovaya

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kursovaya.ui.theme.KursovayaTheme

lateinit var db: SQLiteDatabase

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        db = openOrCreateDatabase("Kursovaya", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS RESULTS (id INTEGER PRIMARY KEY, name TEXT, minute INTEGER, sec INTEGER )")
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContent {
            KursovayaTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Marshroutes.route1) {
                    composable(route=Marshroutes.route1) { MainMenu(navController) }
                    composable(route = Marshroutes.route2){Game(0,0,0.0,0,0.0,navController)}
                    composable(route=Marshroutes.route3){ Table(navController)}
                    composable(route=Marshroutes.route4){Game(Saves1.save,Saves1.pos,Saves1.bat,Saves1.minut,Saves1.sec,navController)}
                    composable(route=Marshroutes.route5){ Register(navController)}
                    composable(route=Marshroutes.route6){ Register1(navController)}
                    composable(route=Marshroutes.route7){ GetSave(NAME,navController)}
                    composable(route=Marshroutes.route8){ SetSave(NAME, Position,
                        Battarey, Minut, Sec,navController)}
                }
            }
        }
    }
}