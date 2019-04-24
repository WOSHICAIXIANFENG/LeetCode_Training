package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepthOfNArryTree_559_S2 {

	public static void main(String[] args) {
		Node node5 = new Node(5, null);
		Node node6 = new Node(6, null);
		List<Node> kids1 = new ArrayList<Node>();
		kids1.add(node5);
		kids1.add(node6);
		Node node3 = new Node(3, kids1);
		Node node4 = new Node(4, null);
		Node node2 = new Node(2, null);
		List<Node> kids2 = new ArrayList<Node>();
		kids2.add(node3);
		kids2.add(node2);
		kids2.add(node4);
		Node node1 = new Node(1, kids2);
		System.out.println("Cai Test = " + maxDepth(node1));

	}
	
	// 2 ms, faster than 99.95% 
	// Recursive way ---- O(n)
//	public static int maxDepth(Node root) {
//		if (root == null) return 0;
//		
//		if (root.children == null || root.children.size() == 0) {
//			return 1;
//		}
//		
//		int maxChildDp = 0;
//		if (root.children != null) {
//			for (Node child : root.children) {
//				int depth = maxDepth(child);
//				maxChildDp = Math.max(maxChildDp, depth);
//			}
//		}
//		
//		return maxChildDp + 1;
//	}

	// Approach 2: Iterative Way to solve it
	public static int maxDepth(Node root) {
		if (root == null) return 0;
		
		int maxDepth = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size(); // how many nodes in the same level
			
			maxDepth ++;
			// try to poll all siblings / brothers of the same level
			for (int i = 0; i < size; i++) {
				Node currNode = queue.poll();
				
				if (currNode.children != null) {
					for (Node child : currNode.children) {
						queue.offer(child);
					}
				}
			}
		}
		
		return maxDepth;
	}
}
