package com.github.leetcode.hard;

import java.util.stream.IntStream;

public class DungeonGame_174 {

	public static void main(String[] args) {
		int[][] a1 = {
				{-2,-3,3},
				{-5,-10,1},
				{10,30,-5}
				};
		System.out.println("Cai Test = " + calculateMinimumHP(a1));
	}
	
	// 38 ms, faster than 5.02%  ---- !!!!
	
	// Approach 1: DP --- Use two-dimensional dp array to solve it
	// Time Complexity: O(m*n)
	// Space Complexity: O(m*n)
	public static int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length;
		int col = dungeon[0].length;
		
		// create a health point grid
		int[][] hp = new int[row + 1][col + 1];
		IntStream.range(0, row + 1).forEach(i -> {
			IntStream.range(0, col + 1).forEach(j -> {
				hp[i][j] = Integer.MAX_VALUE;
			});
		});
//		Arrays.fill(dp, Integer.MAX_VALUE); //this fun only works for one-dimensional array
		
		hp[row - 1][col] = 1;
		hp[row][col - 1] = 1;
		
		for (int y = row - 1; y >= 0; --y) 
			// calculate one row each loop
			for (int x = col - 1; x >= 0; --x)
				hp[y][x] = Math.max(1, Math.min(hp[y][x + 1], hp[y + 1][x]) - dungeon[y][x]);
		
        return hp[0][0];
    }

}
