package com.github.leetcode.medium;

import java.util.Arrays;

public class RedundantConnection_684 {

	public static void main(String[] args) {
		RedundantConnection_684 obj = new RedundantConnection_684();
		int[][] a1 = {
				{1, 2},
				{1, 3},
				{2, 3}
		};
		System.out.println("Cai Test = " + Arrays.toString(obj.findRedundantConnection(a1)));
		
		int[][] a2 = {
				{1, 2},
				{2, 3},
				{3, 4},
				{1, 4},
				{1, 5}
		};
		System.out.println("Cai Test = " + Arrays.toString(obj.findRedundantConnection(a2)));
	}

	// 1 ms, faster than 92.01% 
	
	// Approach 1 : UnionFindSet
	// TC: O(n) * amortized O(1)
	// SC: O(n) --- # of edge + 1
	public int[] findRedundantConnection(int[][] edges) {
		// In this problem, a tree is an undirected graph that is connected and has no cycles.
		// connected!!! ---> so the vertex count is edges length + 1
		// 1->2  3->4 ---> wrong case!!! not connected
		// [[1,2], [2,3], [3,4], [1,4],[3,1], [1,5]] ---> wrong case!!! two cycles
		UnionFindSet s = new UnionFindSet(edges.length);
		for (int[] edge : edges) {
			if (!s.union(edge[0], edge[1])) {
				return edge;
			}
		}
		return new int[] {};
    }
}

// Disjoint-set / Union-find forest
// Check whether two elements are in the same set or not in O(1)
// Without optimization: Find: O(n)
// 1. Path Compression: make tree flat
// 2. Union by rank: Merge low rank tree to high rank one.
// rank ----> the complexity of the tree, it could be the depth or the count of nodes
class UnionFindSet {
	private int[] parents;
	private int[] ranks;
	
	public UnionFindSet(int n) {
		parents = new int[n + 1];
		ranks = new int[n + 1];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
			ranks[i] = 1;
		}
	}
	
	// Merge two clusters
	// TC: O(amortized(n)*) ~~ O(1)
	public boolean union(int u, int v) {
		int pu = find(u);
		int pv = find(v);
		if (pu == pv) return false;
		
		if (ranks[pu] > ranks[pv]) {
			parents[pv] = pu;
		} else if (ranks[pu] < ranks[pv]) {
			parents[pu] = pv;
		} else {
			parents[pv] = pu;
			ranks[pu] += 1;
		}
		return true;
	}
	
	// get the root/cluster-id of u
	// TC: O(amortized(n)*) ~~ O(1)
	public int find(int u) {
		while (parents[u] != u) {
			parents[u] = parents[parents[u]];//!!! two steps
			u = parents[u];
		}
		return u;
	}
}