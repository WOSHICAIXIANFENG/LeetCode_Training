package com.github.leetcode.hard;

import java.util.Arrays;

public class CherryPickup_741 {

	public static void main(String[] args) {
		CherryPickup_741 obj = new CherryPickup_741();
		int[][] g1 = {
				{0, 1, -1},
				{1, 0, -1},
				{1, 1,  1}
		};
		System.out.println("Cai Test = " + obj.cherryPickup(g1));//5
	}

	/**
	 * grid is an N by N 2D array, with 1 <= N <= 50.
	 * Each grid[i][j] is an integer in the set {-1, 0, 1}.
	 * ----- N <=50, so you can't use serach alg to solve this problem.
	 * 
	 */
	
	
	// Approach 1: DP ---- 3 dimensions
	// TC: O(n^3)
	// SC: O(n^3)
	private int[][][] memo;
    private int n;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        memo = new int[n][n][n];

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
            }
        }

        //因为cherryPickupHelper()可以返回负数
        return Math.max(0, cherryPickupHelper(grid, 0, 0, 0));
    }

    private int cherryPickupHelper(int[][] grid, int r1, int c1, int r2){
        int c2 = r1 + c1 - r2;
        if(memo[r1][c1][r2] != Integer.MIN_VALUE){
            return memo[r1][c1][r2];
        }

        int cur = grid[r1][c1];
        if(r1 != r2 || c1 != c2){
            cur += grid[r2][c2];
        }

        int plus = -1;
        if(r1 + 1 < n && r2 + 1 < n && grid[r1 + 1][c1] != -1 && grid[r2 + 1][c2] != -1){
            plus = Math.max(plus, cherryPickupHelper(grid, r1 + 1, c1, r2 + 1));
        }

        if(r1 + 1 < n && c2 + 1 < n && grid[r1 + 1][c1] != -1 && grid[r2][c2 + 1] != -1){
            plus = Math.max(plus, cherryPickupHelper(grid, r1 + 1, c1, r2));
        }

        if(c1 + 1 < n && r2 + 1 < n && grid[r1][c1 + 1] != -1 && grid[r2 + 1][c2] != -1){
            plus = Math.max(plus, cherryPickupHelper(grid, r1, c1 + 1, r2 + 1));
        }

        if(c1 + 1 < n && c2 + 1 < n && grid[r1][c1 + 1] != -1 && grid[r2][c2 + 1] != -1){
            plus = Math.max(plus, cherryPickupHelper(grid, r1, c1 + 1, r2));
        }

        if (r1 == n - 1 && c1 == n - 1 && r2 == n - 1 && c1 == n - 1){
            memo[r1][c1][r2] = cur;
            return cur;
        }

        //当plus < 0时，说明在从(r1, c1), (r2, c2)开始的路径上到达不了(n- 1, n -1)，所有返回-9999
        memo[r1][c1][r2] = plus < 0? -9999:(cur + plus);
        return memo[r1][c1][r2];
    }
    
//	private int[][] grid;
//	private int[][][] memo;
//	public int cherryPickup2(int[][] grid) {
//        this.grid = grid;
//        final int m = grid.length;
//        final int n = grid[0].length;
//        this.memo = new int[m][n][n];
//        for (int i = 0; i < m; i++)
//        	for (int j = 0; j < n; j++)
//        		Arrays.fill(memo[i][j], Integer.MIN_VALUE);
//        
//        return Math.max(0, dp(n - 1, m -1, n - 1));
//    }
//	
//	private int dp(int x1, int y1, int x2) {
//		final int y2 = x1 + y1 - x2;
//		if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) return -1;
//		if (grid[y1][x1] < 0 || grid[y2][x2] < 0) return -1;
//		if (x1 == 0 && y1 == 0) return grid[y1][x1];
//		if (memo[y1][x1][x2] != Integer.MIN_VALUE) {
//			return memo[y1][x1][x2];
//		}
//		
//		memo[y1][x1][x2] = Math.max(Math.max(dp(x1-1, y1, x2-1), dp(x1, y1-1, x2)), 
//				Math.max(dp(x1,  y1-1, x2-1), dp(x1-1, y2, x2)));
//		
//		if (memo[y1][x1][x2] >= 0) {
//			memo[y1][x1][x2] += grid[y1][x1];
//			if (x1 != x2) {
//				memo[y1][x1][x2] += grid[y2][x2];
//			}
//		}
//		
//		return memo[y1][x1][x2];
//	}
}
