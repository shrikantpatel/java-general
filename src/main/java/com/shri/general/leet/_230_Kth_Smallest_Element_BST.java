package com.shri.general.leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 230. Kth Smallest Element in a BST
 * Medium
 * <p>
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * <p>
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * <p>
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 */
public class _230_Kth_Smallest_Element_BST {

    // keeps track what lowest element i am on, so i dont have to traverse the complete tree
    int counter = 0;

    public int kthSmallest(TreeNode root, int k) {

        int answer = -1;
        List<Integer> incrementValueArray = new ArrayList<Integer>();

        TreeNode currentNode = root;

        dfs_PostOrderTrasversal(incrementValueArray, currentNode, k);
        answer = incrementValueArray.get(k-1);
        return answer;

    }

    private void dfs_PostOrderTrasversal(List<Integer> incrementValueArray, TreeNode node, int k) {

        if(node == null) return;
        if (counter >= k) return;

        dfs_PostOrderTrasversal(incrementValueArray, node.left, k);
        incrementValueArray.add(node.val);
        counter++;
        if (counter >= k) return;
        dfs_PostOrderTrasversal(incrementValueArray, node.right, k);

    }

    @Test
    public void test1() {
        _230_Kth_Smallest_Element_BST test = new _230_Kth_Smallest_Element_BST();
        List<Integer> elements = Arrays.asList(3, 1, 4, -1, 2);
        TreeNode rootNode = TreeNode.createTree(elements);
        Assert.assertEquals(1, test.kthSmallest(rootNode, 1));
    }

    @Test
    public void test2() {
        _230_Kth_Smallest_Element_BST test = new _230_Kth_Smallest_Element_BST();
        List<Integer> elements = Arrays.asList(5, 3, 6, 2, 4, -1, -1, 1);
        TreeNode rootNode = TreeNode.createTree(elements);
        Assert.assertEquals(3, test.kthSmallest(rootNode, 3));
    }

    @Test
    public void test3() {
        _230_Kth_Smallest_Element_BST test = new _230_Kth_Smallest_Element_BST();
        List<Integer> elements = Arrays.asList(1, -1, 2);
        TreeNode rootNode = TreeNode.createTree(elements);
        Assert.assertEquals(2, test.kthSmallest(rootNode, 2));
    }
}
