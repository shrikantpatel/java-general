/**
 * https://leetcode.com/problems/subsets/
 */
package com.shri.general.leet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class _78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findSubsets(nums, ans, current, 0);
        return ans;
    }

    private void findSubsets(int[] nums, List<List<Integer>> ans, List<Integer> current, int currentIndex) {

        // Add the current subset to the answer list
        // This captures the current combination, whether empty or partial
        ans.add(new ArrayList<>(current));

        // Iterate through remaining elements starting from currentIndex
        // This ensures subsets are built in order and avoids duplicates
        for (int i = currentIndex; i < nums.length; i++) {
            // Include nums[i] in the current subset
            current.add(nums[i]);

            // Recursively build subsets including nums[i]
            // Move to the next index to avoid reusing the same element
            findSubsets(nums, ans, current, i + 1);

            // Backtrack: remove the last added element
            // This allows exploration of subsets that exclude nums[i]
            current.removeLast();
        }

    }

    // Basic test
    @Test
    public void testSubsetsBasic() {
        _78_Subsets solver = new _78_Subsets();
        int[] input = {1, 2};
        List<List<Integer>> result = solver.subsets(input);

        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(1, 2)
        );

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    // Edge case: empty array
    @Test
    public void testSubsetsEmpty() {
        _78_Subsets solver = new _78_Subsets();
        int[] input = {};
        List<List<Integer>> result = solver.subsets(input);

        assertEquals(1, result.size());
        assertEquals(List.of(), result.getFirst());
    }

    // Edge case: single element
    @Test
    public void testSubsetsSingleElement() {
        _78_Subsets solver = new _78_Subsets();
        int[] input = {5};
        List<List<Integer>> result = solver.subsets(input);

        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(5)
        );

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    // Test with negative numbers
    @Test
    public void testSubsetsWithNegatives() {
        _78_Subsets solver = new _78_Subsets();
        int[] input = {-1, 0, 1};
        List<List<Integer>> result = solver.subsets(input);

        assertEquals(8, result.size()); // 2^3 subsets
        assertTrue(result.contains(List.of()));
        assertTrue(result.contains(List.of(-1)));
        assertTrue(result.contains(List.of(0)));
        assertTrue(result.contains(List.of(1)));
        assertTrue(result.contains(List.of(-1, 0)));
        assertTrue(result.contains(List.of(-1, 1)));
        assertTrue(result.contains(List.of(0, 1)));
        assertTrue(result.contains(List.of(-1, 0, 1)));
    }

    // Test with duplicates (note: subsets will include duplicates)
    @Test
    public void testSubsetsWithDuplicates() {
        _78_Subsets solver = new _78_Subsets();
        int[] input = {1, 1};
        List<List<Integer>> result = solver.subsets(input);

        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(1),
                List.of(1),
                List.of(1, 1)
        );

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }
}