package com.github.leetcode.medium;

public class UniquePaths_62 {

	public static void main(String[] args) {
		UniquePaths_62 obj = new UniquePaths_62();
		System.out.println("Cai Test = " + obj.uniquePaths(3, 2));//3
		
		System.out.println("Cai Test = " + obj.uniquePaths(7, 3));//28
	}
	
	/**
	 * m and n will be at most 100.
	 * ----> You can't use 2^n alg, it will time limited
	 * ----> 统计类问题想DP 来解，DP想子问题，DP 想转义方程，DP从后向前 递归推导出! 
	 */
	
	// 0 ms, faster than 100.00%
	
	// Approach 2: DP --- 2 dimensions
	// TC: O(m * n)
	// SC: O(m * n)
	public int uniquePaths(int m, int n) {
		// define dp array
		// dp[i][j]: # of unique paths from (1,1) to (i,j)
		int[][] dp = new int[m+1][n+1];
		// initial dp array
		dp[1][1] = 1;
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}		
		
		return dp[m][n];
	}
	
	// 0 ms, faster than 100.00%
	// Approach 1: Recursion with memorization
	// TC: O(m * n) --- without memorization, it will become to O(2^(m*n))
	// SC: O(m * n)
	public int uniquePaths2(int m, int n) {
        // define memory array
		// m[i][j]: # of unique paths from (1, 1) to (i, j);
		int[][] memo = new int[m + 1][n + 1];
		// initial memory array --- java language did for you
		memo[1][1] = 1;// start point
		return findPaths(m, n, memo);
    }

	// Top down Process
	public int findPaths(int m, int n, int[][] memo) {
		if (m <= 0 || n <= 0) return 0;
		if (memo[m][n] > 0) return memo[m][n];
		// m[row][col] = m[row-1][col] + m[row][col-1]
		memo[m][n] = findPaths(m - 1, n, memo) + findPaths(m, n - 1, memo);
		return memo[m][n];
	}
}
