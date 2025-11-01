package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/number-of-islands/
200. Number of Islands
Medium

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
]
Output: 3

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/
public class _200_Number_of_Islands_BFS {

    public int numIslands(char[][] grid) {

        for (int row = 0 ; row < grid.length ; row++) {

            for (int col = 0 ; col < grid[0].length ; col++) {

                if (grid[row][col] == 1)
            }

        }
    }

    @Test
    public void test1() {
        _200_Number_of_Islands_BFS test = new _200_Number_of_Islands_BFS();
        char[][] grid = new char[][]
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };
        assertEquals(1, test.numIslands(grid));
    }

    @Test
    public void test2() {
        _200_Number_of_Islands_BFS test = new _200_Number_of_Islands_BFS();
        char[][] grid = new char[][]
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };
        assertEquals(3, test.numIslands(grid));
    }

    @Test
    public void test3() {
        _200_Number_of_Islands_BFS test = new _200_Number_of_Islands_BFS();
        char[][] grid = new char[][]
                {
                        {'1', '1', '1'},
                        {'0', '1', '0'},
                        {'1', '1', '1'}
                };
        assertEquals(1, test.numIslands(grid));
    }

    @Test
    public void test4() {
        _200_Number_of_Islands_BFS test = new _200_Number_of_Islands_BFS();
        char[][] grid = new char[][]
                {
                        {'1', '1', '1', '1'},
                        {'0', '0', '1', '1'},
                        {'1', '1', '1', '1'}
                };
        assertEquals(1, test.numIslands(grid));
    }

}
