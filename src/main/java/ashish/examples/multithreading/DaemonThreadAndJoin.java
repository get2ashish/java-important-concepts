package ashish.examples.multithreading;

public class DaemonThreadAndJoin {
    public static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * Threads created in Java are managed by the underlying operating system on which JVM is running on.
         * Hence these threads are referred to as OS threads.
         * Each OS thread may acquire 1-2 MB of stack space which may not look more but when u create 1000 of threads
         * it definitely impacts.
         * This is was reason for creation of Project LOOM - fibers or green threads.
         * Virtual threads was added to Java 19 as a preview feature
         */

        System.out.println("Name of the main thread "+Thread.currentThread().getName());

        Runnable runnable = ()->{
            for(int i=0;i<10;i++){
                System.out.println("Thread is running: "+Thread.currentThread().getName());
                sleep();
            }
        };
        Thread thread = new Thread(runnable,"MyThread");
        //Setting the thread to Daemon the main thread will not wait for this thread to complete.
        //If the Thread is not marked Daemon the Thread will continue to run in JVM even after completion of main method
        thread.setDaemon(true);
        thread.start();
        //Adding a join will ensure that main thread will wait for the Daemon thread to complete.
        thread.join();
    }



}
