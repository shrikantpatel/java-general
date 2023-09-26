package com.shri.general.algo;

import org.junit.Assert;
import org.junit.Test;


public class QuickSort1 {

    public int[] sort(int[] intArray, int begin, int end) {

        if (begin < end) {
            int partitionIndex = parition(intArray, begin, end);
            sort(intArray, begin, partitionIndex - 1);
            sort(intArray, partitionIndex + 1, end);
        }
        return intArray;
    }

    public int parition(int[] intArray, int begin, int end) {

        //pivot value - choosing the right most element
        int pivotValue = intArray[end];

        // the pointer\index to keep track of the latest lower value element
        int lowerValueIndex = begin - 1;

        for (int counter = begin; counter < end; counter++) {
            if (intArray[counter] < pivotValue) {
                lowerValueIndex++;
                swap(intArray, lowerValueIndex, counter);
            }
        }

        swap(intArray, lowerValueIndex + 1, end);

        return lowerValueIndex + 1;
    }

    private void swap(int[] intArray, int index1, int index2) {
        int temp = intArray[index1];
        intArray[index1] = intArray[index2];
        intArray[index2] = temp;
    }

    @Test
    public void test1() {
        QuickSort1 toTest = new QuickSort1();
        int[] input = new int[]{10, 23, 2, 4, 6, 7};
        int[] output = toTest.sort(input, 0, input.length - 1);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        Assert.assertArrayEquals((new int[]{2, 4, 6, 7, 10, 23}), output);
    }

    @Test
    public void test2() {
        QuickSort1 toTest = new QuickSort1();
        int[] input = new int[]{2, 10, 6, 4, 23, 7};
        int[] output = toTest.sort(input, 0, input.length - 1);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        Assert.assertArrayEquals((new int[]{2, 4, 6, 7, 10, 23}), output);
    }

    @Test
    public void test3() {
        QuickSort1 toTest = new QuickSort1();
        int[] input = new int[]{100, 2, 10, 50, 3, 101, 5};
        int[] output = toTest.sort(input, 0, input.length - 1);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        Assert.assertArrayEquals((new int[]{2, 3, 5, 10, 50, 100, 101}), output);
    }
}
