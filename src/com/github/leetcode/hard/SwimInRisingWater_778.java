package com.github.leetcode.hard;

import java.util.PriorityQueue;

public class SwimInRisingWater_778 {

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
	
	//9 ms, faster than 86.23% 
	
	// Approach 1: Dijkstra Algorithm 
	// https://www.youtube.com/watch?v=pVfj6mxhdMw
	
	// Find the shortest path from [0,0] to [n - 1, n - 1]
	// The total path length is the max element on the path. 
	// PriorityQueue: {time, x, y}
	// Time Complexity: O(n^2log(n^2)) == 2*n^2log(n) = O(N^2logN)
	// Space Complexity: O(n^2) --- we have n^2 elements in total.
	public static int swimInWater(int[][] grid) {
		int n = grid.length; // n*n grid
		PriorityQueue<Vetex> minHeap = new PriorityQueue<>();
		minHeap.offer(new Vetex(grid[0][0], 0 * n + 0));// put ty*N + tx to save code
		boolean[] seen = new boolean[n * n];
		// left dir: (-1,0)  down dir:(0,1)  right dir:(1,0)  up dir:(0,-1)
		int[] dirs = new int[] { -1, 0, 1, 0, -1 };
		seen[0 * n + 0] = true;
		// 所有被放入minHeap中的元素：都代表了从[0,0]到该元素所用的最大max value path. 每个元素只被放一次，只被访问一次。
		// 所有被放入的元素都是 一条从[0,0] to [ty,tx] 的有向路径，其权重取的就是path中value最大的顶点  
		while (!minHeap.isEmpty()) {
			Vetex vetex = minHeap.poll();
			int t = vetex.time;
			int x = vetex.pos % n;
			int y = vetex.pos / n;
			if (x == n - 1 && y == n - 1) {
				//System.out.println("Cai Test heap size = " + minHeap.size());
				// 因为每个结点只被放在heap中一次，也只被访问一次。
				return t;// this is the answer, minimum path from [0,0] to [n-1,n-1] which has max value
			}
			// for directions searching
			for (int i = 0; i < 4; i++) {
				int tx = x + dirs[i];
				int ty = y + dirs[i + 1];
				if (tx < 0 || ty < 0 || tx >= n || ty >= n) continue;
				// each Vetex only visit one time
				if (seen[ty * n + tx]) continue;
				
				minHeap.offer(new Vetex(Math.max(t, grid[ty][tx]), ty * n + tx)); //!!! 特别注意这里是 [ty][tx]
				seen[ty * n + tx] = true;
			}
		}
        return -1;
    }
}

class Vetex implements Comparable<Vetex> {
	int time; // gird[x][y]
	int pos;// ty*N + tx
	public Vetex(int time, int pos) {
		this.time = time;
		this.pos = pos;
	}
	@Override
	public int compareTo(Vetex that) {
		return this.time - that.time;
	}
}
