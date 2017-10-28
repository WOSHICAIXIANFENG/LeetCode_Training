package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * @author Samuel
 *
 */
public class BinaryTreeZLevelOrder_103 {

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
		
		System.out.println("Samuel Test zigzagLevelOrder result = " + zigzagLevelOrder(node3));
	}
	
	// O(n) solution by using LinkedList along with ArrayList. So insertion in the inner List and outer list are both O(1)
	// Using DFS and creating new Lists when needed.
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<>();
		doTraversal(root, results, 0);
		return results;
    }
	
	public static void doTraversal(TreeNode curr, List<List<Integer>> sol, int level) {
		if (curr == null) {
			return;
		}
		
		if (sol.size() <= level) {
			List<Integer> newLevel = new LinkedList<>();
			sol.add(newLevel);
		}
		
		List<Integer> collection = sol.get(level);
		if (level % 2 == 0) {
			collection.add(curr.val);
		} else {
			collection.add(0, curr.val);// use LinkedList has better performance
		}
		
		doTraversal(curr.left, sol, level + 1);
		doTraversal(curr.right, sol, level + 1);
	}

}
