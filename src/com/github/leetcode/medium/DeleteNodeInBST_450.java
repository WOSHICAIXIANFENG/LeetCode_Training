package com.github.leetcode.medium;

public class DeleteNodeInBST_450 {

	public static void main(String[] args) {
		DeleteNodeInBST_450 obj = new DeleteNodeInBST_450();
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(6);
		
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;

		System.out.println("Cai Test = " + obj.deleteNode(node1, 3));
	}

	// if key > root.val ----> deleteNode from rightTree
	// if key < root.val ----> deleteNode from leftTree
	// ----- if key == root.val
	// no leftTree & rightTree ---- delete it
	// has leftTree or rightTree --- delete it and put left/right to its position
	// has leftTree & rightTree 
	// --- delete it, find the mini element of right tree. 
	// s1: exchange miniNode & keyNode value --- delete node from rightTree
	// s2: swap miniNode & keyNode ---
//	public TreeNode deleteNode(TreeNode root, int key) {
//		if (root == null) return null;
//		
//		if (root.val > key) {
//			root.left = deleteNode(root.left, key);
//		} else if (root.val < key) {
//			root.right = deleteNode(root.right, key);
//		} else {
//			// 3 cases
//			if (root.left == null && root.right == null) {
//				// delete root
//				return null;
//			} else if (root.left == null) {
//				// delete root
//				return root.right;
//			} else if (root.right == null) {
//				// delete root
//				return root.left;
//			} else {
//				// case 3: step1 --- find minNode from right sub tree
//				TreeNode minNode = root.right;
//				while (minNode.left != null) minNode = minNode.left;
//				
//				// solution 1 --- swap the val
//				root.val = minNode.val;
//				root.right = deleteNode(root.right, minNode.val);
//			}
//		}
//		return root;
//    }
	
	// 0 ms, faster than 100.00%
	// Time Complexity: O(h)
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return null;
		
		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			// 3 cases
			if (root.left == null && root.right == null) {
				// delete root
				return null;
			} else if (root.left == null) {
				// delete root
				return root.right;
			} else if (root.right == null) {
				// delete root
				return root.left;
			} else {
				// solution 2 --- swap two Nodes
				// case 3: step1 --- find minNode from right sub tree
				TreeNode parent = root;
				TreeNode minNode = root.right;
				while (minNode.left != null) {
					parent = minNode;
					minNode = minNode.left;
				}
				
				// != 判断很重要
				if (parent != root) {
					parent.left = minNode.right;// minNode is the leftest node
					minNode.right = root.right;
				}
				minNode.left = root.left;
				
				// delete root
				return minNode;
			}
		}
		
		return root;
    }
}
