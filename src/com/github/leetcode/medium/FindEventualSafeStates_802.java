package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindEventualSafeStates_802 {

	public static void main(String[] args) {
		FindEventualSafeStates_802 obj = new FindEventualSafeStates_802();
		int[][] g1 = {
				{1, 2},
				{2, 3},
				{5},
				{0},
				{5},
				{},
				{}
		};
		System.out.println("Cai Test = " + obj.eventualSafeNodes(g1));
	}
	
	/**
	 * graph will have length at most 10000.
	 * The number of edges in the graph will not exceed 32000.
	 * 
	 * --------> We can't use O(n^2) solution, we have to figure out a better way which is O(n) time consume.
	 */
	
	// 5 ms, faster than 100.00%
	
	// Approach 1: Topological Sorting --- DFS to finding Cycles
	// A node is safe if and only if: itself and all of its neighbours do not have any cycles
	// TC: O(V + E)
	// SC: O(V + E)
	public List<Integer> eventualSafeNodes(int[][] graph) {
		// visited array
		State[] visited = new State[graph.length]; // 0 ---> UNKOWN, 1 --> Visiting, 2 --> Safe, 3 --> UnSafe
		for (int i = 0; i < graph.length; i++) {
			visited[i] = State.UNKNOWN;
		}
		
		List<Integer> ans = new ArrayList<>();
		
		for (int i = 0; i < graph.length; i++) {
			if (dfs(i, visited, graph) == State.SAFE) {
				ans.add(i);
			}
		}
		System.out.println("Cai Test visited = " + Arrays.toString(visited));
        return ans;
    }
	
	enum State{
		UNKNOWN, VISITING, SAFE, UNSAFE	
	}
	
	// use dfs alg to find if it has cycle
	public State dfs(int cur, State[] visited, int[][] graph) {
		if (visited[cur] == State.VISITING) {// visiting
			visited[cur] = State.UNSAFE;// this is a cycle
		}
		if (visited[cur] != State.UNKNOWN) {// Unknown is a initial state
			return visited[cur];
		}
		
		visited[cur] = State.VISITING;
		// use dfs alg to check the path will meet it's self --- check if it has a cycle
		for (int next : graph[cur]) {
			if (dfs(next, visited, graph) == State.UNSAFE) {
				visited[cur] = State.UNSAFE;
				return State.UNSAFE; 
			}
		}
		visited[cur] = State.SAFE;
		return State.SAFE;
	}
}
