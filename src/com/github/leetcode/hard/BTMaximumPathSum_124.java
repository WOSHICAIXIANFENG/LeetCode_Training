package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class BTMaximumPathSum_124 {

	public static void main(String[] args) {
		BTMaximumPathSum_124 obj = new BTMaximumPathSum_124();
		
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
	
	// 13 ms, faster than 5.03%
	// Approach 2: Approach 1 + memory 
	// TC: O(N)
	// SC: O(N + H)
	private Map<TreeNode, Integer> memory = new HashMap<>();
	private int maxPathSum = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        
        int leftPathSum = maxPath(root.left);
        int rightPathSum = maxPath(root.right);
        //!!!  --- choose 2 arrows or 1 arrow or just a root
        int sum = root.val;
        if (leftPathSum > 0) {
        	sum += leftPathSum;
        }
        if (rightPathSum > 0) {
        	sum += rightPathSum;
        }
        
        if (sum > maxPathSum) {
        	maxPathSum = sum;
        }
        
        maxPathSum(root.left);
        maxPathSum(root.right);
        
        return maxPathSum;
    }
	
	public int maxPath(TreeNode root) {
		if (root == null) return 0;
		int leftMax;
		if (root.left != null && memory.containsKey(root.left)) {
			leftMax = memory.get(root.left);
		} else {
			leftMax = maxPath(root.left);
		}
				
		int rightMax;
		if (root.right != null && memory.containsKey(root.right)) {
			rightMax = memory.get(root.right);
		} else {
			rightMax = maxPath(root.right);
		}
		// chose one arrow or just a root
		int result = Math.max(Math.max(leftMax, rightMax) + root.val, root.val);
		memory.put(root, result);
		return result;
	}
	
	// 179 ms, faster than 5.03%
	
	// Approach 1: Two Arrow Sum --- from parent to child node
	// TC: O(N^2)
	// SC: O(h)
//	private int maxPathSum = Integer.MIN_VALUE;
//	public int maxPathSum(TreeNode root) {
//        if (root == null) return 0;
//        
//        int leftPathSum = maxPath(root.left);
//        int rightPathSum = maxPath(root.right);
//        //!!!  --- choose 2 arrows or 1 arrow or just a root
//        int sum = root.val;
//        if (leftPathSum > 0) {
//        	sum += leftPathSum;
//        }
//        if (rightPathSum > 0) {
//        	sum += rightPathSum;
//        }
//        
//        if (sum > maxPathSum) {
//        	maxPathSum = sum;
//        }
//        
//        maxPathSum(root.left);
//        maxPathSum(root.right);
//        
//        return maxPathSum;
//    }
//	
//	public int maxPath(TreeNode root) {
//		if (root == null) return 0;
//		int leftMax = maxPath(root.left);
//		int rightMax = maxPath(root.right);
//		// chose one arrow or just a root
//		return Math.max(Math.max(leftMax, rightMax) + root.val, root.val);
//	}
}
