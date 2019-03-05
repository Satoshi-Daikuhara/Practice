package com.example.play

fun main() {
    val applicationName = "Test"
    val logImpl = SimpleFactory().simpleFactory(Level.INFO){str: String -> println(applicationName + str) }
    val workFlow = "CHECK"
    val place = "Controller"
    val target = "Server"

    println("BEGIN & END")
    println("******")


    logImpl.log(Level.INFO,
            Type.BEGIN,
            workFlow = "CHECK")

    println("\n******")
    println("INPUT & OUTPUT")
    println("******")


    logImpl.log(Level.INFO,
            Type.INPUT,
            workFlow = workFlow,
            args = *arrayOf(Param("one", "1"),
                    Param("two", "2"),
                    Param("three", "3")))

    println("\n******")
    println("REQUEST & RESPONSE")
    println("******")


    logImpl.log(Level.INFO,
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


    logImpl.log(Level.INFO,
            Type.RESPONSE_CODE,
            msg = "201")

    println("\n******")
    println("Log")
    println("******")


    logImpl.log(Level.INFO,
            Type.INFO,
            workFlow = workFlow,
            place = place,
            msg = "OK")

    println("\n******")
    println("LogError")
    println("******")


    logImpl.log(Level.INFO,
            Type.ERROR,
            workFlow = workFlow,
            msg = "OK")

}

interface LoggerInterface {
    fun log(level: Level, type: Type, workFlow: String = "", place: String = "", msg: String = "", target: String = "", vararg args: Param = arrayOf())
}

class LoggerImplements(private val outputLevel: Level,
                       private val output: (String) -> Unit) : LoggerInterface {

    override fun log(level: Level, type: Type, workFlow: String, place: String, msg: String, target: String, vararg args: Param) {
        if (level < outputLevel) return

        var message = "[$type]"

        if (workFlow.isNotEmpty()) message = message.plus("[$workFlow]")

        if (place.isNotEmpty()) message = message.plus(" : [$place]")

        if (place.isEmpty() && msg.isNotEmpty()) {
            message = message.plus(" : $msg")
        } else if (msg.isNotEmpty()) {
            message = message.plus("\n [Message] : $msg")
        }

        if (target.isNotEmpty()) message = message.plus("\n [Target] : $target")

        if (args.isNotEmpty()) {
            for (arg in args) {
                message = message.plus("\n $arg")
            }
        }
        output(message)
    }
}

interface LoggerFactory {
    fun simpleFactory(outputLevel: Level, output: (String) -> Unit): LoggerInterface
}

class SimpleFactory : LoggerFactory {
    override fun simpleFactory(outputLevel: Level, output: (String) -> Unit): LoggerInterface {
        return LoggerImplements(outputLevel, output)
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

