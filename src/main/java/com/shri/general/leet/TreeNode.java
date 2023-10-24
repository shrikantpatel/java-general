package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode next;

    public TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(List<Integer> elements) {

        int totalElements = elements.size();

        //IMP using queue as its FIFO, FIFO \ Queue structure best describes
        //how to track which node are avialable to add the child node as we iterate through the list
        Queue<TreeNode> nodeAvailable = new ArrayBlockingQueue<TreeNode>(totalElements);
        int counter = 0;

        TreeNode rootNode = new TreeNode(elements.get(counter++));
        nodeAvailable.add(rootNode);
        TreeNode parentNode = null;
        TreeNode leftChildNode = null;
        TreeNode rightChildNode = null;

        // iterate through the element and find place in tree
        while (counter < totalElements) {

            // parent node = get the first element from queue. poll remove it from queue as well
            parentNode = nodeAvailable.poll();

            // create the left children node
            leftChildNode = createTreeNode(elements.get(counter++));
            // add the left children to parent node
            parentNode.left = leftChildNode;
            // add the left children to available node queue.
            addToAvailableNodeQueue(leftChildNode, nodeAvailable);

            if (counter < totalElements) {
                // create the right children node
                rightChildNode = createTreeNode(elements.get(counter++));
                // add the right children to parent node
                parentNode.right = rightChildNode;
                // add the right children to available node queue.
                addToAvailableNodeQueue(rightChildNode, nodeAvailable);
            }
        }
        return rootNode;
    }

    private static void addToAvailableNodeQueue(TreeNode node, Queue<TreeNode> nodeAvailable) {
        if (node != null) {
            nodeAvailable.add(node);
        }
    }

    private static TreeNode createTreeNode(Integer nodeValue) {
        TreeNode node = null;
        if (nodeValue != -1) {
            node = new TreeNode(nodeValue);
        }
        return node;
    }

    // Breadth first search
    public static List<Integer> convertTreeToArray(TreeNode root) {
        List<Integer> elementsArrangeByLevel = new ArrayList<Integer>();

        //IMP using queue as its FIFO, FIFO \ Queue structure best describes
        //how to track which node are avialable to add the child node as we iterate through the list
        Queue<TreeNode> nodeAvailable = new LinkedList<>();
        nodeAvailable.add(root);
        elementsArrangeByLevel.add(root.val);
        TreeNode node = null;

        while (nodeAvailable.size() > 0) {
            node = nodeAvailable.poll();
            addElementToList(node.left, nodeAvailable, elementsArrangeByLevel);
            addElementToList(node.right, nodeAvailable, elementsArrangeByLevel);
        }
        return elementsArrangeByLevel;
    }

    private static void addElementToList(TreeNode node, Queue<TreeNode> nodeAvailable, List<Integer> elementsArrangeByLevel) {
        if (node != null) {
            elementsArrangeByLevel.add(node.val);
            nodeAvailable.add(node);
        }
    }

    @Test
    public void testScenario1() {
        List<Integer> elements = Arrays.asList(5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1);
        List<Integer> elements1 = Arrays.asList(5, 4, 8, 11, 13, 4, 7, 2, 5, 1);
        TreeNode rootNode = createTree(elements);
        List<Integer> treeAsList = convertTreeToArray(rootNode);
        assertArrayEquals(elements1.toArray(), treeAsList.toArray());
    }

    @Test
    public void testScenario2() {
        List<Integer> elements = Arrays.asList(5, 4, 8);
        List<Integer> elements1 = elements;
        TreeNode rootNode = createTree(elements);
        List<Integer> treeAsList = convertTreeToArray(rootNode);
        assertArrayEquals(elements1.toArray(), treeAsList.toArray());
    }

    @Test
    public void testScenario3() {
        List<Integer> elements = Arrays.asList(5, 4, 8, 11, -1, -1, 4);
        List<Integer> elements1 = Arrays.asList(5, 4, 8, 11, 4);
        TreeNode rootNode = createTree(elements);
        List<Integer> treeAsList = convertTreeToArray(rootNode);
        assertArrayEquals(elements1.toArray(), treeAsList.toArray());
    }

    @Test
    public void testScenario4() {
        List<Integer> elements = Arrays.asList(5, 4, 8, -1, 11, 4, -1);
        List<Integer> elements1 = Arrays.asList(5, 4, 8, 11, 4);
        TreeNode rootNode = createTree(elements);
        List<Integer> treeAsList = convertTreeToArray(rootNode);
        assertArrayEquals(elements1.toArray(), treeAsList.toArray());
    }

    @Test
    public void testScenario5() {
        List<Integer> elements = Arrays.asList(1, 2);
        TreeNode rootNode = createTree(elements);
        List<Integer> treeAsList = convertTreeToArray(rootNode);
        assertArrayEquals(elements.toArray(), treeAsList.toArray());
    }

}