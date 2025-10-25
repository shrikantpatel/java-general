package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class _235_Lowest_Common_Ancestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode result = null;

        // find all the nodes in path of the p
        List<TreeNode> pathToP = findAllNodeInPath(root, p);

        // find all the nodes in the path of the q
        List<TreeNode> pathToQ = findAllNodeInPath(root, q);

        // find common parent between the 2 path
        int i = 0;
        while (i < pathToP.size() && i < pathToQ.size() && pathToP.get(i) == pathToQ.get(i)) {
            result = pathToP.get(i);
            i++;
        }

        return result;
    }

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor_1(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor_1(root.right, p, q);
        } else {
            return root;
        }
    }

    private List<TreeNode> findAllNodeInPath(TreeNode root, TreeNode nodeToFind) {

        List<TreeNode> list = new ArrayList<>();
        TreeNode node = root;

        while (node.val != nodeToFind.val) {
            list.add(node);
            if (nodeToFind.val > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        list.add(node);

        return list;

    }

    // LCA tests placed in same class
    private TreeNode buildSampleTreeForLCA() {
        // Construct the BST:
        //         6
        //       /   \
        //      2     8
        //     / \   / \
        //    0   4 7   9
        //       / \
        //      3   5
        TreeNode n0 = new TreeNode(0);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4, n3, n5);
        TreeNode n2 = new TreeNode(2, n0, n4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);
        TreeNode n8 = new TreeNode(8, n7, n9);
        return new TreeNode(6, n2, n8);
    }

    @org.junit.jupiter.api.Test
    public void testLCAIsRootWhenNodesOnDifferentSides() {
        TreeNode root = buildSampleTreeForLCA();
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        TreeNode lca = lowestCommonAncestor(root, p, q);
        assertNotNull(lca);
        assertEquals(6, lca.val);
        lca = lowestCommonAncestor_1(root, p, q);
        assertNotNull(lca);
        assertEquals(6, lca.val);
    }

    @org.junit.jupiter.api.Test
    public void testLCAIsOneOfNodesWhenAncestorIsOneNode() {
        TreeNode root = buildSampleTreeForLCA();
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode lca = lowestCommonAncestor(root, p, q);
        assertNotNull(lca);
        assertEquals(2, lca.val);
        lca = lowestCommonAncestor_1(root, p, q);
        assertNotNull(lca);
        assertEquals(2, lca.val);
    }

    @Test
    public void testLCAWhenNodesAreSame() {
        TreeNode root = buildSampleTreeForLCA();
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(3);
        TreeNode lca = lowestCommonAncestor(root, p, q);
        assertNotNull(lca);
        assertEquals(3, lca.val);
        lca = lowestCommonAncestor_1(root, p, q);
        assertNotNull(lca);
        assertEquals(3, lca.val);
    }
}
