package com.github.leetcode.medium;

/**
 * Property of a binary search tree:
 * a. root.val > all vals in L
 * b. root.val < all vals in R
 * c. Inorder traversal, vals are sorted.
 */
public class ValidateBST_98 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		
		System.out.println("Cai Test = " + isValidBST(node1)); // true
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(6);
		n3.left = n4;
		n3.right = n5;
		System.out.println("Cai Test = " + isValidBST(n1)); // false
	}
	
	// 0 ms, faster than 100.00%
	// Approach 2: In order traverse BST to get a sorted array, check current value with prev value
	// Time Complexity: O(n)
	// Space Complexity: O(h)
	
	private static Integer prev;
	public static boolean isValidBST(TreeNode root) {
		prev = null;
		return inOrder(root);
	}
	
	public static boolean inOrder(TreeNode root) {
		if (root == null) return true;
		if (!inOrder(root.left)) {
			return false;
		}
		if (prev != null) {
			if (prev >= root.val) {
				return false;
			}
		}
		prev = root.val;
		return inOrder(root.right);
	}
	
	// 0 ms, faster than 100.00%
	// Approach 1: Limit the value range for the sub-trees
	// Time Complexity: O(n)
	// Space Complexity: O(h)
//	public static boolean isValidBST(TreeNode root) {
//		// as the val of TreeNode could be Integer.MAX_VALUE
//		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//	}
//	
//	public static boolean isValidBST(TreeNode root, long min_val, long max_val) {
//		if (root == null) {
//			return true;
//		}
//		
//		if (root.val <= min_val || root.val >= max_val) {
//			return false;
//		}
//		return isValidBST(root.left, min_val, root.val) 
//			&& isValidBST(root.right, root.val, max_val);
//	}
	
	// The left subtree of a node contains only nodes with keys less than the node's key
	// The right subtree of a node contains only nodes with keys great then the node's key
	
	// 我的错误提交！！！
	// Time Complexity: O(N)
	// Space Complexity: O(H)
	// 提交错误!!! --- 原因是 你需要检查左右子树上所有节点值均小于／大于 根节点 
	// BST 的定义：
	/**
	 * 是指一棵空树或者具有下列性质的二叉树：
		若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
		若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
		任意节点的左、右子树也分别为二叉查找树；
		没有键值相等的节点。
	 * @param root
	 * @return
	 */
//	public static boolean isValidBST(TreeNode root) {
//		if (root == null) {
//			return true;
//		}
//		
//		if (root.left != null && root.left.val >= root.val) {
//			return false;
//		}
//		if (root.right != null && root.right.val <= root.val) {
//			return false;
//		}
//				
//        return isValidBST(root.left) && isValidBST(root.right);
//    }
}
