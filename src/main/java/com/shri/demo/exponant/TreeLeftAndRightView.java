package com.shri.demo.exponant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=thkuu_FWFD8&t=2146s
 */
class Node {
    public int data;
    public Node left, right = null;

    public Node(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

class TreeUtil {

    int currentMaxLevel = 0;

    public void printLeftView(Node node, int level) {
        if (node == null) return;

        if (level >= currentMaxLevel) {
            System.out.print(node.data + " ");
            currentMaxLevel++;
        }
        printLeftView(node.left, level +1);
        printLeftView(node.right, level +1);
    }

    public void leftEdge (Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.data);
            leftEdge(node.left, list);
        }
    }

    public void rightEdge (Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.data);
            rightEdge(node.right, list);
        }
    }

    public void outlineView (Node node) {
        List<Integer> list = new ArrayList<>();

        if (node != null) {
            list.add(node.data);
            leftEdge(node.left, list);
            Collections.reverse(list);
            rightEdge(node.right, list);
            for (Integer test : list) {
                System.out.print(test.intValue() + " ");
            }
        }

    }
}

class TreeLeftAndRightView {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(8);
        root.left.right = new Node (5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.left.left = new Node(9);
        root.right.left.left.left = new Node(12);
        root.right.left.right = new Node(10);
        root.right.left.right.left = new Node(11);

        root.right.right = new Node(7);

        TreeUtil treeUtil = new TreeUtil();
        treeUtil.printLeftView(root, 0);  //1 2 4 8 12
        System.out.println();
        treeUtil.outlineView(root);  //4, 2, 1, 3, 7
    }
}

/*
                            1                                               1 -- Level = 0
                2                              3                            2 -- Level = 1
         4             5               6               7                    4 -- Level = 2
             8                    9        10                               8 -- Level = 3
                             12          11                                11 -- Level = 4


Left view --> 1, 2, 4, 8, 12
Outline --> 4, 2, 1, 3, 7
*/