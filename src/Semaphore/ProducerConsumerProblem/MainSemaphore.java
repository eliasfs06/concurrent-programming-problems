package Semaphore.ProducerConsumerProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainSemaphore {

    private static final int N_THREADS = 50;
    private static final int BUFFER_CAPACITY = 10;

    public static void main(String[] args) {

        Deque<Integer> container = new ArrayDeque<>();
        SharedBufferSemaphore buffer = new SharedBufferSemaphore(BUFFER_CAPACITY, container);
        ProducerSemaphore[] producers = new ProducerSemaphore[N_THREADS];
        ConsumerSemaphore[] consumers = new ConsumerSemaphore[N_THREADS];

        for(int i = 0; i < N_THREADS; i++){
            producers[i] = new ProducerSemaphore(i+1, buffer);
            consumers[i] = new ConsumerSemaphore(i+1, buffer);
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
