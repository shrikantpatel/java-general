package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/permutations/description/
 */
public class _46_Permutations {

    public List<List<Integer>> permute(int[] nums) {

        // Final list of all permutations
        List<List<Integer>> result = new ArrayList<>();

        // Current partial permutation being built
        List<Integer> permutation = new ArrayList<>();

        // Tracks which indices in nums have already been used in the current permutation
        boolean[] used = new boolean[nums.length];

        // Begin recursive backtracking
        permuteRecursion(result, permutation, nums, used);
        return result;

    }

    private void permuteRecursion(List<List<Integer>> result,
                                  List<Integer> permutation,
                                  int[] nums,
                                  boolean[] used) {

        // Base case: if the permutation is complete (same length as input),
        // add a copy to the result list.
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        // Try placing each number at the current position
        for (int i = 0; i < nums.length; i++) {

            // Skip numbers already used in the current permutation
            if (used[i]) continue;

            // Choose: mark this number as used and add it to the permutation
            used[i] = true;
            permutation.addLast(nums[i]);

            // Explore: recurse to build the next position
            permuteRecursion(result, permutation, nums, used);

            // Un-choose (backtrack): remove the number and mark it unused
            permutation.removeLast();
            used[i] = false;
        }

    }

    @Test
    void testSingleElement() {
        _46_Permutations solver = new _46_Permutations();
        List<List<Integer>> result = solver.permute(new int[]{1});

        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(1)));
    }

    @Test
    void testEmptyArray() {
        _46_Permutations solver = new _46_Permutations();
        List<List<Integer>> result = solver.permute(new int[]{});

        // For empty input, expect 1 permutation: the empty list
        assertEquals(1, result.size());
        assertTrue(result.contains(List.of()));
    }

    @Test
    void testTwoNumbers() {
        _46_Permutations solver = new _46_Permutations();
        List<List<Integer>> result = solver.permute(new int[]{1, 2});

        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(1, 2)));
        assertTrue(result.contains(List.of(2, 1)));
    }

    @Test
    void testPermutations123() {
        _46_Permutations solver = new _46_Permutations();
        List<List<Integer>> result = solver.permute(new int[]{1, 2, 3});

        // Expect exactly 6 permutations
        assertEquals(6, result.size());

        // Expected permutations
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        );

        // Check that all expected permutations are present
        for (List<Integer> perm : expected) {
            assertTrue(result.contains(perm), "Missing permutation: " + perm);
        }
    }

}
