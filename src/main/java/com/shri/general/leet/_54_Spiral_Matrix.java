package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _54_Spiral_Matrix {

    static class Direction {
        int dr, dc; // Change in row and column
        Direction next;

        Direction(int dr, int dc) {
            this.dr = dr;
            this.dc = dc;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> output = new ArrayList<>();
        if (matrix.length == 0) return output;

        // 1. Setup Circular Structure: Right -> Down -> Left -> Up -> (Back to Right)
        Direction right = new Direction(0, 1);
        Direction down = new Direction(1, 0);
        Direction left = new Direction(0, -1);
        Direction up = new Direction(-1, 0);

        right.next = down;
        down.next = left;
        left.next = up;
        up.next = right;

        // 2. Traversal Variables
        int rows = matrix.length, cols = matrix[0].length;
        int totalElements = rows * cols;
        boolean[][] visited = new boolean[rows][cols];

        // Initialize the variables.
        int r = 0, c = 0;
        Direction current = right;

        for (int i = 0; i < totalElements; i++) {

            // add cell to the output and mark it as visiteds
            output.add(matrix[r][c]);
            visited[r][c] = true;

            // Calculate next potential move
            int nextR = r + current.dr;
            int nextC = c + current.dc;

            // 3. Boundary Check & Circular Transition
            if (nextR < 0 || nextR >= rows || nextC < 0 || nextC >= cols || visited[nextR][nextC]) {
                current = current.next; // Switch direction
                nextR = r + current.dr;
                nextC = c + current.dc;
            }

            r = nextR;
            c = nextC;
        }
        return output;
    }

    @Test
    void testStandardMatrix() {
        _54_Spiral_Matrix solver = new _54_Spiral_Matrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assertEquals(expected, solver.spiralOrder(matrix), "Should traverse a 3x3 square matrix correctly");
    }

    @Test
    void testRectangularMatrix() {
        _54_Spiral_Matrix solver = new _54_Spiral_Matrix();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        assertEquals(expected, solver.spiralOrder(matrix), "Should traverse a 3x4 rectangular matrix correctly");
    }

    @Test
    void testSingleRow() {
        _54_Spiral_Matrix solver = new _54_Spiral_Matrix();
        int[][] matrix = {{1, 2, 3, 4}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, solver.spiralOrder(matrix), "Should handle a single row matrix");
    }

    @Test
    void testSingleColumn() {
        _54_Spiral_Matrix solver = new _54_Spiral_Matrix();
        int[][] matrix = {
                {1},
                {2},
                {3}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, solver.spiralOrder(matrix), "Should handle a single column matrix");
    }

    @Test
    void testEmptyMatrix() {
        _54_Spiral_Matrix solver = new _54_Spiral_Matrix();
        int[][] matrix = {};
        List<Integer> result = solver.spiralOrder(matrix);
        assertTrue(result.isEmpty(), "Should return an empty list for an empty matrix input");
    }
}