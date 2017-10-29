package com.github.leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
		
		System.out.println("Cai Test preorderTraversal result = " + posorderTraversal(node1));// 52431
	}
	
	// right -- middle -- left
	public static List<Integer> posorderTraversal(TreeNode root) {
//	    List<Integer> results = new ArrayList<>();
//	    Stack<TreeNode> lefts = new Stack<>();
//	    
//	    while(root != null) {
//	    	if (root.left != null) {
//	    		lefts.push(root.left);
//	    	}
//	    	
//	    	if (root.right == null) {
//	    		results.add(root.val);
//	    		
//	    		if (!lefts.isEmpty()) {
//		    		root = lefts.pop();
//		    	}
//	    	} else {
//	    		root = root.right;
//	    	}
//	    }
//	    
//	    return results;
		
		LinkedList<Integer> result = new LinkedList<>();
	    Deque<TreeNode> stack = new ArrayDeque<>();
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	        if(p != null) {
	            stack.push(p);
	            result.addFirst(p.val);  // Reverse the process of preorder
	            p = p.right;             // Reverse the process of preorder
	        } else {
	            TreeNode node = stack.pop();
	            p = node.left;           // Reverse the process of preorder
	        }
	    }
	    return result;
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