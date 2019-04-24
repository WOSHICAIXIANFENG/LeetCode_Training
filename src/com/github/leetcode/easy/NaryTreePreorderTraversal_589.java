package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal_589 {

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
		System.out.println("Cai Test = " + preorder(node1));
	}
	
	// Approach 1: Iterative solution
	// 5 ms, faster than 47.49%
//	public static List<Integer> preorder(Node root) {
//		List<Integer> ans = new ArrayList<>();
//		if (root == null) return ans;
//		
//		Deque<Node> stack = new ArrayDeque<>();
//		stack.push(root);
//		
//		while (!stack.isEmpty()) {
//			Node pop = stack.pop();
//			ans.add(pop.val);
//			
//			if (pop.children != null) {
//				List<Node> children = pop.children;
//				for (int i = children.size() - 1; i >= 0; i--) {
//					stack.push(children.get(i));
//				}
//			}
//		}
//		return ans;
//	}
	
	// How to become better ?
	
	// 5 ms, faster than 47.49% 
	// Approach 1: Iterative Use Stack to solve this problem.
//	public static List<Integer> preorder(Node root) {
//		List<Integer> ans = new ArrayList<>();
//		if (root == null) return ans;
//		
//		Stack<Node> stack = new Stack<>();
//		stack.push(root);
//		while (!stack.isEmpty()) {
//			Node top = stack.pop();
//			ans.add(top.val);
//			
//			if (top.children != null) {
//				List<Node> children = top.children;
//				for (int i = children.size() - 1; i >= 0; i--) {
//					stack.push(children.get(i));
//				}
//			}
//		}
//		
//		return ans;
//	}

	// Approach 1: Iterative solution
	// 60 ms, faster than 6.88% 
	// My solution ---- too bad!!! ---- I use Queue to do Stack things
//	public static List<Integer> preorder(Node root) {
//		List<Integer> ans = new ArrayList<>();
//		if (root == null) return ans;
//		
//		Queue<Node> queue = new LinkedList<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			//int size = queue.size(); // how many nodes in the same level
//			Node currNode = queue.poll();
//			ans.add(currNode.val);
//			
//			if (currNode.children != null) {
//				List<Node> siblings = new ArrayList<>();
//				while(!queue.isEmpty()) {
//					// we need to skip size - 1 sibling nodes
//					siblings.add(queue.poll());
//				}
//				
//				for (Node child : currNode.children) {
//					queue.offer(child);
//				}
//				
//				// Now add sibling nodes
//				for (Node silbing : siblings) {
//					queue.offer(silbing);
//				}
//			}
//		}
//        return ans;
//    }
	
	// Approach 2: Recursive
	public static List<Integer> preorder(Node root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) return ans;
		preorder(ans, root);
		return ans;
	}
	
	public static void preorder(List<Integer> results, Node root) {
		if (root == null) return;
		
		results.add(root.val);
		if (root.children != null) {
			for (Node child : root.children) {
				preorder(results, child);
			}
		}
	}
}
