package com.shri.general.async;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPool_ArraySumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10000; // Smallest unit of work
    private final long[] array;
    private final int start, end;

    public ForkJoinPool_ArraySumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // Base Case: If the task is small enough, do it normally
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) sum += array[i];
            return sum;
        }

        // Recursive Case: Split the task
        int mid = (start + end) / 2;
        ForkJoinPool_ArraySumTask leftTask = new ForkJoinPool_ArraySumTask(array, start, mid);
        ForkJoinPool_ArraySumTask rightTask = new ForkJoinPool_ArraySumTask(array, mid, end);

        // Fork the left task to run in another thread
        leftTask.fork();

        // Compute the right task in the CURRENT thread
        long rightResult = rightTask.compute();

        // Join the left task (wait for it to finish) and combine
        long leftResult = leftTask.join();

        return leftResult + rightResult;
    }

    public static void main(String[] args) {
        long[] data = new long[100000]; // Large array
        for (int i = 0; i < data.length; i++) data[i] = i;

        // Use the common pool (recommended for most cases)
        ForkJoinPool pool = ForkJoinPool.commonPool();

        long totalSum = pool.invoke(new ForkJoinPool_ArraySumTask(data, 0, data.length));
        System.out.println("Total Sum: " + totalSum);
    }
}
