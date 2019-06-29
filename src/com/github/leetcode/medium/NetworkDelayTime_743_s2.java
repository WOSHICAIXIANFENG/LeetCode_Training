package com.github.leetcode.medium;

// https://leetcode.com/articles/network-delay-time/

/**
 * 
 * 
 * About Floyd-Warshall Algorithm:
 * https://www.youtube.com/watch?v=oNI0rf2P9gE
 * 
 */
public class NetworkDelayTime_743_s2 {

	public static void main(String[] args) {
		NetworkDelayTime_743_s2 obj = new NetworkDelayTime_743_s2();
		int[][] t1 = {
				{2, 1, 1},
				{2, 3, 1},
				{3, 4, 1}
		};
		System.out.println("Cai Test = " + obj.networkDelayTime(t1, 4, 2));//2
	}

	// It is a direct graph issue
	
	// Floyd-Warshall algorithm could solve Any vertex to another vertex shortest path issue.
	
	// idea: Construct the graph and do a shortest path from K to all other nodes.
	// Approach 1: Floyd-Warshall --- because N will be in the range [1, 100], not big
	// TC: O(V^3)
	// SC: O(V^2)
	public int networkDelayTime(int[][] times, int N, int K) {
        final int MAX_TIME = 99 * 100;// from K to the last vertex, at most need 99 edges, each edge at most 100 time
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++)
        		matrix[i][j] = MAX_TIME;// or put it to Infinite
        }
        
        for (int[] time : times) {
        	int u = time[0] - 1;
    		int v = time[1] - 1;
    		int w = time[2];
    		matrix[u][v] = w;
        }
        
        // put the diagonal to 0
        for (int i = 0; i < N; i++) {
        	matrix[i][i] = 0; 
        }
        
        for (int k = 0; k < N; k++)
        	for (int i = 0; i < N; i++)
        		for (int j = 0; j < N; j++)
        			matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
        
        // find the max time of k row
        int maxDist = matrix[K - 1][0];
        for (int i = 0; i < N; i++) {
        	if (matrix[K - 1][i] > maxDist) {
        		maxDist = matrix[K - 1][i];
        	}
        }
     
        return maxDist == MAX_TIME ? -1 : maxDist;
    }
}
