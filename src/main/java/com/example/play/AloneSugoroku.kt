package com.example.play

fun main(args: Array<String>) {
    val line = readLine()?.split(" ") ?: return
    val dice = mapOf(
            line[0].toInt() to "T",
            line[1].toInt() to "B",
            line[2].toInt() to "U",
            line[3].toInt() to "D",
            line[4].toInt() to "L",
            line[5].toInt() to "R"
    )

    val masu = readLine()?.toInt() ?: return
    val boardList = mutableListOf<Int>()

    for (num in 0 until masu) {
        boardList.add(readLine()?.toInt() ?: return)
    }

    var currentStr = "T"
    var count = 0

    for (num in 1 until boardList.size) {
        val nextStr = dice[boardList[num]] ?: return
        if ((currentStr == "T" && nextStr == "B")
                || (currentStr == "B" && nextStr == "T")
                || (currentStr == "L" && nextStr == "R")
                || (currentStr == "R" && nextStr == "L")
                || (currentStr == "U" && nextStr == "D")
                || (currentStr == "D" && nextStr == "U")) {
            count += 2
            currentStr = nextStr
        } else if (currentStr != nextStr) {
            count += 1
            currentStr = nextStr
        }
}
    println(count)
}