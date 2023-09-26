package com.shri.general.leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * <p>
 * 73. Set Matrix Zeroes
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * <p>
 * You must do it in place.
 * <p>
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * <p>
 * Follow up:
 * <p>
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class _73_Set_Matrix_Zeroes {

    public void setZeroes_Approach2(int[][] matrix) {

        int totalCol = matrix[0].length;
        int totalRow = matrix.length;

        // temporary iterator variable.
        int row = 0;
        int col = 0;

        // indicator the first row and col had zero.
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // check if first col has any zeros
        for (row = 0; row < totalRow; row++) {
            if (matrix[row][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // check if first row has any zeros
        for (col = 0; col < totalCol; col++) {
            if (matrix[0][col] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // set the 1st row or 1st col with 0 to indicate the entire row or col is 0
        for (row = 0; row < totalRow; row++) {

            for (col = 0; col < totalCol; col++) {

                if (matrix[row][col] == 0 && !(row == 0 || col == 0)) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // set col to right value expect the col = 0
        for (col = 1; col < totalCol; col++) {
            if (matrix[0][col] == 0) {
                for (row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // set row to right value expect the row = 0
        for (row = 1; row < totalRow; row++) {
            if (matrix[row][0] == 0) {
                for (col = 0; col < totalCol; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // set first row to zero
        if (firstRowZero) {
            for (col = 0; col < totalCol; col++) {
                matrix[0][col] = 0;
            }
        }

        // set first col to zero
        if (firstColZero) {
            for (row = 0; row < totalRow; row++) {
                matrix[row][0] = 0;
            }
        }

        int i = 0;

    }

    public void setZeroes_Approach1(int[][] matrix) {

        Set<Integer> rowToMakeZero = new HashSet();
        Set<Integer> colToMakeZero = new HashSet();

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == 0) {
                    rowToMakeZero.add(row);
                    colToMakeZero.add(col);
                }
            }
        }

        for (int row : rowToMakeZero) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = 0;
            }
        }

        for (int col : colToMakeZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }

        int t = 0;

    }

    @Test
    public void test1() {
        _73_Set_Matrix_Zeroes t = new _73_Set_Matrix_Zeroes();
        int[][] input1 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] input2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        t.setZeroes_Approach1(input1);
        t.setZeroes_Approach2(input2);
        Assert.assertArrayEquals(input1, input2);
    }

    @Test
    public void test2() {
        _73_Set_Matrix_Zeroes t = new _73_Set_Matrix_Zeroes();
        int[][] input1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] input2 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        t.setZeroes_Approach1(input1);
        t.setZeroes_Approach2(input2);
        Assert.assertArrayEquals(input1, input2);
    }

    @Test
    public void test3() {
        _73_Set_Matrix_Zeroes t = new _73_Set_Matrix_Zeroes();
        int[][] input1 = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        int[][] input2 = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        t.setZeroes_Approach1(input1);
        t.setZeroes_Approach2(input2);
        Assert.assertArrayEquals(input1, input2);
    }

    @Test
    public void test4() {
        _73_Set_Matrix_Zeroes t = new _73_Set_Matrix_Zeroes();
        int[][] input1 = new int[][]{{1}};
        int[][] input2 = new int[][]{{1}};
        t.setZeroes_Approach1(input1);
        t.setZeroes_Approach2(input2);
        Assert.assertArrayEquals(input1, input2);
    }

    @Test
    public void test5() {
        _73_Set_Matrix_Zeroes t = new _73_Set_Matrix_Zeroes();
        int[][] input1 = new int[][]{{1}, {0}};
        int[][] input2 = new int[][]{{1}, {0}};
        t.setZeroes_Approach1(input1);
        t.setZeroes_Approach2(input2);
        Assert.assertArrayEquals(input1, input2);
    }

    @Test
    public void test6() {
        _73_Set_Matrix_Zeroes t = new _73_Set_Matrix_Zeroes();
        int[][] input1 = new int[][]{{1, 0, 3}};
        int[][] input2 = new int[][]{{1, 0, 3}};
        t.setZeroes_Approach1(input1);
        t.setZeroes_Approach2(input2);
        Assert.assertArrayEquals(input1, input2);

    }
}
