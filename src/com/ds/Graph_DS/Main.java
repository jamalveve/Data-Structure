package com.ds.Graph_DS;

public class Main {
public static void main(String[] args) {
	Graph myGraph=new Graph();
	myGraph.addVertex("A");
	myGraph.addVertex("B");
	myGraph.addVertex("C");
	myGraph.addVertex("D");
	myGraph.addVertex("E");

	
	myGraph.addEdge("A","B");
	myGraph.addEdge("A","C");
	myGraph.addEdge("C","D");
	myGraph.addEdge("C","E");
	myGraph.addEdge("D","E");


	myGraph.removeEdge("A","C");

	
	myGraph.removeVertex("E");
	

	myGraph.printGraph();

}
}
