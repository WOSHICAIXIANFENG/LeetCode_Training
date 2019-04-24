package com.github.leetcode.easy;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author Samuel
 *
 */
public class Merge2SortedLists_21 {
	public static void main(String[] args) {
		// 1,3,5,7
		// 2, 4, 6
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node5 = new ListNode(5);
		ListNode node7 = new ListNode(7);
		node1.next = node3;
		node3.next = node5;
		node5.next = node7;
		
		ListNode node2 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		ListNode node6 = new ListNode(6);
		node2.next = node4;
		node4.next = node6;
		
//		ListNode result = mergeTwoLists(node1, node2);
//		while (result != null) {
//			System.out.print(result.val + "->");
//			result = result.next;
//		}
//		System.out.println();
//		System.out.println("================================");
		
		// or
		ListNode result = mergeTwoLists2(node1, node2);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
		System.out.println();
	}
	
	// recursion --- time Complexity O(n) --- n is Min(length1, length2);
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		if (l1.val > l2.val) {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		} else {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
    }
	
	// 0 ms, faster than 100.00%
	// iterative --- time Complexity O(n) --- n is Min(length1, length2);
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);//!!! Use a dummy head at first
		ListNode handler = head;
		
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				handler.next = l1;
				l1 = l1.next;
			} else {
				handler.next = l2;
				l2 = l2.next;
			}
			handler = handler.next;
		}
		
		if (l1 != null) {
			handler.next = l1;
		}
		if (l2 != null) {
			handler.next = l2;
		}
		
		return head.next;
	}
}
