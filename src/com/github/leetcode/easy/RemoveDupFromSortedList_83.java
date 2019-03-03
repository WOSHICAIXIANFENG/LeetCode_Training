package com.github.leetcode.easy;

public class RemoveDupFromSortedList_83 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);
		node1.next = node3;
//		node2.next = node3;
		node3.next = node4;
//		node4.next = node5;
		
		ListNode result = deleteDuplicates(node1);
		System.out.println("Cai Test = " + printListNode(result));
	}

	// 1 ms, faster than 99.62%
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode temp = head;
		while (temp != null && temp.next != null) {
			if (temp.val == temp.next.val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
        return head;
    }
	
	public static String printListNode(ListNode head) {
		StringBuilder sb = new StringBuilder();
		ListNode temp = head;
		while (temp != null) {
			sb.append(temp.val + "->");
			temp = temp.next;
		}
		return sb.toString();
	}
}
