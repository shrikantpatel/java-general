package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _310_Minimum_Height_Trees {

    /**
     * Finds all roots of Minimum Height Trees (MHTs).
     *
     * Approach:
     * - A tree's MHT roots are its centroids (1 or 2 nodes).
     * - Use a "leaf trimming" algorithm:
     *   1. Build adjacency list and degree count.
     *   2. Initialize leaves (nodes with degree 1).
     *   3. Iteratively remove leaves layer by layer.
     *   4. Remaining 1–2 nodes are centroids → MHT roots.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Edge case: single node tree
        if (n == 1) return Collections.singletonList(0);

        // Step 1: Build adjacency list
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // Step 2: Initialize leaves (degree == 1)
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }

        // Step 3: Trim leaves until ≤ 2 nodes remain
        int remaining = n;
        while (remaining > 2) {
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                // Each leaf has exactly one neighbor
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(neighbor).remove(leaf);

                // If neighbor becomes a leaf, add to newLeaves
                if (adj.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves; // Move inward
        }

        // Step 4: Remaining nodes are centroids (MHT roots)
        return leaves;
    }

    @Test
    void testSingleNodeTree() {
        assertEquals(List.of(0), findMinHeightTrees(1, new int[][]{}));
    }

    @Test
    void testTwoNodesTree() {
        int[][] edges = {{0,1}};
        assertEquals(List.of(0,1), findMinHeightTrees(2, edges));
    }


    @Test
    void testExampleTreeWithTwoCentroids() {
        int[][] edges = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        List<Integer> result = findMinHeightTrees(6, edges);
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
        assertEquals(2, result.size());
    }

    @Test
    void testLinearChainTree() {
        int[][] edges = {{0,1},{1,2},{2,3},{3,4}};
        List<Integer> result = findMinHeightTrees(5, edges);
        // Centroids are middle nodes [2]
        assertEquals(List.of(2), result);
    }

    @Test
    void testLinearChainEvenLength() {
        int[][] edges = {{0,1},{1,2},{2,3},{3,4},{4,5}};
        List<Integer> result = findMinHeightTrees(6, edges);
        // Centroids are [2,3]
        assertEquals(List.of(2,3), result);
    }
}