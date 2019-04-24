package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class BTPruning_814 {

	public static void main(String[] args) {
		BTPruning_814 obj = new BTPruning_814();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(0);
		TreeNode n4 = new TreeNode(1);
		n1.right = n2;
		n2.left = n3;
		n2.right = n4;
		System.out.println("Cai Test = " + obj.pruneTree(n1));
	}
	
	//0 ms, faster than 100.00%
	// Approach 1: DFS --- recursion
	// TC: O(N)
	// SC: O(h) --- skewed tree --- O(N)
	public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode pruneLeft = pruneTree(root.left);
        TreeNode pruneRight = pruneTree(root.right);
        if (root.val == 0 && pruneLeft == null && pruneRight == null) {
        	return null;
        } else {
        	root.left = pruneLeft;
        	root.right = pruneRight;
        	return root;
        }
    }
	
	// Approach 2: Iterative  ---- 很难！！！ 我想不起来！！！
}
