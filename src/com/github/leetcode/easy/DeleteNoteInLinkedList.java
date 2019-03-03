package com.github.leetcode.easy;

public class DeleteNoteInLinkedList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		deleteNode(node2);
		System.out.println("Cai Test deleteNode = " + printListNode(node1));
	}
	
	// 0 ms, faster than 100.00%
	// Time and space complexity are both O(1)O(1).
	public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

	public static String printListNode(ListNode node) {
		String result = "";
		while (node != null) {
			result += node.val + " ---> ";
			node = node.next;
		}
		return result;
	}
}
