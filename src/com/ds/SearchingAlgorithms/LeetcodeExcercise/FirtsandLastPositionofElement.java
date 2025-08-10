package com.ds.SearchingAlgorithms.LeetcodeExcercise;

public class FirtsandLastPositionofElement {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[] { first, last };
    }

    // Find first occurrence
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] == target)
                index = mid; // record index
        }
        return index;
    }

    // Find last occurrence
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target)
                index = mid; // record index
        }
        return index;
    }

    public static void main(String[] args) {
        FirtsandLastPositionofElement sol = new FirtsandLastPositionofElement();
        int[] nums1 = { 5, 7, 7, 8, 8, 10 };
        int[] nums2 = { 5, 7, 7, 8, 8, 10 };
        int[] nums3 = {};

        System.out.println(java.util.Arrays.toString(sol.searchRange(nums1, 8))); // [3, 4]
        System.out.println(java.util.Arrays.toString(sol.searchRange(nums2, 6))); // [-1, -1]
        System.out.println(java.util.Arrays.toString(sol.searchRange(nums3, 0))); // [-1, -1]
    }
}
