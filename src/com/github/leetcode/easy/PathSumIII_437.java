package com.github.leetcode.easy;

public class PathSumIII_437 {

	public static void main(String[] args) {
//		TreeNode node1 = new TreeNode(5);
//		TreeNode node2 = new TreeNode(4);
//		TreeNode node3 = new TreeNode(8);
//		TreeNode node4 = new TreeNode(11);
//		TreeNode node5 = new TreeNode(13);
//		TreeNode node6 = new TreeNode(4);
//		TreeNode node7 = new TreeNode(7);
//		TreeNode node8 = new TreeNode(2);
//		TreeNode node9 = new TreeNode(5);
//		TreeNode node10 = new TreeNode(1);
//		
//		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node3.left = node5;
//		node3.right = node6;
//		node4.left = node7;
//		node4.right = node8;
//		node6.left = node9;
//		node6.right = node10;
//		System.out.println("Cai Test pathSum = " + pathSum(node1, 22));
		
		
		// single node test 
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(-2);
		TreeNode node3 = new TreeNode(0);
		node1.left = node2;
		node1.right = node3;
		System.out.println("Cai Test pathSum = " + pathSum(node1, -2));// return 1
		
//		TreeNode node1 = new TreeNode(10);
//		TreeNode node2 = new TreeNode(5);
//		TreeNode node3 = new TreeNode(-3);
//		TreeNode node4 = new TreeNode(3);
//		TreeNode node5 = new TreeNode(2);
//		TreeNode node6 = new TreeNode(11);
//		TreeNode node7 = new TreeNode(3);
//		TreeNode node8 = new TreeNode(-2);
//		TreeNode node9 = new TreeNode(1);
//		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.right = node6;
//		node4.left = node7;
//		node4.right = node8;
//		node5.right = node9;
//		System.out.println("Cai Test pathSum = " + pathSum(node1, 8));
	}
	
	// 10 ms, faster than 78.04%
	// Typical recursive DFS
	// Space: O(n) due to recursion.
	// Time: O(n^2).
	// pathSumFrom takes O(n)
	// pathSum has recurrence relation T(n) = n + 2T(n/2) = nlogn for balance tree. ---> ???
	// pathSum has recurrence relation T(n) = n + T(n-1) = n^2 for linear tree.
	public static int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		// 注意这里是 pathSum
		return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	
	// The path does not need to start or end at the root or a leaf, but it must go downwards 
	// so, we don't need to check if the node is leaf node
	private static int pathSumFrom(TreeNode node, int sum) {
		if (node == null) return 0;
		// DFS ----> Pre Order search 
		return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
	}
}
