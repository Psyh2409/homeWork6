package com.gmail.psyh2409;

public class Main {
    public static void main(String[] args) {
        int result1;
        int result2 = 0;
//      Task 1
        System.out.println("Task 1");
        long start = System.currentTimeMillis();
        Task1 task1 = new Task1(100);
        task1.factorialsCounter();
        task1.joiner();
        long end = System.currentTimeMillis();
        result1 = (int) (end - start);
        System.out.println("Task 1 is executed since " + (end - start) + " mls.");

//      Task 2
        for (int x = 0; x < 100; x++) {
            System.out.println();
            System.out.println("Task 2");
            int numbersCapacity = 1_000_000;
            int threadsCapacity = 10;
            System.out.println(lawOfAmdal((double) numbersCapacity / threadsCapacity, threadsCapacity));
            int[] numbers = new int[numbersCapacity];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = i + 1;
            }
            start = System.currentTimeMillis();
            Task2 task2 = new Task2(numbers, threadsCapacity);
            task2.threadsMaker();
            end = System.currentTimeMillis();
            result2 += (end - start);
            System.out.println("Sum of numbers with multithreading " + task2.getResult() + ". Since " + (end - start) + " mls.");
        }
        System.out.println("\n" + "Middle time for Task 1 is: " + result1 + " mls;");
        System.out.println("Middle time for Task 2 is: " + result2 / 100 + " mls;");
    }

    public static double lawOfAmdal(double alfa, int threads) {
        return 1 / (alfa + ((1 - alfa) / threads));
    }
}
