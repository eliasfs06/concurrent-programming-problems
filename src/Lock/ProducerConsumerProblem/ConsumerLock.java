package Lock.ProducerConsumerProblem;

public class ConsumerLock extends Thread{

    private Integer id;
    private SharedBufferLock buffer;

    public ConsumerLock(Integer id, SharedBufferLock buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    public void run(){
        buffer.remove();
    }
}
