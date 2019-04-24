package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

 * @author Samuel
 *
 */
public class FindModeInBST_501 {

	public static void main(String[] args) {
		FindModeInBST_501 obj = new FindModeInBST_501();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		node1.right = node2;
		node2.left = node3;
		System.out.println("Cai Test = " + Arrays.toString(obj.findMode(node1)));
	}
	
	// Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
	
	// 2 ms, faster than 94.16%
	// Approach 1:  In order BST
	private Integer prev;
	private int count;
	private int maxCount;
	public int[] findMode(TreeNode root) {
		maxCount = 0;
		prev = null;
		count = 0;
		
		List<Integer> modes = new ArrayList<>();
		inOrder(root, modes);
		int[] ans = new int[modes.size()];
		int index = 0;
        for (Integer mode : modes) {
        	ans[index++] = mode;
        }
        return ans;
    }
	
	// A little bit cleaner
	public void inOrder(TreeNode root, List<Integer> modes) {
		if (root == null) return;
		inOrder(root.left, modes);
		if (prev != null) {
			if (root.val != prev) {
				count = 1;
			} else {
				count++;
			}
		} else {
			count = 1;
		}
		
		if (count > maxCount) {
			modes.clear();
			modes.add(root.val);
			maxCount = count;
		} else if (count == maxCount) {
			modes.add(root.val);
		}
		prev = root.val;
		inOrder(root.right, modes);
	}

	// My Solution 
//	public void inOrder(TreeNode root, List<Integer> modes) {
//		if (root == null) return;
//		inOrder(root.left, modes);
//		if (prev != null) {
//			if (root.val != prev) {
//				count = 1;
//			} else {
//				count++;
//			}
//			
//			if (count > maxCount) {
//				modes.clear();
//				modes.add(root.val);
//				maxCount = count;
//			} else if (count == maxCount) {
//				modes.add(root.val);
//			}
//		} else {
//			count = 1;
//			modes.add(root.val);
//			maxCount = 1;
//		}
//		prev = root.val;
//		inOrder(root.right, modes);
//	}

}
