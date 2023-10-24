package com.shri.general.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeapSort {

    public int[] sort(int[] intArray) {

        int totalSize = intArray.length;
        int nonLeafNode = totalSize/2 - 1;

        // iterate through the non leaf element and heapify to create the max heap
        for (int counter = nonLeafNode ; counter >= 0 ; counter--) {
            heapify(intArray, totalSize, counter);
        }

        //
        for (int counter = totalSize - 1 ; counter >= 0 ; counter--) {
            // move the root (index 0) (largest element) with last heap index
            swap(intArray, 0, counter);
            // heapify the rest of heap, so the largest element moves 0, ie become root
            heapify(intArray, counter, 0);
        }

        return intArray;
    }

    public void heapify(int[] intArray, int heapSize, int rootIndexPointer) {

        int largerElementIndex = rootIndexPointer;
        int leftChildIndex = 2 * largerElementIndex + 1;
        int rightChildIndex = 2 * largerElementIndex + 2;

        if (leftChildIndex < heapSize && intArray[leftChildIndex] >  intArray[largerElementIndex]) {
            largerElementIndex = leftChildIndex;
        }

        if (rightChildIndex < heapSize && intArray[rightChildIndex] >  intArray[largerElementIndex]) {
            largerElementIndex = rightChildIndex;
        }

        if (largerElementIndex != rootIndexPointer) {
            swap(intArray, largerElementIndex, rootIndexPointer);
            heapify(intArray, heapSize, largerElementIndex);
        }

    }

    private void swap(int[] intArray, int index1, int index2) {
        int temp = intArray[index1];
        intArray[index1] = intArray[index2];
        intArray[index2] = temp;
    }

    @Test
    public void test1() {
        HeapSort toTest = new HeapSort();
        int[] input = new int[]{10, 23, 2, 4, 6, 7};
        int[] output = toTest.sort(input);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        Assertions.assertArrayEquals((new int[]{2, 4, 6, 7, 10, 23}), output);
    }

    @Test
    public void test2() {
        HeapSort toTest = new HeapSort();
        int[] input = new int[]{2, 10, 6, 4, 23, 7};
        int[] output = toTest.sort(input);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        Assertions.assertArrayEquals((new int[]{2, 4, 6, 7, 10, 23}), output);
    }

    @Test
    public void test3() {
        HeapSort toTest = new HeapSort();
        int[] input = new int[]{100, 2, 10, 50, 3, 101, 5};
        int[] output = toTest.sort(input);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.println();
        Assertions.assertArrayEquals((new int[]{2, 3, 5, 10, 50, 100, 101}), output);
    }
}
