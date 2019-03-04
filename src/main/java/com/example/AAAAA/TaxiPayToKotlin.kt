package com.example.AAAAA

fun main(args: Array<String>) {
    val line = readLine()?.split(" ") ?: return
    val taxies = line[0].toInt()
    val long = line[1].toInt()
//    val taxiPay = mutableListOf<List<String>>()
//
//    for (num in 0 until taxies) {
//        taxiPay.add(readLine()?.split(" ") ?:return)
//    }

    val taxiPay = Array(taxies) { readLine()?.split(" ") ?: return}


    var min = 0
    var max = 0

    for (num in 0 until taxies) {
        var cost: Int
        val pay = taxiPay[num]
        val firstL = pay[0].toInt()
        val firstP = pay[1].toInt()
        val addL = pay[2].toInt()
        val addP = pay[3].toInt()

        if (long < firstL) {
            cost = firstP
        } else {
            var count = 1
            while (true) {
                if (long < firstL + addL * count) {
                    cost = firstP + addP * count
                    break
                } else {
                    count++
                }
            }
        }

        if (min == 0 || min > cost) min = cost
        if (max < cost) max = cost

        println("$min $max")
    }
}