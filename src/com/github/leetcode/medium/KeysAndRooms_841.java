package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms_841 {

	public static void main(String[] args) {
		KeysAndRooms_841 obj = new KeysAndRooms_841();
		List<Integer> a1 = new ArrayList<>();
		a1.add(1);
		a1.add(3);
		List<Integer> a2 = new ArrayList<>();
		a2.add(3);
		a2.add(0);
		a2.add(1);
		List<Integer> a3 = new ArrayList<>();
		a3.add(2);
		List<Integer> a4 = new ArrayList<>();
		a4.add(0);
		
		List<List<Integer>> r1 = new ArrayList<>();
		r1.add(a1);
		r1.add(a2);
		r1.add(a3);
		r1.add(a4);
		System.out.println("Cai Test = " + obj.canVisitAllRooms(r1));// false
	}

	// 2 ms, faster than 81.25%
	// Approach 1 : DFS
	// Check whether the entire graph is a connected component
	// TC: O(V + E)
	// SC: O(V)
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        return visited.size() == rooms.size();
    }
	
	public void dfs(List<List<Integer>> rooms, int cur, Set<Integer> visited) {
		if (visited.contains(cur)) {
			return;
		}
		visited.add(cur);
		// iterate all edges
		for (int key : rooms.get(cur)) {
			dfs(rooms, key, visited);
		}
	}
}
