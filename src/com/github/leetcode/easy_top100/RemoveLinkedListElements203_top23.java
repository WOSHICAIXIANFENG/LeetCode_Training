package com.github.leetcode.easy_top100;

public class RemoveLinkedListElements203_top23 {

	public static void main(String[] args) {
		RemoveLinkedListElements203_top23 obj = new RemoveLinkedListElements203_top23();
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
		obj.removeElements(node1, 6);
		System.out.println("Cai Test removeElements = " + obj.printListNode(node1));
		
		ListNode node10 = new ListNode(1);
		obj.removeElements(node10, 1);
		System.out.println("Cai Test removeElements = " + obj.printListNode(node10));
	}
	
	public String printListNode(ListNode head) {
		String result = "";
		while (head != null) {
			result += head.val + " ---> ";
			head = head.next;
		}
		return result;
	}
	

	// Remove all elements from a linked list of integers that have value val.
	
	// 要点在于 当有多个 val时，val打头时，如何操作? ---- dummy Node or skip the starting val nodes to the first non-val ListNode
	// 1 1 1 2 3 4 (1) ---> 2 3 4 (1)
	// 1 1 1 2 3 4 1 1 1 2 3 (1) ---> 2 3 4 1 1 1 2 3 (1) 
	
	// 1 ms, faster than 98.77%
	// Approach 1: 
	// TC: O(n)
	// SC: O(1)
	public ListNode removeElements(ListNode head, int val) {
		// key point!!!
		// jump to the first non-val ListNode
		while (head != null && head.val == val) {
			head = head.next;
		}
		
		ListNode pre = head;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		
		return head;
	}
}
