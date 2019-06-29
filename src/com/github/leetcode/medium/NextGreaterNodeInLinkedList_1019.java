package com.github.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterNodeInLinkedList_1019 {

	public static void main(String[] args) {
		NextGreaterNodeInLinkedList_1019 obj = new NextGreaterNodeInLinkedList_1019();
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(1);
		ListNode a5 = new ListNode(5);
		a1.next = a2;
		a2.next = a5;
		System.out.println("Cai Test = " + Arrays.toString(obj.nextLargerNodes(a1)));
		
		ListNode b1 = new ListNode(2);
		ListNode b2 = new ListNode(7);
		ListNode b3 = new ListNode(4);
		ListNode b4 = new ListNode(3);
		ListNode b5 = new ListNode(5);
		b1.next = b2;
		b2.next = b3;
		b3.next = b4;
		b4.next = b5;
		System.out.println("Cai Test = " + Arrays.toString(obj.nextLargerNodes(b1)));
	}
	
	// The given list has length in the range [0, 10000].
	// So, Brute Force will Time Out Limit
	
	// 39 ms, faster than 64.00% -- Use Stack
	// 11 ms, faster than 96.42% -- Use ArrayDeque
	// Approach 1 : Monotonous Stack
	// TC: O(n) ---- each node only be push or pop one time
	// SC: O(n) stack
	public int[] nextLargerNodes(ListNode head) {
		if (head == null) return null;
		
		int i = 0;
		// step1: reverse ListNode
		ListNode prev = null;// this is the reversed head
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			i++;
		}
		//System.out.println("Cai Test listNode = " + prev);
		System.out.println("Cai Test i = " + i);
		
		// step2: monotonous tack to figure it out
		int[] ans = new int[i];
        //Stack<ListNode> stack = new Stack<ListNode>();
		Deque<ListNode> stack = new ArrayDeque<>();
		
        ListNode curNode = prev;
        while (curNode != null) {
        	// pop up continuous smaller element
    		while (!stack.isEmpty() && curNode.val >= stack.peek().val) {
    			stack.pop();
    		}
    		ans[i - 1] = stack.isEmpty() ? 0 : stack.peek().val;
    		stack.push(curNode);
    		i--;
    		curNode = curNode.next;
        }
        return ans;
    }

}
