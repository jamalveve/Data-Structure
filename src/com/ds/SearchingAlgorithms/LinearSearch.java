package com.ds.SearchingAlgorithms;

import java.util.Scanner;

public class LinearSearch {

    // Linear search method
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Return index if target is found
            }
        }
        return -1; // Return -1 if target is not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Input the array elements
        int[] array = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Input the target element to search for
        System.out.print("Enter the element to search: ");
        int target = scanner.nextInt();

        int result = linearSearch(array, target);

        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element is at index " + result);
        }
    }
}

