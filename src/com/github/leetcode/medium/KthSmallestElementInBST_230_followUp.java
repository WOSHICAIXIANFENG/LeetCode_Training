package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class KthSmallestElementInBST_230_followUp {

	public static void main(String[] args) {
		KthSmallestElementInBST_230_followUp obj = new KthSmallestElementInBST_230_followUp();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(2);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		System.out.println("Cai Test = " + obj.kthSmallest(node1, 1));
	}

	// !!! Follow UP:
	/**
	 * What if the BST is modified (insert/delete operations) often and you need 
	 * to find the kth smallest frequently? 
	 * How would you optimize the kthSmallest routine?
	 */
	// Solution: If we could add a count field in the BST node class, 
	// it will take O(n) time when we calculate the count value for the whole tree, 
	// but after that, it will take O(logn) time when insert/delete a node or calculate the kth smallest element.
	public int kthSmallest(TreeNode root, int k) {
		TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
		System.out.println("Cai Test = " + print(rootWithCount));
		return kthSmallest(rootWithCount, k);
	}
	
	private TreeNodeWithCount buildTreeWithCount(TreeNode root) {
		if (root == null) return null;
		TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
		rootWithCount.left = buildTreeWithCount(root.left);
		rootWithCount.right = buildTreeWithCount(root.right);
		if (rootWithCount.left != null) {
			rootWithCount.count += rootWithCount.left.count;
		}
		if (rootWithCount.right != null) {
			rootWithCount.count += rootWithCount.right.count;
		}
		return rootWithCount;
	}
	
	// !!!
	// Use binary Search solution to figure out kthSmallest ele
	private int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
		if (k <= 0 || k > rootWithCount.count) return -1;
		
		if (rootWithCount.left != null) {
			if (rootWithCount.left.count >= k) return kthSmallest(rootWithCount.left, k);
			if (rootWithCount.left.count == k - 1) return rootWithCount.val;
			return kthSmallest(rootWithCount.right, k - 1 - rootWithCount.left.count);
		} else {
			if (k == 1) return rootWithCount.val;
			return kthSmallest(rootWithCount.right, k - 1);
		}
	}
	
	public String print(TreeNodeWithCount root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNodeWithCount> queue = new LinkedList<>();
		queue.offer(root);
		
		TreeNodeWithCount currNode; 
		while (!queue.isEmpty()) {
			currNode = queue.poll();
			sb.append(currNode + " -- ");
			if (currNode.left != null) {
				queue.offer(currNode.left);
			}
			if (currNode.right != null) {
				queue.offer(currNode.right);
			}
		}
		return sb.toString();
	}
	
	class TreeNodeWithCount {
		int val;
        int count;
        TreeNodeWithCount left;
        TreeNodeWithCount right;
        
        TreeNodeWithCount(int x) {
        	val = x; count = 1;
        }

		@Override
		public String toString() {
			return "[val=" + val + ", count=" + count + "]";
		};
	}
}
