package com.github.leetcode.easy_top100;

public class ReverseLinkedList206_top5 {

	public static void main(String[] args) {
		ReverseLinkedList206_top5 obj = new ReverseLinkedList206_top5();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode head = obj.reverseList(node1);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		
		System.out.println();

	}

	// !!!
	// Approach 1: Recursion
	// TC: O(N)
	// SC: O(1)
	public ListNode reverseList(ListNode head) {
		return reverseNode(head, null);
	}
	
	// loop1: 1 --> null
	// loop2: 2 --> 1 --> null
	// loop3: 3 --> 2 --> 1 --> null
	public ListNode reverseNode(ListNode head, ListNode afterNewHead) {
		if (head == null) return afterNewHead;
		ListNode next = head.next;
		head.next = afterNewHead;
		return reverseNode(next, head);
 	}
	
	// Approach 2: Iterative
	// TC: O(N)
	// SC: O(1)
	public ListNode reverseList2(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;//!!!
			head = next;
		}
		return newHead;
	}
}
