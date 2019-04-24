package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class MiniAbsoluteDifferenceInBST_530 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(2);
		node1.right = node2;
		node2.left = node3;
		System.out.println("Cai Test = " + getMinimumDifference(node1));
	}
	
	private static int minDif;
	private static Integer prev;
	
	// 5 ms, faster than 100.00%
	
	// How to improve Approach 1?  --- we can only remember the previous value to avoid O(n) space consume
	public static int getMinimumDifference(TreeNode root) {
		minDif = Integer.MAX_VALUE;
		prev = null;
		inOrder(root);
		return minDif;
	}
	
	public static void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		if (prev != null) {
			if (minDif > root.val - prev) {
				minDif = root.val - prev;
			}
		}
		prev = root.val;
		inOrder(root.right);
	}

	// 7 ms, faster than 61.63% 
	
	// Approach 1: In order traverse
	// BST property:
	// Vals are sorted if traverse the tree in-order
	// Compare the adjacent elements to get the min_diff
	// Time Complexity: O(N)
	// Space Complexity: O(N)
//	public static int getMinimumDifference(TreeNode root) {
//		List<Integer> values = new ArrayList<Integer>();
//		inOrder(root, values);
//		System.out.println("Cai Test values = " + values);
//		
//		// !!! how to do initialization ?  You can set miniDiff = Integer.MAX_VALUE or Max(nums)
//		int miniDiff = values.get(values.size() - 1);
//		for (int i = 0; i < values.size() - 1; i++) {
//			if (values.get(i + 1) - values.get(i) < miniDiff) {
//				miniDiff = values.get(i + 1) - values.get(i);
//			}
//		}
//        return miniDiff;
//    }
//	
//	public static void inOrder(TreeNode root, List<Integer> nodeList) {
//		if (root == null) return;
//		inOrder(root.left, nodeList);
//		nodeList.add(root.val);
//		inOrder(root.right, nodeList);
//	}
}
