package com.ds.Sorting_Algos;

import java.util.Arrays;

public class InsertionSort {

	public static void insertionSort(int[] array) {

		for (int i = 1; i < array.length; i++) {

			int temp = array[i];
			int j = i - 1;
			while (j > -1 && temp < array[j]) {
				// j>-1 will not lead to array index of out of bound exception

				// swap happens here
				array[j + 1] = array[j];// moves the previous value to next index j to j+1
				array[j] = temp;// moves the temp current value to previous

				j--;
				;
			}
		}
	}

	public static void main(String[] args) {
		int[] myArray = { 4, 2, 6, 3, 2, 5 };
		insertionSort(myArray);
		System.out.println(Arrays.toString(myArray));
	}
}
