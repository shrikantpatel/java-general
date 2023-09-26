package com.shri.general.leet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/*
79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

        The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
        horizontally or vertically neighboring. The same letter cell may not be used more than once.

        Example:

        board =
        [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
        ]

        Given word = "ABCCED", return true.
        Given word = "SEE", return true.
        Given word = "ABCB", return false.
*/
@RunWith(MockitoJUnitRunner.class)
public class Word_Search {

    public boolean exist(char[][] board, String word) {
        int rowMax = board.length;
        int colMax = board[0].length;

        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {

                if (board[row][col] == word.charAt(0)) {

                    char temp = board[row][col];
                    board[row][col] = ' ';
                    if (recursiveMatchRest(row, col, board, word.substring(1)) == true) return true;
                    board[row][col] = temp;
                }
            }
        }
        return false;
    }

    private boolean recursiveMatchRest(int row, int col, char[][] board, String word) {

        if (word.length() == 0) return true;

        int rowMax = board.length;
        int colMax = board[0].length;
        char temp;

        if (row + 1 < rowMax && board[row + 1][col] == word.charAt(0)) {
            temp = board[row + 1][col];
            board[row + 1][col] = ' ';
            if (recursiveMatchRest(row + 1, col, board, word.substring(1)) == true) return true;
            board[row + 1][col] = temp;
        }
        if (row - 1 >= 0 && board[row - 1][col] == word.charAt(0)) {
            temp = board[row - 1][col];
            board[row - 1][col] = ' ';
            if (recursiveMatchRest(row - 1, col, board, word.substring(1)) == true) return true;
            board[row - 1][col] = temp;
        }
        if (col + 1 < colMax && board[row][col + 1] == word.charAt(0)) {
            temp = board[row][col + 1];
            board[row][col + 1] = ' ';
            if (recursiveMatchRest(row, col + 1, board, word.substring(1)) == true) return true;
            board[row][col + 1] = temp;
        }
        if (col - 1 >= 0 && board[row][col - 1] == word.charAt(0)) {
            temp = board[row][col - 1];
            board[row][col - 1] = ' ';
            if (recursiveMatchRest(row, col - 1, board, word.substring(1)) == true) return true;
            board[row][col - 1] = temp;
        }

        return false;
    }

    @Test
    public void testScenario0() {
        char[][] board = {{'A', 'B'}, {'C', 'D'}};
        String word = "AB";
        Assert.assertTrue(exist(board, word));
    }

    @Test
    public void testScenario1() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Assert.assertTrue(exist(board, word));
    }

    @Test
    public void testScenario2() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        Assert.assertTrue(exist(board, word));
    }

    @Test
    public void testScenario3() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        Assert.assertFalse(exist(board, word));
    }

    @Test
    public void testScenario4() {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        Assert.assertTrue(exist(board, word));
    }

    @Test
    public void testScenario5() {
        char[][] board = {{'a', 'a'}, {'a', 'a'}};
        String word = "aaa";
        Assert.assertTrue(exist(board, word));
    }

    @Test
    public void testScenario6() {
        char[][] board = {{'a', 'a'}};
        String word = "aaa";
        Assert.assertFalse(exist(board, word));
    }
}
