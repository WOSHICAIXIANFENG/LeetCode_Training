package com.github.leetcode.medium;

/**

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

 * @author Samuel
 *
 */
public class LinkedListCycleII_142 {

	public static void main(String[] args) {
		// 1,2,3,4,5,6,7,8,2
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		
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
		
		ListNode result = detectCycle(node1);
		System.out.println("Samuel Test detectCycle = " + (result != null ? result.val : "null"));
	}

	public static ListNode detectCycle(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				System.out.println(" ===== fast == slow = " + fast.val);
				ListNode fast2 = head;
				while (fast2 != slow) {
					fast2 = fast2.next;
					slow = slow.next;
				}
				return fast2;
			}
		}
        return null;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}