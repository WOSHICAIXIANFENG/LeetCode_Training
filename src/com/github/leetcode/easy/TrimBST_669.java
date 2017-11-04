package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
 * @author Samuel
 *
 */
public class TrimBST_669 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node0 = new TreeNode(0);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node1_1 = new TreeNode(1);
		TreeNode node2_2 = new TreeNode(2);
		node1.left = node0;
		node0.left = node1_1;
		node0.right = node2_2;
		node1.right = node2;
		node2.left = node3;

		System.out.println("Samuel test trimBST = " + bfs(trimBST(node1, 1, 2)));
	}

	public static TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null)	return null;
		
		if (root.val < L) 	return trimBST(root.right, L, R);
		if (root.val > R)	return trimBST(root.left, L, R);
		
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
	}
	
	public static List<List<Integer>> bfs(TreeNode root) {
		// for ArrayList ----- add(),get() -- O(1) --- contains() --- O(n)
		List<List<Integer>> results = new ArrayList<>();
		bfs(root, results, 0);
		return results;
	}
	
	public static void bfs(TreeNode root, List<List<Integer>> result, int level) {
		if (root == null)	return;
		
		//result.add
		if (result.size() <= level) {
			result.add(new ArrayList<>());
		}
		
		result.get(level).add(root.val);
		bfs(root.left, result, level + 1);
		bfs(root.right, result, level + 1);
	}
}
