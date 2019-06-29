package com.github.leetcode.easy;

public class MinCostClimbingStairs_746 {

	public static void main(String[] args) {
		MinCostClimbingStairs_746 obj = new MinCostClimbingStairs_746();
		int[] c1 = {10, 15, 20};
		int[] c2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println("Cai Test = " + obj.minCostClimbingStairs(c1));
		System.out.println("Cai Test = " + obj.minCostClimbingStairs(c2));
	}
	
	// Given input 'cost' must be a list with length in range [2, 1000]
	

	// DP -- SC O(1)
	public int minCostClimbingStairs(int[] cost) {
		// dp[i]: min cost to climb to n-th step
		int dp1 = 0;
		int dp2 = 0;
		for (int i = 2; i <= cost.length; i++) {
			int dp = Math.min(dp1 + cost[i - 1], dp2 + cost[i - 2]);
			dp2 = dp1;
			dp1 = dp;
		}
		return dp1;//!!!
	}
	
	// Approach 2: DP
	// TC: O(n)
	// SC: O(n)
	public int minCostClimbingStairs3(int[] cost) {
		// dp[i]: min cost to climb to n-th step
		int[] dp = new int[cost.length + 1];
		for (int i = 2; i <= cost.length; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		}
		return dp[cost.length];
	}
	
	// 1 ms, faster than 100.00%
	// Approach 1: Recursion + Memorization
	// TC: O(n) ---- without Memorization it will becomes O(n^n)
	// SC: O(n)
	// dp(n) = min cost to climb to n-th step. start from 0 or 1, it doesn't
	public int minCostClimbingStairs2(int[] cost) {
        int[] m = new int[cost.length + 1];
        return dp(cost, m, cost.length);
    }
	
	// min cost to climb to i-th step
	public int dp(int[] cost, int[] m, int i) {
		if (i <= 1) return 0;// you can either start from the step with index 0 or 1, so no cost!
		if (m[i] > 0) return m[i];
		return m[i] = Math.min(dp(cost, m, i - 1) + cost[i - 1], dp(cost, m, i - 2) + cost[i - 2]);
	}
}
