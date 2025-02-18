import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {

    val time = measureTimeMillis {
        runBlocking {
            //Este código es secuencial
            println("Weather forecast")
            printForecast()
            printTemperature()
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

suspend fun printForecast() {
    delay(3000)
    println("Sunny")
}

suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
} 