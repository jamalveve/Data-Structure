package com.ds.SearchingAlgorithms;

import java.util.Scanner;

public class BinarySearch {

    // Binary search method (iterative)
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // To avoid overflow for large indexes
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found at index mid
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in right half
            } else {
                right = mid - 1; // Search in left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sorted array size
        System.out.print("Enter number of elements in sorted array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        // Input sorted array elements
        System.out.println("Enter " + n + " elements in sorted order:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Input target value to search
        System.out.print("Enter element to search: ");
        int target = scanner.nextInt();

        int result = binarySearch(array, target);

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }

        scanner.close();
    }
}
