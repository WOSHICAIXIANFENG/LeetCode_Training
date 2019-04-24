package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers_129 {

	public static void main(String[] args) {
		SumRootToLeafNumbers_129 obj = new SumRootToLeafNumbers_129();
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(0);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		System.out.println("Cai Test = " + obj.sumNumbers(n1)); // 1026
	}

	// Best Solution: Avoid SC usage.  
	// No List<String>, No stream API, No String.valueOf(), Integer.intValue()
	
	// 0 ms, faster than 100.00%
	// TC: O(N)
	// SC: O(1) + O(H)
	private int totalSum;
	public int sumNumbers(TreeNode root) {
		if (root == null) return 0;
		totalSum = 0;
		sumPath(root, 0);
		return totalSum;
	}
	
	public void sumPath(TreeNode root, int sum){
		if (root == null) return;
		if (root.left == null && root.right == null) {
			totalSum += sum * 10 + root.val;
		}
		sum = sum * 10 + root.val;
		sumPath(root.left, sum);
		sumPath(root.right, sum);
	}
	
	// My first Solution!!!
	// 42 ms, faster than 5.52%
//	public int sumNumbers(TreeNode root) {
//        if (root == null) return 0;
//        List<String> paths = new ArrayList<>();
//        dfsHelper(root, paths, "");
//        return paths.stream().map(Integer::parseInt).mapToInt(Integer::intValue).sum();
//    }
//	
//	public void dfsHelper(TreeNode root, List<String> paths, String path) {
//		if (root == null) return;
//		
//		if (root.left == null && root.right == null) {
//			paths.add(path + String.valueOf(root.val));
//		}
//		path += String.valueOf(root.val);
//		dfsHelper(root.left, paths, path);
//		dfsHelper(root.right, paths, path);
//	}
}
