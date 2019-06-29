package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsIand_827 {

	public static void main(String[] args) {
		MakingALargeIsIand_827 obj = new MakingALargeIsIand_827();
		int[][] a1 = {
				{1,0},
				{0,1}
		};
		System.out.println("Cai Test = " + obj.largestIsland(a1));//3

		int[][] a2 = {
				{1,1},
				{1,0}
		};
		System.out.println("Cai Test = " + obj.largestIsland(a2));//4
		
		int[][] a3 = {
				{1,1},
				{1,1}
		};
		System.out.println("Cai Test = " + obj.largestIsland(a3));//4
	}
	
	/**
	 * 1 <= grid.length = grid[0].length <= 50.
	 * -----> so, the solution will be O(n^2) time consume
	 * 
	 */
	
	// 13 ms, faster than 69.72%
	
	// Approach 1: DFS
	// Use DFS to find all connected components --- Leetcode 200
	// For each '0' check its 4 neighbours, sum all unique CC's area
	// TC: O(n^2)
	// SC: O(n^2)
	public int largestIsland(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
        int color = 1;
        int row = grid.length;
        int col = grid[0].length;
        // Color --> Area
        Map<Integer, Integer> areas = new HashMap<>();
        
        int ans = 0;
        
        // step1: Give each connected component a unique id and count its area.
        for (int i = 0; i < row; i++)
        	for (int j = 0; j < col; j++) 
        		if (grid[i][j] == 1) {
        			color++;
        			areas.put(color, getArea(i, j, color, grid, row, col));
        			ans = Math.max(ans, areas.get(color));
        		}
        
        //System.out.println("Cai Test areas = " + areas);
        // step2: For each '0', check its 4 neighbours, sum areas up by unique ids
        for (int i = 0; i < row; i++)
        	for (int j = 0; j < col; j++)
        		if (grid[i][j] == 0) {
        			int area = 1;
        			 System.out.println("Cai Test colors = " + getColors(i, j, grid, row, col));
        			for (int colour : getColors(i, j, grid, row, col)) {
        				if (colour != 0) {
        					area += areas.get(colour);
        				}
        			}
        			ans = Math.max(ans, area);
        		}
        
        return ans;
    }
	
	public Set<Integer> getColors(int x, int y, int[][] grid, int row, int col) {
		Set<Integer> colors = new HashSet<>();
		colors.add(getColor(x + 1, y, grid, row, col));
		colors.add(getColor(x - 1, y, grid, row, col));
		colors.add(getColor(x, y + 1, grid, row, col));
		colors.add(getColor(x, y - 1, grid, row, col));
		return colors;
	}
	
	public int getColor(int x, int y, int[][] grid, int row, int col) {
		if (x < 0 || x >= row || y < 0 || y >= col) {
			return 0;
		}
		return grid[x][y];
	}
	
	public int getArea(int x, int y, int color, int[][] grid, int row, int col) {
		if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != 1) {//!!! 注意这是 != 1
			return 0;
		}
		grid[x][y] = color;
		return 1 + getArea(x + 1, y, color, grid, row, col)
		 + getArea(x - 1, y, color, grid, row, col)
		 + getArea(x, y + 1, color, grid, row, col)
		 + getArea(x, y - 1, color, grid, row, col);
	}
}
