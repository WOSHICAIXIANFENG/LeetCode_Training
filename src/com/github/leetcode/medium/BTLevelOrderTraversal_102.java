package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal_102 {

	public static void main(String[] args) {
		BTLevelOrderTraversal_102 obj = new BTLevelOrderTraversal_102();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		System.out.println("Cai Test = " + obj.levelOrder(node1));
	}
	
	// Approach 2: Recursive Way
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) return ans;
		levelOrder(root, 0, ans);
		return ans;
	}
	
	public void levelOrder(TreeNode root, int level, List<List<Integer>> ans) {
		if (root == null) return;
	
		if (level >= ans.size()) {
			ans.add(new ArrayList<>());
		}
		
		ans.get(level).add(root.val); // level == ans.size() - 1
		levelOrder(root.left, level + 1, ans);
		levelOrder(root.right, level + 1, ans);
	}
	
	// Approach 1: Iterative Way
	// TC: O(N)
	// SC: O(2^(h-1)) --- 2^(h-1) is the number of leaves of a full binary tree
//	public List<List<Integer>> levelOrder(TreeNode root) {
//		List<List<Integer>> ans = new ArrayList<>();
//		if (root == null) return ans;
//		Queue<TreeNode> queue = new LinkedList<>();
//		queue.offer(root);
//		
//		List<Integer> lineValues;
//		TreeNode cur;
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			lineValues = new ArrayList<>();
//			for (int i = 0; i < size; i++) {
//				cur = queue.poll();
//				lineValues.add(cur.val);
//				
//				if (cur.left != null) queue.offer(cur.left);
//				if (cur.right != null) queue.offer(cur.right);
//			}
//			ans.add(lineValues);
//		}
//        return ans;
//    }
}
