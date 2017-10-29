package com.github.leetcode.medium;

import java.util.*;

/**
 * 
 * 
 * 1
 /   \
2     3
 \
  5
  
 * @author Samuel
 *
 */
public class BinaryTreeInorder_94 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		node2.right = node5;
		node3.right = node4;
		
		System.out.println("Cai Test preorderTraversal result = " + inorderTraversal(node1));// 25134
		
		System.out.println("Cai Test preorderTraversal result = " + inorderTraversal2(node1));// 25134
		
//		int x = 4;
//		int y = (int) Math.ceil(x %5 + x/5.0);
//		System.out.println("Cai Test preorderTraversal y = " + y);// 
	}
	
	// left --- middle --- right
	public static List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> results = new ArrayList<>();
		traverse(root, results);
		return results;
	}
	
	// Recursive solution
	// left --- middle --- right
	public static void traverse(TreeNode root, List<Integer> results) {
		if (root == null) {
			return;
		}
		traverse(root.left, results);
		results.add(root.val);
		traverse(root.right, results);
	}
		

	// Interative solution
	// left -- middle -- right
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> results = new ArrayList<>();
		Stack<TreeNode> middles = new Stack<>();
		while (root != null || !middles.isEmpty()) {
			// find the leftmost leaf node
			while (root != null) {
				middles.push(root);
				root = root.left;
			}
			
			root = middles.pop();
			results.add(root.val);
			root = root.right;
		}
		
		return results;
	}
}


///**
// * Definition for a binary tree node.
// */
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}