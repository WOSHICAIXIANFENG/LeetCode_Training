package com.github.leetcode.medium;

import java.util.Arrays;

public class HouseRobberII_213 {

	public static void main(String[] args) {
		HouseRobberII_213 obj = new HouseRobberII_213();
		int[] a1 = {2, 3, 2};
		int[] a2 = {1, 2, 3, 1};
		System.out.println("Cai Test = " + obj.rob(a1));
		System.out.println("Cai Test = " + obj.rob(a2));
		
		// special cases:
		int[] a3 = {2};
		int[] a4 = {2, 3};
		System.out.println("Cai Test = " + obj.rob(a3));
		System.out.println("Cai Test = " + obj.rob(a4));
	}
	
	// Approach 3: DP without memory Array
	// TC: O(N)
	// SC: O(1)
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}
	
	// dp[i]: max money after visiting house[i]
	public int rob(int[] nums, int left, int right) {
		int n = right - left + 1;
		int dp1 = nums[left];
		int dp2 = Math.max(nums[left], nums[left + 1]);
		for (int i = 2; i < n; i++) {
			// dp: max money after visiting i, dp1 means rob house[i], dp2 means ont rob house[i]
			int dp = Math.max(dp1 + nums[left + i], dp2);
			dp1 = dp2;
			dp2 = dp;
		}
		return dp2;//!!!
	}

	
	// Approach 2: DP with Array
	// TC: O(N)
	// SC: O(N)
//	public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0];
//        if (nums.length == 2) return Math.max(nums[0], nums[1]);
//        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
//    }
//	
//	// dp[i]: max money after visiting house[i]
//	public int rob(int[] nums, int left, int right) {
//		int n = right - left + 1;
//		int[] dp = new int[n];
//		dp[0] = nums[left];
//		dp[1] = Math.max(nums[left], nums[left + 1]);
//		for (int i = 2 ; i < n; i++) {
//			dp[i] = Math.max(dp[i - 2] + nums[left + i], dp[i - 1]);
//		}
//		return dp[n - 1];
//	}
}
