package com.github.leetcode.easy;

// Two Solutions:
// https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better
public class BalancedBinaryTree_110 {

	public static void main(String[] args) {
		BalancedBinaryTree_110 obj = new BalancedBinaryTree_110();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		System.out.println("Cai Test = " + obj.isBalanced(node1));
	}

	// 又被称为AVL树（有别于AVL算法），且具有以下性质：
	// 它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		return dfsHeight(root) != -1;
	}
	
	// TC: O(N)
	// SC: O(H)
	public int dfsHeight(TreeNode root) {
		if (root == null) return 0;
		
		int leftHeight = dfsHeight(root.left);
		if (leftHeight == -1) return -1;
		
		int rightHeight = dfsHeight(root.right);
		if (rightHeight == -1) return -1;
		
		if (Math.abs(leftHeight - rightHeight) > 1) return -1;
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
