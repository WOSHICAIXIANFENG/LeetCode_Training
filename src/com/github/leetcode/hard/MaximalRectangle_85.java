package com.github.leetcode.hard;

import java.util.Arrays;

public class MaximalRectangle_85 {

	public static void main(String[] args) {
		MaximalRectangle_85 obj = new MaximalRectangle_85();
		char[][] c1 = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'},
		};
		System.out.println("Cai test = " + obj.maximalRectangle(c1)); // 6
	}

	// 11 ms, faster than 62.77%
	
	// Approach 1: DP
	// dp[i][j]: max length of all 1 sequence ends with col j, i-th row.
	// Transition:
	// if matrix[i][j] == '0' -->  dp[i][j] = 0;  
	// else ---> dp[i][j-1] + 1.
	
	// TC: O(m * m * n)
	// SC: O(m * n)
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		final int m = matrix.length;
		final int n = matrix[0].length;
		// define dp array
		// dp[i][j]: max len of all 1s ends with col j at row i.
		int[][] dp = new int[m][n];
		// initial dp array --- set value for first col
		for (int i = 0; i < m; i++) {
			dp[i][0] = matrix[i][0] - '0';
		}
		
		for (int i = 0; i < m; i++)
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = dp[i][j-1] + 1;
				}
			}
		
//		for (int[] tmp : dp) {
//			System.out.println("Cai Test tmp = " + Arrays.toString(tmp));
//		}
		
		int ans = 0;
		
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				// try all potential top-left vertex 
				int len = Integer.MAX_VALUE;
				for (int k = i; k < m; k++) {
					len = Math.min(len, dp[k][j]);
					if (len == 0) break;
					// area = length * height
					ans = Math.max(ans, len * (k - i + 1));
				}
			}
				
        return ans;
    }
}
