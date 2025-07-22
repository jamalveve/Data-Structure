package com.ds.LinkedList_DS;

public class LeetCodeHasLoop {

    public static void main(String[] args) {

        LinkedList2 myLinkedList2 = new LinkedList2(1);
        myLinkedList2.append(2);
        myLinkedList2.append(3);
        myLinkedList2.append(4);
        myLinkedList2.append(5);

        // create a loop by connecting the tail to the second node
        myLinkedList2.getTail().next = myLinkedList2.getHead().next;

        System.out.println("Has Loop:");
        System.out.println(myLinkedList2.hasLoop());

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * Has Loop:
         * true
         * 
         */

    }

}

class LinkedList2 {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList2(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;

            }
        }

        return false;
    }
}
