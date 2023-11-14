package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/kth-largest-element-in-an-array/
215. Kth Largest Element in an Array
Medium

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */
public class _215_Kth_Largest_Element {

    /**
     * Approach 1: Min-Heap
     * <p>
     * The main idea of this solution is to use a min-heap with a maximum size of k.
     * By doing this, we ensure that the smallest of the k largest elements is always on the top of the heap.
     */
    public int findKthLargest_1(int[] nums, int k) {

        /*
        create the heap with Kth element
        create heap of Kth element (sort them with lowest at top of the heap and highest at the bottom of the heap)
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int counter = 0; counter < k; counter++) {
            minHeap.offer(nums[counter]);
        }

        int temp = 0;
        for (int counter = k; counter < nums.length; counter++) {
            temp = nums[counter];
            if (temp > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(temp);
            }
        }

        return minHeap.peek();
    }

    /*
    Approach 2: QuickSelect Algorithm
    The QuickSelect algorithm is an efficient method to find the kkk-th smallest (or largest)
    element in an unordered list without sorting the entire list.
    It works similarly to the QuickSort algorithm but only recurses into one half of the data.
     */
    public int findKthLargest_2(int[] nums, int k) {

        int left = 0, right = nums.length - 1;

        int k_Th_indexValue = nums.length - k;
        while (true) {

            int pivotIndex = right;
            int partitionIndex = partition(nums, left, right, pivotIndex);

            // kth the largest meaning kth element from end of the array
            if (partitionIndex == k_Th_indexValue) {
                return nums[partitionIndex];
            } else if (partitionIndex > k_Th_indexValue) {
                right = partitionIndex - 1;
            } else {
                left = partitionIndex + 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right, int pivotIndex) {

        int pivotValue = nums[pivotIndex];
        int higherValueIndex = left;

        for (int counter = left; counter < right; counter++) {
            if (nums[counter] < pivotValue) {
                swap(nums, higherValueIndex, counter);
                higherValueIndex++;
            }
        }

        swap(nums, higherValueIndex, pivotIndex);

        return higherValueIndex;
    }

    private void swap(int[] intArray, int index1, int index2) {
        int temp = intArray[index1];
        intArray[index1] = intArray[index2];
        intArray[index2] = temp;
    }

    @Test
    public void test1_1() {
        _215_Kth_Largest_Element t = new _215_Kth_Largest_Element();
        assertEquals(5, t.findKthLargest_1(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void test1_2() {
        _215_Kth_Largest_Element t = new _215_Kth_Largest_Element();
        assertEquals(4, t.findKthLargest_1(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    @Test
    public void test2_1() {
        _215_Kth_Largest_Element t = new _215_Kth_Largest_Element();
        assertEquals(5, t.findKthLargest_2(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void test2_2() {
        _215_Kth_Largest_Element t = new _215_Kth_Largest_Element();
        assertEquals(4, t.findKthLargest_2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

}
