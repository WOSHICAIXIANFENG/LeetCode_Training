package com.github.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class SwimInRisingWater_778_s2 {

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
	
	// 8 ms, faster than 87.50%
	// Approach 2: Binary Search
	// Guess t, for each t, check whether there exists a path from (0,0) to (n-1,n-1). 
	// Time Complexity: O(n^2 log n^2) == O(n^2logn)
	// Space Complexity: O(n^2)
	public static int swimInWater(int[][] grid) {
		int N = grid.length;
		int low = 0;
		int high = N * N - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			//if (hasPath(grid, mid)) {
			if (canReach(0, 0, mid, N, new boolean[N][N], grid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
    }
	
	// 因为使用了普通的Queue，而没有使用MinHeap (PriorityQueue)，所以它的Time Complexity 从 n^2logN 降到 n^2
	// 使用普通的Queue去找到从 [0,0] 到[n-1,n-1]的最小path
	// ArrayDeque is better than LinkedList
	public static boolean hasPath(int[][] grid, int t) {
		int n = grid.length;
		if (grid[0][0] > t) return false;
		
		boolean[] seen = new boolean[n * n];
		int[] dirs = new int[]{-1,0,1,0,-1};
		Deque<Integer> queue = new ArrayDeque<>(); // ty * N + tx
		queue.offer(0 * n + 0);
		seen[0 * n + 0] = true;
		
		while (!queue.isEmpty()) {
			int pos = queue.poll();
			int x = pos % n;
			int y = pos / n;
			if (x == n - 1 && y == n - 1) {
				return true;// it means it has path from [0,0] to [n-1,n-1]
			}
			// 4 directions to search
			for (int i = 0; i < 4; i++) {
				int tx = x + dirs[i];
				int ty = y + dirs[i + 1];
				if (tx < 0 || ty < 0 || tx >= n || ty >= n || grid[ty][tx] > t) {
					continue;
				}
				if (seen[ty * n + tx]) continue;
				
				queue.offer(ty * n + tx);
				seen[ty * n + tx] = true;
			}
		}
		
		return false;
	}
	
	private static int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
	
	// Since only faster than 84.42%, 
	// 尝试优化 low 的值，可是效果不明显
	// 所以深度优化 hasPath() 方法
	// Haha 达到了 3 ms, faster than 99.82%
	private static boolean canReach(int i, int j, int time, int n, boolean[][] visited, int[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || time < grid[i][j]) {
            return false;
        }
        
        if (i == n-1 && j == n-1) {
            return true;
        }
        
        visited[i][j] = true;
        for (int[] d : dirs) {
			if (canReach(i + d[0], j + d[1], time, n, visited, grid)) {
                return true;
            }    
        }
        
        return false;
    }
}
