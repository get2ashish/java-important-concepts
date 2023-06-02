package ashish.dev;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddLock {
    static int RANGE = 200;
    private static final ReentrantLock lock = new ReentrantLock(true);
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {

        Thread even = new Thread(() -> {
            lock.lock();
            try{
                for(int i=2;i<RANGE;i=i+2){
                    System.out.println(i);
                    condition.signalAll();
                    condition.await();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        Thread odd = new Thread(() -> {
            lock.lock();
            try{
                for(int i=1;i<RANGE;i=i+2){
                    System.out.println(i);
                    condition.signalAll();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }finally {
                lock.unlock();
            }
        });

        odd.start();
        even.start();
    }
}
