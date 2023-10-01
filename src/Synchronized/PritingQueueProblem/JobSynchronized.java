package Synchronized.PritingQueueProblem;

public class JobSynchronized extends Thread {

    private Integer id;
    private PrinterSynchronized printer;

    public JobSynchronized(Integer id, PrinterSynchronized printer) {
        this.id = id;
        this.printer = printer;
    }

    @Override
    public void run(){
        printer.print(id);
    }

}
