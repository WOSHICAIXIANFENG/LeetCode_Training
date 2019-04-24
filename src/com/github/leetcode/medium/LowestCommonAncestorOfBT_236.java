package com.github.leetcode.medium;

public class LowestCommonAncestorOfBT_236 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(1);
		
		TreeNode node4 = new TreeNode(6);
		TreeNode node5 = new TreeNode(2);
		TreeNode node6 = new TreeNode(0);
		TreeNode node7 = new TreeNode(8);
		
		TreeNode node8 = new TreeNode(7);
		TreeNode node9 = new TreeNode(4);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.left = node8;
		node5.right = node9;

		LowestCommonAncestorOfBT_236 obj = new LowestCommonAncestorOfBT_236();
		
		//System.out.println("Cai Test = " + obj.lowestCommonAncestor(node1, node2, node3));
		System.out.println("Cai Test = " + obj.lowestCommonAncestor(node1, node2, node9));
	}
	
	private TreeNode ans;
	
	// 6 ms, faster than 99.84%
	// Approach 1: Recursive Approach
	// Time Complexity: O(N) --- N is the number of nodes in the binary tree. In the worst case we might be visiting all the nodes of the binary tree.
	// Space Compleixty: O(N) --- how many recursion happens. would be N since the height of a skewed binary tree could be N.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
		recurseTree(root, p, q);
		return ans;
    }
	
	public boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
		// If reached the end of a branch, return false;
		if (currentNode == null) {
			return false;
		}
		
		// Left Recursion. If left recursion returns true, set left = 1 else 0
		int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
		
		// Right
		int right = recurseTree(currentNode.right, p, q) ? 1 : 0;
		
		// If the current node is one of P or Q
		int mid = (currentNode == p || currentNode == q) ? 1 : 0;
		
		// If any two of the flags left, right and mid become true
		if (mid + left + right >= 2) {
			ans = currentNode;
			return true;// exit
		}
		
		// Return true if any one of the three bool values is True
		return mid + left + right > 0;
	}
	
	// WRONG !!!
//	public boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
//		// If reached the end of a branch, return false;
//		if (currentNode == null) {
//			return false;
//		}
//		
//		// Left Recursion. If left recursion returns true, set left = 1 else 0
//		int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
//		
//		// Right
//		int right = recurseTree(currentNode.right, p, q) ? 1 : 0;
//		
////		// If the current node is one of P or Q
////		int mid = (currentNode == p || currentNode == q) ? 1 : 0;
////		
////		// If any two of the flags left, right and mid become true
////		if (mid + left + right >= 2) {
////			ans = currentNode;
////		}
////		
////		// Return true if any one of the three bool values is True
////		return mid + left + right > 0;
//		
//		if (left + right == 2) {
//			ans = currentNode;
//		}
//		
//		if (currentNode == p || currentNode == q) {
//			return true;
//		} else {
//			return false;
//		}
//	}

}
