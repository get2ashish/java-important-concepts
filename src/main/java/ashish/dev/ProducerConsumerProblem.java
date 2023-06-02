package ashish.dev;

import java.util.LinkedList;

public class ProducerConsumerProblem {

    static LinkedList<Integer> conveyorBelt = new LinkedList<>();

    public static void main(String[] args) {

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Thread producerThread = new Thread(producer::produce);
        Thread consumerThread = new Thread(consumer::consume);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}


class Producer {
    int data = 0;
    int bufferSize = 5;
    public void produce() {
        try {
            while (true) {
                synchronized (ProducerConsumerProblem.conveyorBelt) {
                    while (ProducerConsumerProblem.conveyorBelt.size() == bufferSize) {
                        System.out.println("Producer buffer size reached, waiting for consumer to consume");
                        ProducerConsumerProblem.conveyorBelt.wait();
                    }
                    data = data +1;
                    ProducerConsumerProblem.conveyorBelt.add(data);
                    System.out.println("Producer produced data " + data);
                    Thread.sleep(500);
                    ProducerConsumerProblem.conveyorBelt.notify();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Consumer {
    public void consume() {
        try {
            while (true) {
                synchronized (ProducerConsumerProblem.conveyorBelt) {
                    while (ProducerConsumerProblem.conveyorBelt.size() == 0) {
                        System.out.println("No items to consume, waiting for producer to produce");
                        ProducerConsumerProblem.conveyorBelt.wait();
                    }
                    int removedData = ProducerConsumerProblem.conveyorBelt.removeFirst();
                    System.out.println("Consumer consumed data " + removedData);
                    Thread.sleep(500);
                    ProducerConsumerProblem.conveyorBelt.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}