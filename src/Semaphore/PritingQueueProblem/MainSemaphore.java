package Semaphore.PritingQueueProblem;

import java.util.ArrayList;
import java.util.List;

public class MainSemaphore {

    public static int N_JOB = 10;
    public static void main(String[] args) {

        PrinterSemaphore printer = new PrinterSemaphore();
        List<JobSemaphore> jobs = new ArrayList<>();

        for(int i = 0; i < N_JOB; i++){
            jobs.add(new JobSemaphore( i+1, printer));
        }

        for(JobSemaphore job : jobs){
            job.start();
        }

        for(JobSemaphore job : jobs){
            try {
                job.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Finished all printing jobs");
    }
}