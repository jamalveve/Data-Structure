package com.ds.LinkedList_DS;

public class LeetCodeKthElement {

	public static void main(String[] args) {
		LinkedList3 myLinkedList = new LinkedList3(1);
		myLinkedList.append(2);
		myLinkedList.append(3);
		myLinkedList.append(4);
		myLinkedList.append(5);

		int k = 2;
		int result = myLinkedList.findKthFromEnd(k).value;

		System.out.println(result); // Output: 4

		/*
		 * EXPECTED OUTPUT: ---------------- 4
		 * 
		 */

	}

}

class LinkedList3 {

	private Node head;
	private Node tail;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public LinkedList3(int value) {
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

	public Node findKthFromEnd(int k) {
		Node fast = head;
		Node slow = head;

		for (int i = 0; i < k; i++) {
			if (fast == null)
				return null;
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;

		}
		return slow;

	}

}
