package com.shri.general.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class QuickSort {

    public int[] sort(int[] intArray, int begin, int end) {

        if (begin < end) {

            int partitionIndex = partition(intArray, begin, end);

            // sort the array to left of the pivot
            sort(intArray, begin, partitionIndex - 1);

            // sort the array to right of the pivot
            sort(intArray, partitionIndex + 1, end);
        }
        return intArray;
    }

    public int partition(int[] array, int begin, int end) {

        // select the right most element as pivot
        int pivot = array[end];

        // array index for the element greater than pivot
        int higherValueIndex = begin;

        int temp = 0;

        for (int j = begin; j < end; j++) {

            if (array[j] < pivot) {

                // swap the smaller and greater element
                temp = array[j];
                array[j] = array[higherValueIndex];
                array[higherValueIndex] = temp;
                higherValueIndex++;
            }
        }

        // swap the pivot with greater element
        array[end] = array[higherValueIndex];
        array[higherValueIndex] = pivot;

        return higherValueIndex;
    }


    @Test
    public void test1() {
        QuickSort toTest = new QuickSort();
        int[] input = new int[]{10, 23, 2, 4, 6, 7};
        int[] output = toTest.sort(input, 0, input.length - 1);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        assertArrayEquals((new int[]{2, 4, 6, 7, 10, 23}), output);
    }

    @Test
    public void test2() {
        QuickSort toTest = new QuickSort();
        int[] input = new int[]{2, 10, 6, 4, 23, 7};
        int[] output = toTest.sort(input, 0, input.length - 1);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        assertArrayEquals((new int[]{2, 4, 6, 7, 10, 23}), output);
    }

    @Test
    public void test3() {
        QuickSort toTest = new QuickSort();
        int[] input = new int[]{100, 2, 10, 50, 3, 101, 5};
        int[] output = toTest.sort(input, 0, input.length - 1);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        assertArrayEquals((new int[]{2, 3, 5, 10, 50, 100, 101}), output);
    }

    @Test
    public void test4() {
        QuickSort toTest = new QuickSort();
        int[] input = new int[]{2, 2, 1, 2, 1, 1, 1, 0, 0, 2, 1, 0, 2, 1, 2, 2, 1, 1, 1, 1, 1, 0, 2, 0, 2, 0, 2, 2, 1, 0, 2, 1, 0, 2, 1, 2, 0, 0, 0, 0, 2, 1, 1, 2, 0, 1, 2, 2, 0, 0, 2, 2, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 2, 2, 2, 1, 0, 0, 2, 1, 0, 1, 0, 2, 2, 1, 2, 1, 1, 2, 1, 1, 0, 0, 2, 1, 0, 0};
        int[] output = toTest.sort(input, 0, input.length - 1);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        assertArrayEquals((new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}), output);
    }
}
