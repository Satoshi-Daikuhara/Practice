package com.example.play

class StaticObject{
    companion object {
        private const val applicationName = "TestApplication"
        val testLogger = SimpleFactory().simpleFactory(Level.INFO){str -> println(applicationName + str)}
//        val testAppLogger = SimpleFactory().simpleFactory(Level.INFO){str -> Log.i(applicationName, str)}
    }
}

fun main(){
    StaticObject.testLogger.log(Level.INFO,
            Type.BEGIN,
            workFlow = "CHECK")
}