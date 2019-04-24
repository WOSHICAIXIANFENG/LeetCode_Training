package com.github.leetcode.easy;

public class IslandPerimeter_463 {

	public static void main(String[] args) {
		IslandPerimeter_463 obj = new IslandPerimeter_463();
		int[][] a1 = {
				{0,1,0,0},
				{1,1,1,0},
				{0,1,0,0},
				{1,1,0,0}
		};
		System.out.println("Cai Test = " + obj.islandPerimeter(a1));
	}

	// 7 ms, faster than 95.47%
	public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int area = 0;
        int neighbours = 0;  
        for (int i = 0; i < m; i++)
        	for (int j = 0; j < n; j++)
        		if (grid[i][j] == 1) {
        			++area;
        			if (i > 0 && grid[i - 1][j] == 1) ++neighbours;
        			if (i < m - 1 && grid[i + 1][j] == 1) ++neighbours;
        			if (j > 0 && grid[i][j - 1] == 1) ++neighbours;
        			if (j < n - 1 && grid[i][j + 1] == 1) ++neighbours;
        		}
        
        return area * 4 - neighbours;
    }
}
