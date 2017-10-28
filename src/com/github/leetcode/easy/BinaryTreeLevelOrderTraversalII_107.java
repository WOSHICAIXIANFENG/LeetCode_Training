package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 * @author Samuel
 *
 */
public class BinaryTreeLevelOrderTraversalII_107 {

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

		System.out.println("Samuel Test levelOrderBottom = " + levelOrderBottom(node3));
	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		// for LinkedList ---- add()/Remove() --- O(1)  get() --- O(n) contains() --- O(n)
		// for ArrayList ---- add() get() --- O(1)  ---- contains() O(n)
		List<List<Integer>> results = new LinkedList<>();
		int level = 0;
		doTraversal(root, level, results);
        return results;
    }
	
	public static void doTraversal(TreeNode root, int level, List<List<Integer>>  results) {
		if (root == null) return;
		
		if (results.size() <= level) {
			List<Integer> subList = new ArrayList<>();
			results.add(0, subList);// If you want to use ArrayList(), you have to use this API. But add(Index,obj) -- performance is not good
			//results.add(subList);// this method() doesn't meet the requirement.
		}
		
		doTraversal(root.left, level + 1, results);
		doTraversal(root.right, level + 1, results);
		
		List<Integer> collection = results.get(results.size() - 1 - level);
		collection.add(root.val);
	}

}
