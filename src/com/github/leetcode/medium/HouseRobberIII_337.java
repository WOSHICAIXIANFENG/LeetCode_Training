package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII_337 {

	public static void main(String[] args) {
		HouseRobberIII_337 obj = new HouseRobberIII_337();
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(1);
		
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n3.right = n5;
		System.out.println("Cai Test = " + obj.rob(n1));//7
	}
	
	// 0 ms, faster than 100.00%
	// Approach 3: DP with constant SC
	// TC: O(N)
	// SC: O(1)
	public int rob(TreeNode root) {
		int[] dp = robSub(root);
		return Math.max(dp[0], dp[1]);
	}
	
	// dp[0] --- not rob current node, max value
	// dp[1] --- rob current node, max value
	public int[] robSub(TreeNode root) {
		if (root == null) return new int[2];
		int[] left = robSub(root.left);
		int[] right = robSub(root.right);
		int[] dp = new int[2];
		dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		dp[1] = root.val + left[0] + right[0];
		return dp;
	}
	
	// 4 ms, faster than 54.61%
	// Approach 2: Recursion with memorization 
	// TC: O(N)
	// SC: O(N)
//	private Map<TreeNode, Integer> memory = new HashMap<>();
//	public int rob(TreeNode root) {
//		if (root == null) return 0;
//		if (memory.containsKey(root)) return memory.get(root);
//		
//		int val = root.val;
//		int ll = root.left != null ? rob(root.left.left) : 0;
//		int lr = root.left != null ? rob(root.left.right) : 0;
//		int rl = root.right != null ? rob(root.right.left) : 0;
//		int rr = root.right != null ? rob(root.right.right) : 0;
//		
//		int maxValue = Math.max(val + ll + lr + rl + rr, rob(root.left) + rob(root.right));
//		memory.put(root, maxValue);
//		return maxValue;
//	}

	// 595 ms, faster than 27.32% 
	// Approach 1: Recursion w/o memorization 
	// TC: O(n^2)
	// SC: O(n)
	// idea: compare grandparent value + rob(grandchildren())
	// VS  rob(children l + r)
//	public int rob(TreeNode root) {
//        if (root == null) return 0;
//        int val = root.val;
//        int ll = root.left != null ? rob(root.left.left) : 0;
//        int lr = root.left != null ? rob(root.left.right) : 0;
//        int rl = root.right != null ? rob(root.right.left) : 0;
//        int rr = root.right != null ? rob(root.right.right) : 0;
//        return Math.max(val + ll + lr + rl + rr, rob(root.left) + rob(root.right));
//    }
}
