package ashish.examples.multithreading;

public class Volatile implements Runnable {
    //if you do not use volatile here the thread runs forever and will never stop as it never gets the updated value
    public static volatile boolean stopThread = false;

    @Override
    public void run() {
        int counter = 0;
        while (!stopThread) {
            try {
                System.out.println("Thread with name ["+Thread.currentThread().getName()+"] running!");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
        System.out.println("Thread completed execution and counter value is " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile volatileDemo = new Volatile();
        Thread myThread = new Thread(volatileDemo, "VolatileExample-Thread");
        myThread.start();
        Thread.sleep(2000);
        stopThread = true;
    }
}
