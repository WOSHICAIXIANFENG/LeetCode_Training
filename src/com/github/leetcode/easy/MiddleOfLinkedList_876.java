package com.github.leetcode.easy;

public class MiddleOfLinkedList_876 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		System.out.println("Cai Test middleNode = " + middleNode(node1));
	}

//	// 1 ms, faster than 81.81%
//	// Approach 1: Output to Array
//	// Time Complexity: O(n), where N is the number of nodes in the given list.
//	// Space Complexity: O(n), the space used by Array
//	public static ListNode middleNode(ListNode head) {
//		ListNode[] array = new ListNode[100];
//		int t = 0;
//		// NOT CHANGE THE DATA IF IT'S NOT THE PURPOSE OF THE ALGORITHM.
//		ListNode temp = head;
//		while (temp.next != null) {
//			array[t++] = temp;
//			temp = temp.next;
//		}
//		return array[t / 2];
//	}
	
	// Fast and Slow Pointer
	// 1 ms, faster than 81.81%
	// Time Complexity: O(n).
	// Space Complexity: O(1). slow and fast pointers.
	public static ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		// 1 2 3 4 5 ---> fast --> 5, slow --> 3
		// 1 2 3 4 5 6 ---> fast --> null, slow --> 4
		
        return slow;
    }
}
