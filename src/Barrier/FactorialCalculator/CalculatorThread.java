package Barrier.FactorialCalculator;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CalculatorThread extends Thread {

    private CyclicBarrier barrier;
    private List<Long> finalMultiplications;
    private Long n1;
    private Long n2;

    public CalculatorThread(CyclicBarrier barrier, List<Long> finalMultiplications, Long n1, Long n2) {
        this.barrier = barrier;
        this.finalMultiplications = finalMultiplications;
        this.n1 = n1;
        this.n2 = n2;
    }

    public void run(){
        Long result = n1 * n2;
        System.out.println(result);
        synchronized (finalMultiplications){
            finalMultiplications.add(result);
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

}
