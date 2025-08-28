package com.ds.SearchingAlgorithms;

public class TernarySearch {
    public static int ternarySearch(int[] arr, int left, int right, int target) {
        if (right >= left) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (arr[mid1] == target)
                return mid1;
            if (arr[mid2] == target)
                return mid2;

            if (target < arr[mid1]) {
                return ternarySearch(arr, left, mid1 - 1, target);
            } else if (target > arr[mid2]) {
                return ternarySearch(arr, mid2 + 1, right, target);
            } else {
                return ternarySearch(arr, mid1 + 1, mid2 - 1, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 10, 20, 40, 60, 80 };
        int target = 40;
        int result = ternarySearch(arr, 0, arr.length - 1, target);
        System.out.println(result == -1 ? "Not Found" : "Found at index " + result);
    }
}
