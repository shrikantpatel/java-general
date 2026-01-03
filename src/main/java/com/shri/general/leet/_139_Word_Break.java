package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/word-break/description/
 */
public class _139_Word_Break {

    public boolean wordBreak(String s, List<String> wordDict) {

        // Base case: empty string is always segmentable
        if (s.isEmpty()) return true;


        // BFS queue: each element represents a starting index in the string
        // that we want to try to segment from.
        Queue<Integer> queue = new LinkedList<>();

        // visited[i] = true means we have already processed index i.
        // This prevents reprocessing the same index and avoids infinite loops.
        boolean[] visited = new boolean[s.length()-1];

        // Start BFS from index 0 (beginning of the string)
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.poll();

            // If we've already processed this index, skip it
            if (visited[start]) continue;
            visited[start] = true;

            // Try every word in the dictionary
            for (String word : wordDict) {
                int end = start + word.length();

                // If the word would go past the string boundary, skip it
                if (end > s.length()) continue;

                // Check if the substring starting at 'start' matches the word
                if (s.startsWith(word, start)) {

                    // If the match reaches the end of the string, segmentation is successful
                    if (end == s.length()) {
                        return true;
                    }

                    // Otherwise, add the next index to BFS queue to continue segmentation
                    queue.add(end);
                }
            }
        }

        // If BFS finishes without reaching the end of the string, segmentation is impossible
        return false;
    }


    @Test
    void testSimpleTrueCase() {
        _139_Word_Break solver = new _139_Word_Break();
        assertTrue(solver.wordBreak("leetcode", List.of("leet", "code")));
    }

    @Test
    void testSimpleFalseCase() {
        _139_Word_Break solver = new _139_Word_Break();
        assertFalse(solver.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    void testSingleWordMatch() {
        _139_Word_Break solver = new _139_Word_Break();
        assertTrue(solver.wordBreak("apple", List.of("apple")));
    }

    @Test
    void testEmptyString() {
        _139_Word_Break solver = new _139_Word_Break();
        assertTrue(solver.wordBreak("", List.of("a", "b"))); // empty string is always segmentable
    }

    @Test
    void testNoDictionaryWords() {
        _139_Word_Break solver = new _139_Word_Break();
        assertFalse(solver.wordBreak("hello", List.of()));
    }

    @Test
    void testOverlappingWords() {
        _139_Word_Break solver = new _139_Word_Break();
        assertTrue(solver.wordBreak("aaaaaaa", List.of("aaaa", "aaa")));
    }

    @Test
    void testRepeatingWord() {
        _139_Word_Break solver = new _139_Word_Break();
        assertTrue(solver.wordBreak("applepenapple", List.of("apple", "pen")));
    }
}