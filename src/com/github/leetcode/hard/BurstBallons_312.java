package com.github.leetcode.hard;

import java.util.Arrays;

public class BurstBallons_312 {

	public static void main(String[] args) {
		BurstBallons_312 obj = new BurstBallons_312();
		int[] n1 = {3, 1, 5, 8};
		System.out.println("Cai Test = " + obj.maxCoins(n1));// 167
	}

	/**
	 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
	 * -----> it means you can't use searching alg to do it. You solution's tc must below n^3
	 * -----> recursion could be Time Limit Exceeded. !!!
	 */
	
	// 5 ms, faster than 84.53%
	// Approach 2: DP
	// TC: O(n^3)
	// SC: O(n^2)
	public int maxCoins(int[] nums) {
		final int n = nums.length;
		int[] nums2 = new int[n + 2];
		for (int i = 1; i <= n; i++) {
        	nums2[i] = nums[i - 1];
        }
	    nums2[0] = 1;
	    nums2[n + 1] = 1;
	    
	    // define dp array
	    // dp[i][j]: the max coins after burst ballons from [i to j]
	    int[][] dp = new int[n + 2][n + 2];
	    // loop1: len
	    for (int len = 1; len <= n; len++) {
	    	// loop2: i
	    	for (int i = 1; i <= n+1 - len; i++) {
	    		int j = i + len - 1;//!!!
	    		for (int k = i; k <= j; k++) {
	    			dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + nums2[i-1] * nums2[k] * nums2[j+1] + dp[k+1][j]);
	    		}
	    	}
	    }
	    
	    return dp[1][n];
	}
	
	// Time Limit Exceeded ---- 递归深度太大  ---- 0 ≤ n ≤ 500
	// Approach 1: Recursion with Memorization
	// TC: O(n^3)
	// SC: O(n * n)
	public int maxCoins2(int[] nums) {
        final int n = nums.length;
        int[] nums2 = new int[n + 2];
        for (int i = 1; i <= n; i++) {
        	nums2[i] = nums[i - 1];
        }
        nums2[0] = 1;
        nums2[n + 1] = 1;
        
        // c[i][j]: max coins (nums[i, j])
        int[][] m = new int[n + 2][n + 2];
        return maxCoins(nums2, 1, n, m);
    }
	
	public int maxCoins(int[] nums, int i, int j, int[][] m) {
		if (i > j) return 0;
		if (m[i][j] > 0) return m[i][j];
		if (i == j) return nums[i - 1] * nums[i] * nums[i + 1];
		
		//
		int ans = 0;
		for (int k = i; k <=j; k++) {
			ans = Math.max(ans, maxCoins(nums, i, k - 1, m) 
					+ nums[i-1] * nums[k] * nums[j + 1] + maxCoins(nums, k + 1, j, m));
		}
		m[i][j] = ans;
		return ans;
	}
}
