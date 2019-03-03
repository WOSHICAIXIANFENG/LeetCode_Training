package com.github.leetcode.easy;

public class SurfaceAreaOf3DShapes_892 {

	public static void main(String[] args) {
		int[] a1 = {2};
		int[][] a2 = {{1,2},{3,4}};
		int[][] a3 = {{1,0},{0,2}};
		int[][] a4 = {{1,1,1},{1,0,1},{1,1,1}};
		
		int[][] a5 = {{2,2,2},{2,1,2},{2,2,2}};
		System.out.println("Cai Test = " + surfaceArea(a2));
		System.out.println("Cai Test = " + surfaceArea(a3));
		System.out.println("Cai Test = " + surfaceArea(a4));
		System.out.println("Cai Test = " + surfaceArea(a5));
	}

	// 5 ms, faster than 100.00%
	// Time Complexity: O(N^2)
	// Space Complexity: O(1)
	public static int surfaceArea(int[][] grid) {
		int sum = 0;
		int length = grid.length; // N * N
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				sum += 6 * grid[i][j];
				
				// subtract the hidden area by it's self cubes placed on grid cell(i,j) 
				if (grid[i][j] > 1) {
					sum -= (grid[i][j] - 1) * 2;
				}
			}
			
			// subtract the hidden area in horizontal orientation
			for (int j = 0; j < length - 1; j++) {
				sum -= Math.min(grid[i][j], grid[i][j + 1]) * 2;
			}
		}
		
		// subtract the hidden area in vertical orientation
		for (int j = 0; j < length; j++) {
			for (int i = 0; i < length - 1; i++) {
				sum -= Math.min(grid[i][j], grid[i + 1][j]) * 2;
			}
		}
        return sum;
    }
}
