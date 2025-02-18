import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReportV4())
        println("Have a good day!")
    }
}

// Esta función obtiene el reporte del tiempo utilizando coroutines para ejecutar las tareas de manera asíncrona
suspend fun getWeatherReportV4() = coroutineScope {
    val forecast = async { getForecastV4() }

    //Al capturar la excepción, forecast y el padre pueden continuar
    val temperature = async {
        try {
            getTemperatureV4()
        } catch (e: AssertionError) {
            println("Caught exception $e")
            "{ No temperature found }"
        }
    }

    "${forecast.await()} ${temperature.await()}"
}

// Simula obtener el pronóstico del tiempo con un retraso
suspend fun getForecastV4(): String {
    delay(1000) // Retraso simulado de 1 segundo
    return "Sunny" // Retorna el pronóstico "Soleado"
}

// Simula obtener la temperatura actual con un retraso
suspend fun getTemperatureV4(): String {
    delay(500) // Retraso simulado de 1 segundo
    //Esta excepcion cancela tanto la ejecucio de sus procesos hermanos y del padre
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C" // Retorna la temperatura "30°C"
}