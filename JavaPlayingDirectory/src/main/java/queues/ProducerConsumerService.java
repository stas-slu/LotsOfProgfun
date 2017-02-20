package queues;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerService {

    public static void main(String[] args) {

        //Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        //starting producer to produce messages in queue
        new Thread(producer, "producer thread").start();

        //starting consumer to consume messages from queue
        new Thread(consumer, "consumer thread").start();

        System.out.println("Producer and Consumer has been started");
    }
}