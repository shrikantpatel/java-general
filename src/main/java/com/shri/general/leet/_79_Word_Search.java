package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/word-search/
 */
public class _79_Word_Search {

    public boolean exist(char[][] board, String word) {

        // Edge case: empty board
        if (board.length == 0) return false;

        // Edge case: empty word
        if (word.isEmpty()) return false;

        // Iterate through every cell in the board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                // Start DFS from cell (row, col) if it matches the first character
                if (findTheWord(row, col, word, board, 0)) return true;
            }
        }

        // If no path matches the word, return false
        return false;
    }

    private boolean findTheWord(int row, int col, String word, char[][] board, int wordIndex) {

        //Base case: entire word matched
        if (wordIndex == word.length()) return true;

        //Boundary check: out of bounds
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;

        //Character mismatch: current cell doesn't match current character in word
        if (board[row][col] != word.charAt(wordIndex)) return false;

        //Mark current cell as visited by replacing it with a placeholder
        char temp = board[row][col];
        board[row][col] = '#';

        //Explore all 4 directions: up, left, down, right
        boolean found = findTheWord(row - 1, col, word, board, wordIndex + 1) ||
                findTheWord(row, col - 1, word, board, wordIndex + 1) ||
                findTheWord(row + 1, col, word, board, wordIndex + 1) ||
                findTheWord(row, col + 1, word, board, wordIndex + 1);

        //Backtrack: restore the original character
        board[row][col] = temp;

        //Return whether the word was found from this path
        return found;
    }


    @Test
    public void testWordExistsHorizontally() {
        _79_Word_Search solver = new _79_Word_Search();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(solver.exist(board, "ABCCED"));
    }

    @Test
    public void testWordExistsVertically() {
        _79_Word_Search solver = new _79_Word_Search();
        char[][] board = {
                {'A', 'B'},
                {'C', 'D'},
                {'E', 'F'}
        };
        assertTrue(solver.exist(board, "ACE"));
    }

    @Test
    public void testWordDoesNotExist() {
        _79_Word_Search solver = new _79_Word_Search();
        char[][] board = {
                {'A', 'B'},
                {'C', 'D'}
        };
        assertFalse(solver.exist(board, "ABCDX"));
    }

    @Test
    public void testWordExistsWithBacktracking() {
        _79_Word_Search solver = new _79_Word_Search();
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        assertTrue(solver.exist(board, "ABE"));
    }

    @Test
    public void testSingleLetterMatch() {
        _79_Word_Search solver = new _79_Word_Search();
        char[][] board = {
                {'A'}
        };
        assertTrue(solver.exist(board, "A"));
    }

    @Test
    public void testSingleLetterMismatch() {
        _79_Word_Search solver = new _79_Word_Search();
        char[][] board = {
                {'A'}
        };
        assertFalse(solver.exist(board, "B"));
    }

    @Test
    public void testEmptyBoard() {
        _79_Word_Search solver = new _79_Word_Search();
        char[][] board = {};
        assertFalse(solver.exist(board, "ANY"));
    }

    @Test
    public void testEmptyWord() {
        _79_Word_Search solver = new _79_Word_Search();
        char[][] board = {
                {'A', 'B'},
                {'C', 'D'}
        };
        assertFalse(solver.exist(board, ""));
    }

    @Test
    public void testWordABCBShouldNotExist() {
        _79_Word_Search solver = new _79_Word_Search();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCB";

        // This word cannot be formed because it would require reusing the 'B' cell
        assertFalse(solver.exist(board, word));
    }


}
