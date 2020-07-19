package com.bsrakdg.multithreadingsamples.demonstrations.visibility;

public class VisibilityDemonstration {

    // private static int sCount = 0; // STEP 1
    private volatile static int sCount = 0; // STEP 2

    // Thread synchronized
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        new Consumer().start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            return;
        }
        new Producer().start();
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            int localValue = -1;
            while (true) {
                // synchronized : guaranteed that it will hold the lock until this statement completes
                synchronized (LOCK) {
                    // Consumer doesn't handle sCount changes on Producer, this is a problem
                    if (localValue != sCount) {
                        System.out.println("Consumer: detected count change " + sCount);
                        localValue = sCount;
                    }
                    if (sCount >= 5) {
                        break;
                    }
                }
            }
            System.out.println("Consumer: terminating");
        }
    }

    static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    int localValue = sCount;
                    localValue++;
                    System.out.println("Producer: incrementing count to " + localValue);
                    sCount = localValue;

                    if (sCount >= 5) {
                        break;
                    }
                }
            }
            System.out.println("Producer: terminating");
        }
    }

}
