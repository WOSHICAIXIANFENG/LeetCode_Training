package com.github.leetcode.easy;

import javax.xml.soap.Node;

public class DiameterOfBT_543 {

	public static void main(String[] args) {
		DiameterOfBT_543 obj = new DiameterOfBT_543();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		System.out.println("Cai Test = " + obj.diameterOfBinaryTree(n1));
	}
	
	/*
	 * Any path can be written as two arrows (in different directions) from some node, 
	 * where an arrow is a path that starts at some node and only travels down to child nodes.
     * If we knew the maximum length arrows L, R for each child, 
     * then the best path touches L + R + 1 nodes.
	 */
	
	// 0 ms, faster than 100.00%
	// TC: O(N)
	// SC: O(h)
	private int ans;
	public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans - 1; //!!!
    }

	// calculate the depth of each node, the leaf node value is 1
	public int dfs(TreeNode root) {
		if (root == null) return 0;
		int L = dfs(root.left);
		int R = dfs(root.right);
		ans = Math.max(ans, L + R + 1);
		return Math.max(L, R) + 1;
	}
}
