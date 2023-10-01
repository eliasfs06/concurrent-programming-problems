package Lock.ProducerConsumerProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainLock {

    private static final int N_THREADS = 50;
    private static final int BUFFER_CAPACITY = 10;

    public static void main(String[] args) {

        Deque<Integer> container = new ArrayDeque<>();
        SharedBufferLock buffer = new SharedBufferLock(BUFFER_CAPACITY, container);
        ProducerLock[] producers = new ProducerLock[N_THREADS];
        ConsumerLock[] consumers = new ConsumerLock[N_THREADS];

        for(int i = 0; i < N_THREADS; i++){
            producers[i] = new ProducerLock(i+1, buffer);
            consumers[i] = new ConsumerLock(i+1, buffer);
        }
        for(int i = 0; i < N_THREADS; i++){
            producers[i].start();
            consumers[i].start();
        }

        for(int i = 0; i < N_THREADS; i++){
            try {
                producers[i].join();
                consumers[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Producer and consumer finished;");

    }
}
