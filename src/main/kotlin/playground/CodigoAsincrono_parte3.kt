import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport3())
        println("Have a good day!")
    }
}

// Esta función obtiene el reporte del tiempo utilizando coroutines para ejecutar las tareas de manera asíncrona
suspend fun getWeatherReport3() = coroutineScope {
    val forecast = async { getForecastV3() } // Llama a la función que obtiene el pronóstico
    val temperature = async { getTemperatureV3() } // Llama a la función que obtiene la temperatura
    "${forecast.await()} ${temperature.await()}" // Espera los resultados de ambas funciones y los concatena
    //Para
}

// Simula obtener el pronóstico del tiempo con un retraso
suspend fun getForecastV3(): String {
    delay(1000) // Retraso simulado de 1 segundo
    return "Sunny" // Retorna el pronóstico "Soleado"
}

// Simula obtener la temperatura actual con un retraso
suspend fun getTemperatureV3(): String {
    delay(1000) // Retraso simulado de 1 segundo
    return "30\u00b0C" // Retorna la temperatura "30°C"
}