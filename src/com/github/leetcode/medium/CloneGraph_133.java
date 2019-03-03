package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph_133 {
	private HashMap<Integer, UndirectedGraphNode> data = new HashMap<>();
	

	public static void main(String[] args) {
		CloneGraph_133 cg = new CloneGraph_133();
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
		return cloneNode(node);
	}
	
	public UndirectedGraphNode cloneNode(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		
		if (data.containsKey(node.label)) {
			return data.get(node.label);
		}
		
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		data.put(node.label, newNode);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			newNode.neighbors.add(cloneNode(neighbor));
		}
		
		return newNode;
	}

}

// Definition for undirected graph
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	
	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Label = " + label);
	
		for (UndirectedGraphNode node : neighbors) {
			sb.append("," + node.label);
		}
		sb.append("#");
		for (UndirectedGraphNode node : neighbors) {
			if (label == node.label) {
				break;
			}
			sb.append(node);
		}
		
		return sb.toString();
	}
}