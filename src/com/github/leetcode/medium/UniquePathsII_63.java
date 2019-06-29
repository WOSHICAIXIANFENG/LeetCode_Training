package com.github.leetcode.medium;

public class UniquePathsII_63 {

	public static void main(String[] args) {
		UniquePathsII_63 obj = new UniquePathsII_63();
		int[][] o1 = {
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
		};
		System.out.println("Cai Test = " + obj.uniquePathsWithObstacles(o1));//2
		
		// !!! special case --- start position also could has obstacle
		int[][] o2 = {{1}};
		System.out.println("Cai Test = " + obj.uniquePathsWithObstacles(o2));//0
	}

	/**
	 * m and n will be at most 100.
	 * ---> Your solution TC needs below  O(2^n)
	 * ---> Counting Problems --- could use DP to solve it
	 */
	
	// 0 ms, faster than 100.00%
    // Approach 2: DP --- two dimensions
    // TC: O(m * n)
    // SC: O(m * n)
    public int uniquePathsWithObstacles_dp(int[][] obstacleGrid) {
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        // pruning !!!
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) 
            return 0;
        
        // define dp array
        int[][] dp = new int[m + 1][n + 1];
        // initial dp
        dp[1][1] = 1;// start point
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                } else {
                    if (obstacleGrid[i - 1][j - 1] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        
        return dp[m][n];
    }
    
	// 6 ms, faster than 23.33%
	// Approach 1: Recursion with memorization
	// TC: O(m * n) --- each cell will be access one time
	// SC: O(m * n)
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		final int m = obstacleGrid.length;
		final int n = obstacleGrid[0].length;
		// define memory array
		int[][] memo = new int[m + 1][n + 1];
        return findPaths(m, n, memo, obstacleGrid);
    }
	
	// top to down process
	public int findPaths(int row, int col, int[][] memo, int[][] grid) {
		if (row <= 0 || col <= 0) return 0;
		if (grid[row - 1][col - 1] == 1) return 0;
		
		// start point!!! --- start cell also could has obstacle, so we put this line below obstacle check
		if (row == 1 && col == 1) return 1;
				
		if (memo[row][col] > 0) return memo[row][col];
		memo[row][col] = findPaths(row - 1, col, memo, grid) +
				findPaths(row, col - 1, memo, grid);
		return memo[row][col];
	}
}
