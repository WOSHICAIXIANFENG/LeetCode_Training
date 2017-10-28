package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @author Samuel
 *
 */
public class BinaryTreeLevelOrderTraversal_102 {

	public static void main(String[] args) {
		TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;

		System.out.println("Samuel Test levelOrderBottom = " + levelOrder(node3));
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		int level = 0;
		// for ArrayList ----- add(),get() -- O(1) --- contains() --- O(n)
		List<List<Integer>> results = new ArrayList<>();
		doTraversal(root, results, level);
		return results;
	}
	
	public static void doTraversal(TreeNode root, List<List<Integer>> results, int level) {
		if (root == null) return;
		
		if (results.size() <= level) {
			results.add(new ArrayList<>());
		}
		
		results.get(level).add(root.val);
		
		doTraversal(root.left, results, level + 1);
		doTraversal(root.right, results, level + 1);
	}
}
