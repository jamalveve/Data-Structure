package com.ds.SearchingAlgorithms;

public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target)
                    return low;
                return -1;
            }

            int pos = low + (((target - arr[low]) * (high - low)) / (arr[high] - arr[low]));

            if (arr[pos] == target)
                return pos;
            if (arr[pos] < target)
                low = pos + 1;
            else
                high = pos - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };
        int target = 60;
        int result = interpolationSearch(arr, target);
        System.out.println(result == -1 ? "Not Found" : "Found at index " + result);
    }
}
