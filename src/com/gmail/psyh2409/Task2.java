package com.gmail.psyh2409;

public class Task2 {
    private int result;
    private int[] array;
    private int treadsQuantity;
    private Thread[] threads;

    public Task2(){super();}

    public Task2(int[] array, int treadsQuantity) {
        this.array = array;
        this.treadsQuantity = treadsQuantity;
        this.threads = new Thread[treadsQuantity];
    }

    public void threadsMaker(){
        for (int i = 0; i < treadsQuantity; i++) {
            threads[i] = new ThreadClass(i);
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getResult() {
        return result;
    }

    public class ThreadClass extends Thread{
        private int iterator;

        public ThreadClass(){super();}

        public ThreadClass(int iterator){
            super();
            this.iterator = iterator;
        }

        @Override
        public void run() {
            int localResult = 0;
            for (int i = iterator; i < array.length; i = i + treadsQuantity) {
                localResult+=array[i];
            }
            result+=localResult;
        }
    }
}
