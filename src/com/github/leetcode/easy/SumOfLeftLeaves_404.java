package com.github.leetcode.easy;

/**
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * @author Samuel
 *
 */
public class SumOfLeftLeaves_404 {

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

		System.out.println("Samuel Test sumOfLeftLeaves = " + sumOfLeftLeaves(node3));
	}

	/**
	 * Recursive method: For given node we check whether its left child is a leaf. 
	 * If it is the case, we add its value to answer, otherwise recursively call method to left child. 
	 * For right child we call method only if it has at least one non-null child.
	 * @param root
	 * @return
	 */
	public static int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				sum += root.left.val;
			} else {
				sum += sumOfLeftLeaves(root.left);
			}
		}
		
		sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
