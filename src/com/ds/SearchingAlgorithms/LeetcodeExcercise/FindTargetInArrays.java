package com.ds.SearchingAlgorithms.LeetcodeExcercise;

public class FindTargetInArrays {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow

            if (nums[mid] == target) {
                return mid; // target found
            } else if (nums[mid] < target) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        return -1; // target not found
    }

    public static void main(String[] args) {
        FindTargetInArrays sol = new FindTargetInArrays();
        int[] nums1 = { -1, 0, 3, 5, 9, 12 };
        System.out.println(sol.search(nums1, 9)); // Output: 4
        System.out.println(sol.search(nums1, 2)); // Output: -1
    }
}
