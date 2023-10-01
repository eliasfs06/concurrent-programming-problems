package Lock.ProducerConsumerProblem;

import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBufferLock {

    private int capacity;
    private Deque<Integer> container;
    private Lock lock;
    Condition isFull;
    Condition isEmpty;

    public SharedBufferLock(int capacity, Deque<Integer> container){
        this.capacity = capacity;
        this.container = container;
        lock = new ReentrantLock();
        isFull = lock.newCondition();
        isEmpty = lock.newCondition();
    }

    public void add(){
        try {
            lock.lock();
            while (container.size() == capacity) {
                System.out.println("Buffer is full! Waiting for consumer.");
                isFull.await();
            }

            int item = (int) (Math.random() * 5) + 1;
            container.add(item);
            int duration = (int) (Math.random() * 2) + 1;
            Thread.sleep(duration * 1000L);
            System.out.println("Producer added " + item);
            isEmpty.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void remove(){
        try {
            lock.lock();
            while (container.isEmpty()) {
                System.out.println("Buffer is empty! Waiting for producer.");
                isEmpty.await();
            }

            int item = container.remove();
            int duration = (int) (Math.random() * 2) + 1;
            Thread.sleep(duration * 1000L);
            System.out.println("Consumer remove " + item);
            isFull.signal();

        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
