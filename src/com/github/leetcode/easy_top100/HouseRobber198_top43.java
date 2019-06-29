package com.github.leetcode.easy_top100;

public class HouseRobber198_top43 {

	public static void main(String[] args) {
		HouseRobber198_top43 obj = new HouseRobber198_top43();
		int[] a1 = {1,2,3,1};
		int[] a2 = {2,7,9,3,1};
		int[] a3 = {2,1,1,2};
		System.out.println("Cai Test rob = " + obj.rob(a1));//4
		System.out.println("Cai Test rob = " + obj.rob(a2));//12
		System.out.println("Cai Test rob = " + obj.rob(a3));//4
	}
	
	// DP without Extra Space Consume
	// TC: O(n)
	// SC: O(1)
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		final int m = nums.length;
		// define dp variable
		int dp1 = 0;
		int dp2 = 0;
		for (int i = 0; i < m; i++) {
			int dp = Math.max(dp1, dp2 + nums[i]);
			dp2 = dp1;
			dp1 = dp;
		}
		return dp1;
	}
	
	// Approach 2: DP
	// bottom to up process
	// TC: O(n)
	// SC: O(n)
	public int rob3(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		final int m = nums.length;
		int[] dp = new int[m];
		for (int i = 0; i < m; i++) {
			// !!! Don't forget ()
			dp[i] = Math.max( (i > 0 ? dp[i - 1] : 0), (i > 1 ? dp[i - 2] : 0) + nums[i]);
		}
		return dp[m - 1];
	}
	
//	public int rob(int[] nums) {
//		if (nums == null || nums.length == 0) return 0;
//		final int m = nums.length;
//		// define dp array
//		int[] dp = new int[m + 1];
//		// initial dp array to 0
//		// set start point
//		dp[0] = 0;
//		dp[1] = nums[0];
//		for (int i = 2; i <= m; i++) {
//			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
//		}
//		return dp[m];
//	}

	// Approach 1: Recursion with Memorization
	// top to down process
	// TC: O(n)
	// SC: O(n)
	public int rob2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		// define memory array
		final int n = nums.length;
		int[] memo = new int[n];
		// memo[i]: max amount after rob or unrob i-th house
		return rob(nums, n - 1, memo); 
	}
	
	public int rob(int[] nums, int i, int[] memo) {
		if (i < 0) {
			return 0;
		}
		
		if (memo[i] > 0) {
			return memo[i];
		}
		int val = Math.max(rob(nums, i - 1, memo), rob(nums, i - 2, memo) + nums[i]);
		memo[i] = val;
		return val;
	}
}
