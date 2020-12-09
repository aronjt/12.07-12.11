package org.progmatic;

import org.progmatic.dec9.EvenNumberThread;
import org.progmatic.dec9.OddNumberRunnable;
import org.progmatic.dec9.ParallelCalculator;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[100000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        ParallelCalculator par = new ParallelCalculator();
        System.out.println(par.sumArrayParalelly(arr, 8));
        System.out.println(par.sumArraySequential(arr));
    }

    public void threadDemo() throws InterruptedException {
        System.out.println("Main started");
        EvenNumberThread evenNumberThread = new EvenNumberThread();
        OddNumberRunnable oddNumberRunnable = new OddNumberRunnable();
        Thread oddNumberThread = new Thread(oddNumberRunnable);
        evenNumberThread.start();
        oddNumberThread.start();
        evenNumberThread.join();
        Thread.sleep(3000);
        System.out.println("Main ended");

        int count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);
    }
}
