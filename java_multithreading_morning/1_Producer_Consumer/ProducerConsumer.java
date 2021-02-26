import java.util.*;


public class ProducerConsumer {
    public static void main(String[] args) {
        List<Integer> queue = new LinkedList<Integer>();

        for(Integer i=1;i<=5;i++)
            queue.add(i);
        
        Thread t1 = new Thread(new Producer(queue));
        Thread t2 = new Thread(new Consumer(queue));

        t1.start();
        t2.start();
    }
}



class Consumer implements Runnable {
    List<Integer> queue = null;

    public Consumer(List<Integer> queue) {
        super();
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                System.out.println("Queue is empty !!!!!!");
                System.out.println("Wait for the producer to produce the amount");
                queue.wait();
            }
        }

        synchronized (queue) {
            Thread.sleep(1000);
            System.out.println("Consumer consumed amount " + queue.remove(0));
            queue.notify();
        }
    }
}

class Producer implements Runnable {
    List<Integer> queue = null;
    final int MAX_SIZE = 4;
    private int amount = 1;

    public Producer(List<Integer> queue) {
        super();
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                amount += amount;
                produce(amount);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void produce(int amount) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == MAX_SIZE) {
                System.out.println("Queue is full..\n");
                System.out.println("Wait for consumer to consume.\n");
                queue.wait();
            }
        }

        synchronized (queue) {
            System.out.println("Producer produced amount " + amount);
            queue.add(amount);
            Thread.sleep(10);
            queue.notify();
        }
    }
}