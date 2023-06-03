package ashish.examples.multithreading;

public class InheritableThreadLocalExample {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal= new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal= new InheritableThreadLocal<>();

        Thread parentThread = new Thread(() -> {
            threadLocal.set("Parent Thread 1 - ThreadLocal");
            inheritableThreadLocal.set("Thread 1 - InheritableThread Local");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());


            Thread childThreadOfT1 = new Thread( () -> {
                System.out.println("Inside Child Thread");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            });
            childThreadOfT1.start();
        });

        parentThread.start();
    }
}
