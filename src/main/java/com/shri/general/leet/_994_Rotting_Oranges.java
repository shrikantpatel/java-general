package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/rotting-oranges/description/
 */
public class _994_Rotting_Oranges {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges to queue, count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        // If no fresh oranges, answer is 0
        if (fresh == 0) return 0;

        int minutes = -1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: Multi-source BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    // Skip boundaries or non-fresh cells
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    if (grid[nr][nc] != 1) continue;

                    // Rot the fresh orange
                    grid[nr][nc] = 2;
                    fresh--;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    @Test
    void testZeroAndRotten() {
        _994_Rotting_Oranges solver = new _994_Rotting_Oranges();

        int[][] grid = {
                {0, 2}
        };

        assertEquals(0, solver.orangesRotting(grid));
    }

    @Test
    void testSimpleCase() {
        _994_Rotting_Oranges solver = new _994_Rotting_Oranges();

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        assertEquals(4, solver.orangesRotting(grid));
    }

    @Test
    void testSimpleCaseVariation1() {
        _994_Rotting_Oranges solver = new _994_Rotting_Oranges();

        int[][] grid = {
                {2, 1, 2},
                {1, 1, 0},
                {0, 1, 1}
        };

        assertEquals(4, solver.orangesRotting(grid));
    }

    @Test
    void testSimpleCaseVariation2() {
        _994_Rotting_Oranges solver = new _994_Rotting_Oranges();

        int[][] grid = {
                {2, 1, 2},
                {1, 1, 2},
                {0, 1, 1}
        };

        assertEquals(2, solver.orangesRotting(grid));
    }

    @Test
    void testAlreadyAllRotten() {
        _994_Rotting_Oranges solver = new _994_Rotting_Oranges();

        int[][] grid = {
                {2, 2, 2},
                {2, 2, 2}
        };

        assertEquals(0, solver.orangesRotting(grid));
    }

    @Test
    void testImpossibleCase() {
        _994_Rotting_Oranges solver = new _994_Rotting_Oranges();

        int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        assertEquals(-1, solver.orangesRotting(grid));
    }

    @Test
    void testNoOranges() {
        _994_Rotting_Oranges solver = new _994_Rotting_Oranges();

        int[][] grid = {
                {0, 0, 0},
                {0, 0, 0}
        };

        assertEquals(0, solver.orangesRotting(grid));
    }

    @Test
    void testSingleFreshOrange() {
        _994_Rotting_Oranges solver = new _994_Rotting_Oranges();

        int[][] grid = {
                {1}
        };

        assertEquals(-1, solver.orangesRotting(grid));
    }

    @Test
    void testSingleRottenOrange() {
        _994_Rotting_Oranges solver = new _994_Rotting_Oranges();

        int[][] grid = {
                {2}
        };

        assertEquals(0, solver.orangesRotting(grid));
    }

}