package com.github.leetcode.hard;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DungeonGame_174_dp {

	public static void main(String[] args) {
		int[][] a1 = {
				{-2,-3,3},
				{-5,-10,1},
				{10,30,-5}
				};
		System.out.println("Cai Test = " + calculateMinimumHP(a1));
	}
	
	// If at any point his health point drops to 0 or below, he dies immediately.
	// !!!! he dies immediately !!! ---- 这是最关键的!!!
	
	// 用DP的思想逆推过程 ---- 最后 bottom-right cell 最少要有 1的值剩下 
	// 所以，我们需要在最右边多加一列，在最下面多回一行. 并设置 起点 dp[row][col-1] = 1, dp[row-1][col] = 1
	// 每个cell 的计算过程 必须从 它的右一格和下一格 取最小值 代入.
	// dp[i][j] = Math.min(dp[i][j+1], dp[i+1][j]) - grid[i][j]
	
	// Approach 1: DP --- Use two-dimensional dp array to solve it
	// Time Complexity: O(m*n)
	// Space Complexity: O(m*n)
	public static int calculateMinimumHP(int[][] dungeon) {
		final int row = dungeon.length;
		final int col = dungeon[0].length;
		// define dp array 
		// dp[i][j] --- miniHP value needed from (i, j) to the bottom-right cell
		int[][] dp = new int[row + 1][col + 1];
		// initialize dp array
		for (int[] tmp : dp) {
			Arrays.fill(tmp, Integer.MAX_VALUE);
		}
		// set starting poses
		dp[row][col-1] = 1;
		dp[row-1][col] = 1;
		
		// calculation
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				int temp = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
				dp[i][j] = temp > 0 ? temp : 0;//!!! negative means 这一格不需要提供extra HP
				// If at any point his health point drops to 0 or below, he dies immediately. !!! 
				// so, you can't take over the HP value back in the process
			}
		}
		return dp[0][0];
    }
}
