package com.github.leetcode.hard;

import java.util.Arrays;

public class RedundantConnectionII_685 {

	public static void main(String[] args) {
		RedundantConnectionII_685 obj = new RedundantConnectionII_685();
		// no cycle, but it has duplicate parent
		// case 2: A node v has two parents, return the second edge that creates duplicate parents
		int[][] e2 = {
				{1, 2},
				{1, 3},
				{2, 3}
		};
		System.out.println("Cai Test = " + Arrays.toString(obj.findRedundantDirectedConnection(e2)));
		
		// only has cycle
		// case 1: No duplicate parents, return the first edge that creates the loop
		int[][] e1 = {
				{1, 2},
				{2, 3},
				{3, 4},
				{4, 1},
				{1, 5}
		};
		System.out.println("Cai Test = " + Arrays.toString(obj.findRedundantDirectedConnection(e1)));
		
		// plus every node has exactly one parent
		// has Cycle & duplicate parent
		// case 3: A node v has two parents{u1, u2}, return {u1, v} or {u2, v} that creates the loop
		int[][] e3 = {
				{2, 1},
				{3, 1},
				{4, 2},
				{1, 4}
		};
		System.out.println("Cai Test = " + Arrays.toString(obj.findRedundantDirectedConnection(e3)));
		
		int[][] e4 = {
				{1, 2},
				{2, 3},
				{3, 4},
				{4, 1},
				{1, 5}
		};
		System.out.println("Cai Test = " + Arrays.toString(obj.findRedundantDirectedConnection(e4)));
	}
	
	/**
	 * a rooted tree is a directed graph such that, 
	 * there is exactly one node (the root) for which all other nodes are descendants of this node, 
	 * plus every node has exactly one parent, except for the root node which has no parents.
	 * 
	 * !!! plus every node has exactly one parent ---> so [2,1],[3,1] was wrong, 1 has 2 parents
	 */

	// 1 ms, faster than 99.38%
	// Approach 1: Without Using Union Find
	// TC: O(e) + O(e^2) --- e is # of edge
	// SC: O(e)
	public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        
        int[] ans1 = new int[2];
        int[] ans2 = new int[2];
        // step1: find two edges (ans1 & ans2) that has multiple/two parents
        // (2,1), (3,1) ---> 1 has two parents 2, 3
        boolean dupParents = false;
        // (1, 3) ---> parent is u 1, child is v 3
        for (int[] edge : edges) {
        	int u = edge[0];
        	int v = edge[1];
        	
        	// node v has two parents
        	if (parents[v] > 0) {
        		ans1[0] = parents[v];
        		ans1[1] = v;
        		
        		ans2[0] = u;
        		ans2[1] = v;
        		dupParents = true;
        		// Delete the later edge --- !!! tricy!!!
        		edge[0] = -1;
        		edge[1] = -1;
        	} else {
        		parents[v] = u;
        	}
        }
        
        // Reset parents ---- !!!
        parents = new int[edges.length + 1];
        
        // Step2: check if exists cycle, if the edge in the cycle
        for (int[] edge : edges) {
        	int u = edge[0];
        	int v = edge[1];
        	
        	// Invalid edge (we deleted in the step1)
        	if (u < 0 || v < 0) continue;
        	
        	parents[v] = u;//!!! set parent first, then check if it has cycle
        	
        	if (cycle(v, parents)) {
        		// case 3: 有多个parent,同时也有cycle，这时需要返回那个在环中的edge. case1: 如果没有多个parent的话，就返加那个构成cycle的edge
        		return dupParents ? ans1 : edge;
        	}
        }
        // case 2: 没有cycle，但是有多个parent,则返回后面一个。
        return ans2;// the 
    }
	
	// check if the v is in the cycle.
	// case: 1 --> 2 --> 3 ---- false
	// case: 1 --> 2 --> 3 --> 1 ---- true
	public boolean cycle(int v, int[] parents) {
		int u = parents[v];
		while (u > 0) {
			if (u == v) return true;
			u = parents[u];
		}
		return false;
	}
}
