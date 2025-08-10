package com.ds.SearchingAlgorithms.LeetcodeExcercise;

public class SingleElementinSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // Ensure mid is even so comparison is always to its pair
            if (mid % 2 == 1)
                mid--;

            // If this pair is valid, single is further right
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                // Single is to the left (or at mid)
                right = mid;
            }
        }

        // When left == right, we've found the single
        return nums[left];
    }

    public static void main(String[] args) {
        SingleElementinSortedArray sol = new SingleElementinSortedArray();

        int[] nums1 = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        int[] nums2 = { 3, 3, 7, 7, 10, 11, 11 };

        System.out.println("Output 1: " + sol.singleNonDuplicate(nums1)); // Output: 2
        System.out.println("Output 2: " + sol.singleNonDuplicate(nums2)); // Output: 10
    }
}
