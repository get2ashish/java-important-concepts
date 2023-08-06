package ashish.examples.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        //This example Phaser will work as Countdown latch
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Phaser phaser = new Phaser(3);

        executorService.submit(new DependentInitializationService(phaser, 1));
        executorService.submit(new DependentInitializationService(phaser, 2));
        executorService.submit(new DependentInitializationService(phaser, 3));

        phaser.awaitAdvance(0);
        System.out.println("This is called after all dependent calls are complete.");
    }
}

class DependentInitializationService implements Runnable {

    private final Phaser phaser;
    private final int WAIT_TIME = 2000;
    private final int MULTIPLIER;

    public DependentInitializationService(Phaser phaser, int multiplier) {
        this.phaser = phaser;
        this.MULTIPLIER = multiplier;
    }

    @Override
    public void run() {
        //some task
        System.out.println("Thread " + Thread.currentThread().getName() + " waiting for " + MULTIPLIER * WAIT_TIME + " seconds.");
        try {
            Thread.sleep(MULTIPLIER * WAIT_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " wait completed, calling Phaser arrive.");
        //for working as countdown latch
        //phaser.arrive();

        //for working as cyclic barrier
        phaser.arriveAndAwaitAdvance();
        System.out.println("This will be printed for all thread at the same time.");
    }
}
