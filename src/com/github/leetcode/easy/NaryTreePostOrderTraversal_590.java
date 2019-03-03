package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NaryTreePostOrderTraversal_590 {

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
		System.out.println("Cai Test = " + postorder(node1));

	}
	
	// !!! LinkedList is a double queue structure, you can poll/remove element from last or first
	
	// 4 ms, faster than 62.51%
	// a little better solution to use LinkedList to solved it
	// Iterative Solution
	public static List<Integer> postorder(Node root) {
		LinkedList<Integer> results = new LinkedList<>();
        if (root == null) return results;
        
        // have to use LinkedList, not generation type Queue
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node currNode = queue.pollLast();
            //results.add(0, currNode.val); 
            results.addFirst(currNode.val);// addFrist() method is in LinkedList.  O(1)
            
            if (currNode.children != null) {
            	for (Node child : currNode.children) {
            		queue.offer(child);
                }
            }
        }
        
        return results;
	}
	
	// Approach 2: Iterative solution is tough
	// 6 ms, faster than 39.64%
//	public static List<Integer> postorder(Node root) {
//		List<Integer> results = new ArrayList<>();
//        if (root == null) return results;
//        
//        // Use a stack as the result or always add element on index 0 for list
//        //Stack<Integer> values = new Stack<>();
//        
//        Stack<Node> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//        	Node currNode = stack.pop();
//        	results.add(0, currNode.val); // for ArrayList, it will O(n) time consume
//        	
//        	if (currNode.children != null) {
//        		for (Node child : currNode.children) {
//        			stack.push(child);
//        		}
//        	}
//        }
//        
//        return results;
//	}
	
	// Approach 1: Recursive solution is trivial!
//	public static List<Integer> postorder(Node root) {
//        List<Integer> results = new ArrayList<>();
//        if (root == null) return results;
//        postorder(results, root);
//        return results;
//    }
//	
//	public static void postorder(List<Integer> results, Node root) {
//		if (root == null) return;
//		
//		if (root.children != null) {
//			for (Node child : root.children) {
//				postorder(results, child);
//			}
//		}
//		
//		results.add(root.val);
//	}
}
