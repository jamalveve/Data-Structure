package com.ds.SearchingAlgorithms;

public class ExponentialSearch {
    public static int exponentialSearch(int[] arr, int target) {
        if (arr[0] == target)
            return 0;

        int i = 1;
        while (i < arr.length && arr[i] <= target) {
            i = i * 2;
        }

        return binarySearch(arr, i / 2, Math.min(i, arr.length - 1), target);
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 10, 40, 50, 70, 90 };
        int target = 10;
        int result = exponentialSearch(arr, target);
        System.out.println(result == -1 ? "Not Found" : "Found at index " + result);
    }
}
