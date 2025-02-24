package playground.ejemplo_java.asincrono;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EjemploExecutor {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Creamos un ejecutor de hilos
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //Creamos un hilo de tipo Callable, es decir, podemos obtener un retorno de el observandolo
        PintarAula pintarAula1 = new PintarAula("Alberto");
        PintarAula pintarAula2 = new PintarAula("Ruben");
        PintarAula pintarAula3 = new PintarAula("Lucia");
        //Ejecutamos la tarea asincrona
        executor.submit(pintarAula1);
        executor.submit(pintarAula2);
        executor.submit(pintarAula3);


        System.out.println("Tarea principal finalizada");
        executor.shutdown();
    }


}