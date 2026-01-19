package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/accounts-merge/
 */
public class _721_Accounts_Merge_Union_Find {

    /**
     * Main method to merge accounts using Union-Find.
     * Each email is treated as a node. If two emails appear in the same account,
     * they belong to the same connected component.
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // Map each email → unique integer ID (Union-Find works on integers)
        Map<String, Integer> emailToId = new HashMap<>();

        // Map each email → username (needed for final output)
        Map<String, String> emailToName = new HashMap<>();

        int id = 0; // unique ID counter

        // ---------------------------------------------------------
        // STEP 1: Assign each email a unique ID and store its name
        // ---------------------------------------------------------
        for (List<String> acc : accounts) {
            String name = acc.get(0);

            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);

                // Assign ID only once per email
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                    emailToName.put(email, name);
                }
            }
        }

        // Initialize Union-Find with total number of unique emails
        UnionFind uf = new UnionFind(id);

        // ---------------------------------------------------------
        // STEP 2: Union all emails within the same account
        // ---------------------------------------------------------
        for (List<String> acc : accounts) {

            // First email in the account becomes the "anchor"
            String firstEmail = acc.get(1);
            int firstId = emailToId.get(firstEmail);

            // Union all other emails in the account with the anchor
            for (int i = 2; i < acc.size(); i++) {
                String nextEmail = acc.get(i);
                uf.union(firstId, emailToId.get(nextEmail));
            }
        }

        // ---------------------------------------------------------
        // STEP 3: Group emails by their root parent
        // ---------------------------------------------------------
        Map<Integer, List<String>> rootToEmails = new HashMap<>();

        for (String email : emailToId.keySet()) {
            int root = uf.find(emailToId.get(email)); // find root parent
            rootToEmails.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        // ---------------------------------------------------------
        // STEP 4: Build final merged account list
        // ---------------------------------------------------------
        List<List<String>> result = new ArrayList<>();

        for (List<String> emails : rootToEmails.values()) {
            Collections.sort(emails); // sort emails lexicographically

            // All emails in this group belong to the same user
            String name = emailToName.get(emails.get(0));

            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(emails);

            result.add(merged);
        }

        return result;
    }

    // =====================================================================
    // UNION-FIND (DISJOINT SET UNION) WITH DETAILED COMMENTS
    // =====================================================================
    static class UnionFind {
        int[] parent; // parent[i] = parent of node i
        int[] rank;   // rank[i] = height heuristic for union by rank

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            // Initially, each node is its own parent (self root)
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        /**
         * Find the root of x with path compression.
         * Path compression flattens the tree, making future finds faster.
         */
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // compress path
            }
            return parent[x];
        }

        /**
         * Union two sets by rank.
         * Attach smaller tree under larger tree to keep structure shallow.
         */
        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) return; // already in same set

            // Attach smaller rank tree under larger rank tree
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                // Same rank: attach B under A and increase A's rank
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }


    private void sortOuterList(List<List<String>> list) {
        list.sort(Comparator.comparing(a -> a.get(1))); // sort by first email
    }


    @Test
    void testExample1() {
        _721_Accounts_Merge_Union_Find m = new _721_Accounts_Merge_Union_Find();

        List<List<String>> input = List.of(
                List.of("John", "a@mail", "b@mail"),
                List.of("John", "b@mail", "c@mail"),
                List.of("John", "d@mail"),
                List.of("John", "o@mail", "p@mail")
        );

        List<List<String>> expected = new ArrayList<>(List.of(
                List.of("John", "a@mail", "b@mail", "c@mail"),
                List.of("John", "d@mail"),
                List.of("John", "o@mail", "p@mail")
        ));

        List<List<String>> actual = m.accountsMerge(input);

        sortOuterList(expected);
        sortOuterList(actual);

        assertEquals(expected, actual);
    }


    @Test
    void testSingleAccount() {
        _721_Accounts_Merge_Union_Find m = new _721_Accounts_Merge_Union_Find();

        List<List<String>> input = List.of(
                List.of("Mary", "x@mail", "y@mail")
        );

        List<List<String>> expected = List.of(
                List.of("Mary", "x@mail", "y@mail")
        );

        assertEquals(expected, m.accountsMerge(input));
    }

    @Test
    void testNoOverlap() {
        _721_Accounts_Merge_Union_Find m = new _721_Accounts_Merge_Union_Find();

        List<List<String>> input = List.of(
                List.of("A", "a@mail"),
                List.of("B", "b@mail"),
                List.of("C", "c@mail")
        );

        List<List<String>> expected = new ArrayList<>(List.of(
                List.of("A", "a@mail"),
                List.of("B", "b@mail"),
                List.of("C", "c@mail")
        ));

        List<List<String>> actual = m.accountsMerge(input);

        // Sort both lists before comparing
        sortOuterList(expected);
        sortOuterList(actual);

        assertEquals(expected, actual);
    }

    @Test
    void testFullChainMerge() {
        _721_Accounts_Merge_Union_Find m = new _721_Accounts_Merge_Union_Find();

        List<List<String>> input = List.of(
                List.of("John", "a@mail", "b@mail"),
                List.of("John", "b@mail", "c@mail"),
                List.of("John", "c@mail", "d@mail")
        );

        List<List<String>> expected = List.of(
                List.of("John", "a@mail", "b@mail", "c@mail", "d@mail")
        );

        assertEquals(expected, m.accountsMerge(input));
    }

    @Test
    void testEmptyInput() {
        _721_Accounts_Merge_Union_Find m = new _721_Accounts_Merge_Union_Find();

        List<List<String>> input = List.of();
        List<List<String>> expected = List.of();

        assertEquals(expected, m.accountsMerge(input));
    }

    @Test
    void testDavidCaseFullyMerged() {
        _721_Accounts_Merge_Union_Find m = new _721_Accounts_Merge_Union_Find();

        List<List<String>> input = List.of(
                List.of("David", "David0@m.co", "David1@m.co"),
                List.of("David", "David3@m.co", "David4@m.co"),
                List.of("David", "David4@m.co", "David5@m.co"),
                List.of("David", "David2@m.co", "David3@m.co"),
                List.of("David", "David1@m.co", "David2@m.co")
        );

        List<List<String>> expected = List.of(
                List.of(
                        "David",
                        "David0@m.co",
                        "David1@m.co",
                        "David2@m.co",
                        "David3@m.co",
                        "David4@m.co",
                        "David5@m.co"
                )
        );

        assertEquals(expected, m.accountsMerge(input));
    }

}