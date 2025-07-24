package com.ds.HashTable_DS;

public class MainClass {
public static void main(String[] args) {
	HashTable myHashTable=new HashTable();
	
	
	myHashTable.set("snail", 1000);
	myHashTable.set("crawl", 200);
	myHashTable.set("fint", 3000);

	myHashTable.printTable();
	
	System.out.println(myHashTable.get("snail"));
	
	System.out.println(myHashTable.getKeys());
}

}
