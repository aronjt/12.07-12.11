package org.progmatic.dec9;

import java.util.ArrayList;
import java.util.List;

public class ParallelCalculator {

    public ParallelCalculator() {
    }

    public double sumArrayParalelly(int[] arr, int nrOfProcesses) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        List<CounterThread> threads = new ArrayList<>();
        int div = arr.length / nrOfProcesses;
        int beforeNr = 0;
        for (int i = 1; i <= nrOfProcesses; i++) {
            threads.add(new CounterThread(beforeNr, div * i, arr));
            System.out.println("Index: " + beforeNr + " " + div * i);
            beforeNr += div;
        }
        for (CounterThread thread : threads) {
            thread.start();
        }
        double sum = 0.0;
        for (CounterThread thread : threads) {
            thread.join();
            sum += thread.getSum();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Parallel time: " + (t2-t1));
        return sum;
    }

    public double sumArraySequential(int[] arr) {
        long t1 = System.currentTimeMillis();
        double sum = 0.0;
        for (int j : arr) {
            sum += Math.sin(j);
           // sum += j;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Seq time: " + (t2-t1));
        return sum;
    }
}
