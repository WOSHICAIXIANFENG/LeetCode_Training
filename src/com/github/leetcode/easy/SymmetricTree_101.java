package com.github.leetcode.easy;

/**
 * 
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 * @author Samuel
 *
 */
public class SymmetricTree_101 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node2_2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		
		node1.left = node2;
		node1.right = node2_2;
		node2.left = node3;
		node2.right = node4;
		
		node2_2.left = node4;
		node2_2.right = node3;

		System.out.println("Samuel Test isSymmetric = " + isSymmetric(node1));
	}
	
	public static boolean isSymmetric(TreeNode root) {
		
        return root == null || isSymmetricHalf(root.left, root.right);
    }
	
	public static boolean isSymmetricHalf(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		
		if (left.val != right.val) {
			return false;
		}
		
		return isSymmetricHalf(left.right, right.left) && isSymmetricHalf(left.left, right.right);
	}

}
