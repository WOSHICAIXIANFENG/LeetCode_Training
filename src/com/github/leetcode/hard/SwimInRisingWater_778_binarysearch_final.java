package com.github.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class SwimInRisingWater_778_binarysearch_final {

	public static void main(String[] args) {
		int[][] a1 = {{0,2},{1,3}};
		int[][] a2 = {
				{0,1,2,3,4},
				{24,23,22,21,5},
		        {12,13,14,15,16},
				{11,17,18,19,20},
				{10,9,8,7,6}
				};
		
		System.out.println("Cai Test = " + swimInWater(a1));
		System.out.println("Cai Test = " + swimInWater(a2));
	}

	// key point to understand the question:
	// You can swim infinite distance in zero time!!!!
	// e.g. if the time is 10，就是说你游的路径中的节点 at most is 10
	// Note2: grid[i][j] is a permutation of [0, ..., N*N - 1].  ---- 因为这里面的grid[x][y] 的值最大就为 N*N -1
	// 所以我们才可以使用 binary search 去尝试
	
	private static int[] dirs = new int[]{-1, 0, 1, 0, -1};
	// 3 ms, faster than 99.82%
	// Approach 2: Binary Search
	// Guess t, for each t, check whether there exists a path from (0,0) to (n-1,n-1). 
	// Time Complexity: O(n^2 log n^2) == O(n^2logn)
	// Space Complexity: O(n^2)
	public static int swimInWater(int[][] grid) {
		int n = grid.length;
		int low = 0;
		int high = n * n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (canReach(0, 0, mid, n, new boolean[n * n], grid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
    }
	
	// Check if there is a path from [x,y] to [n-1, n-1]
	public static boolean canReach(int x, int y, int t, int n, boolean[] visited, int[][] grid) {
		if (x < 0 || x >= n || y < 0 || y >= n || visited[y * n + x] || grid[y][x] > t) {
			return false;
		}
		
		if (x == n - 1 && y == n - 1) {
			return true;
		}
		visited[y * n + x] = true;
		
		for (int i = 0; i < 4; i++) {
			if (canReach(x + dirs[i], y + dirs[i + 1], t, n, visited, grid)) {
				return true;
			}
		}
		return false;
	}
}
