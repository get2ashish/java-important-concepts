package ashish.examples.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    //static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            Random random = new Random();
            while (true) {
                Integer value = random.nextInt(100);
                System.out.println("Producer Produced " + value);
                try {
                    queue.put(value);
                    //it's a blocking queue so the thread will block if the queue is full
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                Integer value;
                try {
                    //Thread blocks if the queue is empty
                    value = queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Consumer consumed " + value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }

}
