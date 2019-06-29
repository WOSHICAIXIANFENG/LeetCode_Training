package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://zxi.mytechroad.com/blog/stack/leetcode-901-online-stock-span/
public class OnlineStockPlan_901 {

	public static void main(String[] args) {
		StockSpanner obj = new StockSpanner();
		System.out.println("Cai Test = " + obj.next(100));
		System.out.println("Cai Test = " + obj.next(80));
		System.out.println("Cai Test = " + obj.next(60));
		System.out.println("Cai Test = " + obj.next(70));
		System.out.println("Cai Test = " + obj.next(60));
		System.out.println("Cai Test = " + obj.next(75));
		System.out.println("Cai Test = " + obj.next(85));
	}
}
// There will be at most 10000 calls to StockSpanner.next per test case.
// So, Approach 1: Brute Force will Time Out --- 
// TC: next O(n).  SC: O(n)

// 91 ms, faster than 85.73%
// Approach 2 : DP
// idea:  dp[i] = span of prices[i].  
// j = i - 1. while j >= 0 and prices[i] >= prices[j]: j-=dp[j]
// dp[i] = i - j
// TC: 约~~O(1) amortized
// SC: 2 * O(n)

class StockSpanner {
	List<Integer> dp;// save span of prices
	List<Integer> prices; // save prices history
	
    public StockSpanner() {
    	this.prices = new ArrayList<>();
        this.dp = new ArrayList<>();
    }
    
    public int next(int price) {
    	if (prices.isEmpty() || price < prices.get(prices.size() - 1)) {
    		dp.add(1);
    	} else {
    		int j = prices.size() - 1;
    		while (j >= 0 && price > prices.get(j)) {
    			j -= dp.get(j);
    		}
    		dp.add(prices.size() - j);
    	}
    	prices.add(price);
        return dp.get(dp.size() - 1);
    }
}