package com.shri.general.leet;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
public class _208_Implement_Trie {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private final TrieNode root;

    public _208_Implement_Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int idx = c -'a';

            if (curr.children[idx] == null) {
                TrieNode temp = new TrieNode();
                curr.children[idx] = temp;
            }

            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return !(findNode(prefix) == null);
    }

    private TrieNode findNode(String s) {

        TrieNode curr = root;

        for (char c : s.toCharArray()) {
            int idx = c -'a';
            if (curr.children[idx] == null) return null;
            curr = curr.children[idx];
        }
        return curr;
    }

    @Nested
    class Tests {

        @Test
        void testInsertAndSearchSimple() {
            _208_Implement_Trie trie = new _208_Implement_Trie();

            trie.insert("apple");

            assertTrue(trie.search("apple"));
            assertFalse(trie.search("app"));
        }

        @Test
        void testStartsWith() {
            _208_Implement_Trie trie = new _208_Implement_Trie();

            trie.insert("apple");

            assertTrue(trie.startsWith("app"));
            assertTrue(trie.startsWith("a"));
            assertFalse(trie.startsWith("b"));
        }

        @Test
        void testInsertMultipleWords() {
            _208_Implement_Trie trie = new _208_Implement_Trie();

            trie.insert("dog");
            trie.insert("door");
            trie.insert("dove");

            assertTrue(trie.search("dog"));
            assertTrue(trie.search("door"));
            assertTrue(trie.search("dove"));

            assertFalse(trie.search("do"));
        }

        @Test
        void testPrefixOnly() {
            _208_Implement_Trie trie = new _208_Implement_Trie();

            trie.insert("car");

            assertTrue(trie.startsWith("c"));
            assertTrue(trie.startsWith("ca"));
            assertTrue(trie.startsWith("car"));
            assertFalse(trie.startsWith("cat"));
        }

        @Test
        void testSearchNonExistingWord() {
            _208_Implement_Trie trie = new _208_Implement_Trie();

            trie.insert("hello");

            assertFalse(trie.search("hell"));
            assertFalse(trie.search("helloo"));
            assertFalse(trie.search("world"));
        }

        @Test
        void testInsertOverlappingWords() {
            _208_Implement_Trie trie = new _208_Implement_Trie();

            trie.insert("app");
            trie.insert("apple");

            assertTrue(trie.search("app"));
            assertTrue(trie.search("apple"));
            assertTrue(trie.startsWith("app"));
        }
    }

}