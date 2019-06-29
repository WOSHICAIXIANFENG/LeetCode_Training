package com.github.leetcode.easy_top100;

public class DiameterOfBinaryTree543_top31 {

	public static void main(String[] args) {
		DiameterOfBinaryTree543_top31 obj = new DiameterOfBinaryTree543_top31();
	}

	// https://leetcode.com/articles/diameter-of-binary-tree/
	
	// 0 ms, faster than 100.00%
	// Approach 1: Depth-First Search!!!
	// Any path can be written as two arrows from each node. An arraw is a path from root to its leaves
	
	// TC: O(n) --- n is the # of tree node ---- each node will only be accessed one time
	// SC: O(n) --- the worst case: trile tree.
	
	private int diameter; // This path may or may not pass through the root
	public int diameterOfBinaryTree(TreeNode root) {
		this.diameter = 0;
		depth(root);
		return diameter;
	}
	
	public int depth(TreeNode root) {
		if (root == null) return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		// This path may or may not pass through the root
		diameter = Math.max(diameter, left + right);
		return Math.max(left, right) + 1;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}