package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class _39_Combination_Sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> output = new ArrayList<>();

        //Edge condition handling
        if (candidates.length == 0) return output;
        if (target == 0) return List.of(List.of());

        // sort the candidate so the number are ascending order
        Arrays.sort(candidates);
        List<Integer> currentCombination = new ArrayList<>();

        findCombination(candidates, 0, currentCombination, output, target);

        return output;
    }

    private void findCombination(int[] candidates,
                                 int index,
                                 List<Integer> currentCombination,
                                 List<List<Integer>> output,
                                 int remainingTarget) {

        // If remainingTarget is exactly 0, record the current combination
        if (remainingTarget == 0) {
            // Add a copy to avoid later mutation issues
            output.add(new ArrayList<>(currentCombination));
            return;
        }

        // If remainingTarget is negative or index is out of bounds, stop this path
        if (remainingTarget < 0 || index >= candidates.length) {
            return;
        }

        int currentNumber = candidates[index];

        // Choice 1: include currentNumber (we stay at same index to allow reuse)
        currentCombination.add(currentNumber);
        findCombination(candidates, index, currentCombination, output, remainingTarget - currentNumber);
        // backtrack
        currentCombination.removeLast();

        // Choice 2: skip currentNumber and move to next index
        findCombination(candidates, index + 1, currentCombination, output, remainingTarget);
    }

    @Test
    void testExample1() {
        _39_Combination_Sum solution = new _39_Combination_Sum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> actual = solution.combinationSum(candidates, target);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 3),
                List.of(7)
        );

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());

        assertTrue(actual.contains(Arrays.asList(2, 2, 3)));
        assertTrue(actual.contains(List.of(7)));
    }

    @Test
    void testExample2() {
        _39_Combination_Sum solution = new _39_Combination_Sum();
        int[] candidates = {2, 3, 5};
        int target = 8;

        List<List<Integer>> actual = solution.combinationSum(candidates, target);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5)
        );

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.contains(Arrays.asList(2, 2, 2, 2)));
        assertTrue(actual.contains(Arrays.asList(2, 3, 3)));
        assertTrue(actual.contains(Arrays.asList(3, 5)));
    }

    @Test
    void testExample3_NoCombinationPossible() {
        _39_Combination_Sum solution = new _39_Combination_Sum();
        int[] candidates = {2};
        int target = 1;

        List<List<Integer>> actual = solution.combinationSum(candidates, target);

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void testEmptyCandidates() {
        _39_Combination_Sum solution = new _39_Combination_Sum();
        int[] candidates = {};
        int target = 7;

        List<List<Integer>> actual = solution.combinationSum(candidates, target);

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void testZeroTarget() {
        _39_Combination_Sum solution = new _39_Combination_Sum();
        int[] candidates = {1, 2, 3};
        int target = 0;

        List<List<Integer>> actual = solution.combinationSum(candidates, target);

        // Typical interpretation for target == 0: one empty combination.
        List<List<Integer>> expected = List.of(
                List.of()
        );

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.contains(List.of()));
    }
}
