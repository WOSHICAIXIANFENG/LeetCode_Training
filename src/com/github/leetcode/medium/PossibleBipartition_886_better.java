package com.github.leetcode.medium;

import java.util.ArrayList;

public class PossibleBipartition_886_better {

	public static void main(String[] args) {
		PossibleBipartition_886_better obj = new PossibleBipartition_886_better();
		int[][] d1 = {
				{1,2},
				{1,3},
				{2,4}
		};
		System.out.println("Cai Test = " + obj.possibleBipartition(4, d1));
		int[][] d2 = {
				{1,2},
				{1,3},
				{2,3}
		};
		System.out.println("Cai Test = " + obj.possibleBipartition(3, d2));
		int[][] d3 = {
				{1,2},
				{2,3},
				{3,4},
				{4,5},
				{1,5}
		};
		System.out.println("Cai Test = " + obj.possibleBipartition(5, d3));
	}

	/**
	 * 1 <= N <= 2000    0 <= dislikes.length <= 10000
	 * -----> the solution TC has been below  N*E ---- usually, it will be V + E	
	 * 
	 * Each person may dislike some other people, and they should not go into the same group. 
	 * -----> this is a undirected graph!!!! dislike[i][j] mean i and j dislike each other
	 */
	
	// 14 ms, faster than 95.32% --- Use ArrayList<Integer>[] graph is much better than Map<Integer, List<Integer>> graph
	// Approach 1 : Graph Coloring ---- color a node with one color, and color all it's disliked nodes with another color
	// TC: O(V + E)
	// SC: O(V + E)
	// DFS Implementation
	
	private ArrayList<Integer>[] graph;
   
	public boolean possibleBipartition(int N, int[][] dislikes) {
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] dis : dislikes) {
			graph[dis[0]].add(dis[1]);
			graph[dis[1]].add(dis[0]);
		}
		
        // O: unknown, 1: red, -1: blue
        int[] colors = new int[N + 1];
        for (int i = 1; i <= N; i++) {
        	if (colors[i] == 0 && !dfs(i, 1, colors)) {
        		return false;// the you can't color your neighbour, return false
        	}
        }
        return true;
    }
	
	// Use dfs alg to coloring 'cur' to red, make it's neighbours to blue 
	public boolean dfs(int cur, int color, int[] colors) {
		colors[cur] = color;
		// coloring its connections neighbours
		for (int next : graph[cur]) {
			if (colors[next] == color) return false;//can't coloring 
			if (colors[next] == 0 && !dfs(next, -color, colors)) return false;
		}
		return true;
	}
}
