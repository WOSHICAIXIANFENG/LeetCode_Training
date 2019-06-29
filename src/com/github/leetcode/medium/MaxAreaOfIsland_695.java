package com.github.leetcode.medium;

public class MaxAreaOfIsland_695 {

	public static void main(String[] args) {
		MaxAreaOfIsland_695 obj = new MaxAreaOfIsland_695();
		
		int[][] a1 = {
				 {0,0,1,0,0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,1,1,0,1,0,0,0,0,0,0,0,0},
				 {0,1,0,0,1,1,0,0,1,0,1,0,0},
				 {0,1,0,0,1,1,0,0,1,1,1,0,0},
				 {0,0,0,0,0,0,0,0,0,0,1,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,0,0,0,0,0,0,1,1,0,0,0,0}
		};
		System.out.println("Cai Test = " + obj.maxAreaOfIsland(a1));
	}

	// 2 ms, faster than 100.00%
	
	// Approach 1: Use DFS to find the connected components
	// TC: O(m*n)
	// SC: O(m*n/2) --- the space used by the call stack during our recursion. the depth <= m*n/2
	public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
        	return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++)
        	for (int j = 0; j < col; j++)
        		if (grid[i][j] == 1) {
        			max = Math.max(max, dfs(grid, i, j, row, col));
        		}
        return max;		
    }
	
	public int dfs(int[][] grid, int i, int j, int row, int col) {
		if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0)
			return 0;
		
		grid[i][j] = 0;// mark it to 0 or use another visited array
		return 1 + dfs(grid, i + 1, j, row, col)
			+ dfs(grid, i - 1, j, row, col)
			+ dfs(grid, i, j + 1, row, col)
			+ dfs(grid, i, j - 1, row, col);
	}
}
