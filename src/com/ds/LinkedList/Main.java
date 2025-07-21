package com.ds.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList list = new LinkedList(4);

		list.getHead();
		list.getLength();
		list.getTail();

//	list.PrintList();
		list.append(5);
		list.append(6);
		list.append(7);
		list.prepend(10);
		list.PrintList();
		list.getLength();

		list.RemoveLast();
		list.PrintList();
		list.getLength();

		list.RemoveFirst();
		list.PrintList();

		System.out.println(list.get(2).value);
		list.set(2, 100);
		list.PrintList();

		System.out.println("after inserting new element");

		list.insert(2, 200);

		list.PrintList();

		System.out.println("after removing  element");

		list.remove(2);

		list.PrintList();
		list.reverse();
		System.out.println("after reverse  element");

		
		list.PrintList();

	}

}
