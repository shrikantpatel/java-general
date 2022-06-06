package com.shri.algo;

import org.junit.Assert;
import org.junit.Test;


public class QuickSort {

    public int[] sort(int[] intArray, int low, int high) {

        if (low < high) {
            int partition = partition(intArray, low, high);
            sort(intArray, low, partition);
            sort(intArray, partition + 1, high);
        }
        return intArray;
    }

    public int partition(int[] intArray, int low, int high) {

        int i = low;
        int j = high;
        int pivot = intArray[low];
        int temp = 0;

        while (i < j) {
            do {
                i++;
            } while (intArray[i] <= pivot);

            do {
                j--;
            } while (intArray[j] > pivot);

            if (i < j) {
                temp = intArray[i];
                intArray[i] = intArray[j];
                intArray[j] = temp;
            }
        }
        temp = intArray[low];
        intArray[low] = intArray[j];
        intArray[j] = temp;
        return j;
    }


    @Test
    public void test1() {
        QuickSort toTest = new QuickSort();
        int[] input = new int[]{10, 23, 2, 4, 6, 7, Integer.MAX_VALUE};
        int[] output = toTest.sort(input, 0, 6);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        Assert.assertArrayEquals((new int[]{2, 4, 6, 7, 10, 23, Integer.MAX_VALUE}), output);
    }

    @Test
    public void test2() {
        QuickSort toTest = new QuickSort();
        int[] input = new int[]{23, 10, 6, 4, 2, 7, Integer.MAX_VALUE};
        int[] output = toTest.sort(input, 0, 6);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        Assert.assertArrayEquals((new int[]{2, 4, 6, 7, 10, 23, Integer.MAX_VALUE}), output);
    }
}
