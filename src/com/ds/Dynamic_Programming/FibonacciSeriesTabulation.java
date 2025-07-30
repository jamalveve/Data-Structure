package com.ds.Dynamic_Programming;

public class FibonacciSeriesTabulation {

	// 3. Tabulation - Bottom-Up DP
	static int counter=0;

	
	public static int fibTab(int n) {
		
		// Handle base cases
		if (n == 0 || n==1)
			return n;
		

		int[] fibList = new int[n + 1];
		fibList[0] = 0;
		fibList[1] = 1;

		for (int i = 2; i <= n; i++) {
			counter ++;

			fibList[i] = fibList[i - 1] + fibList[i - 2];
		}

		return fibList[n];
	}

	public static void main(String[] args) {

		int n = 40;

		System.out.println("Fibonacci using Tabulation:");
		
		System.out.println(fibTab(n));
		System.out.println(counter);

	}
}
