package com.ds.HashTable_DS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeTwoSum {



	
	    
	    // WRITE THE TWOSUM MEHTOD HERE //
	    public static int[] twoSum(int nums[],int target) {
	    	
	    	
	    	  Map<Integer, Integer> map = new HashMap<>();
	          
	          for (int i = 0; i < nums.length; i++) {
	              int complement = target - nums[i];
	             
	              if (map.containsKey(complement)) {
	                 
	                  return new int[] { map.get(complement), i };
	              }
	             
	              map.put(nums[i], i);
	          }
	          
	      
	          return new int[0];
	    

	    }


	    private static String formatResult(int[] result) {
	        return result.length == 0 ? "[]" : Arrays.toString(result);
	    }

	    public static void main(String[] args) {
	        System.out.println("These tests confirm twoSum() returns the indices");
	        System.out.println("of two numbers in the array that add up to target.");
	        System.out.println();

	        // Test 1: Basic pair
	        System.out.println("Test 1: Basic Pair");
	        int[] nums1 = {2, 7, 11, 15};
	        int target1 = 9;
	        System.out.println("Expected: Indices of 2 and 7 (any valid order)");
	        System.out.println("Actual: " + formatResult(twoSum(nums1, target1)));
	        System.out.println();

	        // Test 2: Multiple pairs exist
	        System.out.println("Test 2: Multiple Pairs");
	        int[] nums2 = {1, 3, 2, 4, 6};
	        int target2 = 5;
	        System.out.println("Expected: Any valid pair summing to 5");
	        System.out.println("Actual: " + formatResult(twoSum(nums2, target2)));
	        System.out.println();

	        // Test 3: Negative numbers
	        System.out.println("Test 3: Negative Numbers");
	        int[] nums3 = {-3, 4, 3, 90};
	        int target3 = 0;
	        System.out.println("Expected: Indices of -3 and 3");
	        System.out.println("Actual: " + formatResult(twoSum(nums3, target3)));
	        System.out.println();

	        // Test 4: Duplicates used twice
	        System.out.println("Test 4: Duplicates Used Twice");
	        int[] nums4 = {3, 3};
	        int target4 = 6;
	        System.out.println("Expected: Indices of both 3's");
	        System.out.println("Actual: " + formatResult(twoSum(nums4, target4)));
	        System.out.println();

	        // Test 5: No solution
	        System.out.println("Test 5: No Solution");
	        int[] nums5 = {1, 2, 3};
	        int target5 = 10;
	        System.out.println("Expected: []");
	        System.out.println("Actual: " + formatResult(twoSum(nums5, target5)));
	        System.out.println();

	        /*
	            EXPECTED OUTPUT:
	            ----------------
	            These tests confirm twoSum() returns the indices
	            of two numbers in the array that add up to target.

	            Test 1: Basic Pair
	            Expected: Indices of 2 and 7 (any valid order)
	            Actual: [0, 1] (or valid indices for 2,7)

	            Test 2: Multiple Pairs
	            Expected: Any valid pair summing to 5
	            Actual: [1, 2] (or valid indices)

	            Test 3: Negative Numbers
	            Expected: Indices of -3 and 3
	            Actual: [0, 2] (or valid indices)

	            Test 4: Duplicates Used Twice
	            Expected: Indices of both 3's
	            Actual: [0, 1]

	            Test 5: No Solution
	            Expected: []
	            Actual: []
	        */
	        
	    }
	    
	


}
