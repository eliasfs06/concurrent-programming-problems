package Semaphore.ProducerConsumerProblem;

public class ConsumerSemaphore extends Thread{

    private Integer id;
    private SharedBufferSemaphore buffer;

    public ConsumerSemaphore(Integer id, SharedBufferSemaphore buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    public void run(){
        buffer.remove();
    }
}
