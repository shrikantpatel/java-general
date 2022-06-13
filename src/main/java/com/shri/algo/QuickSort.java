package com.shri.algo;

import org.junit.Assert;
import org.junit.Test;


public class QuickSort {

    public int[] sort(int[] intArray, int begin, int end) {

        if (begin < end) {
            int partition = partition(intArray, begin, end);
            sort(intArray, begin, partition-1);
            sort(intArray, partition + 1, end);
        }
        return intArray;
    }

    public int partition(int[] array, int begin, int end) {

        // choose the rightmost element as pivot
        int pivot = array[end];

        // pointer for greater element
        int i = (begin - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }
        // swapt the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;

        // return the position from where partition is done
        return (i + 1);
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
        Assert.assertArrayEquals((new int[]{2, 4, 6, 7, 10, 23}), output);
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
        Assert.assertArrayEquals((new int[]{2, 4, 6, 7, 10, 23}), output);
    }
}
