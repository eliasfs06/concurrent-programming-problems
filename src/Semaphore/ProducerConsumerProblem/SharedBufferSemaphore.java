package Semaphore.ProducerConsumerProblem;

import java.util.Deque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBufferSemaphore {

    private Deque<Integer> container;
    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore full;

    public SharedBufferSemaphore(int capacity, Deque<Integer> container){
        this.container = container;
        this.mutex = new Semaphore(1);
        this.empty = new Semaphore(capacity);
        this.full = new Semaphore(0);
    }

    public void add(){
        try {
            empty.acquire();
            mutex.acquire();

            int item = (int) (Math.random() * 5) + 1;
            container.add(item);
            int duration = (int) (Math.random() * 2) + 1;
            Thread.sleep(duration * 1000L);
            System.out.println("Producer added " + item);

            mutex.release();
            full.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remove(){
        try {

            full.acquire();
            mutex.acquire();

            int item = container.remove();
            int duration = (int) (Math.random() * 2) + 1;
            Thread.sleep(duration * 1000L);
            System.out.println("Consumer remove " + item);

            mutex.release();
            empty.release();

        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
