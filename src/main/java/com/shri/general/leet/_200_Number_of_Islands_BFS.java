package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

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

        // Edge case: if the grid is null or empty, there are no islands
        if (grid == null || grid.length == 0) return 0;

        int islands = 0; // Counter to track number of islands

        // Traverse every cell in the grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                // If the cell contains land ('1'), it's the start of a new island
                if (grid[row][col] == '1') {
                    islands++; // Increment island count

                    // Use BFS to mark all connected land cells as visited
                    bfs(row, col, grid);
                }
            }
        }

        // Return the total number of islands found
        return islands;
    }

    private void bfs(int startRow, int startCol, char[][] grid) {

        int rowCount = grid.length;
        int colCount = grid[0].length;

        // Queue to perform BFS traversal starting from the initial land cell
        Queue<int[]> land = new LinkedList<>();
        land.add(new int[]{startRow, startCol});

        // Define 4 possible directions: down, up, right, left
        int[][] directions = new int[][] {
                {1, 0},  // down
                {-1, 0}, // up
                {0, 1},  // right
                {0, -1}  // left
        };

        // Continue BFS until all connected land cells are visited
        while (!land.isEmpty()) {

            // Dequeue the current cell
            int[] cell = land.poll();

            // Mark the current cell as visited by changing '1' to 'X'
            grid[cell[0]][cell[1]] = 'X';

            // Explore all 4 adjacent cells
            for (int[] dir : directions) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];

                // Check bounds and whether the adjacent cell is unvisited land
                if (row >= 0 && row < rowCount &&
                        col >= 0 && col < colCount &&
                        grid[row][col] == '1') {

                    // Enqueue the adjacent land cell for further exploration
                    land.add(new int[]{row, col});
                }
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
