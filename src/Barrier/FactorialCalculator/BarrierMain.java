package Barrier.FactorialCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class BarrierMain {

    private final static int FACTORIAL_NUMBER = 12;

    public static void main(String[] args) {
        List<Long> finalMultiplications = new ArrayList<>();
        List<CalculatorThread> threads = new ArrayList<>();

        Runnable barrierAction = new Runnable() {
            public void run() {
                Long result = 1L;
                for(Long n : finalMultiplications){ result *= n; }
                System.out.println(FACTORIAL_NUMBER+"! = " + result);
            }
        };

        CyclicBarrier barrier = new CyclicBarrier(FACTORIAL_NUMBER/2, barrierAction);

        for(long i = 1; i <= FACTORIAL_NUMBER; i += 2){
            Long n1 = i;
            Long n2 = i + 1;
            if(n1 == FACTORIAL_NUMBER) finalMultiplications.add(n1);
            else threads.add(new CalculatorThread(barrier, finalMultiplications, n1, n2));
        }

        for(CalculatorThread thread : threads){
            thread.start();
        }
    }
}
