package com.github.leetcode.medium;

import java.util.Arrays;

public class OutOfBoundaryPaths_576 {

	public static void main(String[] args) {
		OutOfBoundaryPaths_576 obj = new OutOfBoundaryPaths_576();
		System.out.println("Cai Test = " + obj.findPaths(2, 2, 2, 0, 0));// 6
		System.out.println("Cai Test = " + obj.findPaths(1, 3, 3, 0, 1));// 12
	}
	
	/**
	 * Once you move the ball out of boundary, you cannot move it back.
	 * The length and height of the grid is in range [1,50].
	 * N is in range [0,50].
	 * --------> so, the TC at most be O(n^3)
	 */
	
	
	// http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-576-out-of-boundary-paths/
	
	// idea -- # of paths start from (i, j) to out of boundary <==> # of paths from out of boundary to (i, j)
	// DP
	// dp[N][i][j]: # of paths start from outside to (i,j) by moving N steps.
	// dp[*][x][y] = 1, if (x,y) is out of boundary.
	
	// 8 ms, faster than 61.63%
	
	// Approach 2: DP ---- 3 dimensions ---- 你可以将 外围的 loop s 去掉，转化成 2 维!!!
	// TC: O(N * m * n)
	// SC: O(N * m * n)
	public int findPaths(int m, int n, int N, int i, int j) {
		// define dp array
		int[][][] dp = new int[N + 1][m][n];
		int[] dirs = {-1, 0, 1, 0, -1};
		for (int s = 1; s <= N; s++)
			for (int x = 0; x < m; x++)
				for (int y = 0; y < n; y++) {
					// for each cell, calculate from 4 directions
					for (int d = 0; d < 4; d++) {
						int tx = x + dirs[d];
						int ty = y + dirs[d + 1];
						if (tx < 0 || tx >= m || ty < 0 || ty >= n) {
							dp[s][x][y] += 1;
						} else {
							dp[s][x][y] = (dp[s][x][y] + dp[s - 1][tx][ty]) % kMod;
						}
					}
				}
		
		return dp[N][i][j];
	}
	
	// 3 ms, faster than 99.10%
	
	// Approach 1: Recursion with Memorization
	// TC: O(N * m * n)
	// SC: O(N * m * n)
	final int kMod = 1000000007;
	public int findPaths2(int m, int n, int N, int i, int j) {
        // define memory array --- 3 dimensions
		int[][][] dp = new int[N + 1][m][n];
		// initialize dp array
		for (int[][] group: dp) {
			for (int[] row: group) {
				//!!! 因为在计算过程中 可能会产生0的值，所以我们必须必须必须使用一种非0的 初始值!!!
				Arrays.fill(row, -1);// set default value to '-1' or Integer.MAX_VALUE;
			}
		}
        return paths(N, m, n, i, j, dp);
    }

	// top to down process
	public int paths(int s, int m, int n, int x, int y, int[][][] dp) {
		// (x,y) is out of boundary
		if (x < 0 || x >= m || y < 0 || y >= n) return 1;
		if (s == 0) {
			return 0;// can't exit by N steps
		}
		//!!!
		if (dp[s][x][y] >= 0) return dp[s][x][y];
		
		// use long type to avoid result out of Integer range
		long ans = 0;
		ans += paths(s - 1, m, n, x + 1, y, dp);
		ans += paths(s - 1, m, n, x - 1, y, dp);
		ans += paths(s - 1, m, n, x, y + 1, dp);
		ans += paths(s - 1, m, n, x, y - 1, dp);
		dp[s][x][y] = (int) (ans % kMod);
		return dp[s][x][y];
	}
}
