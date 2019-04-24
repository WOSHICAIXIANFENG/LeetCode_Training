package com.github.leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RecoverBST_99 {

	public static void main(String[] args) {
		RecoverBST_99 obj = new RecoverBST_99();
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(2);
		node1.left = node2;
		node2.right = node3;
		//obj.recoverTree2(node1);// 3 2 1 ---> 1 2 3 
		//System.out.println("Cai Test = " + obj.print(node1));
		
		TreeNode b1 = new TreeNode(3);
		TreeNode b2 = new TreeNode(1);
		TreeNode b3 = new TreeNode(4);
		TreeNode b4 = new TreeNode(2);
		b1.left = b2;
		b1.right = b3;
		b3.left = b4;
		obj.recoverTree2(b1);// 1 3 2 4 ----> 1 2 3 4
		System.out.println("Cai Test = " + obj.print(b1));
	}
	
	public String print(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		TreeNode currNode; 
		while (!queue.isEmpty()) {
			currNode = queue.poll();
			sb.append(currNode.val + " -- ");
			if (currNode.left != null) {
				queue.offer(currNode.left);
			}
			if (currNode.right != null) {
				queue.offer(currNode.right);
			}
		}
		return sb.toString();
	}
	
	// 22 ms, faster than 98.17%
	// Approach 1: DFS ---- In order + recursive
	// TC: O(N)
	// SC: O(1)
	private TreeNode firstNode = null;
	private TreeNode secondNode = null;
	private TreeNode prev = null;
	
	// Recover the tree without changing its structure
	public void recoverTree(TreeNode root) {
		if (root == null) return;
        helper(root);
        // swap the value of firstNode and secondNode
        int val = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = val;
    }
	
	// BST properties:
	// 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
	// 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
	// 任意节点的左、右子树也分别为二叉查找树；
	// 没有键值相等的节点。
	public void helper(TreeNode root) {
		if (root == null) return;
		helper(root.left);
		if (prev != null && prev.val > root.val) {
			if (firstNode == null) 
				firstNode = prev;
			
			// case: [1 3 2 4] ---> firstNode = 3, secondNode have to be 2
			secondNode = root;
		}
		prev = root;
		helper(root.right);
	}
	
	// Approach 2: Iterative way
	public void recoverTree2(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currNode = root;
		while (!stack.isEmpty() || currNode != null) {
			if (currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			} else {
				currNode = stack.pop();
				if (prev != null && prev.val > currNode.val) {
					if (firstNode == null)  firstNode = prev;
					secondNode = currNode;
				}
				prev = currNode;
				currNode = currNode.right;
			}			
		}
		// swap the value of firstNode and secondNode
        int val = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = val;
	}
}
