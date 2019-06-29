package com.github.leetcode.easy;

public class BestTimeBuySellStock_121_dp {

	public static void main(String[] args) {
		int[] a1 = {7,1,5,3,6,4};
		int[] a2 = {7,6,4,3,1};
		
		int[] a3 = {1,Integer.MIN_VALUE,4,Integer.MAX_VALUE,1};
		System.out.println("Cai Test maxProfit = " + maxProfit(a1));//5
		System.out.println("Cai Test maxProfit = " + maxProfit(a2));//0
		// You can use long type to solve this problem.
		System.out.println("Cai Test maxProfit = " + maxProfit(a3));// Wrong!!! should return 4294967295
	}
	
	// Approach 2: DP --- without extra space consume
    // TC: O(n)
    // SC: O(1)
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
			return 0;
		}
		int minPrice = prices[0];// the min Price up to i-th ele
		int maxProfit = 0;// the maxPrice up to i-th ele
		for (int price : prices) {
			if (price < minPrice) {
				minPrice = price;
			}
			// Sell at Today VS maxProfit of yesterday
			if (price - minPrice > maxProfit) {
				maxProfit = price - minPrice;
			}
		}
		return maxProfit;
    }
    
	// 2 ms, faster than 19.85%
	//1 ms, faster than 99.92% --- O(n)
	// Approach 1: DP
	// L[i]: lowest price to i-th day
	// P[i]: max profit up to i-th day
	// P[i] = Math.max(P[i - 1], price[i] - L[i]) 
	public static int maxProfit2(int[] prices) {
		if (prices == null || prices.length < 1) {
			return 0;
		}
		int[] minPrice = new int[prices.length];
		int[] maxProfit = new int[prices.length];
		minPrice[0] = prices[0];
		maxProfit[0] = 0;// no profit on the first day
		for (int i = 1; i < prices.length; i++) {
			minPrice[i] = Math.min(minPrice[i - 1], prices[i]);
			maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] - minPrice[i - 1]);
		}
		
		return maxProfit[prices.length - 1];	
	}
}
