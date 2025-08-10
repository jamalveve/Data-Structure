package com.ds.SearchingAlgorithms.LeetcodeExcercise;

public class FindKthMissingElement {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int current = 1;
        int i = 0;

        while (missingCount < k) {

            if (i < arr.length && arr[i] == current) {
                i++;
            } else {

                missingCount++;
                if (missingCount == k) {
                    return current;
                }
            }
            current++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 7, 11 };
        int k = 5;
        FindKthMissingElement s1 = new FindKthMissingElement();
        System.out.println(s1.findKthPositive(arr, k));
    }
}
