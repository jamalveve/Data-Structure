package com.ds.SearchingAlgorithms;

import java.util.Scanner;

public class JumpSearch {

    // Jump Search method
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);  // Optimal jump size

        int prev = 0;

        // Jump in blocks until we find a block where target could be
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1; // Target not found
            }
        }

        // Linear search in identified block
        while (prev < Math.min(step, n)) {
            if (arr[prev] == target) {
                return prev;  // Found target
            }
            prev++;
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements in sorted array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter " + n + " elements in sorted order:");

        // Input sorted array
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Input target value
        System.out.print("Enter element to search: ");
        int target = scanner.nextInt();

        int index = jumpSearch(array, target);

        if (index == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + index);
        }

        scanner.close();
    }
}
