package com.ds.LinkedList_DS;


public class LeetCodeRemoveDuplicates {
	
	    public static void main(String[] args) {

	        LinkedList5 myLinkedList = new LinkedList5(1);

	        myLinkedList.append(2);
	        myLinkedList.append(3);
	        myLinkedList.append(1);
	        myLinkedList.append(4);
	        myLinkedList.append(2);
	        myLinkedList.append(5);

	        myLinkedList.removeDuplicates();

	        myLinkedList.printList();

	    }

}




 class LinkedList5 {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList5(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
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
        } else {
            System.out.println("Head: " + head.value);
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
        length = 0;
    }
    
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }
    
   
public void removeDuplicates() {
    Node current = head;
    int count = 0; // to recalculate length

    while (current != null) {
        count++; // this node is unique so far
        Node runner = current;
        while (runner.next != null) {
            if (runner.next.value == current.value) {
                // Remove duplicate node
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }
        }
        current = current.next;
    }

    // Update length after removing duplicates
    this.length = count;
}


    
}

