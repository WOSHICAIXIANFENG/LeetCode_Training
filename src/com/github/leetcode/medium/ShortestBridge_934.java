package com.github.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge_934 {

	public static void main(String[] args) {
		ShortestBridge_934 obj = new ShortestBridge_934();
		int[][] a1 = {
				{0, 1},
				{1, 0},
		};
		System.out.println("Cai Test = " + obj.shortestBridge(a1));//1
		int[][] a2 = {
				{0, 1, 0},
				{0, 0, 0},
				{0, 0, 1}
		};
		System.out.println("Cai Test = " + obj.shortestBridge(a2));//2
		
		int[][] a3 = {
				{1,1,1,1,1},
				{1,0,0,0,1},
				{1,0,1,0,1},
				{1,0,0,0,1},
				{1,1,1,1,1}
		};
		System.out.println("Cai Test = " + obj.shortestBridge(a3));//1
	}

	// 8 ms, faster than 99.16% 
	
	// Approach : DFS + BFS
	// Use DFS to find one island and mark all the nodes as 2, Use BFS to find the shortest path from any node of isLand with value-2
	// to any node with value 1
	
	// TC: O(mn) ---- Each node will be visited several times
	// SC: O(mn) ---- At most m*n cells will be put into Queue
	public int shortestBridge(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0) return 0;
		int row = A.length;
		int col = A[0].length;
		// since only exists 2 island
		boolean found = false;
		Queue<Pair> queue = new ArrayDeque<>();
		for (int i = 0; i < row && !found; i++)
			for (int j = 0; j < col && !found; j++)
				if (A[i][j] == 1) {
					found = true;
					dfs(A, i, j, row, col, queue);
				}
		
		int steps = 0;
		int[] dirs = {0, 1, 0, -1, 0};
		while (!queue.isEmpty()) {
			// BFS from each node of first island to find another one
			int size = queue.size();
			while (size-- > 0) {
				Pair pair = queue.poll();
				int x = pair.x;
				int y = pair.y;
				// 4 directions to search 
				for (int k = 0; k < 4; k++) {
					int i = x + dirs[k];
					int j = y + dirs[k + 1];
					if (i < 0 || i >= row || j < 0 || j >= col || A[i][j] == 2) continue;
					if (A[i][j] == 0) {
						queue.offer(new Pair(i, j));
						A[i][j] = 2;//!!! 不能忘记!!!
					}
					if (A[i][j] == 1) {
						return steps;
					}
				}
			}
			steps++;
		}
        return steps;
    }
	
	public void dfs(int[][] grid, int x, int y, int row, int col, Queue<Pair> queue) {
		if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != 1) //!!! 注意这里是 != 1
			return;
		
		grid[x][y] = 2;// mark it to 2
		queue.offer(new Pair(x, y));
		dfs(grid, x + 1, y, row, col, queue);
		dfs(grid, x - 1, y, row, col, queue);
		dfs(grid, x, y + 1, row, col, queue);
		dfs(grid, x, y - 1, row, col, queue);
	}
	
	class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
