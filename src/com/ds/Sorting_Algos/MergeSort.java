package com.ds.Sorting_Algos;

import java.util.Arrays;

public class MergeSort {

	public static int[] mergeSort(int[] array) {
		if(array.length==1) return array;
		
		int midIndex=array.length/2;
		
		int[] leftArray=Arrays.copyOfRange(array, 0, midIndex);
		int[] rightArray=Arrays.copyOfRange(array, midIndex,array.length);
		
		int[] sortedLeft = mergeSort(leftArray);//recursvie call
		int[] sortedRight = mergeSort(rightArray);//recursvie call
		
		return merge(sortedLeft,sortedRight);
		

	}
	public static int[] merge(int[] array1, int[] array2) {
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
			combinedArray[index++] = array1[i++];
			
		}
		while (j < array2.length) {
			combinedArray[index++] = array2[j++];
			
		}

		return combinedArray;

	}

	public static void main(String[] args) {
		int[] myArray = { 3,1,4,2};
		int[] sortedArray=mergeSort(myArray);

		System.out.println(Arrays.toString(sortedArray));
	}


}
