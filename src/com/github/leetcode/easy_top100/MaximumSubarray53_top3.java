package com.github.leetcode.easy_top100;

public class MaximumSubarray53_top3 {
	public static void main(String[] args) {
		MaximumSubarray53_top3 obj = new MaximumSubarray53_top3();
		int[] a1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 }; // 6 -- [4,-1,2,1]
		int[] a2 = { -2, 1, -3, 4, -1, 2, 1, -5, 6 }; // 7 -- [4,-1,2,1,-5,6]
		int[] a3 = { -2, -1, -3, -4, -1, 2, 1 }; // 3
		int[] a4 = { -2, -1, -3, -4, -1, -2, -1 }; // -1
		System.out.println("Cai Test " + obj.maxSubArray(a1));
		System.out.println("Cai Test " + obj.maxSubArray(a2));
		System.out.println("Cai Test " + obj.maxSubArray(a3));
		System.out.println("Cai Test " + obj.maxSubArray(a4));
	}
	
	// Approach 2: DP without extra space consume
	// TC: O(n)
	// SC: O(1)
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		final int n = nums.length;
		
		// define dp0 variable
		int dp0 = nums[0];
		int ans = nums[0];
		for (int i = 1; i < n; i++) {
			dp0 = Math.max(nums[i], dp0 + nums[i]);
			ans = Math.max(ans, dp0);
		}
		return ans;
	}
	
	// Approach 1: DP
	// dp[i]: the largest sum got after handling from 0 to i index
	// dp[i]: take cur ith ele or dp[i-1] + nums[i]
	// TC: O(n)
	// SC: O(n)
	public int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		
		final int n = nums.length;
		// define dp array
		// dp[i]: the largest sum of contiguous subarray from 0 to i index
		int[] dp = new int[n];
		// set start point
		dp[0] = nums[0];
		
		int maxSum = nums[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
			maxSum = Math.max(maxSum, dp[i]);
		}
		return maxSum;
	}
}
