import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReportV5())
        println("Have a good day!")
    }
}

// Esta función obtiene el reporte del tiempo utilizando coroutines para ejecutar las tareas de manera asíncrona
suspend fun getWeatherReportV5() = coroutineScope {
    var forecastResult = ""
    var temperatureResult = ""

    //En el anterior caso, usabamos async, con esto usamos launch
    val forecastJob = launch {
        //Aqui normalmente ira una llamada a un API
        forecastResult = getForecastV5()
    }

    val temperatureJob = launch {
        temperatureResult = getTemperatureV5()
    }
    
    forecastJob.join()
    temperatureJob.join()

    "$forecastResult $temperatureResult"
}

// Simula obtener el pronóstico del tiempo con un retraso
suspend fun getForecastV5(): String {
    delay(1000) // Retraso simulado de 1 segundo
    return "Sunny" // Retorna el pronóstico "Soleado"
}

// Simula obtener la temperatura actual con un retraso
suspend fun getTemperatureV5(): String {
    delay(1000) // Retraso simulado de 1 segundo
    return "30\u00b0C" // Retorna la temperatura "30°C"
}