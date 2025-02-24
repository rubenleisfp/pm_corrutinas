package playground.ejemplo_java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.Callable;

public class TareaAsincrona implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);

        System.out.println("Ya hice mi tarea asincrona de obtener la fecha hora");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }
}
