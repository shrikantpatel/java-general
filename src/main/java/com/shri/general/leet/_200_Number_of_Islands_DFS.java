package com.shri.general.leet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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
public class _200_Number_of_Islands_DFS {

    public int numIslands(char[][] grid) {

        // Total number of rows and columns in the grid
        int totalRow = grid.length;
        int totalCol = grid[0].length;

        // Counter to track the number of distinct islands
        int noOfIsland = 0;

        // Traverse every cell in the grid
        for (int row = 0; row < totalRow; row++) {
            for (int col = 0; col < totalCol; col++) {

                // If the cell contains land ('1'), it's part of a new island
                if (grid[row][col] == '1') {
                    noOfIsland++; // Increment island count

                    // Recursively mark all connected land cells as visited
                    markAllAdjacentLand(row, col, grid);
                }
            }
        }

        // Return the total number of islands found
        return noOfIsland;
    }

    private void markAllAdjacentLand(int startRow, int startCol, char[][] grid) {

        int totalRow = grid.length;
        int totalCol = grid[0].length;

        // Boundary check: return if out of bounds
        if (startRow < 0 || startRow >= totalRow || startCol < 0 || startCol >= totalCol) {
            return;
        }

        // If the current cell is land ('1'), mark it as visited ('X')
        if (grid[startRow][startCol] == '1') {
            grid[startRow][startCol] = 'X'; // Mark as visited

            // Recursively visit all 4 adjacent directions
            markAllAdjacentLand(startRow, startCol + 1, grid); // Right
            markAllAdjacentLand(startRow + 1, startCol, grid); // Down
            markAllAdjacentLand(startRow, startCol - 1, grid); // Left
            markAllAdjacentLand(startRow - 1, startCol, grid); // Up
        } else {
            // If the cell is water ('0') or already visited ('X'), do nothing
            return;
        }
    }

    @Test
    public void test1() {
        _200_Number_of_Islands_DFS test = new _200_Number_of_Islands_DFS();
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
        _200_Number_of_Islands_DFS test = new _200_Number_of_Islands_DFS();
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
        _200_Number_of_Islands_DFS test = new _200_Number_of_Islands_DFS();
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
        _200_Number_of_Islands_DFS test = new _200_Number_of_Islands_DFS();
        char[][] grid = new char[][]
                {
                        {'1', '1', '1', '1'},
                        {'0', '0', '1', '1'},
                        {'1', '1', '1', '1'}
                };
        assertEquals(1, test.numIslands(grid));
    }

}
