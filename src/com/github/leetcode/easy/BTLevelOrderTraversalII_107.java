package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversalII_107 {

	public static void main(String[] args) {
		BTLevelOrderTraversalII_107 obj = new BTLevelOrderTraversalII_107();
		
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		System.out.println("Cai Test = " + obj.levelOrderBottom(node1));
	}
	
	// 1 ms, faster than 88.42%
	// Approach 1: Iterative way
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> ans = new LinkedList<>();
		if (root == null) return ans;// !!! Don't forget!
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		List<Integer> lineValues;
		TreeNode cur;
		while (!queue.isEmpty()) {
			int size = queue.size();
			lineValues = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				cur = queue.poll();
				lineValues.add(cur.val);
				
				if (cur.left != null) queue.offer(cur.left);
				if (cur.right != null) queue.offer(cur.right);
			}
			ans.addFirst(lineValues);// O(1) TC
		}
        return ans;
    }
	
//	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
//			ans.add(0, lineValues);// O(N) TC
//		}
//        return ans;
//    }
}
