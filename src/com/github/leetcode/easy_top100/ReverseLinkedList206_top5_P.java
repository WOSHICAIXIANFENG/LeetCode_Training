package com.github.leetcode.easy_top100;

public class ReverseLinkedList206_top5_P {

	public static void main(String[] args) {
		ReverseLinkedList206_top5_P obj = new ReverseLinkedList206_top5_P();
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

	// 1->2->3->4->5->null
	
	// !!!
	// Approach 1: Recursion
	// TC: O(N)
	// SC: O(1)
	public ListNode reverseList2(ListNode head) {
		// TODO
		return null;
	}
	
	// 1->2->3->4->5->null
	
	
	// 1->2->3->4->5->null
	// Approach 2: Iterative
	// TC: O(N)
	// SC: O(1)
	public ListNode reverseList(ListNode head) {
		// TODO 
		return null;
	}
}
