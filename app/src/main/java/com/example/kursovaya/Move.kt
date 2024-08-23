package com.example.kursovaya

fun relocation():Int{
    val ver = (0..3).random()
    if (ver==0){
        return 0
    }
    return 1
}
fun NextMove(){
    if (Position==0){
        Position=(1..2).random()
    }
    else if(Position==1){
        Position=(1..3).random()
        if(Position==2){
            Position=3
        }
    }
    else if(Position==2){
        Position=(2..4).random()
        if(Position==3){
            Position=4
        }
    }
    else if(Position==3){
        if (LeftClosed==1){
            Position=0
        }
        else{
            Position=5
        }
    }
    else if(Position==4){
        if (RightClosed==1){
            Position=0
        }
        else{
            Position=5
        }
    }
}