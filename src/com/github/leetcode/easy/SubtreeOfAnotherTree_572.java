package com.github.leetcode.easy;

public class SubtreeOfAnotherTree_572 {

	public static void main(String[] args) {
		SubtreeOfAnotherTree_572 obj = new SubtreeOfAnotherTree_572();
		TreeNode a1 = new TreeNode(3);
		TreeNode a2 = new TreeNode(4);
		TreeNode a3 = new TreeNode(5);
		TreeNode a4 = new TreeNode(1);
		TreeNode a5 = new TreeNode(2);
		TreeNode a6 = new TreeNode(0);
		a1.left = a2;
		a1.right = a3;
		a2.left = a4;
		a2.right = a5;
		a5.left = a6;
		
		TreeNode b1 = new TreeNode(4);
		TreeNode b2 = new TreeNode(1);
		TreeNode b3 = new TreeNode(2);
		b1.left = b2;
		b1.right = b3;
		System.out.println("Cai Test = " + obj.isSubtree(a1, b1));
	}

	// 6 ms, faster than 98.36%
	// Approach 1: DFS tree to String, make lNull, rNull, #val as the elements
	// TC: O(N1 + N2 + n). ---- last O(n) for .contains() function
	// SC: O(1) + O(H) ---- O(H) for recursive function call
	// SC: O(max(m,n)). The depth of the recursion tree can go upto nn for tree tt and mm for tree ss in worst case.
	public boolean isSubtree(TreeNode s, TreeNode t) {
		StringBuilder sb1 = new StringBuilder();
		preOrderTraverse(s, sb1);
		StringBuilder sb2 = new StringBuilder();
		preOrderTraverse(t, sb2);
//		System.out.println("Cai Test sb1 = " + sb1.toString());
//		System.out.println("Cai Test sb2 = " + sb2.toString());
        return sb1.toString().contains(sb2.toString());
    }
	
	public void preOrderTraverse(TreeNode root, StringBuilder sb) {
		if (root == null) return;
		
		sb.append("#" + root.val); // "#" is very important
		if (root.left == null) {
			sb.append("lNull");
		} else {
			preOrderTraverse(root.left, sb);
		}
		
		if (root.right == null) {
			sb.append("rNull");
		} else {
			preOrderTraverse(root.right, sb);
		}
	}
	
	
}
