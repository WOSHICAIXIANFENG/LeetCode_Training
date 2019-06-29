package com.github.leetcode.easy_top100;

public class FibonacciNumber509_top38 {

	public static void main(String[] args) {
		FibonacciNumber509_top38 obj = new FibonacciNumber509_top38();
		System.out.println("Cai Test fib = " + obj.fib(2));// 1
		System.out.println("Cai Test fib = " + obj.fib(3));// 2
		System.out.println("Cai Test fib = " + obj.fib(4));// 3
		System.out.println("Cai Test fib = " + obj.fib(5));// 5
		
		// Corner cases
		System.out.println("Cai Test fib = " + obj.fib(0));// 0
		System.out.println("Cai Test fib = " + obj.fib(1));// 1
	}
	
	// 0 ≤ N ≤ 30.
	
	// 9 ms, faster than 27.03% --- Why??? --- because it has lots of duplicate computation.
	// How to improve? ---- Use iterative way or  Use memory array to cache resut. fib(30)--> fib(29) + fib(28)
	// Approach 1: Recursion
	// TC: O(2^n) --- Exponential Level!!!
	public int fib2(int N) {
		if (N == 0) return 0;
		if (N == 1) return 1;
		return fib(N - 1) + fib(N - 2);
	}
	
	// 0 ms, faster than 100.00%
	// Recursion with memorization ----- DP 
	// Appproach 2: DP
	// TC: O(n)
	// SC: O(n)
	public int fib3(int N) {
		//!!! corner cases !!! Don't forget!!!
		if (N == 0) return 0;
		if (N == 1) return 1;
		
		// define dp array
		int[] dp = new int[N + 1];
		// initial dp array
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[N];
	}
	
	// Approach 3: DP without extra space consume
	// TC: O(n)
	// SC: O(1)
	public int fib(int N) {
		// corner case!!!
		if (N == 0) return 0;
		//if (N == 1) return 1;
		
		// define dp variables.
		// initial dp variables.
		int dp2 = 0; // i-2
		int dp1 = 1; // i-1
		for (int i = 2; i <= N; i++) {
			int dp = dp1 + dp2;
			dp2 = dp1;
			dp1 = dp;
		}
		return dp1;
	}
}
