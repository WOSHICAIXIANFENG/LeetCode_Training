package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph_133_s2 {
	
	public static void main(String[] args) {
		CloneGraph_133_s2 cg = new CloneGraph_133_s2();
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
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<Integer, UndirectedGraphNode> data = new HashMap<>();
		return dfs(node, data);
	}
	
	public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> data) {
		if (node == null) {
			return null;
		}
		
		if (data.containsKey(node.label)) {
			return data.get(node.label);
		}
		
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		data.put(node.label, newNode);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			newNode.neighbors.add(dfs(neighbor, data));
		}
		
		return newNode;
	}

}