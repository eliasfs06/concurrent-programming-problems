package Semaphore.ProducerConsumerProblem;

public class ProducerSemaphore extends Thread {

    private Integer id;
    SharedBufferSemaphore buffer;

    public ProducerSemaphore(Integer id, SharedBufferSemaphore buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    public void run(){
        buffer.add();
    }

}
