package com.gmail.psyh2409;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
//      Task 1
        System.out.println("Task 1");
        long start = System.currentTimeMillis();
        int number = 100;
        Thread[] threads = new Thread[number];
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
        for (int i = 0; i < number; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Task 1 is executed since " + (end - start) + " mls.");
// Task 1. 100 threads near 144 mls;
//         10 threads near 103 mls.

//      Task 2
        System.out.println();
        System.out.println("Task 2");
        int numbersCapacity = 1_000;
        int threadsCapacity = 10;
        int[] numbers = new int[numbersCapacity];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        start = System.currentTimeMillis();
        Task2 task2 = new Task2(numbers, threadsCapacity);
        task2.threadsMaker();
        end = System.currentTimeMillis();

        System.out.println("Sum of numbers with multithreading " + task2.getResult() + ". Since " + (end - start) + " mls.");
        //Task 2. As more threads, as longer program is working:
        //10 threads near 46 mls;
        //1 thread near 14 mls.
    }
}
