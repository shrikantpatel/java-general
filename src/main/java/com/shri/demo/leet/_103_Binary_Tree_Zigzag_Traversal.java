package com.shri.demo.leet;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * <p>
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */

import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class _103_Binary_Tree_Zigzag_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        // return 2 dimensional list.
        // outer list contains all the element at level 0, 1, 2, 3 etc.
        // inner list is the on the element at that specific level
        traverseTree(root, 0, result);

        //we want zig-zag ie move left to right for level 0
        //move right to left for level 1
        //move left to right from level 2 and so on and so forth
        //below achives that
        int count = 0;
        for (List<Integer> list :result) {
            if (count % 2 == 1) Collections.reverse(list);
            count++;
        }
        return result;
    }

    public void traverseTree(TreeNode root, int level, List<List<Integer>> result) {

        List<Integer> list = null;

        // if reach the level above current result size we need to add the list to the master list
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }
        list = result.get(level);

        if (root == null) {
            return;
        } else {
            list.add(root.val);
        }

        if (root.left != null) {
            traverseTree(root.left,level+1, result);
        }
        if (root.right != null) {
            traverseTree(root.right,level+1, result);
        }
    }

    @Test
    public void test1() {
        List<Integer> elements = Arrays.asList(5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1);
        TreeNode rootNode = TreeNode.createTree(elements);
        zigzagLevelOrder(rootNode);

    }

}