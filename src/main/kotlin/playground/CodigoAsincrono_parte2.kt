package com.fp.playground

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("Weather forecast")
        //Aqui se paraleliza el trabajo, se lanzan "ambos a la vez"
        val forecast: Deferred<String> = async {
            getForecastV2()
        }
        val temperature: Deferred<String> = async {
            getTemperatureV2()
        }
        //Tengo que esperar que me devuelvan el resultado mis 2 metodos async
        println("${forecast.await()} ${temperature.await()}")
        println("Have a good day!")
    }
}

suspend fun getForecastV2(): String {
    delay(3000)
    return "Cloudy"
}

suspend fun getTemperatureV2(): String {
    delay(1000)
    return "11\u00b0C"
}