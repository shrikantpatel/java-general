package com.shri.general.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * 347. Top K Frequent Elements
 * Medium
 * 16.2K
 * 591
 * Companies
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class _347_Top_K_Frequent_Elements {

    public int[] topKFrequent(int[] nums, int k) {

        Map <Integer, Integer> frequency = new HashMap<>();

        // create frequency map where key is element in list and value is how many times it occurred in the list.
        for (int i : nums) {
            frequency.merge(i, 1, Integer::sum);
            //frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }

        // get just the key from above map
        List<Integer> values = new ArrayList<>(frequency.keySet());
        // sort the list of key using the values (ie how often the element has occurred)  in the map
        values.sort((val1, val2) -> frequency.get(val2) - frequency.get(val1));

        int[] result = new int[k];
        // take the 1st key element and return them
        for (int i = 0 ; i < k ; i++) {
            result[i] = values.get(i);
        }

        return result;
    }

    @Test
    public void test1() {
        Assertions.assertArrayEquals(new int[]{1, 2}, topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }

    @Test
    public void test2() {
        Assertions.assertArrayEquals(new int[]{1, 3}, topKFrequent(new int[]{1,1,1,2,2,3,3,3}, 2));
    }

    @Test
    public void test3() {
        Assertions.assertArrayEquals(new int[]{4, 1}, topKFrequent(new int[]{1,1,1,2,2,3,3,3,4,4,4,4,4}, 2));
    }
}
