package com.ds.Sorting_Algos;

import java.util.Arrays;

public class MergeSortWithTWoSortedArray {

	public static int[] mergeSort(int[] array1, int[] array2) {
		int[] combinedArray = new int[array1.length + array2.length];

		int index = 0;
		int i = 0;// iterate through array1
		int j = 0;// iterate through array2

		while (i < array1.length && j < array2.length) {
			if (array1[i] < array2[j]) {
				combinedArray[index] = array1[i];
				index++;
				i++;
			} else {
				combinedArray[index] = array2[j];
				index++;
				j++;
			}

		}

		while (i < array1.length) {
			combinedArray[index] = array1[i];
			index++;
			i++;
		}
		while (i < array2.length) {
			combinedArray[index] = array2[j];
			index++;
			j++;
		}

		return combinedArray;

	}

	public static void main(String[] args) {
		int[] array1 = {1,3,7,8};
        int[] array2 = {2,4,5,6};

		System.out.println(Arrays.toString(mergeSort(array1,array2)));
	}
}

//public static int[] merge(int[] array1, int[] array2) {
//    int[] combined = new int[array1.length + array2.length];
//    int index = 0;
//    int i = 0;
//    int j = 0;
//    while (i < array1.length && j < array2.length) {
//        if (array1[i] < array2[j]) {
//            combined[index] = array1[i];
//            index++;
//            i++;
//        } else {
//            combined[index] = array2[j];
//            index++;
//            j++;
//        }
//    }
//    while (i < array1.length) {
//        combined[index] = array1[i];
//        index++;
//        i++;
//    }
//    while (j < array2.length) {
//        combined[index] = array2[j];
//        index++;
//        j++;
//    }
//    return combined;
//}

