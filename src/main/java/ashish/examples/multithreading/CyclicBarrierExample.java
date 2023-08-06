package ashish.examples.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CyclicBarrier barrier = new CyclicBarrier(3);

        executorService.submit(new InitalizingService(barrier,1));
        executorService.submit(new InitalizingService(barrier,2));
        executorService.submit(new InitalizingService(barrier,3));
    }
}

class InitalizingService implements Runnable {

    private final CyclicBarrier barrier;
    private final int WAIT_TIME = 2000;
    private final int multiplier;

    public InitalizingService(CyclicBarrier barrier, int multiplier) {
        this.barrier = barrier;
        this.multiplier = multiplier;
    }

    @Override
    public void run() {
        //some task
        System.out.println("Thread " + Thread.currentThread().getName() + " will be waiting for " + multiplier * WAIT_TIME + " seconds.");
        try {
            Thread.sleep(multiplier * WAIT_TIME);
            System.out.println("Thread "+Thread.currentThread().getName()+" completed waiting now waiting for cyclic barrier completion.");
            barrier.await();
            System.out.println("This will be called when all threads come to barrie.await call.");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
