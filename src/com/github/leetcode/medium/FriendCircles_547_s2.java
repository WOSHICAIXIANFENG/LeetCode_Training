package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class FriendCircles_547_s2 {

	public static void main(String[] args) {
		FriendCircles_547_s2 obj = new FriendCircles_547_s2();
		int[][] a1 = {
				{1, 1, 0},
				{1, 1, 0},
				{0, 0, 1}
		};
		System.out.println("Cai Test = " + obj.findCircleNum(a1));//2
		
		int[][] a2 = {
				{1, 1, 0},
				{1, 1, 1},
				{0, 1, 1}
		};
		System.out.println("Cai Test = " + obj.findCircleNum(a2));//1
		
		int[][] a3 = {
				{1, 0, 0, 1},
				{0, 1, 1, 0},
				{0, 1, 1, 1},
				{1, 0, 1, 1}
		};
		System.out.println("Cai Test = " + obj.findCircleNum(a3));//1 ！！！
	}

	// Approach 1: DFS ---- Use solution of Leetcode 200
	// 发现答案错误！！！ 原因是对题目的理解不到位。并不等同于 LC 200
	// [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]] --- 4个独立的island, 但是却只有一个朋友圈
	
	// 注：可以不使用visited array，不过那样代码不容易理解
	// http://zxi.mytechroad.com/blog/graph/leetcode-547-friend-circles/
	
	// 1 ms, faster than 100.00%
	
	// Approach 2: DFS --- Find all connected components using DFS
	// TC: O(n*n)
	// SC: O(n) --- visisted --- 记录访问过的学生
	
	// Approach 3: UnionFindSet
	// TC: O(n*n) ---- # of students
	// SC: O(n)
	public int findCircleNum(int[][] M) {
		int n = M.length;
		UnionFindSet s = new UnionFindSet(n);
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) {
				if (M[i][j] == 1) {
					// student i, j are friends, so union/merge them to the same cluster
					s.union(i, j);
				}
			}
		
		// check how many cluster exists
		Set<Integer> ids = new HashSet<>();
		for (int i = 0; i < n; i++)
			ids.add(s.find(i));
		
        return ids.size();
    }
}

// Disjoint Set/ Union Find Set
class UnionFindSet2 {
	private int[] parents;
	private int[] ranks;
	
	public UnionFindSet2(int n) {
		this.parents = new int[n + 1];
		this.ranks = new int[n + 1];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
			ranks[i] = 1;
		}
	}
	
	// TC: O(amortized(1))
	// Union/Merge two tree/cluster together
	public boolean union(int u, int v) {
		int pu = find(u);
		int pv = find(v);
		if (pu == pv) {
			return false;// these two vertexs already in the same cluster
		}
		
		// merge lower rank tree/cluster into the higher one
		if (ranks[pu] < ranks[pv]) {
			parents[pu] = pv;
		} else if (ranks[pu] > ranks[pv]) {
			parents[pv] = pu;
		} else {
			parents[pv] = pu;
			ranks[pu] += 1;//!!!
		}
		return true;
	}
	
	// TC: O(amortized(1))
	// Find the root/cluster id of u
	public int find(int u) {
		while (parents[u] != u) {
			parents[u] = parents[parents[u]];
			u = parents[u];
		}
		return u;
	}
}

