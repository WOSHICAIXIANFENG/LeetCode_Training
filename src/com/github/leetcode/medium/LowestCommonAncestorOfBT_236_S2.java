package com.github.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestorOfBT_236_S2 {

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

		LowestCommonAncestorOfBT_236_S2 obj = new LowestCommonAncestorOfBT_236_S2();
		
		System.out.println("Cai Test = " + obj.lowestCommonAncestor(node1, node2, node3));
		System.out.println("Cai Test = " + obj.lowestCommonAncestor(node1, node2, node9));
	}
	
	// 14 ms, faster than 15.45%
	// Approach 2: Iterative using parent pointers
	// Time Complexity: O(N). We have to visit all the nodes of the BT.
	// Space Complexity: O(N). Since the height of a skewed binary tree could be N. parents will have N - 1 entries. 
	// the ancestor set could be N
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Queue for tree traversal
    	Deque<TreeNode> queue = new ArrayDeque<>();
    	queue.add(root);

    	Map<TreeNode, TreeNode> parents = new HashMap<>();
    	parents.put(root, null);
    	
    	while (!parents.containsKey(p) || !parents.containsKey(q)) {
    		TreeNode currNode = queue.poll();
    		if (currNode.left != null) {
    			queue.offer(currNode.left);
    			parents.put(currNode.left, currNode);
    		}
    		if (currNode.right != null) {
    			queue.offer(currNode.right);
    			parents.put(currNode.right, currNode);
    		}
    	}
    	
    	// Ancestors set() for node p.
    	Set<TreeNode> ancestors = new HashSet<>();
    	while (p != null) {
    		ancestors.add(p);
    		p = parents.get(p);
    	}
    	
    	// The first ancestor of q which occurs/appears in p's ancestor set() is their lowest common ancestor
    	while (!ancestors.contains(q)) {
    		q = parents.get(q);
    	}
    	
		return q;
    }
}
