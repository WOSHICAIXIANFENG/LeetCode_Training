package com.github.leetcode.easy;

public class BestTimeBuySellStockII_122 {

	public static void main(String[] args) {
		int[] a1 = {7,1,5,3,6,4};
		int[] a2 = {7,6,4,3,1};
		
		System.out.println("Cai Test maxProfit = " + maxProfit(a1));
		System.out.println("Cai Test maxProfit = " + maxProfit(a2));
	}
	
	// Simple One Pass ---- not need to looking for every peak following a valley, just keeping add profit
	// more add coculations 
	// keep on adding the profit obtained from every consecutive transaction --- equals we use vally and peak
	// O(n), single pass.  O(1). Constant space needed
	// 1 ms, faster than 99.72% 
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 1) {
			return 0;
		}
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i ++) {
			if (prices[i] > prices[i - 1]) {
				maxProfit += prices[i] - prices[i - 1];
			}
		}
		return maxProfit;
	}
	
//	// Peak Vally Approach
//	// 1 ms, faster than 99.72%
//	// Time complexity: O(n). Single pass
//	// Space complexity: O(1). Constant space required. 
//	public static int maxProfit(int[] prices) {
//		if (prices == null || prices.length < 1) {
//			return 0;
//		}
//		
//		int valley = prices[0];
//		int peak = prices[0];
//		int maxProfit = 0;
//		
//		int i = 0;
//		while (i < prices.length - 1) {
//			// find valley
//			while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
//				i ++;
//			}
//			valley = prices[i];
//			
//			// find peak
//			while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
//				i ++;
//			}
//			peak = prices[i];
//			maxProfit += peak - valley;
//		}
//		return maxProfit;
//    }
	

//	// Brute force --- Time Limit Exceeded
//	// Time complexity: O(n^n) Recursive function is called n^n times
//	// Space complexity: O(n) Depth of recursion is n.
//	public static int maxProfit(int[] prices) {
//		if (prices == null || prices.length < 1) {
//			return 0;
//		}
//		return calculate(prices, 0);
//    }
//	
//	public static int calculate(int prices[], int s) {
//		if (s >= prices.length) {
//			return 0;
//		}
//		int max = 0;
//		for (int start = s; start < prices.length; start ++) {
//			int maxProfitOneRound = 0;
//			for (int i = start + 1; i < prices.length; i ++) {
//				if (prices[i] > prices[start]) {
//					int profit = calculate(prices, i + 1) + prices[i] - prices[start];
//					if (profit > maxProfitOneRound) {
//						maxProfitOneRound = profit;
//					}
//				}
//			}
//			if (maxProfitOneRound > max) {
//				max = maxProfitOneRound;
//			}
//		}
//		
//		return max;
//	}
}
