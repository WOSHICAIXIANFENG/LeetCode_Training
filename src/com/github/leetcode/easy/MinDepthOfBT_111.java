package com.github.leetcode.easy;

public class MinDepthOfBT_111 {

	public static void main(String[] args) {
		MinDepthOfBT_111 obj = new MinDepthOfBT_111();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		System.out.println("Cai test = " + obj.minDepth(node1));
		
		TreeNode b1 = new TreeNode(1);
		TreeNode b2 = new TreeNode(2);
		b1.left = b2;
		System.out.println("Cai test = " + obj.minDepth(b1));// should return 2
	}

	// 0 ms, faster than 100.00%
	public int minDepth(TreeNode root) {
		return minDepth(root, 1);
    }
    
    public int minDepth(TreeNode root, int depth) {
        if (root == null) return depth - 1;
        int leftDepth = minDepth(root.left, depth + 1);
        int rightDepth = minDepth(root.right, depth + 1);
        // if the left sub tree is null, we take rightDepth value
        if (leftDepth == depth) {
        	return rightDepth;
        } else if (rightDepth == depth) {
        	return leftDepth;
        } else {
        	return leftDepth > rightDepth ? rightDepth : leftDepth;
        }
    }
}
