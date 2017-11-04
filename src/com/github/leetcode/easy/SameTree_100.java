package com.github.leetcode.easy;

/**
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * @author Samuel
 *
 */
public class SameTree_100 {

	public static void main(String[] args) {
		TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;

		System.out.println("Samuel Test sumOfLeftLeaves = " + isSameTree(node3, node20));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		
		if (p == null || q == null) {
			return false;
		}
		
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
        return false;
    }
}
