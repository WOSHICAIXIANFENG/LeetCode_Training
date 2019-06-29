package com.github.leetcode.easy_top100;

public class BestTimeBuyAndSellStock121_top6 {

	public static void main(String[] args) {
		BestTimeBuyAndSellStock121_top6 obj = new BestTimeBuyAndSellStock121_top6();
		int[] a1 = {7,1,5,3,6,4};
		int[] a2 = {7,6,4,3,1};
		System.out.println("Cai Test maxProfit = " + obj.maxProfit(a1));// 5
		System.out.println("Cai Test maxProfit = " + obj.maxProfit(a2));// 0
		
		// special case!!!
		System.out.println(" Cai Test max Int = " + Integer.MAX_VALUE + " < 4294967295 ");
		int[] a3 = {1,Integer.MIN_VALUE,4,Integer.MAX_VALUE,1};
		System.out.println("Cai Test maxProfit = " + obj.maxProfit(a3));// Wrong!!! should return 4294967295
	}

	// Approach 2: DP without extra space
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		final int n = prices.length;
		// define dp variable
		int dp = 0;// even dp variable could be omit
		int maxProfit = 0;
		int min = prices[0];
		for (int i = 0; i < n; i++) {
			dp = Math.max(0, prices[i] - min);
			min = Math.min(min, prices[i]);
			maxProfit = Math.max(maxProfit, dp);
		}
		return maxProfit;
	}
	
	// Approach 1: DP
	// dp[i]: maximum profit after selling stock on i-th day
	// TC: O(N)
	// SC: O(N)
	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		final int n = prices.length;
		// define dp array
		int[] dp = new int[n];
		// initial dp array
		dp[0] = 0;// you can't sell stock on 0th day
		int maxProfit = 0;
		int min = prices[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(0, prices[i] - min);
			min = Math.min(min, prices[i]);
			maxProfit = Math.max(maxProfit, dp[i]);
		}
		return maxProfit;
	}
}
