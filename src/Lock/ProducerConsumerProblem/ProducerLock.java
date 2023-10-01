package Lock.ProducerConsumerProblem;

public class ProducerLock extends Thread {

    private Integer id;
    SharedBufferLock buffer;

    public ProducerLock(Integer id, SharedBufferLock buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    public void run(){
        buffer.add();
    }

}
