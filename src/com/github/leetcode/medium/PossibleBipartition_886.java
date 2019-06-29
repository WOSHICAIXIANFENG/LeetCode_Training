package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossibleBipartition_886 {

	public static void main(String[] args) {
		PossibleBipartition_886 obj = new PossibleBipartition_886();
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
	
	// Approach 1 : Graph Coloring ---- color a node with one color, and color all it's disliked nodes with another color
	// TC: O(V + E)
	// SC: O(V + E)
	// DFS Implementation
	
	// 46 ms, faster than 47.03% --- map.get(key) is slower than array[i] --- You can optimize with ArrayList<Integer>[] graph
	Map<Integer, List<Integer>> graph;
	public boolean possibleBipartition(int N, int[][] dislikes) {
		graph = new HashMap<>();
        for (int[] dis : dislikes) {
        	List<Integer> heighbours = graph.getOrDefault(dis[0] - 1, new ArrayList<>());
        	heighbours.add(dis[1] - 1);
        	graph.put(dis[0] - 1, heighbours);
        	
        	List<Integer> heighbours2 = graph.getOrDefault(dis[1] - 1, new ArrayList<>());
        	heighbours2.add(dis[0] - 1);
        	graph.put(dis[1] - 1, heighbours2);
        }
        //System.out.println("Cai Test graph = " + graph);
        // O: unknown, 1: red, -1: blue
        int[] colors = new int[N];
        for (int i = 0; i < N; i++) {
        	if (colors[i] == 0 && !dfs(i, 1, colors, graph)) {
        		return false;// the you can't color your neighbour, return false
        	}
        }
        return true;
    }
	
	// Use dfs alg to coloring 'cur' to red, make it's neighbours to blue 
	public boolean dfs(int cur, int color, int[] colors, Map<Integer, List<Integer>> graph) {
		colors[cur] = color;
		// coloring its connections neighbours
		if (graph.containsKey(cur)) {
			for (int next : graph.get(cur)) {
				if (colors[next] == color) return false;//can't coloring 
				if (colors[next] == 0 && !dfs(next, -color, colors, graph)) return false;
			}
		}
		return true;
	}
}
