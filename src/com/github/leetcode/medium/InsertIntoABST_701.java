package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class InsertIntoABST_701 {

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
		System.out.println("Cai Test = " + print(insertIntoBST(node1, 5)));
	}
	
	public static String print(TreeNode root) {
		String result = "";
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			result += node.val == Integer.MAX_VALUE ? "null," : node.val + ",";
			if (node.val == Integer.MAX_VALUE) {
				continue;
			}
			if (node.left != null)
				queue.offer(node.left);
			else 
				queue.offer(new TreeNode(Integer.MAX_VALUE));
				
			if (node.right != null)
				queue.offer(node.right);
			else 
				queue.offer(new TreeNode(Integer.MAX_VALUE));
				
		}
		return result;
	}

	// My Solution: 2 ms, faster than 63.54%
	// BST 算法Delete/Insert/Remove 时间依赖于树的拓扑结构。最佳情况是 O(log­2n)，而最坏情况是 O(n)。
	// Time Complexity: O(logN) ---- O(n)
    // Space Complexity: O(h)
	public static TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) return null;
		
		if (val < root.val) {
			if (root.left == null) {
				root.left = new TreeNode(val);
			} else {
				root.left = insertIntoBST(root.left, val);
			}
		} else {
			if (root.right == null) {
				root.right = new TreeNode(val);
			} else {
				root.right = insertIntoBST(root.right, val);
			}
		}
		
		return root;
    }
}
