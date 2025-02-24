package playground.ejemplo_java.asincrono;


import java.time.Instant;
import java.util.Random;

public class PintarAula extends Thread {

    private String name;

    public PintarAula(String name) {
        this.name = name;
    }


    @Override
    public void run()  {
        Instant before = Instant.now();
        try {
            Thread.sleep(getRandomNumberUsingNextInt(1000, 3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Instant after = Instant.now();
        long seconds = after.getEpochSecond() - before.getEpochSecond();
        System.out.println("Aula pintada por: " + name + " en " + seconds +" segundos");

    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
