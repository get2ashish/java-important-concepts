package ashish.examples.multithreading;

public class EvenOdd {

    public static void main(String[] args) throws InterruptedException {

        int RANGE = 20;
        Object lock = new Object();

        Thread even = new Thread(() -> {
            for(int i=2;i<RANGE;i=i+2) {
                synchronized (lock) {
                    System.out.println(i + " ");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread odd = new Thread(() -> {
            for(int i=1;i<RANGE;i=i+2){
                synchronized (lock) {
                    System.out.println(i + " ");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        odd.start();
        even.start();

        odd.join();
        even.join();
    }
}