package com.example.kursovaya

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Game(save:Int,pos:Int,bat:Double,minut:Int,sec:Double,navController: NavController){
    navController.enableOnBackPressed(false)
    var save1 by remember {
        mutableStateOf(save)
    }
    val context= LocalContext.current
    var timertime by remember {
    mutableStateOf(0.0)
    }
    var minutes by remember {
        mutableStateOf(0)
    }
    if (save1==1){
        Position=pos
        Battarey=bat
        timertime +=sec
        minutes +=minut
        save1-=1
    }
    var timertime1 by remember {
        mutableStateOf(0.0)
    }
    var dvig by remember {
        mutableStateOf(1)
    }
    val SceneRem = remember {
        mutableStateOf(0.0f)
    }
    val Cmr = remember {
        mutableStateOf(1)
    }
    CoroutineScope(Dispatchers.Main).launch {
        timertime += 0.015
        Sec+=0.015
        timertime1 += 0.015
        if((timertime1 / 5).toInt() >= 1){
            dvig= relocation()
            timertime1=0.0
        }
        if (dvig==0){
            NextMove()
            dvig=1
        }
        if ((timertime / 60).toInt() >= 1) {
            minutes += 1
            Minut+=1
            timertime = 0.0
            Sec=0.0
        }
        Battarey-=tacking_b*0.01
        delay(1000)
    }
    Box {
        if(Position!=5 && Battarey>0){
            if (SceneRem.value == 0.0f) {
                Office(context = context)
            } else {
                Camera(Cmr, Position)
            }
            Text(text=Battarey.toInt().toString(), fontSize = 20.sp)
            Text(text="Выход", fontSize = 20.sp,modifier = Modifier.offset(LocalConfiguration.current.screenWidthDp.dp/2, 0.dp).clickable { navController.navigate(Marshroutes.route8) })
            Text(text= "${minutes}:${timertime .toInt()}", modifier = Modifier.offset(LocalConfiguration.current.screenWidthDp.dp-50.dp, 0.dp), fontSize = 20.sp)
            Button(
                onClick = { SceneRem.value = 1.0f; tacking_b+=1},
                enabled = if (SceneRem.value == 0.0f) {true}; else {false},
                modifier = Modifier
                    .offset(0.dp, 275.dp)
                    .width(LocalConfiguration.current.screenWidthDp.dp / 2)
                    .height(50.dp)
                    .alpha(0.75f)
            ) {}
            Button(
                onClick = { SceneRem.value = 0.0f;tacking_b-=1 },
                enabled = if (SceneRem.value == 1.0f) { true }; else {false},
                modifier = Modifier
                    .offset(LocalConfiguration.current.screenWidthDp.dp / 2, 275.dp)
                    .width(LocalConfiguration.current.screenWidthDp.dp / 2)
                    .height(50.dp)
                    .alpha(0.75f)
            ) {}
        }
        else{
            SaveInTable(NAME, minutes,timertime.toInt().toDouble())
            jmpscr(navController = navController,context)
        }
}
}