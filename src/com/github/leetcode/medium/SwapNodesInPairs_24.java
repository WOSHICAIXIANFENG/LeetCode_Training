package com.github.leetcode.medium;

public class SwapNodesInPairs_24 {

	public static void main(String[] args) {
		SwapNodesInPairs_24 obj = new SwapNodesInPairs_24();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println("Cai Test = " + obj.swapPairs(n1));
	}

	// 0 ms, faster than 100.00%
	// Approach 1: Iterative Way
//	public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) return head;
//        
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode pre = dummy;
//        // swap two nodes
//        while (pre.next != null && pre.next.next != null) {
//        	ListNode n1 = pre.next;
//        	ListNode n2 = n1.next;
//        	n1.next = n2.next;
//        	n2.next = n1;
//        	pre.next = n2;
//        	pre = n1;
//        }
//        head = dummy.next;
//        return dummy.next;
//    }
	
	// Approach 2: Recursion
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode n1 = head;
		ListNode n2 = n1.next;
		n1.next = swapPairs(n2.next);
		n2.next = n1;
		return n2;
	}
}
