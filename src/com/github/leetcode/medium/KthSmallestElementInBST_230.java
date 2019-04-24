package com.github.leetcode.medium;

import java.util.Stack;

public class KthSmallestElementInBST_230 {

	public static void main(String[] args) {
		KthSmallestElementInBST_230 obj = new KthSmallestElementInBST_230();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(2);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		System.out.println("Cai Test = " + obj.kthSmallest(node1, 1));
	}
	
	// !!! Follow UP:
	/**
	 * What if the BST is modified (insert/delete operations) often and you need 
	 * to find the kth smallest frequently? 
	 * How would you optimize the kthSmallest routine?
	 */
	
	// Solution: If we could add a count field in the BST node class, 
	// it will take O(n) time when we calculate the count value for the whole tree, 
	// but after that, it will take O(logn) time when insert/delete a node or calculate the kth smallest element.
	public int kthSmallest(TreeNode root, int k) {
		TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
        return kthSmallest(rootWithCount, k);
	}
	
	private int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
        if (k <= 0 || k > rootWithCount.count) return -1;
        if (rootWithCount.left != null) {
            if (rootWithCount.left.count >= k) return kthSmallest(rootWithCount.left, k);
            if (rootWithCount.left.count == k-1) return rootWithCount.val;
            return kthSmallest(rootWithCount.right, k-1-rootWithCount.left.count);
        } else {
            if (k == 1) return rootWithCount.val;
            return kthSmallest(rootWithCount.right, k-1);
        }
    }
	
	private TreeNodeWithCount buildTreeWithCount(TreeNode root) {
        if (root == null) return null;
        TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
        rootWithCount.left = buildTreeWithCount(root.left);
        rootWithCount.right = buildTreeWithCount(root.right);
        if (rootWithCount.left != null) rootWithCount.count += rootWithCount.left.count;
        if (rootWithCount.right != null) rootWithCount.count += rootWithCount.right.count;
        return rootWithCount;
    }
	
	class TreeNodeWithCount {
		int val;
        int count;
        TreeNodeWithCount left;
        TreeNodeWithCount right;
        
        TreeNodeWithCount(int x) {
        	val = x; count = 1;
        	};
	}
	
	// Approach 3: Use Binary Search
	// Time Complexity: O(logN)
	// Space Complexity: O(N)
//	public int kthSmallest(TreeNode root, int k) {
//		int counter = helper(root.left);
//		if (k <= counter) {
//			return kthSmallest(root.left, k);
//		} else if (k > counter + 1) {
//			return kthSmallest(root.right, k - 1 - counter);
//		}
//		return root.val;
//	}
//	
//	public int helper(TreeNode root) {
//		if (root == null) return 0;
//		return 1 + helper(root.left) + helper(root.right);
//	}

	// Approach 2: DFS in-order iterative:
	// Time Complexity: O(N) !!!
//	public int kthSmallest(TreeNode root, int k) {
//		Stack<TreeNode> st = new Stack<>();
//		while (root != null) {
//			st.push(root);
//			root = root.left;
//		}
//		
//		while (k != 0) {
//			TreeNode n = st.pop();
//			k--;
//			if (k == 0) return n.val;
//			
//			TreeNode right = n.right;
//			while (right != null) {
//				st.push(right);
//				right = right.left;
//			}
//		}
//		return -1; // never hit if k is valid
//	}
	
	
//	// 0 ms, faster than 100.00%
//	// Approach 1: DFS In-Order recursive
//	// Time Complexity: O(N)
//	private Integer prev;
//	private int index; 
//	public int kthSmallest(TreeNode root, int k) {
//		prev = null;
//		index = 0;
//		inOrder(root, k);
//        return prev;
//    }
//	
//	public boolean inOrder(TreeNode root, int k) {
//		if (root == null) return false;
//		
//		if (inOrder(root.left, k)) {
//			return true;
//		}
//		prev = root.val;
//		index++;
//		if (index == k) {
//			return true;
//		}
//		return inOrder(root.right, k);
//	}
	
}
