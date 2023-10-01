package Semaphore.PritingQueueProblem;

import java.util.concurrent.Semaphore;

public class PrinterSemaphore {

    Semaphore semaphore;

    public PrinterSemaphore() {
        this.semaphore = new Semaphore(1, true);
    }

    public void print(Integer id) {
        try {
            semaphore.acquire();
            System.out.println("Starting priting job " + id);
            System.out.println("Priting...");
            int duration = (int) (Math.random() * 5) + 1;
            Thread.sleep(duration * 1000L);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finishing priting job " + id);
            semaphore.release();
        }
    }
}
