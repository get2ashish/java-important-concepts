package ashish.examples.multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private void readResource() {
        readLock.lock();
        System.out.println("Sleeping in readResource for Thread "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread woke up "+Thread.currentThread().getName());
        readLock.unlock();
    }

    private void writeResource() {
        writeLock.lock();
        System.out.println("Sleeping in writeResource for Thread "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread woke up "+Thread.currentThread().getName());
        writeLock.unlock();
    }

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();

        Thread t1 = new Thread(readWriteLock::readResource,"T1");
        Thread t2 = new Thread(readWriteLock::readResource,"T2");
        Thread t3 = new Thread(readWriteLock::readResource,"T3");
        Thread t4 = new Thread(readWriteLock::readResource,"T4");

        //All these threads can access the readResource as they are readonly
        t1.start();
        t2.start();
        t3.start();
        t4.start();


        Thread w1 = new Thread(readWriteLock::writeResource,"W1");
        Thread w2 = new Thread(readWriteLock::writeResource,"W2");
        Thread w3 = new Thread(readWriteLock::writeResource,"W3");
        Thread w4 = new Thread(readWriteLock::writeResource,"W4");

        //All these threads can only access writeResource one at a time(when they hold the lock)
        w1.start();
        w2.start();
        w3.start();
        w4.start();
    }

}
