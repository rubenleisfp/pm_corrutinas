package playground.ejemplo_java.callable;


import java.time.Instant;
import java.util.Random;
import java.util.concurrent.Callable;

public class PintarAula implements Callable<Long> {

    private String name;

    public PintarAula(String name) {
        this.name = name;
    }


    @Override
    public Long call() throws Exception {
        Instant before = Instant.now();
        try {
            Thread.sleep(getRandomNumberUsingNextInt(1000, 3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Instant after = Instant.now();
        long seconds = after.getEpochSecond() - before.getEpochSecond();
        System.out.println("Aula pintada por: " + name + " en " + seconds +" segundos");
        return seconds;
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
