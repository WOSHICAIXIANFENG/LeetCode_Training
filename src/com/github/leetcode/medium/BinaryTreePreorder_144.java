package com.github.leetcode.medium;

import java.util.*;

/**
 *    
   1
 /   \
2     3
 \     \
  5     4
  
 * @author Samuel
 *
 */

public class BinaryTreePreorder_144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		node2.right = node5;
		node3.right = node4;
		
		System.out.println("Cai Test preorderTraversal result = " + preorderTraversal(node1));// 12534
		System.out.println("Cai Test preorderTraversal result = " + preorderTraversal2(node1));// 
		System.out.println("Cai Test preorderTraversal result = " + preorderTraversal3(node1));//
	}
	
	public static List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> results = new ArrayList<>();
		if (root == null) {
			return results;
		}
		
		// Divide
		List<Integer> left = preorderTraversal3(root.left);
		List<Integer> right = preorderTraversal3(root.right);
		
		// Conquer
		results.add(root.val);
		results.addAll(left);
		results.addAll(right);
		return results;
	}
	
	
	// middle --- left --- right
	public static List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> results = new ArrayList<>();
		traverse(root, results);
		return results;
	}
	
	// Recursive solution
	// middle --- left --- right
	public static void traverse(TreeNode root, List<Integer> results) {
		if (root == null) {
			return;
		}
		results.add(root.val);
		traverse(root.left, results);
		traverse(root.right, results);
	}

	// Iterative Solution
	// middle --- left --- right
	public static List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> results = new ArrayList<>();
	    Stack<TreeNode> rights = new Stack<>();
	    
	    while(root != null) {
	    	results.add(root.val);
	    	
	    	if (root.right != null) {
	    		rights.push(root.right);
	    	}
	    	root = root.left;
	    	if (root == null && !rights.isEmpty()) {
	    		root = rights.pop();
	    	}
	    }
	    return results;
	}
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
