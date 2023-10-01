package Synchronized.PritingQueueProblem;

public class PrinterSynchronized {

    public PrinterSynchronized() {}

    public synchronized void print(Integer id) {
        try {
            System.out.println("Starting priting job " + id);
            System.out.println("Priting ...");
            int duration = (int) (Math.random() * 5) + 1;
            Thread.sleep(duration * 1000L);
            System.out.println("Finishing priting job " + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
