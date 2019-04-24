package com.github.leetcode.hard;

import java.util.Arrays;

public class DungeonGame_174_better {

	public static void main(String[] args) {
		int[][] a1 = {
				{-2,-3,3},
				{-5,-10,1},
				{10,30,-5}
				};
		System.out.println("Cai Test = " + calculateMinimumHP(a1));
	}
	
	// try to use one one-dimensional array to reduce memory usage.
	// 2 ms, faster than 100.00% 
	// Time Complexity: O(m * n)
	// Space Complexity: O(m)
	// 对比前一种方法，两个方法计算的每一个值都是相同的。！！！可见一维数组操作明显 快于 二维，
	public static int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length;
		int col = dungeon[0].length;
		
		int[] dp = new int[row + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[row] = 1; // use this value to calculate the last column
		
		// from bottom to up
		for (int i = col - 1; i >= 0; i--) {
			// when user calculate the last second column, don't forget to update the dp[row]
			if (i != col - 1) {
				dp[row] = Integer.MAX_VALUE;
			}
			// from rightest column to leftest
			for (int j = row - 1; j >= 0; j--) {
				int value = Math.min(dp[j + 1], dp[j]) - dungeon[j][i];
				dp[j] = value <= 0 ? 1 : value;
			}
		}
		
		return dp[0];
    }

}
