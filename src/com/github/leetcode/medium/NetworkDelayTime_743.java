package com.github.leetcode.medium;

// http://zxi.mytechroad.com/blog/graph/leetcode-743-network-delay-time/

/**
 * About Bellman-Ford Algorithm:
 * https://www.youtube.com/watch?v=FtN3BYH2Zes
 * 
 */
public class NetworkDelayTime_743 {

	public static void main(String[] args) {
		NetworkDelayTime_743 obj = new NetworkDelayTime_743();
		int[][] t1 = {
				{2, 1, 1},
				{2, 3, 1},
				{3, 4, 1}
		};
		System.out.println("Cai Test = " + obj.networkDelayTime(t1, 4, 2));//2
	}

	// It is a direct graph issue
	
	// 31 ms, faster than 71.13%
	
	// idea: Construct the graph and do a shortest path from K to all other nodes.
	// Approach 1: Bellman-Ford
	// TC: O(V * E)
	// SC: O(V)
	public int networkDelayTime(int[][] times, int N, int K) {
        final int MAX_TIME = 100 * 100;// from K to the last vertex, at most need 99 edges, each edge at most 100 time
        
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
        	dist[i] = MAX_TIME;
        }
        
        dist[K - 1] = 0;// set start vertex value to 0
        for (int i = 1; i < N; i++) {
        	for (int[] time : times) {
        		int u = time[0] - 1;
        		int v = time[1] - 1;
        		int w = time[2];
        		dist[v] = Math.min(dist[v], dist[u] + w);
        	}
        }
        // How long will it take for all nodes to receive the signal? If it is impossible, return -1.
        int maxDist = dist[0];
        for (int val : dist) {
        	if (val > maxDist) {
        		maxDist = val;
        	}
        }
        return maxDist == MAX_TIME ? -1 : maxDist;
    }
}
