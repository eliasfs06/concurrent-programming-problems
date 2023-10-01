package Semaphore.PritingQueueProblem;

public class JobSemaphore extends Thread {

    private Integer id;
    private PrinterSemaphore printer;

    public JobSemaphore(Integer id, PrinterSemaphore printer) {
        this.id = id;
        this.printer = printer;
    }

    @Override
    public void run(){
        printer.print(id);
    }

}
