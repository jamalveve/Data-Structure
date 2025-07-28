package com.ds.Dynamic_Programming;

public class FibonacciSeriesTabulation {

	// 3. Tabulation - Bottom-Up DP

	public static int fibTab(int n) {
		// Handle base cases
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	public static void main(String[] args) {

		int n = 10;

		System.out.println("Fibonacci using Tabulation:");
		for (int i = 0; i <= n; i++) {
			System.out.print(fibTab(i) + " ");
		}
		System.out.println();
	}
}
