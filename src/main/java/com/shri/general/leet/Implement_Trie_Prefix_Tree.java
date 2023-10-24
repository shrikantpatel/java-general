package com.shri.general.leet;

/*
208. Implement Trie (Prefix Tree)
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Implement_Trie_Prefix_Tree {

    private Node trie;

    public Implement_Trie_Prefix_Tree() {
       trie = new Node("");
    }

    private class Node {
        boolean isWord = false;
        String prefix;
        Map<Character, Node> children;

        public Node(String prefix) {
            this.prefix = prefix;
            children = new HashMap();
        }
    }

    public void insert (String word) {
        Node node = trie;

        int i = 0;
        for (char c : word.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                Node newNode = new Node(word.substring(0, ++i));
                node.children.put(c, newNode);
                node = newNode;
            }
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = trie;

        for (char c : word.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                return false;
            }
        }
        return node.isWord;
    }

    public boolean startsWith(String partialWord) {
        Node node = trie;

        for (char c : partialWord.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {

        Implement_Trie_Prefix_Tree trie = new Implement_Trie_Prefix_Tree();
        trie.insert("apple");
        assertTrue(trie.search("apple"));   // returns true
        assertFalse(trie.search("app"));     // returns false
        assertTrue(trie.startsWith("app")); // returns true
        assertFalse(trie.startsWith("appt")); // returns true
        trie.insert("app");
        assertTrue(trie.search("app"));     // returns true
    }
}
