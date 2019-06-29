package com.github.leetcode.medium;

public class NumberOfIslands_200 {

	public static void main(String[] args) {
		NumberOfIslands_200 obj = new NumberOfIslands_200();
		char[][] g1 = {
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '1', '0'}
		};
		System.out.println("Cai Test = " + obj.numIslands(g1));
		
		char[][] g2 = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		System.out.println("Cai Test = " + obj.numIslands(g2));
	}

	// 1 ms, faster than 100.00% 
	
	// Approach : DFS ---- Use DFS to find a connected cells and mark all the nodes to 0
	// TC: O(mn)
	// SC: O(1)
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
		int row = grid.length;
		int col = grid[0].length;
		
		int ans = 0;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (grid[i][j] == '1') {
					++ans;
					dfs(grid, i, j, row, col);
				}
		
        return ans;
    }
	
	public void dfs(char[][] grid, int x, int y, int row, int col) {
		if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == '0')
			return;
		
		grid[x][y] = '0';
		dfs(grid, x + 1, y, row, col);
		dfs(grid, x - 1, y, row, col);
		dfs(grid, x, y + 1, row, col);
		dfs(grid, x, y - 1, row, col);
	}
}
