package com.ds.SearchingAlgorithms.LeetcodeExcercise;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame sol = new JumpGame();
        int[] nums1 = { 2, 3, 1, 1, 4 };
        int[] nums2 = { 3, 2, 1, 0, 4 };

        System.out.println("Example 1 Output: " + sol.canJump(nums1)); // true
        System.out.println("Example 2 Output: " + sol.canJump(nums2)); // false
    }
}
