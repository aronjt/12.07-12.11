package org.progmatic.dec9;

import java.util.ArrayList;
import java.util.List;

public class ParallelCalculator {

    public ParallelCalculator() {
    }

    public double sumArrayParalelly(int[] arr, int nrOfProcesses) throws InterruptedException {
        List<CounterThread> threads = new ArrayList<>();
        int div = arr.length / nrOfProcesses;
        int beforeNr = 0;
        for (int i = 1; i <= nrOfProcesses; i++) {
            threads.add(new CounterThread(beforeNr, div * i, arr));
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
        System.out.println(System.currentTimeMillis());
        return sum;
    }

    public double sumArraySequential(int[] arr) {
        double sum = 0.0;
        for (int j : arr) {
            sum += Math.sin(j);
        }
        System.out.println(System.currentTimeMillis());
        return sum;
    }
}
