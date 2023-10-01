package Synchronized.PritingQueueProblem;

import java.util.ArrayList;
import java.util.List;

public class MainSynchronized {

    public static int N_JOB = 10;
    public static void main(String[] args) {

        PrinterSynchronized printer = new PrinterSynchronized();
        List<JobSynchronized> jobs = new ArrayList<>();

        for(int i = 0; i < N_JOB; i++){
            jobs.add(new JobSynchronized( i+1, printer));

        }

        for(JobSynchronized job : jobs){
            job.start();
        }

        for(JobSynchronized job : jobs){
            try {
                job.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Finished all printing jobs");
    }
}