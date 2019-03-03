package com.github.leetcode.easy;

public class BestTimeBuySellStock_121 {

	public static void main(String[] args) {
		int[] a1 = {7,1,5,3,6,4};
		int[] a2 = {7,6,4,3,1};
		
		int[] a3 = {1,Integer.MIN_VALUE,4,Integer.MAX_VALUE,1};
		System.out.println("Cai Test maxProfit = " + maxProfit(a1));
		System.out.println("Cai Test maxProfit = " + maxProfit(a2));
		System.out.println("Cai Test maxProfit = " + maxProfit(a3));// Wrong!!! should return 4294967295
	}
	
	//1 ms, faster than 99.92% --- O(n)
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 1) {
			return 0;
		}
		int maxProfit = 0;
		int min = prices[0];
		
		for (int price : prices) {
			if (price < min) {
				min = price;
			}
			if (price - min > maxProfit) {
				maxProfit = price - min;
			}
		}
		return maxProfit;	
	}
	
	
//	// 3 ms, faster than 20.64% 
//	public static int maxProfit(int[] prices) {
//		int minSoFar = Integer.MAX_VALUE;
//		int maxProfit = 0;
//		for (int i = 0; i < prices.length; i ++) {
//			minSoFar = Math.min(minSoFar, prices[i]);
//			maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
//		}
//		return maxProfit;
//	}

//	// 190 ms, faster than 16.68%  
//	// O(n^2)
//	public static int maxProfit(int[] prices) {
//		int maxProfit = 0;
//		for (int i = 0; i < prices.length; i ++) {
//			for (int j = i + 1; j < prices.length; j ++) {
//				if (prices[j] - prices[i] > maxProfit) {
//					maxProfit = prices[j] - prices[i];
//				}
//			}
//		}
//        return maxProfit;
//    }
}
