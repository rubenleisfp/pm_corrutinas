package playground.ejemplo_java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EjemploEnjava {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Creamos un ejecutor de hilos
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //Creamos un hilo de tipo Callable, es decir, podemos obtener un retorno de el observandolo
        TareaAsincrona tareaAsincrona = new TareaAsincrona();
        //Ejecutamos la tarea asincrona
        Future<String> future = executor.submit(tareaAsincrona);
        //Esperamos por la asincrona para obtener el resultado
        //System.out.println(future.get());
        System.out.println("Tarea principal finalizada");
    }
}