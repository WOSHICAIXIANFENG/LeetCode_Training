package com.github.leetcode.easy;

public class SubtreeOfAnotherTree_572_S2 {

	public static void main(String[] args) {
		SubtreeOfAnotherTree_572_S2 obj = new SubtreeOfAnotherTree_572_S2();
		TreeNode a1 = new TreeNode(3);
		TreeNode a2 = new TreeNode(4);
		TreeNode a3 = new TreeNode(5);
		TreeNode a4 = new TreeNode(1);
		TreeNode a5 = new TreeNode(2);
		TreeNode a6 = new TreeNode(0);
		a1.left = a2;
		a1.right = a3;
		a2.left = a4;
		a2.right = a5;
		a5.left = a6;
		
		TreeNode b1 = new TreeNode(4);
		TreeNode b2 = new TreeNode(1);
		TreeNode b3 = new TreeNode(2);
		b1.left = b2;
		b1.right = b3;
		System.out.println("Cai Test = " + obj.isSubtree(a1, b1));
	}

	// 6 ms, faster than 98.36% 
	// Approach 1: Check if the subTree equals t 
	// TC: O(N*M).
	// SC: O(N). The depth of the recursion tree can go upto n. n refers to the number of nodes in s.
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) return false;
		return equals(s, t) == true || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
	
	public boolean equals(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null) {
			return true;
		}
		if (r1 == null || r2 == null) {
			return false;
		}
		if (r1.val != r2.val) {
			return false;
		}
		
		return equals(r1.left, r2.left) && equals(r1.right, r2.right);
	}
}
