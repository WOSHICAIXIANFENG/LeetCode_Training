package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class BTMaximumPathSum_124_best {

	public static void main(String[] args) {
		BTMaximumPathSum_124_best obj = new BTMaximumPathSum_124_best();
		
		TreeNode n1 = new TreeNode(-10);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		System.out.println("Cai Test = " + obj.maxPathSum(n1));
		
		obj.maxPathSum = Integer.MIN_VALUE;
		TreeNode b1 = new TreeNode(2);
		TreeNode b2 = new TreeNode(-1);
		b1.left = b2;
		System.out.println("Cai Test = " + obj.maxPathSum(b1));
	}
	
	// 1 ms, faster than 99.67%
	
	// 最优解 ---- Best Solution --- Simple & Beautiful
	// Approach 3: DFS
	// TC: O(N)
	// SC: O(H)
	private int maxPathSum = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if(root == null) return 0;
        dfs(root);
        return maxPathSum;
    }
	
	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int left = Math.max(dfs(root.left), 0);
		int right = Math.max(dfs(root.right), 0);
		maxPathSum = Math.max(root.val + left + right, maxPathSum);
		return Math.max(left, right) + root.val;
	}
}
