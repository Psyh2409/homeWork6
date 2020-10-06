package com.gmail.psyh2409;

import java.math.BigInteger;

public class Task1 {
    int number = 100;
    Thread[] threads;

    public Task1() {
        super();
    }

    public Task1(int number) {
        this.number = number;
        threads = new Thread[number];
    }

    public void factorialsCounter() {

        for (int i = 0; i < number; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                long id = threads[finalI].getId();
                BigInteger factId = new BigInteger(String.valueOf(id));
                for (long j = id - 1; j > 0; j--) {
                    factId = factId.multiply(BigInteger.valueOf(j));
                }
                System.out.println(threads[finalI].getName() + " has Id: " + id + ". Factorial of it is:\n" + factId);
            });
            threads[i].start();
        }
    }

    public void joiner() {
        for (int i = 0; i < number; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
