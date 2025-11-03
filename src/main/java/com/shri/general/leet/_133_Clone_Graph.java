package com.shri.general.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/clone-graph/description/
 */

public class _133_Clone_Graph {

    // --- Node Class Definition (Required for the problem) ---
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    // --------------------------------------------------------

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }

    private Node clone(Node node, Map<Node, Node> map) {
        // If this node has already been cloned, return the clone to avoid cycles and duplicate work
        if (map.containsKey(node)) return map.get(node);

        // Create a new node with the same value as the original
        Node copy = new Node(node.val);

        // Store the mapping from the original node to its clone
        map.put(node, copy);

        // Recursively clone all neighbors and add them to the clone's neighbors list
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor, map));
        }

        // Return the cloned node
        return copy;
    }

    // --- Unit Test Methods ---

    private _133_Clone_Graph solution;

    @BeforeEach
    public void setUp() {
        solution = new _133_Clone_Graph();
    }

    // --- Utility Methods for Testing ---

    /**
     * Constructs a graph from a list of adjacency lists (1-indexed node values).
     */
    private Node buildGraph(List<List<Integer>> adjList) {
        if (adjList == null || adjList.isEmpty()) {
            return null;
        }
        // Special case: single node with no neighbors
        if (adjList.size() == 1 && adjList.get(0).isEmpty()) {
            return new Node(1);
        }

        int numNodes = adjList.size();
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 1; i <= numNodes; i++) {
            nodeMap.put(i, new Node(i));
        }

        for (int i = 0; i < numNodes; i++) {
            Node originalNode = nodeMap.get(i + 1);
            for (int neighborVal : adjList.get(i)) {
                originalNode.neighbors.add(nodeMap.get(neighborVal));
            }
        }

        return nodeMap.get(1); // Return the first node (val = 1)
    }

    /**
     * Verifies if the cloned graph is a correct deep copy of the original.
     * Checks for new object instances (deep copy) and structural integrity.
     */
    private void verifyDeepCopy(Node original, Node cloned) {
        if (original == null) {
            Assertions.assertNull(cloned);
            return;
        }

        Map<Node, Node> visited = new HashMap<>();
        verifyDeepCopyDFS(original, cloned, visited);

        // Root node check
        Assertions.assertNotSame(original, cloned, "**Cloned node must be a new object instance.**");
    }

    private void verifyDeepCopyDFS(Node original, Node cloned, Map<Node, Node> visited) {
        if (original == null) return;

        if (visited.containsKey(original)) {
            Assertions.assertSame(visited.get(original), cloned, "**Revisiting a node should return the same cloned object.**");
            return;
        }

        visited.put(original, cloned);

        Assertions.assertNotSame(original, cloned, "**Cloned node must be a new instance.**");
        Assertions.assertEquals(original.val, cloned.val, "Node values must match.");
        Assertions.assertEquals(original.neighbors.size(), cloned.neighbors.size(), "Neighbors list size must match.");

        for (int i = 0; i < original.neighbors.size(); i++) {
            verifyDeepCopyDFS(original.neighbors.get(i), cloned.neighbors.get(i), visited);
        }
    }
    // ---------------------------------------------


    /**
     * 🧪 Test case for a graph with a cycle (standard LeetCode example)
     */
    @Test
    void testGraphWithCycle() {
        // Input: [[2,4],[1,3],[2,4],[1,3]] -> Graph: 1--2, 2--3, 3--4, 4--1
        List<List<Integer>> adjList = List.of(
                List.of(2, 4),
                List.of(1, 3),
                List.of(2, 4),
                List.of(1, 3)
        );
        Node original = buildGraph(adjList);
        Node cloned = solution.cloneGraph(original);

        verifyDeepCopy(original, cloned);
    }

    /**
     * 🧪 Test case for a single node with no neighbors
     */
    @Test
    void testSingleNodeGraph() {
        // Input: [[]] -> Graph: 1
        List<List<Integer>> adjList = List.of(List.of());
        Node original = buildGraph(adjList);

        Node cloned = solution.cloneGraph(original);

        verifyDeepCopy(original, cloned);
        Assertions.assertTrue(cloned.neighbors.isEmpty(), "Single node clone should have no neighbors.");
    }

    /**
     * 🧪 Test case for a null input
     */
    @Test
    void testNullInput() {
        Node original = null;
        Node cloned = solution.cloneGraph(original);

        verifyDeepCopy(original, cloned);
    }

    /**
     * 🧪 Test case for a simple linear graph
     */
    @Test
    void testGraphInALine() {
        // Input: [[2], [1,3], [2]] -> Graph: 1 -- 2 -- 3
        List<List<Integer>> adjList = List.of(
                List.of(2),
                List.of(1, 3),
                List.of(2)
        );
        Node original = buildGraph(adjList);
        Node cloned = solution.cloneGraph(original);

        verifyDeepCopy(original, cloned);
    }
}

