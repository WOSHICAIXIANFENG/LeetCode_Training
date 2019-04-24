package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees_872 {

	public static void main(String[] args) {
		LeafSimilarTrees_872 obj = new LeafSimilarTrees_872();
	}

	// 0 ms, faster than 100.00%
	
	// TC: O(N1 + N2). where N1, N2 are the lengths of the given trees.
	// SC: O(T1 + T2). The space used in storing the leaf values
	// In the worst case, the binary tree is perfect, and the number of leaves is 0.5 * T. That's why space complexity is linear in T.
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> leaves1 = new ArrayList<>();
		List<Integer> leaves2 = new ArrayList<>();
		
        dfsTree(root1, leaves1);
        dfsTree(root2, leaves2);
        return leaves1.equals(leaves2);
    }
	
	public void dfsTree(TreeNode root, List<Integer> leaves) {
		if (root == null) return;
		
		if (root.left == null && root.right == null) {
			leaves.add(root.val);
		}
		dfsTree(root.left, leaves);
		dfsTree(root.right, leaves);
	}
}
