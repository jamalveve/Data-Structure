package com.ds.LinkedList_DS;

public class LeetCodeSwapElements {


	    
	       public static void main(String[] args) {

	        System.out.println("Test 1: Even number of nodes");
	        LinkedList4 ll1 = new LinkedList4(1);
	        ll1.append(2);
	        ll1.append(3);
	        ll1.append(4);
	        System.out.print("BEFORE: ");
	        ll1.printList();
	        ll1.swapPairs();
	        System.out.print("AFTER:  ");
	        ll1.printList();

	        System.out.println("\nTest 2: Odd number of nodes");
	        LinkedList4 ll2 = new LinkedList4(1);
	        ll2.append(2);
	        ll2.append(3);
	        ll2.append(4);
	        ll2.append(5);
	        System.out.print("BEFORE: ");
	        ll2.printList();
	        ll2.swapPairs();
	        System.out.print("AFTER:  ");
	        ll2.printList();

	        System.out.println("\nTest 3: Single node");
	        LinkedList4 ll3 = new LinkedList4(1);
	        System.out.print("BEFORE: ");
	        ll3.printList();
	        ll3.swapPairs();
	        System.out.print("AFTER:  ");
	        ll3.printList();

	        System.out.println("\nTest 4: Empty list");
	        LinkedList4 ll4 = new LinkedList4(1);
	        ll4.makeEmpty();
	        System.out.print("BEFORE: ");
	        ll4.printList();
	        ll4.swapPairs();
	        System.out.print("AFTER:  ");
	        ll4.printList();

	        System.out.println("\nTest 5: Two nodes");
	        LinkedList4 ll5 = new LinkedList4(1);
	        ll5.append(2);
	        System.out.print("BEFORE: ");
	        ll5.printList();
	        ll5.swapPairs();
	        System.out.print("AFTER:  ");
	        ll5.printList();
	    }
	    
	



}

 class LinkedList4 {

    private Node head;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList4(int value) {
        Node newNode = new Node(value);
        head = newNode;
    }

    public Node getHead() {
        return head;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public void makeEmpty() {
        head = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }


    public void swapPairs()
    
    
    {
        //   +===================================================+
        //   |               WRITE YOUR CODE HERE                |
        //   | Description:                                      |
        //   | - Swaps every two adjacent nodes in the linked    |
        //   |   list.                                           |
        //   | - The method modifies the list in place.          |
        //   |                                                   |
        //   | Behavior:                                         |
        //   | - A dummy node is used to simplify swapping the   |
        //   |   first pair.                                     |
        //   | - In each iteration, two nodes (`first` and       |
        //   |   `second`) are swapped by adjusting pointers.    |
        //   | - The `previous` pointer helps reconnect the      |
        //   |   swapped pairs to the rest of the list.          |
        //   | - The `first` pointer then moves forward two      |
        //   |   nodes at a time.                                |
        //   | - At the end, `head` is updated to point to the   |
        //   |   new first node.                                 |
        //   +===================================================+
    	
    
    	    if (head == null || head.next == null) return;

    	    Node dummy = new Node(0);
    	    dummy.next = head;

    	    Node prev = dummy;

    	    while (prev.next != null && prev.next.next != null) {
    	        Node first = prev.next;
    	        Node second = first.next;

    	        // Swapping
    	        first.next = second.next;
    	        second.next = first;
    	        prev.next = second;

    	        // Move prev two nodes ahead
    	        prev = first;
    	    }

    	    head = dummy.next;
    	}

    
    
}

