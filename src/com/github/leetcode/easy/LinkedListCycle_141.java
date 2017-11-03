package com.github.leetcode.easy;

public class LinkedListCycle_141 {

	public static void main(String[] args) {
		// 1,2,3,4,5,6,7,8,2
		ListNode2 node1 = new ListNode2(1);
		ListNode2 node2 = new ListNode2(2);
		ListNode2 node3 = new ListNode2(3);
		ListNode2 node4 = new ListNode2(4);
		ListNode2 node5 = new ListNode2(5);
		ListNode2 node6 = new ListNode2(6);
		ListNode2 node7 = new ListNode2(7);
		ListNode2 node8 = new ListNode2(8);
		
		// fast  ---- 1,3,5,7,8,8,8,8
		// slow  ---- 1,2,3,4,5,6,7,8
		// fast2               ---- 1,2,3,4,5,6,7,8
		// slow  ---- 1,2,3,4,5,6,7,8,8,8,8,8,8,8,8
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		//node8.next = node2;
		node8.next = node8;
				
		System.out.println("Samuel Test detectCycle = " + hasCycle(node1));
	}
	
	public static boolean hasCycle(ListNode2 head) {
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode2 slow = head;
		ListNode2 fast = head.next;
		
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
        return true;
    }
	
	static class ListNode2 {
		int val;
		ListNode2 next;
		ListNode2(int x) {
			val = x;
			next = null;
		}
	}

}

 
