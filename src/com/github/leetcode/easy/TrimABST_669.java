package com.github.leetcode.easy;

public class TrimABST_669 {

	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(3);
		TreeNode a2 = new TreeNode(0);
		TreeNode a3 = new TreeNode(4);
		TreeNode a4 = new TreeNode(2);
		TreeNode a5 = new TreeNode(1);
		a1.left = a2;
		a1.right = a3;
		a2.right = a4;
		a4.left = a5;
		System.out.println("Cai Test = " + trimBST(a1, 1, 3));
	}

	// 0 ms, faster than 100.00%
	// TC: O(N)
	// SC: O(H)
	public static TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) return null;
		if (root.val < L) {
			return trimBST(root.right, L, R);
		}
		if (root.val > R) {
			return trimBST(root.left, L, R);
		}
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
        return root;
    }
}
