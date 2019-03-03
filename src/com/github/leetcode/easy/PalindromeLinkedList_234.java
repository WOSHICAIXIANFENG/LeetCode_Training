package com.github.leetcode.easy;

/**
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

 * @author Samuel
 *
 */
public class PalindromeLinkedList_234 {

	public static void main(String[] args) {
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
		System.out.println("Samuel Test isPalindrome = " + isPalindrome(node1));
		System.out.println("Samuel Test isPalindrome = " + isPalindrome(null));
	}

	// 1 ms, faster than 96.97%
	
	public static boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		// 1 2 3 3 2 1  ---- fast --> null --3次  slow ---> 3 第二个3
		// 1 2 3 4 3 2 1 ---- fast --> 1 3次 slow ---> 4
		if (fast != null) {
			slow = slow.next;
		}
		
		slow = reverse(slow);
		fast = head;
		// 1 2 3 -- 1 2 3   fast --> 1, slow --> 1
		// 1 2 3 4 -- 1 2 3  fast --> 1, slow --> 1
		
		while (slow != null) {
			if (fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
        return true;
    }
	
	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
				head.next = prev;
				prev = head;
			head = next;	
		}
		return prev;
	}
}
