package ashish.dev;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadsSharingObjects {
    public static void main(String[] args) {

        MyRunnable runnable = new MyRunnable();

        Thread t1 = new Thread(runnable, "MyThread1");
        Thread t2 = new Thread(runnable, "MyThread2");
        t1.start();
        t2.start();
    }
}

class MyRunnable implements Runnable {
    //Making count variable volatile is not enough as 2 threads are updating the value at the same time
    //Volatile only guarantees that value will be read and written to main memory and not from cache or CPU registers
    //A possible solution for this use case can be to use AtomicInteger
    int count = 0;

    AtomicInteger counter = new AtomicInteger(0);


    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
                this.count++;
                this.counter.incrementAndGet();
        }
        System.out.println("Count value for Thread " + Thread.currentThread().getName() + " is " + count);
        System.out.println("Counter value for Thread " + Thread.currentThread().getName() + " is " + counter);
    }
}
