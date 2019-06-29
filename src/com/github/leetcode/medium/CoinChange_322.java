package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange_322 {

	public static void main(String[] args) {
		CoinChange_322 obj = new CoinChange_322();
		int[] c1 = {1, 2, 5};
		System.out.println("Cai Test = " + obj.coinChange(c1, 11));// 3
		int[] c2 = {2};
		System.out.println("Cai Test = " + obj.coinChange(c2, 3));// -1
	}
	
	// 3 ms, faster than 99.19%
	
	// Approach 2: DFS + greedy + pruning
	// Use largest and as many as coins frist to reduce the search space
	// TC: O(amount^n/coin0*coin1*coinN)
	// SC: O(n)
	public int coinChange(int[] coins, int amount) {
		// sort the coins in descending order
		// you need to convert int[] to Integer[] --- !!! --- 相当麻烦
		// Arrays.sort(coins), Collections.reverseOrder());
		Arrays.sort(coins);
		ans = amount + 1; // or Integer.MAX_VALUE
		dfs(coins, coins.length - 1, amount, 0);
		return ans == amount + 1 ? -1 : ans;
	}
	
	int ans = Integer.MAX_VALUE;
	
	public void dfs(int[] coins, int s, int amount, int count) {
		if (amount == 0) {
			ans = Math.min(ans, count);
			return;
		}
		
		//!!! to avoid IndexOutOfArrayException
		if (s < 0) return; 
		
		final int coin = coins[s];
		// !!! count + k < ans to avoid unnecessary calculation!!!
		for (int k = amount / coin; k >= 0 && count + k < ans; k--) {
			dfs(coins, s - 1, amount - k * coin, count + k);
		}
	}
	

	// 7 ms, faster than 96.79% 
	
	// def: dp[i][j]: min coins to make up j amount using first i types of coins.
	// dp[i][j] = min(dp[i][j], dp[i][j-coin_i] + 1) ----> dp[j] = min(dp[j], dp[j-coin_i] + 1)
	// TC: O(n * amount)
	// SC: O(n * amount)
	
	// 7 ms, faster than 96.79% 
	// Approach 1: DP ----- 
	// TC: O(n * amount)
	// SC: O(amount)
	public int coinChange2(int[] coins, int amount) {
        // dp[i]: min coins to make up to amount i
        int[] dp = new int[amount + 1];
        // initial dp[i] to max value or amount + 1
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;// start point!!! you need 0 coin to make up to amount 0
        
        // draw diagram to make yourself feel better
        for (int coin : coins) {
        	for (int i = coin; i <= amount; i++) {
        		if (dp[i - coin] != Integer.MAX_VALUE) {//!!! if dp[i-coin] is Max_value, +1 will become a negative big value
        			dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        		}
        	}
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
