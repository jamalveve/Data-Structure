package com.ds.Dynamic_Programming;

import java.util.Arrays;

public class FibonaciSeriesNaive {

	// 1. Naive Recursive Approach (exponential time)
	public static int fibNaive(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibNaive(n - 1) + fibNaive(n - 2);
	}

	public static void main(String[] args) {
		int n = 10;

		System.out.println("Fibonacci using Naive Recursion:");
		for (int i = 0; i <= n; i++) {
			System.out.print(fibNaive(i) + " ");
		}
		System.out.println();

	}

}
