package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int shortestPath(int[][] grid, int k) {

        return -1;
    }

    @Test
    public void test1() {
        Solution sol = new Solution();
        int[][] grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        int answer = sol.shortestPath(grid, 1);
        Assert.assertEquals(6, answer);
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        int[][] grid = new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 0, 0}};
        int answer = sol.shortestPath(grid, 1);
        Assert.assertEquals(-1, answer);
    }
}