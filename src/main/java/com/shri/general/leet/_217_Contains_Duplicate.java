package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class _217_Contains_Duplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) return true;  // add() returns false if already present
        }
        return false;
    }

    @Test
    public void testContainsDuplicate() {
        assertTrue(containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(containsDuplicate(new int[]{1, 2, 3, 4}));
        assertTrue(containsDuplicate(new int[]{1, 1, 1, 1}));
        assertFalse(containsDuplicate(new int[]{}));
        assertFalse(containsDuplicate(new int[]{42}));
    }

}
