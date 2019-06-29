package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseScheduleII_210 {

	public static void main(String[] args) {
		CourseScheduleII_210 obj = new CourseScheduleII_210();
		int[][] p1 = {
				{1, 0},
				{2, 0},
				{3, 1},
				{3, 2}
		};
		System.out.println("Cai Test = " + Arrays.toString(obj.findOrder(4, p1)));
	}

	// 3 ms, faster than 98.58% 
	// 36 ms, faster than 18.26% --- use stream API
	// Approach 1: Topological Sorting --- Visited Array hold 2 statues --- visiting or visited
	// TC: O(V + E)
	// SC: O(V + E)
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i ++) {
        	graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
        	int course = prerequisites[i][0];
        	int prerequisite = prerequisites[i][1];
        	graph.get(course).add(prerequisite);
        }
        
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
        	if (dfs(i, visited, graph, ans)) {
        		return new int[0];
        	}
        }
        
        // 36 ms, faster than 18.26%
        //return ans.stream().mapToInt(Integer::intValue).toArray();
        
        // 3 ms, faster than 98.58% 
        int[] results = new int[numCourses];
        int i = 0;
        for (int val : ans) {
        	results[i++] = val;
        }
        return results;
    }
	
	public boolean dfs(int cur, int[] visited, List<List<Integer>> graph, List<Integer> ans) {
		if (visited[cur] == 1) return true;// 'cur' was in visiting statue
		if (visited[cur] == 2) return false;// visited by other paths
		
		// mark it as visiting status
		visited[cur] = 1;
		// use dfs to iterate all edges/prerequsite
		for (int next : graph.get(cur)) {
			if (dfs(next, visited, graph, ans)) {
				return true;
			}
		}
		// after visiting, set it to visited status
		visited[cur] = 2;
		
		// I have learnt this Course, put it into ans
		ans.add(cur);
		
		return false;
	}
}
