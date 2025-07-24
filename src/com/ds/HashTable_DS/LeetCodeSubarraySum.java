package com.ds.HashTable_DS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeSubarraySum {

	

	    // WRITE SUBARAYSUM METHOD HERE //
	public static int[] subarraySum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    int cumulativeSum = 0;

	    for (int i = 0; i < nums.length; i++) {
	        cumulativeSum += nums[i];

	        if (cumulativeSum == target) {
	            return new int[] {0, i};
	        }

	        if (map.containsKey(cumulativeSum - target)) {
	            return new int[] { map.get(cumulativeSum - target) + 1, i };
	        }

	        map.putIfAbsent(cumulativeSum, i);
	    }

	    return new int[0];
	}





	    private static String formatResult(int[] result) {
	        return result.length == 0 ? "[]" : Arrays.toString(result);
	    }

	    public static void main(String[] args) {
	        System.out.println("These tests confirm subarraySum() returns");
	        System.out.println("the start and end indices of a subarray");
	        System.out.println("that sums to the target, or [] if none exists.");
	        System.out.println();

	        // Test 1: Basic subarray
	        System.out.println("Test 1: Basic Subarray");
	        int[] nums1 = {1, 2, 3, 4, 5};
	        int target1 = 9;
	        System.out.println("Expected: Indices of subarray summing to 9");
	        System.out.println("Actual: " + formatResult(subarraySum(nums1, target1)));
	        System.out.println();

	        // Test 2: Multiple possible subarrays
	        System.out.println("Test 2: Multiple Possible Subarrays");
	        int[] nums2 = {1, 2, 2, 3, 1};
	        int target2 = 5;
	        System.out.println("Expected: Any valid subarray summing to 5");
	        System.out.println("Actual: " + formatResult(subarraySum(nums2, target2)));
	        System.out.println();

	        // Test 3: Includes negative numbers
	        System.out.println("Test 3: Handles Negative Numbers");
	        int[] nums3 = {3, 4, -7, 5, 1};
	        int target3 = 5;
	        System.out.println("Expected: Any valid subarray summing to 5");
	        System.out.println("Actual: " + formatResult(subarraySum(nums3, target3)));
	        System.out.println();

	        // Test 4: Entire array is the subarray
	        System.out.println("Test 4: Entire Array Matches");
	        int[] nums4 = {2, 2, 2, 2};
	        int target4 = 8;
	        System.out.println("Expected: Indices for full array [0,3]");
	        System.out.println("Actual: " + formatResult(subarraySum(nums4, target4)));
	        System.out.println();

	        // Test 5: No subarray found
	        System.out.println("Test 5: No Subarray Found");
	        int[] nums5 = {1, 1, 1};
	        int target5 = 10;
	        System.out.println("Expected: []");
	        System.out.println("Actual: " + formatResult(subarraySum(nums5, target5)));
	        System.out.println();

	        /*
	            EXPECTED OUTPUT:
	            ----------------
	            These tests confirm subarraySum() returns
	            the start and end indices of a subarray
	            that sums to the target, or [] if none exists.

	            Test 1: Basic Subarray
	            Expected: Indices of subarray summing to 9
	            Actual: [1, 3] (or valid subarray indices)

	            Test 2: Multiple Possible Subarrays
	            Expected: Any valid subarray summing to 5
	            Actual: [0, 2] (or other valid indices)

	            Test 3: Handles Negative Numbers
	            Expected: Any valid subarray summing to 5
	            Actual: [3, 4] (or other valid indices)

	            Test 4: Entire Array Matches
	            Expected: [0, 3]
	            Actual: [0, 3]

	            Test 5: No Subarray Found
	            Expected: []
	            Actual: []
	        */
	        
	    }

	
	    


}
