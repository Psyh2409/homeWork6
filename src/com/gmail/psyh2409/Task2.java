package com.gmail.psyh2409;

public class Task2 {
    private long result;
    private int[] array;
    private int threadsCapacity;
    private Thread[] threads;

    public Task2() {
        super();
    }

    public Task2(int[] array, int threadsCapacity) {
        this.array = array;
        this.threadsCapacity = threadsCapacity;
        this.threads = new Thread[threadsCapacity];

    }

    public void threadsMaker() {
        int[][] arrays = arraySeparator();
        for (int i = 0; i < threadsCapacity; i++) {
            threads[i] = new ThreadClass(arrays[i]);
            threads[i].start();
        }
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int[][] arraySeparator() {
        boolean divisible = array.length % threadsCapacity == 0;
        int subarrayCapacity = divisible ? array.length / threadsCapacity : (array.length / threadsCapacity) * (threadsCapacity + 1);
        int[][] arrays = new int[threadsCapacity][subarrayCapacity];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (index < array.length) {
                    arrays[i][j] = array[index];
                    index++;
                }
            }
        }
        return arrays;
    }

    public long getResult() {
        return result;
    }

    public class ThreadClass extends Thread {
        private int[] localArray;


        public ThreadClass() {
            super();
        }

        public ThreadClass(int[] localArray) {
            super();
            this.localArray = localArray;
        }

        @Override
        public void run() {
            long localResult = 0;
            for (int j : localArray) {
                localResult += j;
            }
            result += localResult;
        }
    }
}
