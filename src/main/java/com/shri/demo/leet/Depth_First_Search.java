package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Depth_First_Search {


    /**
     * pre order transversal without recursion
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTransversal(TreeNode root) {

        List<Integer> preOrderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current;

        //start with the root, push it on stack first
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current != null) {
                preOrderList.add(current.val);
                stack.push(current.right); // push right first, so it pop after left tree trasversal is done
                stack.push(current.left); // push left last, so it pop first
            }
        }
        return preOrderList;
    }

    /**
     * in order transversal without recursion
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTransversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inOrderList = new ArrayList<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            inOrderList.add(current.val);
            current = current.right;
        }
        return inOrderList;
    }

    /**
     *                          5
     *                  4                              8
     *          11                                    13              4
     * 7          2                                        5       1
     * <p>
     * 5   4   11   7
     * 7
     */

    @Test
    public void testScenario1() {
        List<Integer> elements = Arrays.asList(5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1);
        TreeNode rootNode = TreeNode.createTree(elements);

        List<Integer> preOrderActual = preOrderTransversal(rootNode);
        List<Integer> inOrderActual = inOrderTransversal(rootNode);

        List<Integer> preOrderExpected = Arrays.asList(5, 4, 11, 7, 2, 8, 13, 4, 5, 1);
        List<Integer> inOrderExpected = Arrays.asList(7, 11, 2, 4, 5, 13, 8, 5, 4, 1);

        Assert.assertArrayEquals(preOrderExpected.toArray(), preOrderActual.toArray());
        Assert.assertArrayEquals(inOrderExpected.toArray(), inOrderActual.toArray());
    }

    @Test
    public void testScenario2() {
        List<Integer> elements = Arrays.asList(5, 4, 8);
        TreeNode rootNode = TreeNode.createTree(elements);

        List<Integer> preOrderActual = preOrderTransversal(rootNode);
        List<Integer> inOrderActual = inOrderTransversal(rootNode);

        List<Integer> preOrderExpected = Arrays.asList(5, 4, 8);
        List<Integer> inOrderExpected = Arrays.asList(4, 5, 8);

        Assert.assertArrayEquals(preOrderExpected.toArray(), preOrderActual.toArray());
        Assert.assertArrayEquals(inOrderExpected.toArray(), inOrderActual.toArray());
    }

    @Test
    public void testScenario3() {
        List<Integer> elements = Arrays.asList(5, 4, 8, 11, -1, -1, 4);
        TreeNode rootNode = TreeNode.createTree(elements);

        List<Integer> preOrderActual = preOrderTransversal(rootNode);
        List<Integer> inOrderActual = inOrderTransversal(rootNode);

        List<Integer> preOrderExpected = Arrays.asList(5, 4, 11, 8, 4);
        List<Integer> inOrderExpected = Arrays.asList(11, 4, 5, 8, 4);

        Assert.assertArrayEquals(preOrderExpected.toArray(), preOrderActual.toArray());
        Assert.assertArrayEquals(inOrderExpected.toArray(), inOrderActual.toArray());
    }

    @Test
    public void testScenario4() {
        List<Integer> elements = Arrays.asList(5, 4, 8, -1, 11, 4, -1);
        TreeNode rootNode = TreeNode.createTree(elements);

        List<Integer> preOrderActual = preOrderTransversal(rootNode);
        List<Integer> inOrderActual = inOrderTransversal(rootNode);

        List<Integer> preOrderExpected = Arrays.asList(5, 4, 11, 8, 4);
        List<Integer> inOrderExpected = Arrays.asList(4, 11, 5, 4, 8);

        Assert.assertArrayEquals(preOrderExpected.toArray(), preOrderActual.toArray());
        Assert.assertArrayEquals(inOrderExpected.toArray(), inOrderActual.toArray());
    }

    @Test
    public void testScenario5() {
        List<Integer> elements = Arrays.asList(1, 2);
        TreeNode rootNode = TreeNode.createTree(elements);

        List<Integer> preOrderActual = preOrderTransversal(rootNode);
        List<Integer> inOrderActual = inOrderTransversal(rootNode);

        List<Integer> preOrderExpected = Arrays.asList(1, 2);
        List<Integer> inOrderExpected = Arrays.asList(2, 1);

        Assert.assertArrayEquals(preOrderExpected.toArray(), preOrderActual.toArray());
        Assert.assertArrayEquals(inOrderExpected.toArray(), inOrderActual.toArray());
    }
}
