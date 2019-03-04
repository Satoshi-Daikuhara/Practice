package com.example.AAAAA


fun main(args: Array<String>) {
    creditCardNumber()
}


fun creditCardNumber() {
    print("Number of leaves >")
    val leaves = readLine()?.toInt() ?: return

    val cards: MutableList<String> = mutableListOf()

    for (i in 0 until leaves) {
        cards.add(readLine() ?: return)
    }

    checkDigit(cards)
}

fun checkDigit(cards: List<String>) {
    for (card in cards) {
        var evens = 0
        var odds = 0
        val cardNumbers: MutableList<Int> = mutableListOf()
        for (index in 0 until card.length - 1) {
            cardNumbers.add(card.substring(index, index + 1).toInt())
        }

        for (index in 0 until cardNumbers.size) {
            if (index % 2 == 0) {
                val even = cardNumbers[index] * 2
                evens += if (even >= 10) 1 + (even % 10)
                else even
            } else {
                odds += cardNumbers[index]
            }
        }
        println((10 - ((evens + odds) % 10)) % 10)
    }
}

