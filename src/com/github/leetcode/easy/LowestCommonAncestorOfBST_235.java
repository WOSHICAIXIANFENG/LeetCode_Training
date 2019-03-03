package com.github.leetcode.easy;

public class LowestCommonAncestorOfBST_235 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(8);
		
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(9);
		
		TreeNode node8 = new TreeNode(3);
		TreeNode node9 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right = node9;
		
		System.out.println("Cai Test = " + lowestCommonAncestor(node1, node2, node3));
		System.out.println("Cai Test = " + lowestCommonAncestor(node1, node2, node5));
	}
	
	// All of the nodes' values will be unique.
	// p and q are different and both values will exist in the BST.
	
	// 4 ms, faster than 100.00%
	// Approach 2: Iterative Approach
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (p.val < root.val && q.val < root.val) {
				root = root.left;
			} else if (p.val > root.val && q.val > root.val) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

	// 4 ms, faster than 100.00% 
	// p & q is in the tree, no value is equals. 
	// Approach 1: Recursive Approach
//	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		if (p.val < root.val && q.val < root.val) {
//			return lowestCommonAncestor(root.left, p, q);
//		} else if (p.val > root.val && q.val > root.val) {
//			return lowestCommonAncestor(root.right, p, q);
//		} else {
//			return root;
//		}
//    }
}
