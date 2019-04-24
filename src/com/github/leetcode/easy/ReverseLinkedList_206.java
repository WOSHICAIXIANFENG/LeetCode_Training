package com.github.leetcode.easy;

/**
 Reverse a singly linked list.
 
 * @author Samuel
 *
 */
public class ReverseLinkedList_206 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode head = reverseList2(node1);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		
		System.out.println();
	}

	// Iterative Solution
	public static ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		// 1 -> 2 -> 3 -> 4 -> 5
		// newHead(1) -> 1 -> null,  head -> 2
		// newHead(2) -> 2 -> 1,   head -> 3
		// newHead(3) -> 3 -> 2-> 1, head -> 4
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		
		return newHead;
	}
	
	// Recursive Solution
	public static ListNode reverseList2(ListNode head) {
		return reverseNode(head, null);
	}
	
	// 1->2->3->4->5->NULL
    // loop1 --> 1->Null
    // loop2 --> 2->1->Null
    // loop3 --> 3->2->1->Null
    // loop4 --> 4->3->2->1->Null
	public static ListNode reverseNode(ListNode head, ListNode afterNewHead) {
		if (head == null)  return afterNewHead;
		
		ListNode next = head.next;
		head.next = afterNewHead;
		return reverseNode(next, head);
	}
}
