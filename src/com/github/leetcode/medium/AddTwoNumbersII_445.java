package com.github.leetcode.medium;

import java.util.Stack;

public class AddTwoNumbersII_445 {

	public static void main(String[] args) {
		AddTwoNumbersII_445 obj = new AddTwoNumbersII_445();
		
		ListNode a1 = new ListNode(7);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(4);
		ListNode a4 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(4);
		b1.next = b2;
		b2.next = b3;
		
		ListNode result = obj.addTwoNumbers(a1, b1);
		System.out.println("Cai Test result = " + result);
	}
	
	// 2 ms, faster than 100.00% !!!
	// Approach 1: Reverse List without extra Space
	// TC: O(l1 + l2)
	// SC: O(1)
	public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
		ListNode l1 = reverse(h1);
		ListNode l2 = reverse(h2);
		ListNode ansNext = null;
		int sum = 0;
		while (l1 != null || l2 != null || sum != 0) {
			sum += l1 == null ? 0 : l1.val;
			sum += l2 == null ? 0 : l2.val;
			ListNode temp = new ListNode(sum % 10);
			sum /= 10;
			temp.next = ansNext;
			ansNext = temp;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		return ansNext;
	}
	
	public ListNode reverse(ListNode head) {
		ListNode next = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode rest = cur.next;
			cur.next = next;
			next = cur;
			cur = rest;
		}
		return next;
	}
	
	// 6 ms, faster than 91.53%
	// Approach 1: Using a stack to 'reverse' the list
	// TC: O(l1 + l2)
	// SC: O(max(l1, l2))
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        Stack<Integer> s1 = new Stack<>();
//        Stack<Integer> s2 = new Stack<>();
//        while (l1 != null) {
//        	s1.push(l1.val);
//        	l1 = l1.next;
//        }
//        while (l2 != null) {
//        	s2.push(l2.val);
//        	l2 = l2.next;
//        }
//        ListNode head = null;
//        int sum = 0;
//        while (!s1.isEmpty() || !s2.isEmpty() || sum != 0) {
//        	sum += s1.isEmpty() ? 0 : s1.pop();
//        	sum += s2.isEmpty() ? 0 : s2.pop();
//        	ListNode temp = new ListNode(sum % 10);
//        	sum /= 10;
//        	temp.next = head;
//        	head = temp;
//        }
//        return head;
//    }
}
