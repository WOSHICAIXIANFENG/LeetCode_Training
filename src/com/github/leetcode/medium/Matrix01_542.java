package com.github.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Matrix01_542 {

	public static void main(String[] args) {
		Matrix01_542 obj = new Matrix01_542();
		int[][] a1 = {
				{0,0,0},
				{0,1,0},
				{1,1,1}
		};
		int[][] ans = obj.updateMatrix(a1);
		for (int[] an : ans) {
			System.out.println("Cai Test = " + Arrays.toString(an));
		}
	}

	// 16 ms, faster than 75.02%
	// 17 ms, faster than 68.15%
	
	// Approach 1: BFS ---- start from all 0 cells and find shortest paths to rest of the cells
	// TC: O(mn) ---- each node will be put in queue
	// SC: O(mn) seen or ans
	public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col= matrix[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        
        int[][] seen = new int[row][col];
        int[][] ans = new int[row][col];
        // pre-computation
        for (int i = 0; i < row; i++)
        	for (int j = 0; j < col; j++)
        		ans[i][j] = Integer.MAX_VALUE;
        
        for (int i = 0; i < row; i++)
        	for (int j = 0; j < col; j++)
        		if (matrix[i][j] == 0) {
        			q.offer(new Pair(i, j));
        			seen[i][j] = 1;
        		}
        		
        int[] dirs = {0, -1, 0, 1, 0};
        int steps = 0;
        // first level --- 处理所有0s
        // send level --- 处理distance为1 的 1s
        // third leve --- handle distance==2 的 1s
        while (!q.isEmpty()) {
        	int size = q.size();
        	while (size-- > 0) {
        		Pair pair = q.poll();
        		int i = pair.x;
        		int j = pair.y;
        		ans[i][j] = steps;//!!!
        		// 4 directions to search
        		for (int k = 0; k < 4; ++k) {
        			int x = i + dirs[k];
        			int y = j + dirs[k + 1];
        			if (x < 0 || x >= row || y < 0 || y >= col || seen[x][y] == 1) continue;
        			seen[x][y] = 1;
        			q.offer(new Pair(x, y));
        		}
        	}
        	++steps;
        }
        return ans;
    }
	
	class Pair {
		private int x;
		private int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
