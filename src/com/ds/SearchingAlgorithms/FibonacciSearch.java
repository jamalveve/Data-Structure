package com.ds.SearchingAlgorithms;

public class FibonacciSearch {
    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length;

        int fibMMm2 = 0; // (m-2)'th Fibonacci
        int fibMMm1 = 1; // (m-1)'th Fibonacci
        int fibM = fibMMm2 + fibMMm1; // m'th Fibonacci

        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibMMm2, n - 1);

            if (arr[i] < target) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            } else {
                return i;
            }
        }

        if (fibMMm1 == 1 && offset + 1 < n && arr[offset + 1] == target) {
            return offset + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100 };
        int target = 85;
        int result = fibonacciSearch(arr, target);
        System.out.println(result == -1 ? "Not Found" : "Found at index " + result);
    }
}