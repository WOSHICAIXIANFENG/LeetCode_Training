package com.github.leetcode.easy;

import java.util.Arrays;

public class HouseRobber_198 {

	public static void main(String[] args) {
		HouseRobber_198 obj = new HouseRobber_198();
		int[] a1 = {1,2,3,1};
		int[] a2 = {2,7,9,3,1};
		int[] a3 = {2,1,1,2};
		System.out.println("Cai Test rob = " + obj.rob(a1));
		System.out.println("Cai Test rob = " + obj.rob(a2));
		System.out.println("Cai Test rob = " + obj.rob(a3));
	}
	
	// Approach 2: Recursion + Memorization ---- use Memorization to avoid duplicate calculation
	// rob(n) = Max(rob(n - 2) + money[i], rob(n - 1))
	// TC: O(n).  SC: O(n) 
//	private int[] memory;
//	public int rob(int[] nums) {
//		int len = nums.length;
//		this.memory = new int[len];
//		Arrays.fill(this.memory, -1);
//		return rob(nums, len - 1);
//	}
//	
//	public int rob(int[] nums, int i) {
//		if (i < 0) return 0;
//		
//		// Use memory array to avoid duplicate calculation
//		if (memory[i] >= 0) return memory[i];
//		
//		int maxValue = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
//		memory[i] = maxValue;
//		return maxValue;
//	}
	
	// Approach 1: Recursion
	// TC: O(2^n) --- exponential
	// SC: O(1)
	// This algorithm will process the same i multiple times and it needs improvement. Time complexity: [n^2]

//	public int rob(int[] nums) {
//	    return rob(nums, nums.length - 1);
//	}
//	
//	private int rob(int[] nums, int i) {
//	    if (i < 0) {
//	        return 0;
//	    }
//	    return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
//	}
	
	// 0 ms, faster than 100.00%
	// Approach 3: DP
	// dp[i]: max money after visiting house[i]
	// dp[i] = max(dp[i - 2] + money[i], dp[i - 1])
	// DP solution, Time Complexity: O(n). 
	// SC: O(N)
//	public int rob(int[] nums) {
//		if (nums == null || nums.length == 0) return 0;
//		int[] dp = new int[nums.length];
//		for (int i = 0; i < nums.length; i++) {
//			dp[i] = Math.max((i > 1 ? dp[i - 2] : 0) + nums[i],
//					(i > 0 ? dp[i - 1] : 0));
//		}
//		return dp[dp.length - 1];
//	}
	
	// Approach 4: DP --- without dp array
	// Space Complexity: O(1).
	public int rob(int[] nums) {
		int dp2 = 0;  
		int dp1 = 0; 
		for (int i = 0; i < nums.length; i++) {
			// dp代表访问到(抢或不抢)时的值，dp1代表当前不抢，dp2代表当前抢
			int dp = Math.max(dp2 + nums[i], dp1);
			dp2 = dp1;
			dp1 = dp;
		}
		return dp1;//!!!
    }
}
