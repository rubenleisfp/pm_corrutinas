package com.fp.playground

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("Weather forecast")
        //Aqui se paraleliza el trabajo, se lanzan "ambos a la vez"
        launch {
            printForecast()
        }
        launch {
            printTemperature()
        }
        println("Have a good day!")
    }
}

suspend fun printForecast() {
    delay(3000)
    println("Sunny")
}

suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
}