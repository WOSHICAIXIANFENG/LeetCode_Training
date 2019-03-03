package com.github.leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *    
   1
 /   \
2     3
 \     \
  5     4
  
 * @author Samuel
 *
 */
public class BinaryTreePostorderTraversal_145 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		
		node1.left = node2;
		node1.right = node3;
		node2.right = node5;
		node3.right = node4;
		
		System.out.println("Cai Test preorderTraversal result = " + postorderTraversal(node1));// 52431
	}

	// Use LinkedList & Stack to solve this problem
	// for LinkedList addFirst(), you can use ArrayList.add(0, val) -- but it has O(n) consume
	// for Stack, You also can use ArrayDeque or LinkedList to do it. 
	// LinkedList has method push(), pop(), peek(), addFrist(), addLast()....
	// offer(), offerFirst(), offerLast(), poll(), pollFirst(), pollLast();
	// 
	// ArrayDeque also has all above methods
	public static List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> results = new LinkedList<>();
        
        if (root == null) return results;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            results.addFirst(currNode.val);
            
            if (currNode.left != null) stack.push(currNode.left);
            if (currNode.right != null) stack.push(currNode.right);
        }
        
        return results;
	}
	
	
//	public static List<Integer> postorderTraversal(TreeNode root) {
//        LinkedList<Integer> results = new LinkedList<>();
//        
//        if (root == null) return results;
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        deque.push(root);
//        while (!deque.isEmpty()) {
//            TreeNode currNode = deque.pop();
//            results.addFirst(currNode.val);
//            
//            if (currNode.left != null) {
//            	deque.push(currNode.left);
//            }
//            
//            if (currNode.right != null) {
//            	deque.push(currNode.right);
//            }
//        }
//        
//        return results;
//    }
}
