package com.github.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// Use BFS to implement
public class PossibleBipartition_886_BFS {

	public static void main(String[] args) {
		PossibleBipartition_886_BFS obj = new PossibleBipartition_886_BFS();
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
	// Use BFS to implement
   
	public boolean possibleBipartition(int N, int[][] dislikes) {
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] dis : dislikes) {
			graph[dis[0]].add(dis[1]);
			graph[dis[1]].add(dis[0]);
		}
		
        // O: unknown, 1: red, -1: blue
        int[] colors = new int[N + 1];
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) { //!!!! ---- the graph may have several clusters/ connected components
        	if (colors[i] != 0) continue;// if the vertex has been colored, we ignore it
        	queue.offer(i);
        	colors[i] = 1;//red
        	// BFS Classic implementation to color its all neighbours
        	while (!queue.isEmpty()) {
        		int cur = queue.poll();
        		// try to color it's neighbours
        		for (int next : graph[cur]) {
        			if (colors[next] == colors[cur]) return false;//conflict --- my intent is to put my neighbour color to -color
        			if (colors[next] != 0) {
        				// it already has -color color, we skip this neighbour
        				continue;
        			}
        			colors[next] = -colors[cur];
        			queue.offer(next);
        		}
        	}
        }
        return true;
    }
}
