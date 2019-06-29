package com.github.leetcode.medium;

public class FriendCircles_547 {

	public static void main(String[] args) {
		FriendCircles_547 obj = new FriendCircles_547();
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
	public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int n = M.length;
        // visited array to 记录统计过的学生
        boolean[] visited = new boolean[n];
        int ans = 0;
        // M[i][i] == 1 for all students, so M[0][0] is a start point
        for (int i = 0; i < n; i++) {
        	if (visited[i]) continue;
        	++ans;
        	dfs(M, i, n, visited);
        }
        return ans;
    }
	// start from 0th student, visit his all friends --> friend's all friends
	public void dfs(int[][] M, int cur, int n, boolean[] visited) {
		if (visited[cur]) return;
		
		visited[cur] = true;//!!!
		
		// visit all friends
		for (int i = 0; i < n; i++) {
			if (M[cur][i] == 1 && !visited[i]) {
				dfs(M, i, n, visited);
			}
		}
	}
}
