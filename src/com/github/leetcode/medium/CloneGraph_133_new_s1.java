package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph_133_new_s1 {
	
	public static void main(String[] args) {
		CloneGraph_133_new_s1 cg = new CloneGraph_133_new_s1();
		// Test
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		node0.neighbors.add(node1);
		node0.neighbors.add(node2);
		node1.neighbors.add(node2);
		node2.neighbors.add(node2);
		
		UndirectedGraphNode cloneGraph = cg.cloneGraph(node0);
		System.out.println("Samuel Test CloneGraph = " + cloneGraph);
	}
	
	// 2 ms, faster than 66.77%
	
	// Approach 1: Queue + Hashtable
	// TC: O(V + E) --- V is total vertexes.  E is total deges
	// SC: O(V + E)
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode start) {
		if (start == null) return null;
		
		// Map original node ---> its clone node
		Map<UndirectedGraphNode, UndirectedGraphNode> vertexMap = new HashMap<>();
		// Queue for Breadth First Search
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		
		queue.offer(start);
		vertexMap.put(start, new UndirectedGraphNode(start.label));
		
		// BFS 
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			// BFS -- iterate over all neighbours
			for (UndirectedGraphNode neighbour : cur.neighbors) {
				if (!vertexMap.containsKey(neighbour)) {
					vertexMap.put(neighbour, new UndirectedGraphNode(neighbour.label));
					queue.add(neighbour);
				}
				
				// Draw the edge from cur's clone to neighbor's clone 
				vertexMap.get(cur).neighbors.add(vertexMap.get(neighbour));
			}
		}
		// return the clone of the start. this is the entry point for the cloned graph section
		return vertexMap.get(start);
	}

}