package ashish.examples.multithreading;

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(
                () -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Hi there, this is executed by a different thread " + Thread.currentThread().getName());
                }
        );
        t1.start();
        //Main thread comes here after executing line t1.start() and will wait for the thread t1 to complete
        t1.join();
        //Main thread waits for the t1 thread to complete its execution
        //If we comment out t1.join then main thread will execute and after thread waits for 5 seconds it will complete its execution
        //Since thread t1 is a non demon thread it will continue to run in JVM
        System.out.println("This line is executed by main thread " + Thread.currentThread().getName());
    }
}
