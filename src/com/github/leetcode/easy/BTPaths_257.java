package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BTPaths_257 {

	public static void main(String[] args) {
		BTPaths_257 obj = new BTPaths_257();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		System.out.println("Cai Test = " + obj.binaryTreePaths(n1));
	}
	
	// 1 ms, faster than 100.00%
	// Best solution to speed up: Avoiding use List<Integer> or StringBuilder, we use String
	// TC: O(N)
	// SC: O(H) + O(the count of paths)
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        dfsHelper(root, ans, "");
        return ans;
	}
	
	public void dfsHelper(TreeNode root, List<String> ans, String path) {
		if (root == null) {
            
        } else if (root.left == null && root.right == null) {
            ans.add(path + root.val);
        } else {
            path += root.val + "->";
            dfsHelper(root.left, ans, path);
            dfsHelper(root.right, ans, path);
        }
	}

	// My First solution
	// 41 ms, faster than 5.95% 
//	public List<String> binaryTreePaths(TreeNode root) {
//        List<String> ans = new ArrayList<>();
//        if (root == null) return ans;
//        //StringBuilder sb = new StringBuilder(); // SB doesn't work very well
//        //dfsHelp(root, ans, sb);
//        dfsHelp(root, ans, new ArrayList<>());
//        return ans;
//    }
//	
//	public void dfsHelp(TreeNode root, List<String> ans, List<Integer> pathValues) {
//		if (root == null) return;
//		if (root.left == null && root.right == null) {
//			pathValues.add(root.val);
//			String path = pathValues.stream().map(String::valueOf).collect(Collectors.joining("->"));
//			ans.add(path);
//			pathValues.remove(pathValues.size() - 1);
//		}
//		pathValues.add(root.val);
//		dfsHelp(root.left, ans, pathValues);
//		dfsHelp(root.right, ans, pathValues);
//		pathValues.remove(pathValues.size() - 1);
//	}
	
//	public void dfsHelp(TreeNode root, List<String> ans, StringBuilder sb) {
//		if (root == null) return;
//		
//		if (root.left == null && root.right == null) {
//			sb.append(root.val);
//			ans.add(sb.toString());
//			System.out.println("Cai Test sb = " + sb.toString());
//			sb.replace(sb.length() - 3, sb.length() - 1, ""); // can't replace the last char in sb.length - 1
//			System.out.println("Cai Test sb after = " + sb.toString());
//			return;
//		}
//		sb.append(root.val + "->");
//		dfsHelp(root.left, ans, sb);
//		dfsHelp(root.right, ans, sb);
//		if (sb.length() > 3)
//			sb.replace(sb.length() - 3, sb.length() - 1, "");
//	}
}
