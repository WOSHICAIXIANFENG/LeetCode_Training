package com.github.leetcode.easy;

public class RemoveLinkedListElements_203 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		removeElements(node1, 6);
		System.out.println("Cai Test removeElements = " + printListNode(node1));
		
		ListNode node10 = new ListNode(1);
		removeElements(node10, 1);
		System.out.println("Cai Test removeElements = " + printListNode(node10));
	}
	
	// 3 ms, faster than 100.00%
	// O(n)
	// O(1)
	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		
		// 1 1 1 2 3 4 1 1 1 2 3 (1) ---> 2 3 4 1 1 1 2 3 (1) 
		ListNode cursor = head;
		while (cursor.next != null) {
			if (cursor.next.val == val) {
				cursor.next = cursor.next.next;
			} else {
				cursor = cursor.next;
			}
		}
		return head.val == val ? head.next : head;
	}
	
//	// 3 ms, faster than 100.00%
//	// O(n)
//	// O(1)
//	public static ListNode removeElements(ListNode head, int val) {
//		// find first non val node
//		while (head != null && head.val == val) {
//			head = head.next;
//		}
//		
//		// 1 1 1 2 3 4 (1) ---> 2 3 4 (1)
//		// 1 1 1 2 3 4 1 1 1 2 3 (1) ---> 2 3 4 1 1 1 2 3 (1) 
//		ListNode curr = head;
//		ListNode prev = head;
//		while (curr != null) {
//			if (curr.val == val) {
//				prev.next = curr.next;
//			} else {
//				prev = curr;
//			}
//			curr = curr.next;
//		}
//		
//        return head;
//    }

//	// 4 ms, faster than 57.64%
//	public static ListNode removeElements(ListNode head, int val) {
//		if (head == null) return null;
//		head.next = removeElements(head.next, val);
//		return head.val == val ? head.next : head;
//	}
	
	public static String printListNode(ListNode head) {
		String result = "";
		while (head != null) {
			result += head.val + " ---> ";
			head = head.next;
		}
		return result;
	}
}
