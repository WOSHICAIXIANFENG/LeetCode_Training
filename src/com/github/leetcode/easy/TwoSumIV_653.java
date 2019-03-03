package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True

 * @author Samuel
 *
 */
public class TwoSumIV_653 {

	public static void main(String[] args) {
		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		
		TreeNode node1 = new TreeNode(1);
		node5.left = node3;
		node5.right = node6;
		node3.left = node2;
		node3.right = node4;
		node6.right = node7;
		int target = 9;
		
		System.out.println("Samuel Test findTarget = " + findTarget(node5, target));
		node6.right = node1;

		System.out.println("Samuel Test findTarget = " + findTarget2(node5, target));
		System.out.println("Samuel Test findTarget = " + findTarget2(node5, target));
	}

	/**
The idea is to use a sorted array to save the values of the nodes in the BST by using an inorder traversal. Then, we use two pointers which begins from the start and end of the array to find if there is a sum k.

Time Complexity: O(n), Space Complexity: O(n).

Issues:  if the tree is not ordered

	 * @param root
	 * @param k
	 * @return
	 */
	public static boolean findTarget(TreeNode root, int k) {
		// for ArrayList  ---- get(index), add(e) --- time complexity is O(1)
		List<Integer> data = new ArrayList<>();
		inorder(root, data);
		System.out.println("Samuel Test findTarget = " + data);
		
		// use two pointers for sorted array
		int head = 0;
		int last = data.size() - 1;
		while (head < last) {
			// for Big numbers
			double avg = data.get(head) + (data.get(last) - data.get(head))/2d;
			if (avg == k/2d) {
				return true;
			} else if (avg > k) {
				last --;
			} else {
				head ++;
			}
			
//			if (data.get(head) + data.get(last) == k) {
//				return true;
//			} else if (data.get(head) + data.get(last) > k) {
//				last --;
//			} else {
//				head ++;
//			}
		}
        return false;
    }
	
	// The idea is to use a sorted array to save the values of the nodes in the BST by using an inorder traversal. 
	public static void inorder(TreeNode root, List<Integer> nums) {
		if (root == null) {
			return;
		}
		
		inorder(root.left, nums);
		nums.add(root.val);
		inorder(root.right, nums);
	}
	
	/**
	 * The idea is to use a hashtable to save the values of the nodes in the BST. 
	 * Each time when we insert the value of a new node into the hashtable, we check if the hashtable contains k - node.val
	 * 
	 * Time Complexity: O(n), Space Complexity: O(n)
	 * @param root
	 * @param k
	 * @return
	 */
	public static boolean findTarget2(TreeNode root, int k) {
		// for HashSet, get()  & contains() its time complexity is O(1)
		HashSet<Integer> set = new HashSet<>();
		return dfs(root, set, k);
	}
	
	public static boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
		if (root == null) {
			return false;
		}
		
		if (set.contains(k - root.val)) {
			return true;
		}
		set.add(root.val);
		return dfs(root.left, set, k) || dfs(root.right, set, k);
	}
}
