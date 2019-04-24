package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInOrderTraverse_94 {

	public static void main(String[] args) {
		BTInOrderTraverse_94 obj = new BTInOrderTraverse_94();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.right = node2;
		node2.left = node3;
		System.out.println("Cai Test = " + obj.inorderTraversal(node1));

	}
	
	// have a try to improve TC, but the result is the same
	public List<Integer> inorderTraversal(TreeNode root) {
		List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
	}

	// 1 ms, faster than 30.27% 
	// TC: O(N)
	// Recursive solution is trivial, could you do it iteratively?
//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> ans = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode currNode = root;
//        while (!stack.isEmpty() || currNode != null) {
//        	if (currNode != null) {
//        		stack.push(currNode);
//        		currNode = currNode.left;
//        	} else {
//        		currNode = stack.pop();
//        		ans.add(currNode.val);
//        		currNode = currNode.right;
//        	}
//        }
//        return ans;
//    }
}
