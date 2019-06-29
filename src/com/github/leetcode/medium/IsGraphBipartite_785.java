package com.github.leetcode.medium;

public class IsGraphBipartite_785 {

	public static void main(String[] args) {
		IsGraphBipartite_785 obj = new IsGraphBipartite_785();
		int[][] g1 = {
				{1,3},
				{0,2},
				{1,3},
				{0,2}
		};
		System.out.println("Cai Test = " + obj.isBipartite(g1));// true
		
		int[][] g2 = {
				{1,2,3},
				{0,2},
				{0,1,3},
				{0,2}
		};
		System.out.println("Cai Test = " + obj.isBipartite(g2));// false
	}
	
	/**
	 * The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
	 * !!! It is a undirected graph ---- split into two parts --- bipartite!!!
	 * 
	 */
	
	// 0 ms, faster than 100.00%
	
	// Approach 1: Graph Coloring --- solved the undirected grouping issue
	// TC: O(V + E) --- each vertex and edge will be visisted once
	// SC: O(1) ---- graph has been provied by int[][]
	// Use DFS or BFS to implement
	public boolean isBipartite(int[][] graph) {
		final int n = graph.length;
		int[] colors = new int[n]; // 0: unknown, 1: Red, -1: Blue
		for (int i = 0; i < n; i++) {
			// if i-th vertex are not colored, you need to color it to Red 
			if (colors[i] == 0 && !dfs(i, 1, colors, graph)) {
				return false;
			}
		}
        return true;
    }
	
	// Use dfs alg to color the node to 'red' and color its neighbours to -color 'blue'
	public boolean dfs(int node, int color, int[] colors, int[][] graph) {
		colors[node] = color;
		for (int next : graph[node]) {
			if (colors[next] == color) return false;//your intent is to color next to -color, but its color is color
			if (colors[next] == 0 && !dfs(next, -color, colors, graph)) return false;
		}
		return true;
	}
}
