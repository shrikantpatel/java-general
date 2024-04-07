package com.shri.general.ds_course;

/**
 * LL: Find Middle Node ( ** Interview Question)
 * Implement a method called findMiddleNode that returns the middle node of the linked list.
 * <p>
 * If the list has an even number of nodes, the method should return the second middle node.
 * <p>
 * Note: this LinkedList implementation does not have a length member variable.
 * <p>
 * Method signature:
 * <p>
 * public Node findMiddleNode()
 * <p>
 * Example:
 * <p>
 * LinkedList myList = new LinkedList(1);
 * myList.append(2);
 * myList.append(3);
 * myList.append(4);
 * myList.append(5);
 * Node middleNode = myList.findMiddleNode();
 * System.out.println(middleNode.value); // Output: 3
 * <p>
 * myList.append(6);
 * middleNode = myList.findMiddleNode();
 * System.out.println(middleNode.value); // Output: 4
 * <p>
 * When the linked list has an odd number of nodes, like 1 -> 2 -> 3 -> 4 -> 5, the function will find the exact middle node. In this case, it will return the node containing the value 3.
 * <p>
 * When the linked list has an even number of nodes, there will be two middle nodes. The findMiddleNode function will return the second of these two middle nodes.
 * <p>
 * For example, if the linked list is 1 -> 2 -> 3 -> 4 -> 5 -> 6, the two middle nodes are 3 and 4. The function will return the node containing the value 4.
 * <p>
 * Note:
 * <p>
 * In this problem, you should use the slow and fast pointer technique (also known as Floyd's Tortoise and Hare algorithm) to find the middle element of the linked list efficiently.
 * <p>
 * The key idea is to have two pointers, one that moves twice as fast as the other. By the time the fast pointer reaches the end of the linked list, the slow pointer will be at the middle.
 */

public class LinkedList {

    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node findMiddleNode() {

        // this pointer move 1 element at time
        Node pointer1X = getHead();

        // this pointer move 2 element at time
        Node pointer2X = getHead();

        // while  end of the linked
        while (pointer2X != null) {
            pointer2X = pointer2X.next;
            if (pointer2X == null) break;
            pointer2X = pointer2X.next;
            pointer1X = pointer1X.next;
        }
        return pointer1X;
    }

    public boolean hasLoop() {

        // this pointer move 1 element at time
        Node pointer1x = getHead();

        // this pointer move 2 element at time
        Node pointer2x = getHead();

        while (pointer1x != null && pointer2x != null) {
            pointer2x = pointer2x.next;
            if (pointer2x == null || pointer1x.equals(pointer2x)) break;
            pointer2x = pointer2x.next;
            pointer1x = pointer1x.next;
        }

        return pointer2x != null;

    }

    public static void main (String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        System.out.println(ll.findMiddleNode().value);
        ll.append(5);
        System.out.println(ll.findMiddleNode().value);
    }

}


