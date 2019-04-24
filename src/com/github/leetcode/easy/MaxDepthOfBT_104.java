package com.github.leetcode.easy;

public class MaxDepthOfBT_104 {

	public static void main(String[] args) {
		MaxDepthOfBT_104 obj = new MaxDepthOfBT_104();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		System.out.println("Cai Test = " + obj.maxDepth(node1));
	}

	// 0 ms, faster than 100.00%
	public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }
	
	public int maxDepth(TreeNode root, int depth) {
		if (root == null) return depth - 1;
		int leftMax = maxDepth(root.left, depth + 1);
		int rightMax = maxDepth(root.right, depth + 1);
		return leftMax > rightMax ? leftMax : rightMax; // we don't need to take care if left/right subtree is empty case
	}
}
