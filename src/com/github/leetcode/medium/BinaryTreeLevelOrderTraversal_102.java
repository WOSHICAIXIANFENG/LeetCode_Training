package com.github.leetcode.medium;
import java.util.*;

/**
 *  3
   / \
  9  20
    /  \
   15   7
   
 * @author Samuel
 *
 */
public class BinaryTreeLevelOrderTraversal_102 {

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal_102 lot = new BinaryTreeLevelOrderTraversal_102();
		
		TreeNode2 node3 = new TreeNode2(3);
		TreeNode2 node9 = new TreeNode2(9);
		TreeNode2 node20 = new TreeNode2(20);
		TreeNode2 node15 = new TreeNode2(15);
		TreeNode2 node7 = new TreeNode2(7);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
		
		List<List<Integer>> result = lot.levelOrder(node3);
		System.out.println("Samuel Test result = " + result);
	}
	
	public List<List<Integer>> levelOrder(TreeNode2 root) {
		Queue<TreeNode2> queue = new LinkedList<>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		
		if (root == null) {
			return wrapList;
		}
		
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i ++) {
				if (queue.peek().left != null) {
					queue.offer(queue.peek().left);
				}
				
				if (queue.peek().right != null) {
					queue.offer(queue.peek().right);
				}
				subList.add(queue.poll().val);
			}
			wrapList.add(subList);
		}
		
		return wrapList;
	}

}

class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;
	
	TreeNode2(int x) {
		val = x;
	}
}
