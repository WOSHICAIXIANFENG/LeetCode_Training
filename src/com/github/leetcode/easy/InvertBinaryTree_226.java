package com.github.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(7);
		
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(9);;

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		System.out.println("Cai Test invertTree = " + printTree(invertTree(node1)));
	}
	
	public static String printTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		String result = "";
		while (!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			result += (currNode.val + " --> ");
			if (currNode.left != null)
				queue.add(currNode.left);
			if (currNode.right != null)
				queue.add(currNode.right);
		}
		return result;
	}

	// 0 ms, faster than 100.00%
	// Approach #1 --- Recursive
	// Time Complexity: O(n) ---- each node in the tree is visited only once. we cannot do better than that
	// since at the very least we have to visit each node to invert it. 
	// Space Complexity: O(h) --- O(h) functions calls will be placed on the stack in the worst case
	// where h is the height of the tree. Since h belongs O(n), so the space complexity is O(n).
//	public static TreeNode invertTree(TreeNode root) {
//		if (root == null) {
//			return null;
//		}
//		
//		TreeNode leftTree = invertTree(root.left);
//		TreeNode rightTree = invertTree(root.right);
//		
//		root.left = rightTree;
//		root.right = leftTree;
//        return root;
//    }
	
	// Approach #2 (Iterative)
	// Time Complexity: Since each node in the tree is visited / added to the queue only once, the time complexity is O(n)
	// Space Complexity: O(n). since in the worst case, the queue will contain all nodes in one level of the binary tree.
	// For a full binary tree, the leaf level has n/2 = O(n) leaves.
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			TreeNode leftTree = currNode.left;
			TreeNode rightTree = currNode.right;
			currNode.left = rightTree;
			currNode.right = leftTree;
			
			if (leftTree != null) {
				queue.add(leftTree);
			}
			
			if (rightTree != null) {
				queue.add(rightTree);
			}
		}
		return root;
	}
}
