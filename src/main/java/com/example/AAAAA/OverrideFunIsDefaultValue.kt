package com.example.AAAAA

fun main() {
    val strImpl = SimpleFactory().simpleFactory(Level.INFO)
    val workFlow = "CHECK"
    val place = "Controller"
    val target = "Server"

    println("BEGIN & END")
    println("******")


    strImpl.log(Level.INFO,
            Type.BEGIN,
            workFlow = "CHECK")

    println("\n******")
    println("INPUT & OUTPUT")
    println("******")


    strImpl.log(Level.INFO,
            Type.INPUT,
            workFlow = workFlow,
            args = *arrayOf(Param("one", "1"),
                    Param("two", "2"),
                    Param("three", "3")))

    println("\n******")
    println("REQUEST & RESPONSE")
    println("******")


    strImpl.log(Level.INFO,
            Type.REQUEST,
            workFlow = workFlow,
            place = place,
            target = target,
            args = *arrayOf(Param("one", "1"),
                    Param("two", "2"),
                    Param("three", "3")))

    println("\n******")
    println("RESPONSE_CODE")
    println("******")


    strImpl.log(Level.INFO,
            Type.RESPONSE_CODE,
            msg = "201")

    println("\n******")
    println("Log")
    println("******")


    strImpl.log(Level.INFO,
            Type.INFO,
            workFlow = workFlow,
            place = place,
            msg = "OK")

    println("\n******")
    println("LogError")
    println("******")


    strImpl.log(Level.INFO,
            Type.ERROR,
            workFlow = workFlow,
            msg = "OK")

}

interface LoggerInterface {
    fun log(level: Level, type: Type, workFlow: String = "", place: String = "", msg: String = "", target: String = "", vararg args: Param = arrayOf())
}

class LoggerImplements(private val outputLevel: Level) : LoggerInterface {

    override fun log(level: Level, type: Type, workFlow: String, place: String, msg: String, target: String, vararg args: Param) {
        if (level < outputLevel) return

        var output = "[$type]"

        if (workFlow.isNotEmpty()) output = output.plus("[$workFlow]")

        if (place.isNotEmpty()) output = output.plus(" : [$place]")

        if (place.isEmpty() && msg.isNotEmpty()) {
            output = output.plus(" : $msg")
        } else if (msg.isNotEmpty()) {
            output = output.plus("\n [Message] : $msg")
        }

        if (target.isNotEmpty()) output = output.plus("\n [Target] : $target")

        if (args.isNotEmpty()) {
            for (arg in args) {
                output = output.plus("\n $arg")
            }
        }
        println(output)
    }
}

interface LoggerFactory {
    fun simpleFactory(outputLevel: Level): LoggerInterface
}

class SimpleFactory : LoggerFactory {
    override fun simpleFactory(outputLevel: Level): LoggerInterface {
        return LoggerImplements(outputLevel)
    }
}

data class Param(private val name: String,
                 private val value: String
) {
    override fun toString(): String {
        return "Param [$name] : [$value]"
    }
}

enum class Type {
    BEGIN,
    END,
    INPUT,
    OUTPUT,
    REQUEST,
    RESPONSE,
    INFO,
    ERROR,
    RESPONSE_CODE
}

