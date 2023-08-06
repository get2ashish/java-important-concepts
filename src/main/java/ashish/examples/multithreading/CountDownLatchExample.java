package ashish.examples.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {

        //Count down latch is usefull when you have muktiple dependent service and you want to proceed when all of them
        //complete

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CountDownLatch countDownLatch = new CountDownLatch(3);

        executorService.submit(new DependentService(countDownLatch));
        executorService.submit(new DependentService(countDownLatch));
        executorService.submit(new DependentService(countDownLatch));

        countDownLatch.await();
        //This code will only be executed once all the 3 dependent services have called countDown (completed or as per business logic)
        System.out.println("All dependent services completed (executing code after countdown latch completes)");
    }

}


class DependentService implements Runnable{

    private final CountDownLatch latch;
    private final int WAIT_TIME = 2000;
    public DependentService(CountDownLatch countDownLatch) {
        this.latch = countDownLatch;
    }

    @Override
    public void run() {
        //some task
        System.out.println("Thread "+Thread.currentThread().getName()+" waiting for "+WAIT_TIME+" seconds.");
        try {
            Thread.sleep(WAIT_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread "+Thread.currentThread().getName()+" wait completed, calling count down.");
        latch.countDown();
    }
}