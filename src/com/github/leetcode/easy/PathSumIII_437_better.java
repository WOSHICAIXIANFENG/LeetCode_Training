package com.github.leetcode.easy;

import java.util.HashMap;

public class PathSumIII_437_better {

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
		TreeNode node3 = new TreeNode(-3);
		node1.left = node2;
		node1.right = node3;
		//System.out.println("Cai Test pathSum = " + pathSum(node1, -2));// return 1
		System.out.println("Cai Test pathSum = " + pathSum(node1, -1));// return 1
		
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
	
	// 9 ms, faster than 94.16%
	public static int pathSum(TreeNode root, int sum) {
		// key: the prefix Sum, value: how many ways get to this prefix sum
		HashMap<Integer, Integer> preSum = new HashMap();
		preSum.put(0, 1);
		return helper(root, 0, sum, preSum);
	}
	
	// O(n) Prefix sum method
	public static int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
		if (root == null) return 0;
		
		currSum += root.val;
		int result = preSum.getOrDefault(currSum - target, 0);
		preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
		
		result += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
		
		preSum.put(currSum, preSum.get(currSum) - 1); // !!! because we either find the path in left side or right side.
		// reduce the curr pre sum to avoid one side affect another side when the another side is in traverse
		return result;
	}
}
