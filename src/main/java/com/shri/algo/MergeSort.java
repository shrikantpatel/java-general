package com.shri.algo;

import org.junit.Assert;
import org.junit.Test;


public class MergeSort {

    public int[] sort(int[] intArray, int begin, int end) {

        // end when the start is less than end
        if (begin < end) {
            int middle = (begin + end) / 2;

            // sort left side array
            sort(intArray, begin, middle);

            // sort right side array
            sort(intArray, middle + 1, end);

            // right and left sorted array
            merge(intArray, begin, middle, end);
        }
        return intArray;
    }

    public void merge(int[] intArray, int begin, int middle, int end) {

        // calculate the size of the right array or left array
        int leftLength = middle - begin + 1;
        int rightLength = end - middle;

        // initial  temporary arrays
        int leftArray[] = new int[leftLength];
        int rightArray[] = new int[rightLength];

        // copy data to temp arrays
        for (int counter = 0; counter < leftLength; counter++) {
            leftArray[counter] = intArray[begin + counter];
        }
        for (int counter = 0; counter < rightLength; counter++) {
            rightArray[counter] = intArray[middle + 1 + counter];
        }

        // initial index of left and right array
        int leftArrayPointer = 0;
        int rightArrayPointer = 0;

        // initial index of the merged array
        int mergeArrayPointer = begin;

        while (leftArrayPointer < leftLength && rightArrayPointer < rightLength) {
            if (leftArray[leftArrayPointer] <= rightArray[rightArrayPointer]) {
                intArray[mergeArrayPointer] = leftArray[leftArrayPointer];
                leftArrayPointer++;
            } else {
                intArray[mergeArrayPointer] = rightArray[rightArrayPointer];
                rightArrayPointer++;
            }
            mergeArrayPointer++;
        }

        while (leftArrayPointer < leftLength) {
            intArray[mergeArrayPointer] = leftArray[leftArrayPointer];
            leftArrayPointer++;
            mergeArrayPointer++;
        }

        while (rightArrayPointer < rightLength) {
            intArray[mergeArrayPointer] = rightArray[rightArrayPointer];
            rightArrayPointer++;
            mergeArrayPointer++;
        }
    }

    @Test
    public void test1() {
        MergeSort toTest = new MergeSort();
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
        MergeSort toTest = new MergeSort();
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
        MergeSort toTest = new MergeSort();
        int[] input = new int[]{100, 2, 10, 50, 3, 101, 5};
        int[] output = toTest.sort(input, 0, input.length - 1);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        Assert.assertArrayEquals((new int[]{2, 3, 5, 10, 50, 100, 101}), output);
    }
}
