package com.github.leetcode.medium;

import java.util.Arrays;

public class MinimumPathSum_64 {

	public static void main(String[] args) {
		MinimumPathSum_64 obj = new MinimumPathSum_64();
		int[][] g1 = {
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		};
		System.out.println("Cai Test = " + obj.minPathSum(g1));// 7
	}
	
	// 2 ms, faster than 92.32%
	// Approach 2: DP
    // TC: O(m * n)
    // SC: O(m * n)
    public int minPathSum(int[][] grid) {
        final int m = grid.length;
		final int n = grid[0].length;
        // define dp array
        // dp[i][j] --- minPathSum from (1,1) to (i,j)
        int[][] dp = new int[m + 1][n + 1];
        // initial dp array
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        dp[1][1] = grid[0][0];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                } else {
                    dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        
        return dp[m][n];
    }

	// 1 ms, faster than 99.72%
	
	// Approach 1: Recursion with Memorization
	// TC: O(m * n)
	// SC: O(m * n)
	public int minPathSum2(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		// define memory array
		int[][] memo = new int[m + 1][n + 1];
		// memo[i][j]: minPathSum from(1,1) to (i,j)
        return minPathSum(m, n, memo, grid);
    }
	
	// top to down process
	public int minPathSum(int row, int col, int[][] memo, int[][] grid) {
		if (row <= 0 || col <= 0) return Integer.MAX_VALUE;
		if (row == 1 && col == 1) return grid[0][0];
		if (memo[row][col] > 0) return memo[row][col];
		
		int preRow = minPathSum(row - 1, col, memo, grid);
		int preCol = minPathSum(row, col - 1, memo, grid);
		memo[row][col] = grid[row-1][col-1] + Math.min(preRow, preCol);

		return memo[row][col];
	}
}
