package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal_429 {

	public static void main(String[] args) {
		Node node5 = new Node(5, null);
		Node node6 = new Node(6, null);
		List<Node> kids1 = new ArrayList<Node>();
		kids1.add(node5);
		kids1.add(node6);
		Node node3 = new Node(3, kids1);
		Node node4 = new Node(4, null);
		Node node2 = new Node(2, null);
		List<Node> kids2 = new ArrayList<Node>();
		kids2.add(node3);
		kids2.add(node2);
		kids2.add(node4);
		Node node1 = new Node(1, kids2);
		System.out.println("Cai Test = " + levelOrder(node1));
	}
	
	// Approach 2: Iteration
	public static List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		//!!!
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size(); // how many nodes in the same level
			// poll all nodes from current level, then put all child nodes of next level into the queue.
			for (int i = 0; i < size; i++) {
				Node currNode = queue.poll();
				list.add(currNode.val);
				if (currNode.children != null) {
					for (Node child : currNode.children) {
						queue.offer(child);
					}
				}
			}

			result.add(list);
		}
		
		return result;
	}

	// 2 ms, faster than 100.00%
	// Recursive Solution:
//	public static List<List<Integer>> levelOrder(Node root) {
//		List<List<Integer>> result = new ArrayList<>();
//		int level = 0;
//		levelOrder(result, level, root);
//        return result;
//    }
//	
//	public static void levelOrder(List<List<Integer>> result, int level, Node root) {
//		if (root == null) return;
//		 
//		//System.out.println("Cai Test levelOrder = " + level + " root = " + root);
//		
//		// put root value into current level/index list
//		if (result.size() > level) {
//			result.get(level).add(root.val);// the same level value, put into the same list.
//		} else {
//			List<Integer> leaves = new ArrayList<>();
//			leaves.add(root.val);
//			result.add(leaves);
//		}
//		
//		// set for root's children
//		if (root.children != null) {
//			for (Node child : root.children) {
//				//!!! can't use level++, or ++level, because we need to keep the level is mutable.  the sibling nodes should have the same level value. 
//				levelOrder(result, level + 1, child);// !!! Here can't be level++ or ++level
//			}
//		}
//	}
}

//Definition for a Node.
class Node {
 public int val;
 public List<Node> children;

 public Node() {}

 public Node(int _val,List<Node> _children) {
     val = _val;
     children = _children;
 }

@Override
public String toString() {
	return "Node [val=" + val + ", children=" + children + "]";
}
};