package ashish.dev;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<T> {
    private final Queue<T> queue;
    private final int MAX;
    private final ReentrantLock lock = new ReentrantLock(true);

    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();


    public MyBlockingQueue (int maxSize){
        this.queue = new LinkedList<>();
        this.MAX = maxSize;
    }

    public void put(T item){
        lock.lock();
        try{
            if(queue.size()==MAX){
                notFull.await();
            }
            queue.add(item);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try{
            //use while rather than if to avoid case when multiple threads are waiting and could get null
            if(queue.size()==0){
                notEmpty.await();
            }
            T item = queue.remove();
            notFull.signalAll();
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> myBlockingQueue = new MyBlockingQueue<>(10);
        Thread producer = new Thread(() -> {
            Random random =  new Random();
            while(true){
                int producedData = random.nextInt(100);
                System.out.println("Producer Produced " + producedData);
                myBlockingQueue.put(producedData);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while(true){
                int data = myBlockingQueue.take();
                System.out.println("Consumer consumer " + data);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }

}
