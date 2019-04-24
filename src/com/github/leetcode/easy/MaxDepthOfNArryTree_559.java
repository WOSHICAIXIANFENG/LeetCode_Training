package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class MaxDepthOfNArryTree_559 {

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

	private static int maxDepth = 0;
	
	// 2 ms, faster than 99.95%
	// Approach 1: Recursive way
	public static int maxDepth(Node root) {
		if (root == null) return 0;
		
		int level = 1;
		maxDepth(level, root);
		
        return maxDepth;
    }
	
	public static void maxDepth(int level, Node root) {
		if (root == null) return;
		
		maxDepth = Math.max(maxDepth, level);
		if (root.children != null) {
			for (Node child : root.children) {
				maxDepth(level + 1, child);
			}
		}
	}
}