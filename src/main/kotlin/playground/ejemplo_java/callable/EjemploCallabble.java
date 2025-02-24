package playground.ejemplo_java.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EjemploCallabble {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Creamos un ejecutor de hilos
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //Creamos un hilo de tipo Callable, es decir, podemos obtener un retorno de el observandolo
        PintarAula pintarAula1 = new PintarAula("Alberto");
        PintarAula pintarAula2 = new PintarAula("Ruben");
        PintarAula pintarAula3 = new PintarAula("Lucia");
        //Ejecutamos la tarea asincrona
        Future<Long> response1 = executor.submit(pintarAula1);
        Future<Long> response2 =executor.submit(pintarAula2);
        Future<Long> response3 = executor.submit(pintarAula3);

        while (!response1.isDone() && !response1.isDone() && !response1.isDone()) {
            System.out.println("Esperando a que acaben tanto Alberto, como Ruben como Lucia...");
        }
        Long duracionAlberto = response1.get();
        Long duracionRuben = response2.get();
        Long duracionLucia = response3.get();
        System.out.println("Duracion total : " +  + duracionAlberto + duracionRuben + duracionLucia);
        System.out.println("Tarea principal finalizada");
        executor.shutdown();
    }


}