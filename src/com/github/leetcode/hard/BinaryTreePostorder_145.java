package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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


public class BinaryTreePostorder_145 {
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
		
		System.out.println("Cai Test preorderTraversal result = " + posorderTraversal(node1));// 25134
	}
	
	// right -- middle -- left
	public static List<Integer> posorderTraversal(TreeNode root) {
	    List<Integer> results = new ArrayList<>();
	    Stack<TreeNode> lefts = new Stack<>();
	    
	    while(root != null) {
	    	if (root.left != null) {
	    		lefts.push(root.left);
	    	}
	    	
	    	if (root.right == null) {
	    		results.add(root.val);
	    		
	    		if (!lefts.isEmpty()) {
		    		root = lefts.pop();
		    	}
	    	} else {
	    		root = root.right;
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