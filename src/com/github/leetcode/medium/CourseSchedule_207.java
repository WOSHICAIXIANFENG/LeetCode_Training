package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule_207 {

	public static void main(String[] args) {
		CourseSchedule_207 obj = new CourseSchedule_207();
		int[][] p1 = {
				{1, 0}
		};
		System.out.println("Cai Test = " + obj.canFinish(2, p1));// true
		
		int[][] p3 = {
				{0, 1}
		};
		System.out.println("Cai Test = " + obj.canFinish(2, p3));// true
		
		int[][] p2 = {
				{1, 0},
				{2, 6},
				{1, 7},
				{5, 1},
				{6, 4},
				{7, 0},
				{0, 5}
		};
		System.out.println("Cai Test = " + obj.canFinish(8, p2));// false
	}
	
	/**
	 * You may assume that there are no duplicate edges in the input prerequisites.
	 * --- So you can use List<List<Integer>> to build the graph
	 */
	
	// 3 ms, faster than 96.57% 
	// Approach 2: Topological Sort --- Graph
	// TC: O(n)
	// SC: O(n)
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int prerequisite = prerequisites[i][1];
			graph.get(course).add(prerequisite);
		}
		// !!! for Topological Sort, the visited array has two status --- visiting or visited
		int[] visited = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (dfs(i, graph, visited)) {
				return false;
			}
		}
		return true;
	}
	
	// start from cur Vertex to go through the DFS path
	public boolean dfs(int cur, List<List<Integer>> graph, int[] visited) {
		if (visited[cur] == 1) return true;//cur was visiting status --- cycle found
		if (visited[cur] == 2) return false;//
		
		visited[cur] = 1;//visiting
		for (int next : graph.get(cur)) {
			if (dfs(next, graph, visited)) {
				return true;
			}
		}
		visited[cur] = 2;//visited
		return false;
	}

	
	// 285 ms, faster than 5.01%
	
	// Approach 1: DFS Finding Cycles --- Graph
	// TC: O(n ^ 2) ---- visited array only hold 1 status
	// SC: O(n^2) --- each start Vertex needs a new visited array
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		// course ---> prerequisites
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
        	Set<Integer> pres = graph.getOrDefault(prerequisites[i][0], new HashSet<>());
        	pres.add(prerequisites[i][1]);
        	graph.put(prerequisites[i][0], pres);
        }
        //System.out.println("Cai Test graph was build = " + graph);
        
        for (int i = 0; i < numCourses; i++) {
        	// this array is used by per path, that's why you need to put in here
        	// this visited only has one status --- true or false
        	boolean[] visited = new boolean[numCourses];
        	if (cycle(i, i, visited, graph)) {
        		return false;
        	}
        }
        return true;
    }
	
	// start from cur Vertex, put its edges into visited array, until the edge/prerequisite is itself!!!
	public boolean cycle(int start, int cur, boolean[] visited,  Map<Integer, Set<Integer>> graph) {
		// once you get a prerequisite course is the start course, it means there exists a cycle
		//System.out.println(" Cai Test start = " + start + " , cur = " + cur + " , visited = " + Arrays.toString(visited));
		if (cur == start && visited[start] == true) return true;
		
		if (!graph.containsKey(cur)) return false;
		
		// iterate all edges
		for (int next : graph.get(cur)) {
			//System.out.println(" Cai Test start = " + start + " , next = " + next + " , visited = " + Arrays.toString(visited));
			if (visited[next]) {
				continue;
			}
			visited[next] = true;
			if (cycle(start, next, visited, graph)) {
				return true;
			}
		}
		return false;
	}
}
