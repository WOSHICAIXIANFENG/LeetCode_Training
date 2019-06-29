package com.github.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Queue;

// http://zxi.mytechroad.com/blog/graph/leetcode-847-shortest-path-visiting-all-nodes/
public class ShortestPathVisitingAllNodes_847 {

	public static void main(String[] args) {
		ShortestPathVisitingAllNodes_847 obj = new ShortestPathVisitingAllNodes_847();
		int[][] g1 = {
				{1,2,3},
				{0},
				{0},
				{0}
		};
		System.out.println("Cai Test = " + obj.shortestPathLength(g1));
		
		int[][] g2 = {
				{1},
				{0, 2, 4},
				{1, 3, 4},
				{2},
				{1, 2}
		};
		System.out.println("Cai Test = " + obj.shortestPathLength(g2));
	}
	
	/**
	 * 1 <= graph.length <= 12
	 *  ----> the final solution TC should be O(n!) or O(2^n)
	 * 
	 * You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
	 *  ----> !!! Difference!!! You cant use Dijastra Alg, Bellman Ford, Floyd-Warshall 
	 */

	// 9 ms, faster than 70.97%
	
	// Approach 1: BFS ---- How to represent a unique state?
	// (curr_node, visited_nodes)  ---- 1 <= graph.length <= 12
	// So, we can use a 32 bit int to represent visited_nodes.
	// N = 4, 1101 ---> Node 0, 2, 3 are visited.  Goal is (1 << n) - 1
	// BFS --- init --- push all nodes into the queue
	// TC: O(n * 2^n) --- each unique state will be visited one time
	// SC: O(n * 2^n)
	public int shortestPathLength(int[][] graph) {
		final int n = graph.length;
		// final state --- all nodes have been visited. 11111
		final int kAns = (1 << n) - 1; // 1101 --> node 0,2,3 has been visited
		Queue<Pair> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][1 << n];
		// put the first layer into the queue
		for (int i = 0; i < n; i++)
			queue.offer(new Pair(i, 1 << i));
		
		// We start from each node, then do one step by one step.!!! ----> that's the BFS idea
		int steps = 0;
		while (!queue.isEmpty()) {
			int s = queue.size();// how many nodes in this layer
			while (s-- > 0) {
				Pair cur = queue.poll();
				int node = cur.node;
				int state = cur.visitedState;
				if (state == kAns) return steps;//!!!
				// !!! speed up
				if (visited[node][state]) {
					continue;
				}
				visited[node][state] = true;//
				for (int next : graph[node]) {
					queue.offer(new Pair(next, state | (1 << next)));
				}
			}
			steps++;
		}
		
        return -1;
    }
	
	// The unique State!!1 the element of BFS
	class Pair {
		int node;
		int visitedState;// we use a 32 bit int to represent visited nodes
		public Pair(int node, int state) {
			this.node = node;
			this.visitedState = state;
		}
	}
}
