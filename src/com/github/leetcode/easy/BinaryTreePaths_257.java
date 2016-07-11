package com.github.leetcode.easy;

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
		
	}

	public List<String> binaryTreePaths(TreeNode root) {
        return null;
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
 

