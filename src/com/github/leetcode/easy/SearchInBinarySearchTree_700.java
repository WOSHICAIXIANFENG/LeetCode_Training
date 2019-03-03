package com.github.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class SearchInBinarySearchTree_700 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		System.out.println("Cai Test searchBST = " + printTree(searchBST(node1, 2)));
	}
	
	public static String printTree(TreeNode root) {
		if (root == null) {
			return "[]";
		}
		
		String result = "";
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			result += currNode.val + " --- ";
			if (currNode.left != null) {
				queue.add(currNode.left);
			}
			if (currNode.right != null) {
				queue.add(currNode.right);
			}
		}
		
		return "[" + result + "]";
	}

	/**
	 * In order traversal a binary search tree --- you can get a sorted sequences. 
	 * You can sort a sequence by creating a binary search tree. each node insert was the new leaf node. 
	 * Insert a new node, you don't need to move other nodes, just change the pointer from null to new node.
	 * So, search, delete, insert operations' time complexity equal the height of tree. O(logN)
	 * 
	 */
	// Approach1: recursive search
	// 2 ms, faster than 92.75%
	// Time Complexity: O(lgn)
	// Space Complexity: O(h) --- O(n)
//	public static TreeNode searchBST(TreeNode root, int val) {
//		if (root == null) {
//			return null;
//		}
//		
//		if (root.val == val) {
//			return root;
//		}
//		
//		// since this is a binary search tree
//		if (root.val < val) {
//			return searchBST(root.right, val);
//		} else {
//			return searchBST(root.left, val);
//		}
//    }
	
	// Approach #2 (Iterative)
	// 2 ms, faster than 92.75%
	//  Time Complexity: O(lgn)
	//  Space Complexity: For a full binary search tree, the leaf level has n/2 = O(n) leaves. each time we just search half part.
	//  so, the space complexity is O(n/2 + n/2/2 + n/2/2/2 + n) ---- O(logN)
	public static TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			if (currNode.val == val) {
				return currNode;
			} else if (currNode.val < val) {
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
			} else {
				if (currNode.left != null) {
					queue.add(currNode.left);
				}
			}
		}
		return null;
	}
}
