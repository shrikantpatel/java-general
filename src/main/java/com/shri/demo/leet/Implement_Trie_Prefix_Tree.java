package com.shri.demo.leet;

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

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Implement_Trie_Prefix_Tree {

    private Node trie;

    /**
     * Initialize your data structure here.
     */
    public Implement_Trie_Prefix_Tree() {
        trie = new Node("");
    }

    private class Node {
        HashMap<Character, Node> children;
        boolean isWord = false;
        String prefix;

        public Node(String prefix) {
            this.prefix = prefix;
            children = new HashMap<>();
        }
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        Node curr = trie;
        int i = 0;
        for (char c : word.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                Node temp = new Node(word.substring(0, i + 1));
                curr.children.put(c, temp);
                curr = temp;
            }
            i++;
        }
        curr.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node curr = trie;

        for (char c : word.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return false;
            }
        }

        return curr.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node curr = trie;

        for (char c : prefix.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
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
        Assert.assertTrue(trie.search("apple"));   // returns true
        Assert.assertFalse(trie.search("app"));     // returns false
        Assert.assertTrue(trie.startsWith("app")); // returns true
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));     // returns true
    }
}
