package com.example.AAAAA

fun main (args: Array<String>){
    println(Level.INFO.compareTo(Level.WARNING)) //-1
    println(Level.INFO.compareTo(Level.INFO)) //0
    println(Level.WARNING.compareTo(Level.INFO)) //1
    println(Level.WARNING >= Level.ERROR) // false
    println(Level.WARNING >= Level.WARNING) // true
    println(Level.ERROR >= Level.WARNING) // true
}

enum class Level{
    INFO,
    WARNING,
    ERROR
}

