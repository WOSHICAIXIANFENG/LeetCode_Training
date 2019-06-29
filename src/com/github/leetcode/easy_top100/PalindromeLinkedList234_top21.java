package com.github.leetcode.easy_top100;

public class PalindromeLinkedList234_top21 {

	public static void main(String[] args) {
		PalindromeLinkedList234_top21 obj = new PalindromeLinkedList234_top21();
		// 1 2 3 4 3 2 1
		// 1 2 3 3 2 1
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node1_1 = new ListNode(1);
		ListNode node2_2 = new ListNode(2);
		ListNode node3_3 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node3_3;
		node3_3.next = node2_2;
		//node3.next = node2_2;
		node2_2.next = node1_1;
		System.out.println("Samuel Test isPalindrome = " + obj.isPalindrome(node1));// true
		System.out.println("Samuel Test isPalindrome = " + obj.isPalindrome(null));// true
	}
	
	// Could you do it in O(n) time and O(1) space?
	
	// Approach 1: Tortoise and hare algorithm --- find mid pos
	// TC: O(n)
	// SC: O(1) 
	public boolean isPalindrome(ListNode head) {
		if (head == null) return true;
		// Use slow/fast pointers to quickly find the mid pos
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// 1,2,3,4,3,2,1 ---> slow -> 4, fast -> 1
		// 1,2,3,3,2,1 --> slow -> 3, fast -> null
		if (fast == null) {
			slow = slow.next;
		}
		// !!! Now, slow is the head of second half part. The first half part size >= second
		slow = reverse(slow);
		
		// compare two halves
		while (slow != null) {
			if (slow.val != head.val) {
				return false;
			}
			slow = slow.next;
			head = head.next;
		}
		return true;
	}
	
	public ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}
