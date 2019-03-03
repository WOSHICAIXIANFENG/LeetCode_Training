package com.github.leetcode.easy;

public class LongestUnivaluePath_687 {
	static int length; 
	
	public static void main(String[] args) {
//		TreeNode node1 = new TreeNode(5);
//		TreeNode node2 = new TreeNode(4);
//		TreeNode node3 = new TreeNode(5);
//		TreeNode node4 = new TreeNode(1);
//		TreeNode node5 = new TreeNode(1);
//		TreeNode node6 = new TreeNode(5);
//		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.right = node6;
		
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(5);
		TreeNode node8 = new TreeNode(4);
		TreeNode node9 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		
		node3.left = node4;
		node3.right = node5;
		node5.left = node6;
		node5.right = node7;
		node6.left = node8;
		node6.right = node9;
		System.out.println("Cai Test longestUnivaluePath = " + longestUnivaluePath(node1));
	}

	// https://leetcode.com/articles/longest-univalue-path/
	
	// 7 ms, faster than 66.64%
	// Time Complexity: O(n). Where N is the number of nodes in the tree. We precess every node once.
	// Space Complexity: O(H). Where H is the height of the tree, Our recursive call stack could be up to H layers deep.
	public static int longestUnivaluePath(TreeNode root) {
		length = 0;
		arrowLength(root);
        return length;
    }
	
	public static int arrowLength(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = arrowLength(node.left);
		int right = arrowLength(node.right);
		
		int arrowLeft = 0, arrowRight = 0;
		if (node.left != null && node.left.val == node.val) {
			arrowLeft += left + 1;
		}
		if (node.right != null && node.right.val == node.val) {
			arrowRight += right + 1;
		}
		length = Math.max(length, arrowLeft + arrowRight);
		return Math.max(arrowLeft, arrowRight);
	}
}
