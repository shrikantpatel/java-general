package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/01-matrix/description/
 */
public class _542_01_Matrix {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        // Initialize distances: 0-cells → 0, 1-cells → MAX_VALUE
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j}); // multi-source BFS seed
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Multi-source BFS expansion
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];

                // Skip out-of-bounds
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                // If we found a shorter path to this neighbor, update it
                if (dist[nr][nc] > dist[r][c] + 1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return dist;
    }

    @Test
    void testSimpleCase() {
        int[][] mat = {
                {0,1},
                {1,1}
        };

        int[][] expected = {
                {0,1},
                {1,2}
        };

        int[][] result = updateMatrix(mat);

        assertMatrixEquals(expected, result);
    }

    @Test
    void testMixedMatrix() {
        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };

        int[][] expected = {
                {0,0,0},
                {0,1,0},
                {1,2,1}
        };

        int[][] result = updateMatrix(mat);

        assertMatrixEquals(expected, result);
    }

    @Test
    void testAllZeros() {
        int[][] mat = {
                {0,0},
                {0,0}
        };

        int[][] expected = {
                {0,0},
                {0,0}
        };

        int[][] result = updateMatrix(mat);

        assertMatrixEquals(expected, result);
    }

    @Test
    void testAllOnes() {
        int[][] mat = {
                {1,1},
                {1,1}
        };

        int[][] result = updateMatrix(mat);

        // All distances should be MAX_VALUE because no zero exists
        for (int[] ints : result) {
            for (int j = 0; j < result[0].length; j++) {
                assertEquals(Integer.MAX_VALUE, ints[j]);
            }
        }
    }

    @Test
    void testSingleRow() {
        int[][] mat = {
                {1,0,1,1}
        };

        int[][] expected = {
                {1,0,1,2}
        };

        int[][] result = updateMatrix(mat);

        assertMatrixEquals(expected, result);
    }

    @Test
    void testSingleColumn() {
        int[][] mat = {
                {1},
                {0},
                {1},
                {1}
        };

        int[][] expected = {
                {1},
                {0},
                {1},
                {2}
        };

        int[][] result = updateMatrix(mat);

        assertMatrixEquals(expected, result);
    }

    @Test
    void testLargeDistancePropagation() {
        int[][] mat = {
                {1,1,1,1,0}
        };

        int[][] expected = {
                {4,3,2,1,0}
        };

        int[][] result = updateMatrix(mat);

        assertMatrixEquals(expected, result);
    }

    // Helper for matrix comparison
    private void assertMatrixEquals(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length);
        assertEquals(expected[0].length, actual[0].length);

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
                assertEquals(expected[i][j], actual[i][j],
                        "Mismatch at (" + i + "," + j + ")");
            }
        }
    }
}
