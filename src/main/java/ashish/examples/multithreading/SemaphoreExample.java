package ashish.examples.multithreading;

import java.util.concurrent.Semaphore;

//Semaphore are used when you want to manage or restrict the use of limited resources
public class SemaphoreExample {
    //When fairness is set to true then thread that waits the longest get to run first (FIFO)
    private static Semaphore semaphore = new Semaphore(1, true);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                semaphore.acquire();
                sharedResources();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        }, "T1");

        Thread t2 = new Thread(() -> {
            try {
                semaphore.acquire();
                sharedResources();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        }, "T2");

        Thread t3 = new Thread(() -> {
            try {
                semaphore.acquire();
                sharedResources();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        }, "T3");

        Thread t4 = new Thread(() -> {
            try {
                semaphore.acquire();
                sharedResources();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        }, "T4");

        Thread t5 = new Thread(() -> {
            try {
                semaphore.acquire();
                sharedResources();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        }, "T5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    //This method can handle only 1 request at a time
    private static void sharedResources() throws InterruptedException {
        System.out.println("Going to sleep! Thread " + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("Thread finished " + Thread.currentThread().getName());
    }

}
