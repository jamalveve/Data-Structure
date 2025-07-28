package com.ds.Dynamic_Programming;

import java.util.Arrays;

public class FIbonaciSeriesMemoization {

	// 2. Memoization - Top-Down DP

	public static int fibMemo(int n, int[] memo) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		if (memo[n] != -1)
			return memo[n]; // Return cached result if available

		memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
		return memo[n];
	}

	public static void main(String[] args) {
		int n = 10;

		System.out.println("Fibonacci using Memoization:");
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1); // Initialize memo array with -1 meaning 'not calculated yet'
		for (int i = 0; i <= n; i++) {
			System.out.print(fibMemo(i, memo) + " ");
		}
		System.out.println();
	}
}
