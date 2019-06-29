package com.github.leetcode.easy_top100;

public class ClimbingStairs70_top37 {

	public static void main(String[] args) {
		ClimbingStairs70_top37 obj = new ClimbingStairs70_top37();
		System.out.println("Cai Test climbStairs = " + obj.climbStairs(1));// 1,2,3,5,8,13,21
		System.out.println("Cai Test climbStairs = " + obj.climbStairs(2));// 2
		System.out.println("Cai Test climbStairs = " + obj.climbStairs(3));// 3
		System.out.println("Cai Test climbStairs = " + obj.climbStairs(6));// 13
	}
	
	// 0 ms, faster than 100.00%
	// Approach 2: DP without extra space
	// TC: O(n)
	// SC: O(1)
	public int climbStairs(int n) {
		// !!!corner cases!!!
		if (n == 1) return 1;
		
		// define dp variables
		int dp2 = 1;// i -2
		int dp1 = 2;// i -1 --- n == 2
		for (int i = 3; i <= n; i++) {
			int dp = dp1 + dp2;
			dp2 = dp1;
			dp1 = dp;
		}
		return dp1;
	}

	// Approach 1: DP
	// dp[i]: # of ways to climb to i-th step
	// TC: O(n)
	// SC: O(n)
	public int climbStairs2(int n) {
		// !!! corner cases
		if (n == 1) return 1;
		
		// define dp array
		int[] dp = new int[n + 1];
		// initial dp array
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
