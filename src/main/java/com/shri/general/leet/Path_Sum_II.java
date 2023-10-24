package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/path-sum-ii/
 *
 * 113. Path Sum II
 *
 * Share
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Path_Sum_II {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int previousNodeSum = 0;
        Stack<Integer> currentElement = new Stack<>();
        getRooToLeafThatMatchTargetSum(root, targetSum, previousNodeSum, result, currentElement);

        return result;
    }

    private void getRooToLeafThatMatchTargetSum(TreeNode node, int targetSum, int previousNodeSum, List<List<Integer>> result, Stack<Integer> currentElements) {

        if (node == null) return;

        // add current node to previous node to get current running total
        int currentRunningNodeSum = previousNodeSum + node.val;
        currentElements.push(node.val);

        // if this is leaf node and current RunningNodeSum match target sum then add all element from current elements stack to result
        if (isLeafNode(node) && currentRunningNodeSum == targetSum) {
            result.add(new ArrayList<>(currentElements));
        }
        // if not leaf node continue the journey to child nodes
        else {
            getRooToLeafThatMatchTargetSum(node.left, targetSum, currentRunningNodeSum, result, currentElements);
            getRooToLeafThatMatchTargetSum(node.right, targetSum, currentRunningNodeSum, result, currentElements);
        }
        currentElements.pop();
    }

    //this is leaf node if it right or left child
    private boolean isLeafNode(TreeNode node) {
        if (node.left == null && node.right == null) return true;
        return false;
    }

    @Test
    public void test() {
        List<Integer> elements = Arrays.asList(5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1);
        TreeNode rootNode = TreeNode.createTree(elements);
        List<List<Integer>> output = pathSum(rootNode, 22);
        List<List<Integer>> exepected = Arrays.asList(Arrays.asList(5, 4, 11, 2), Arrays.asList(5, 8, 4, 5));
        assertArrayEquals(exepected.toArray(), output.toArray());
    }

    @Test
    public void test1() {
        List<Integer> elements = Arrays.asList(1, 2, 3);
        TreeNode rootNode = TreeNode.createTree(elements);
        List<List<Integer>> output = pathSum(rootNode, 5);
        assertArrayEquals((new ArrayList()).toArray(), output.toArray());
    }

    @Test
    public void test2() {
        List<Integer> elements = Arrays.asList(1, 2);
        TreeNode rootNode = TreeNode.createTree(elements);
        List<List<Integer>> output = pathSum(rootNode, 0);
        assertArrayEquals((new ArrayList()).toArray(), output.toArray());
    }

    @Test
    public void test3() {
        List<Integer> elements = Arrays.asList(1, 2);
        TreeNode rootNode = TreeNode.createTree(elements);
        List<List<Integer>> output = pathSum(rootNode, 3);
        List<List<Integer>> exepected = Arrays.asList(Arrays.asList(1, 2));
        assertArrayEquals(exepected.toArray(), output.toArray());
    }
}


