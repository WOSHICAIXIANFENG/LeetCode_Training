package com.github.leetcode.medium;

// LC Stock related Questions: 
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems

public class BestTimeBuySellStckWithCooldown_309 {

	public static void main(String[] args) {
		BestTimeBuySellStckWithCooldown_309 obj = new BestTimeBuySellStckWithCooldown_309();
		int[] p1 = {1, 2, 3, 0, 2};
		System.out.println("Cai Test = " + obj.maxProfit(p1));
	}
	
	/**
	 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-309-best-time-to-buy-and-sell-stock-with-cooldown/
	 * 
	 * sold[i] 表示在第i天卖出股票后能够获得的最大利润。
     * hold[i] 表示在第i天（或之前）买入股票后能够获得的最大利润。即第i天结束后手里持有股票。
     * rest[i] 表示在第i天休息(前一个状态可能还是休息，或者是刚刚卖出)能够获得的最大利润。
     * 
	 * hold[i] = max(hold[i - 1], rest[i-1] - prices[i])
	 * sold[i] = hold[i - 1] + prices[i];
	 * rest[i] = max(rest[i - 1], sold[i - 1])
	 */

	// 1 ms, faster than 90.02% 
	// Approach 1: DP --- finite State machine
	// init: rest[0] = sold[0] = 0, hold[0] = -Infinite
	// TC: O(n)
	// SC: O(n) ---> O(1)
	public int maxProfit(int[] prices) {
		// Use variables to replace state/dp array
		int sold = 0;
		int rest = 0;
		int hold = Integer.MIN_VALUE;//!!! You have to set to -Infinite
		for (int price : prices) {
			int prev_hold = hold;
			hold = Math.max(hold, rest - price);
			rest = Math.max(rest, sold);
			sold = prev_hold + price;
		}
        return Math.max(sold, rest);//the final step, you either sell or rest(did the sell at the second last step)
    }
}
