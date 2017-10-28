package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 * 
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]


 * @author Samuel.Cai
 */
public class BinaryTreePaths_257 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node2.right = node5;
		node1.right = node3;
		
		System.out.println("Samuel Test binaryTreePaths = " + binaryTreePaths(node1));
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> answer = new ArrayList<String>();
		if (root != null)
			searchBT(root, "", answer);
        return answer;
    }
	
	public static void searchBT(TreeNode root, String path, List<String> answer) {
		if (root.left == null && root.right == null) {
			answer.add(path + root.val);
		} 
		
		if (root.left != null) {
			searchBT(root.left, path + root.val + "->", answer);
		} 
		
		if (root.right != null) {
			searchBT(root.right, path + root.val + "->", answer);
		}
	}
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { 
    	  val = x; 
    	  }
  }
 

