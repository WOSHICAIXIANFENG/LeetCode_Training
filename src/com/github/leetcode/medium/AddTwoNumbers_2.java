package com.github.leetcode.medium;

public class AddTwoNumbers_2 {

	public static void main(String[] args) {
		AddTwoNumbers_2 obj = new AddTwoNumbers_2();
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(4);
		b1.next = b2;
		b2.next = b3;
		System.out.println("Cai Test = " + obj.addTwoNumbers(a1, b1));
	}

	// 2 ms, faster than 97.39% 
	// TC: O(l1 + l2)
	// SC: O(1)
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
        return reverse(ansNext);
    }
	
	public ListNode reverse(ListNode head) {
		ListNode next = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode rest = cur.next;
			cur.next = next;// always put the cur next as the head of reversed list
			next = cur;
			cur = rest;
		}
		return next;
	}
}
