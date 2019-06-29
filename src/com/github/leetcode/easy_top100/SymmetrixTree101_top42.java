package com.github.leetcode.easy_top100;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetrixTree101_top42 {

	public static void main(String[] args) {
		SymmetrixTree101_top42 obj = new SymmetrixTree101_top42();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node2_2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		
		node1.left = node2;
		node1.right = node2_2;
		node2.left = node3;
		node2.right = node4;
		
		node2_2.left = node4;
		node2_2.right = node3;

		System.out.println("Samuel Test isSymmetric = " + obj.isSymmetric(node1));
	}
	
	/**
	 * Queue: Compare LinkedList VS ArrayDeque
	 * a. LinkedList support Null,  ArrayDeque Does not.
	 * b. if you need add/remove of the both ends, ArrayDeque is significantly better than a linked list.
	 * c. LinkedList -- Safe removing the current ele during iteration
	 * d. Internal implementation is different.  ArrayDequeue use an internal array
	 * 
	 * Accessing an element in ArrayDeque is always faster compared to LinkedList with O(1) for accessing elements. 
	 * In Linked list, it will take O(N) to find last element.
	 * 
	 * ArrayDeque is memory efficient since you don't have to keep track of next node unlike in Linked List.
	 * 
	 */
	
	// 1 ms, faster than 35.51%
	// Approach 2: Iterative ---- It's very hard to figure out.
	// idea: Use Queue, "make a clone tree", tree1 from left, tree2 from right
	// TC: O(n)
	// SC: O(n)
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur1 = queue.poll();
			TreeNode cur2 = queue.poll();
			if (cur1 == null && cur2 == null)
				continue;//!!! ---- Not return true;!!!
			if (cur1 == null || cur2 == null)
				return false;
			if (cur1.val != cur2.val)
				return false;
			
			queue.offer(cur1.left);
			queue.offer(cur2.right);
			queue.offer(cur1.right);
			queue.offer(cur2.left);
		}
		return true;
	}
	
	// 0 ms, faster than 100.00%
	
	// Approach 1: Recursion
	// TC: O(n) --- we traverse the entire input tree once.
	// SC: O(n) --- the worst case, the tree is linear and its height is O(n).
	// the SC due to recursive calls on the stack is O(n) in the worst case.
	public boolean isSymmetric2(TreeNode root) {
		return root == null || isSymmetricHalf(root.left, root.right);
	}
	
	public boolean isSymmetricHalf(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		
		if (left == null || right == null) 
			return false;
		
		if (left.val != right.val) {
			return false;
		}
		
		return isSymmetricHalf(left.left, right.right) && isSymmetricHalf(left.right, right.left);
	}
}
