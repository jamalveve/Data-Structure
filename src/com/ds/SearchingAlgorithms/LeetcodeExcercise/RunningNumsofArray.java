package com.ds.SearchingAlgorithms.LeetcodeExcercise;

public class RunningNumsofArray {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;

        // Linear scan through nums
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // accumulate sum
            result[i] = sum; // store in result array
        }

        return result;
    }

    public static void main(String[] args) {
        RunningNumsofArray sol = new RunningNumsofArray();
        int[] nums1 = { 1, 2, 3, 4 };
        int[] output1 = sol.runningSum(nums1);
        for (int n : output1) {
            System.out.print(n + " "); // Output: 1 3 6 10
        }
    }

}
