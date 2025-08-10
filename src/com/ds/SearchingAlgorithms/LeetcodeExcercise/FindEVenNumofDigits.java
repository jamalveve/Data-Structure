package com.ds.SearchingAlgorithms.LeetcodeExcercise;

public class FindEVenNumofDigits {

    public int findNumbers(int[] nums) {
        int evenCount = 0;
        for (int num : nums) {
            int digitCount = String.valueOf(num).length();
            if (digitCount % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    public static void main(String[] args) {
        int array[] = { 12, 345, 2, 6, 7896 };
        FindEVenNumofDigits s1 = new FindEVenNumofDigits();
        System.out.println(s1.findNumbers(array));
    }
}
