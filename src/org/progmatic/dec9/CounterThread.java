package org.progmatic.dec9;

public class CounterThread extends Thread {
    private int startIdx;
    private int endIdx;
    private int[] toSum;
    private double sum;

    public CounterThread(int startIdx, int endIdx, int[] toSum) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
        this.toSum = toSum;
    }

    @Override
    public void run() {
        for (int i = startIdx; i < endIdx; i++) {
            sum += Math.sin(toSum[i]);
        }
    }

    public double getSum() {
        return sum;
    }
}
