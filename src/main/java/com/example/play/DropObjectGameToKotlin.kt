package com.example.play

fun main(args: Array<String>) {
    val readyList = readLine()?.split(" ") ?: return
    val high = readyList[0].toInt()
    val wide = readyList[1].toInt()
    val obSu = readyList[2].toInt()
    val mapList = Array(high) {CharArray(wide)}

    for (h in 0 until high) {
        for (w in 0 until wide) {
            mapList[h][w] = '.'
        }
    }
    
    for (time in 0 until obSu) {
        val objList = readLine()?.split(" ") ?: return
        val obH = objList[0].toInt()
        val obW = objList[1].toInt()
        val obX = objList[2].toInt()
        var top = -1
        
        for (h in 0 until high) {
            for (w in 0 until wide) {
                if (mapList[h][w] == '.') top = h
            }
        }
        
        for (h in top+1..top+obH) {
            for (w in obX until obX+obW) {
                mapList[h][w] = '#'
            }
        }
    }
    
    for (h in high-1 downTo 0) {
        for (w in 0 until wide) {
            print(mapList[h][w])
        }
        println()
    }
}