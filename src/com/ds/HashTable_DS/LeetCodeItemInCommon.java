package com.ds.HashTable_DS;

import java.util.HashMap;

public class LeetCodeItemInCommon {
	
	
	
	public static boolean itemInCommon(int[] array1,int[] array2) {
		HashMap<Integer, Boolean> map=new HashMap<Integer, Boolean>();
		
		for(int i:array1) {
			map.put(i, true);
		}
		for(int j:array2) {
			if(map.get(j)!=null) return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
        System.out.println("These tests confirm itemInCommon() detects");
        System.out.println("whether two arrays share any common element.");
        System.out.println();

        // Test 1: Common element exists
        System.out.println("Test 1: Common Element Exists");
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 3};
        System.out.println("Expected: true");
        System.out.println("Actual: " + itemInCommon(array1, array2));
        System.out.println();

        // Test 2: No common element
        System.out.println("Test 2: No Common Element");
        int[] array3 = {1, 2, 3};
        int[] array4 = {4, 5, 6};
        System.out.println("Expected: false");
        System.out.println("Actual: " + itemInCommon(array3, array4));
        System.out.println();

        // Test 3: All elements match
        System.out.println("Test 3: All Elements Match");
        int[] array5 = {7, 8, 9};
        int[] array6 = {7, 8, 9};
        System.out.println("Expected: true");
        System.out.println("Actual: " + itemInCommon(array5, array6));
        System.out.println();

        // Test 4: Arrays with duplicates
        System.out.println("Test 4: Arrays with Duplicates");
        int[] array7 = {1, 1, 2, 3};
        int[] array8 = {3, 3, 4, 5};
        System.out.println("Expected: true");
        System.out.println("Actual: " + itemInCommon(array7, array8));
        System.out.println();

        // Test 5: Edge case with empty array
        System.out.println("Test 5: Edge Case with Empty Array");
        int[] array9 = {};
        int[] array10 = {1, 2, 3};
        System.out.println("Expected: false");
        System.out.println("Actual: " + itemInCommon(array9, array10));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            These tests confirm itemInCommon() detects
            whether two arrays share any common element.

            Test 1: Common Element Exists
            Expected: true
            Actual: true

            Test 2: No Common Element
            Expected: false
            Actual: false

            Test 3: All Elements Match
            Expected: true
            Actual: true

            Test 4: Arrays with Duplicates
            Expected: true
            Actual: true

            Test 5: Edge Case with Empty Array
            Expected: false
            Actual: false
        */
        
    }
    

}
