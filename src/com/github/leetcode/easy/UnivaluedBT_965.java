package com.github.leetcode.easy;

public class UnivaluedBT_965 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		System.out.println("Cai Test = " + isUnivalTree(node1));
	}

	// concise solution: 
	public static boolean isUnivalTree(TreeNode root) {
		boolean leftUnival = root.left == null || (root.val == root.left.val && isUnivalTree(root.left));
		boolean rightUnival = root.right == null || (root.val == root.right.val && isUnivalTree(root.right));
		return leftUnival && rightUnival;
	}
	
	// 0 ms, faster than 100.00%
	// TC: O(N)
	// SC: O(H) --- where H is the height of the tree
//	public static boolean isUnivalTree(TreeNode root) {
//		if (root == null) return true;
//        return isUnivalTree(root, root.val);
//    }
//	
//	public static boolean isUnivalTree(TreeNode root, int val) {
//		if (root == null) return true;
//		
//		if (root.val != val) {
//			return false;
//		}
//		return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
//	}
}
