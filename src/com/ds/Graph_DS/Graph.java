package com.ds.Graph_DS;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

//	Graph vertix structure 
//	
//	{
//		"A"=[]
//	}

//	step1:empty hashmap ,we need to create { } 

	private HashMap<String, ArrayList<String>> adjustList = new HashMap<>();

	public void printGraph() {
		System.out.println(adjustList);
	}

//	step 2:add vertex ,we need to create "A"=[] i.e "vertex"=emptyarraylist

	public boolean addVertex(String vertex) {
		if (adjustList.get(vertex) == null) {
			adjustList.put(vertex, new ArrayList<String>());
			return true;
		}
		return false;
	}

//	step 3:remove vertex ,
	public boolean removeVertex(String vertex) {
		if (adjustList.get(vertex) == null)
			return false;// means vertex is not in graoh
		for (String otherVertex : adjustList.get(vertex)) {
			adjustList.get(otherVertex).remove(vertex);

		}

		adjustList.remove(vertex);
		return true;

	}

//	step4: add edge is vertex 1,vertex 2..

//	Graph edge structure 

//	
//		"A"=[B],
//	    "B"=[A]
//	

	public boolean addEdge(String vertex1, String vertex2) {
		if (adjustList.get(vertex1) != null && adjustList.get(vertex2) != null)

		{
			adjustList.get(vertex1).add(vertex2);
			adjustList.get(vertex2).add(vertex1);
			return true;
		}
		return false;

	}

//	step5: remove edge is vertex 1,vertex 2..

	public boolean removeEdge(String vertex1, String vertex2) {
		if (adjustList.get(vertex1) != null && adjustList.get(vertex2) != null) {
			adjustList.get(vertex1).remove(vertex2);
			adjustList.get(vertex2).remove(vertex1);
			return true;

		}

		return false;
	}

}
