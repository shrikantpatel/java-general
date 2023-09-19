package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

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
public class _200_Number_of_Islands {

    public int numIslands(char[][] grid) {

        int totalRow = grid.length;
        int totalCol = grid[0].length;
        int noOfIsland = 0;

        for (int row = 0; row < totalRow; row++) {

            for (int col = 0; col < totalCol; col++) {

                if (grid[row][col] == '1') {
                    noOfIsland++;
                    markAllAdjacentLand(row, col, grid);
                }
            }
        }

        return noOfIsland;
    }

    private void markAllAdjacentLand(int startRow, int startCol, char[][] grid) {

        int totalRow = grid.length;
        int totalCol = grid[0].length;

        if (startRow == totalRow) return;
        if (startCol == totalCol) return;
        if (startRow == -1) return;
        if (startCol == -1) return;

        if (grid[startRow][startCol] == '1') {
            grid[startRow][startCol] = 'X';
            markAllAdjacentLand(startRow, startCol + 1, grid);
            markAllAdjacentLand(startRow + 1, startCol, grid);
            markAllAdjacentLand(startRow, startCol -1, grid);
            markAllAdjacentLand(startRow - 1, startCol, grid);
        } else {
            return;
        }
    }

    @Test
    public void test1() {
        _200_Number_of_Islands test = new _200_Number_of_Islands();
        char[][] grid = new char[][]
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };
        Assert.assertEquals(1, test.numIslands(grid));
    }

    @Test
    public void test2() {
        _200_Number_of_Islands test = new _200_Number_of_Islands();
        char[][] grid = new char[][]
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };
        Assert.assertEquals(3, test.numIslands(grid));
    }

    @Test
    public void test3() {
        _200_Number_of_Islands test = new _200_Number_of_Islands();
        char[][] grid = new char[][]
                {
                        {'1', '1', '1'},
                        {'0', '1', '0'},
                        {'1', '1', '1'}
                };
        Assert.assertEquals(1, test.numIslands(grid));
    }

    @Test
    public void test4() {
        _200_Number_of_Islands test = new _200_Number_of_Islands();
        char[][] grid = new char[][]
                {
                        {'1', '1', '1', '1'},
                        {'0', '0', '1', '1'},
                        {'1', '1', '1', '1'}
                };
        Assert.assertEquals(1, test.numIslands(grid));
    }

}
