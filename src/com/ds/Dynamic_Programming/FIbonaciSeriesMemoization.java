package com.ds.Dynamic_Programming;

import java.util.Arrays;

public class FIbonaciSeriesMemoization {

	// 2. Memoization - Top-Down DP

	static int counter=0;
	static Integer[] memo=new Integer[100];
	public static int fibMemo(int n) {
		counter ++;
		if (n == 0 || n==1)
			return n;
		

		if (memo[n]!= null)
			return memo[n]; // Return cached result if available

		memo[n] = fibMemo(n - 1) + fibMemo(n - 2);
		return memo[n];
	}

	public static void main(String[] args) {
		int n = 7;

		System.out.println("Fibonacci using Memoization:");
		 
		System.out.println(fibMemo(n));
		System.out.println(counter);
	}
}
