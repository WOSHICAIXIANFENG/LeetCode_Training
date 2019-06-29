package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// http://zxi.mytechroad.com/blog/graph/leetcode-743-network-delay-time/

/**
 * About Dijkstra Algorithm:
 * https://www.youtube.com/watch?v=XB4MIexjvY0
 * 
 * https://leetcode.com/articles/network-delay-time/
 * 
 */
public class NetworkDelayTime_743_s3 {

	public static void main(String[] args) {
		NetworkDelayTime_743_s3 obj = new NetworkDelayTime_743_s3();
		int[][] t1 = {
				{2, 1, 1},
				{2, 3, 1},
				{3, 4, 1}
		};
		System.out.println("Cai Test = " + obj.networkDelayTime(t1, 4, 2));//2
		
		int[][] t2 = {
				{1, 2, 1},
				{2, 1, 3}
		};
		System.out.println("Cai Test = " + obj.networkDelayTime2(t2, 2, 2));//3
	}

	// It is a direct graph issue
	
	// 16 ms, faster than 90.69%
	
	// idea: Construct the graph and do a shortest path from K to all other nodes.
	// Approach 3: Dijkstra Algorithm --- Basic Implementation
	// TC: O(N^2 + E) where E is the length of times in the basic implementation
	// SC: O(N+E), the size of the graph O(E), plus the size of the other objects used O(N)
	public int networkDelayTime2(int[][] times, int N, int K) {
		// U -> v1,time1; v2,time2
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] edge : times) {
			if (!graph.containsKey(edge[0])) {
				graph.put(edge[0], new ArrayList<>());
			}
			graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
		}
		
		// Dijkstra Algorithm ---- suitable to solve the shortest distance issues
		// V ---> shortest distance
		Map<Integer, Integer> dist = new HashMap<>();
		for (int node = 1; node <= N; node++) {
			dist.put(node, Integer.MAX_VALUE);
		}
		// start vertex, put value to 0
		dist.put(K, 0);
		
		// Seen Array
		boolean[] seen = new boolean[N + 1];
		
		// Dijkstra Algorithm ---- 其实最近执行 N次就退出了
		// TC: O(N^2)
		int loop = N + 1;
		while (loop-- > 0) {
//		while (true) {
			int smallestNode = -1;
			int smallestDist = Integer.MAX_VALUE;
			// find the smallest vertex to start next iteration
			for (int i = 1; i <= N; i++) {
				if (!seen[i] && dist.get(i) < smallestDist) {
					smallestDist = dist.get(i);
					smallestNode = i;
				}
			}
			
			if (smallestNode == -1) {
				break;// exit from loop when all vertex has been visited
			}
			seen[smallestNode] = true;
			
			if (graph.containsKey(smallestNode)) {
				for (int[] edge : graph.get(smallestNode)) {
					dist.put(edge[0], Math.min(dist.get(edge[0]), dist.get(smallestNode) + edge[1]));
				}
			}
		}
		
		// find the longest path in the shortest path set U --> V
		int ans = 0;
		for (int cand : dist.values()) {
			if (cand == Integer.MAX_VALUE) return -1; // there exists some vertex can arrive from K
			ans = Math.max(ans, cand);
		}
        return ans;
    }
	
	// Approach 3: Dijkstra Algorithm --- Heap Implementation
	// TC: O(ElogE) in the heap implementation, as potentially every edge gets added to the heap.
	// SC: O(N+E), the size of the graph O(E), plus the size of the other objects used O(N)
	public int networkDelayTime(int[][] times, int N, int K) {
		// step1: build the graph to get info quickly
		// U --> v1,d1; v2,d2; v3,d3;
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] edge : times) {
			int u = edge[0];
			if (!graph.containsKey(u)) {
				graph.put(u, new ArrayList<>());
			}
			graph.get(u).add(new int[]{edge[1], edge[2]});
		}
		// Use PriorityQueue to quickly find the smallest Node
		// {distance, vertex}
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((info1, info2) -> info1[0] - info2[0]);
		minHeap.offer(new int[]{0, K});
		
		// Vertex ---> Distance --- 不同上面的basic implementation，这里只放 
		Map<Integer, Integer> dist = new HashMap<>();
		while (!minHeap.isEmpty()) {
			int[] smallestInfo = minHeap.poll();
			int time = smallestInfo[0];
			int node = smallestInfo[1];
			
			// !!! continue poll the current smallest vertex's previous value if that was the smallest now
			if (dist.containsKey(node)) continue;
			
			dist.put(node, time);
			// try to update all directed connection edges Vertexs
			if (graph.containsKey(node)) {
				for (int[] edge : graph.get(node)) {
					if (!dist.containsKey(edge[0])) {
						minHeap.offer(new int[]{dist.get(node) + edge[1], edge[0]});
					}
				}
			}
		}
		
		// output the result
		if (dist.size() != N) return -1;
		int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);
        return ans;
	}
}
