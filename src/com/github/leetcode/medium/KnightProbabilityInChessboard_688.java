package com.github.leetcode.medium;

public class KnightProbabilityInChessboard_688 {

	public static void main(String[] args) {
		KnightProbabilityInChessboard_688 obj = new KnightProbabilityInChessboard_688();
		System.out.println("Cai Test = " + obj.knightProbability(3, 2, 0, 0)); // 0.0625
	}

	/**
	 * N will be between 1 and 25.
	 * K will be between 0 and 100.
	 * -----> 
	 */
	
	// 求概率的问题 转化为 计数类的问题。
	
	// 5 ms, faster than 74.71%
	
	// Approach 1: DP --- count the ways to reach (x,y) after k moves from start.
	// dp[k][i][j] = sum(dp[k-1][x][y]) which (x,y) could move to (i,j) by 1 step
	// ans = sum(dp[k][i][j]) / 8^k
	
	// TC: O(k * N^2)
	// SC: O(k * N^2) ---> O(N^2)
	public double knightProbability(int N, int K, int r, int c) {
        // define dp0 array
		double[][] dp0 = new double[N][N];
		// initial dp0 to 0
		// set start point
		dp0[r][c] = 1.0d;// because we start from (r,c) cell, move 0 step,
		// so, there is only 1 way to reach(r,c). All other cells value is 0
		
		int[][] dirs = {
			{1, 2}, {-1, -2}, {1, -2}, {-1, 2},
            {2, 1}, {-2, -1}, {2, -1}, {-2, 1}
		};
		
		for (int k = 1; k <= K; k++) {
			double[][] dp1 = new double[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// for each cell --- in 8 directions
					for (int d = 0; d < 8; d++) {
						int tx = i + dirs[d][0];
						int ty = j + dirs[d][1];
						if (tx < 0 || tx >= N || ty < 0 || ty >= N) {
							continue;// it after this step, the des cell is out of boundary, ignore 
						}
						dp1[i][j] += dp0[tx][ty];//!!!
					}
				}
			}
			dp0 = dp1;	
		}
		
		// compute the probability: sums up all cell's probability after k steps
		double total = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				total += dp0[i][j];
			}
		return total / Math.pow(8, K);
    }
}
