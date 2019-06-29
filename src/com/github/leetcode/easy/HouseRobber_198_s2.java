package com.github.leetcode.easy;


public class HouseRobber_198_s2 {

	public static void main(String[] args) {
		HouseRobber_198_s2 obj = new HouseRobber_198_s2();
		int[] a1 = {1,2,3,1};
		int[] a2 = {2,7,9,3,1};
		int[] a3 = {2,1,1,2};
		System.out.println("Cai Test rob = " + obj.rob(a1));//4
		System.out.println("Cai Test rob = " + obj.rob(a2));//12
		System.out.println("Cai Test rob = " + obj.rob(a3));//4
	}
	
	// Approach 1: Recursion + Memorization ---- Top --> down
	// TC: O(n)
	// SC: O(n)
	public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        final int n = nums.length;
        int[] m = new int[n];
        return rob(n - 1, m, nums);
	}
	
	// Top ---> down --- rob[i] = max(rob(i - 2) + cur, rob(i - 1))
	public int rob(int index, int[] m, int[] nums) {
		if (index < 0) return 0;
		if (m[index] > 0) return m[index];//!!!
		return m[index] = Math.max(rob(index - 1, m, nums), rob(index - 2, m, nums) + nums[index]);
	}
	
	// Approach 2: DP --- Bottom UP
	// TC: O(n)
	// SC: O(n)
	public int rob3(int[] nums) {
		 if (nums == null || nums.length == 0) return 0;
	     final int n = nums.length;
	     int[] dp = new int[n];
	     for (int i = 0; i < n; i++) {
	    	 dp[i] = Math.max((i > 0 ? dp[i - 1] : 0), (i > 1 ? dp[i - 2] : 0) + nums[i]);//!!! () !!!
	     }
	     return dp[n - 1];
	}
	
	// Approach 3: DP --- Bottom UP
	// TC: O(n)
	// SC: O(1) --- without dp array
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
	    final int n = nums.length;
	    int dp1 = 0;
	    int dp2 = 0;
	    for (int i = 0; i < n; i++) {
	    	int dp = Math.max(dp1, dp2 + nums[i]);
	    	dp2 = dp1;
	    	dp1 = dp;
	    }
	    return dp1;
	}
}
