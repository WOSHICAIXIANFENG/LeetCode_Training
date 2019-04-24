package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {

	public static void main(String[] args) {
		PathSumII_113 obj = new PathSumII_113();
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(5);
		TreeNode n10 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n3.right = n6;
		n4.left = n7;
		n4.right = n8;
		n6.left = n9;
		n6.right = n10;
		System.out.println("Cai Test = " + obj.pathSum(n1, 22));
	}

	// 1 ms, faster than 99.95%
	// TC: O(N)
	// SC: O(H) + O(answer size * O(answer's length)) 
	// ----- in the worst case, O(H) is O(N),  2O(N)
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		help(root, sum, ans, new ArrayList<>());
        return ans;
    }
	
	public void help(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> pathValues) {
		if (root == null) return;
		
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				pathValues.add(root.val);
				ans.add(new ArrayList<>(pathValues));// we create a new path Array to avoid the values are removed
				pathValues.remove(pathValues.size() - 1);//!!!处理好就要删除掉最后一个元素
			}
			return;// optimize --- don't need to continue to check this leaf node
		}
		pathValues.add(root.val);
		help(root.left, sum - root.val, ans, pathValues);
		help(root.right, sum - root.val, ans, pathValues);
		pathValues.remove(pathValues.size() - 1);//!!!处理好就要删除掉最后一个元素
	}
}
