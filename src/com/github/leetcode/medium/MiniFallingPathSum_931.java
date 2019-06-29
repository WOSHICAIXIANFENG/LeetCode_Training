package com.github.leetcode.medium;

import java.util.Arrays;

public class MiniFallingPathSum_931 {

	public static void main(String[] args) {
		MiniFallingPathSum_931 obj = new MiniFallingPathSum_931();
		int[][] a1 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		System.out.println("Cai Test = " + obj.minFallingPathSum(a1));// 12
	}

	/**
	 *  1 <= A.length == A[0].length <= 100
	 *  ----> so the TC O(2^n) will out of time limited
	 *  
	 *  -100 <= A[i][j] <= 100
	 *  
	 *  
	 */
	
	// 3 ms, faster than 91.55%
	
	// Approach 1: DP
	// TC: O(m * n)
	// SC: O(m * n)
	public int minFallingPathSum(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0) {
			return 0;
		}
		
		final int m = A.length;
		final int n = A[0].length;
		// define dp array -- two dimensions
		// dp[i][j]: minFallPathSum from A(0,0) to A(i-1,j-1)
		int[][] dp = new int[m + 1][n + 2];
		// initialize dp array
		// first row to 0
		for (int i = 0; i < n + 2; i++) {
			dp[0][i] = 0;
		}
		// extra-first and extra-last cols to Max
		for (int i = 1; i < m + 1; i++) {
			dp[i][0] = Integer.MAX_VALUE;
			dp[i][n + 1] = Integer.MAX_VALUE;
		}
		
		// calculation
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				dp[i][j] = A[i-1][j-1] 
						+ Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i-1][j+1]);
			}
		
//		for (int[] t: dp) {
//			System.out.println("Cai Test dp array = " + Arrays.toString(t));
//		}
		int ans = dp[m][1];
		for (int i = 2; i <= n; i++) {
			ans = Math.min(ans, dp[m][i]);
		}
        return ans;
    }
}
