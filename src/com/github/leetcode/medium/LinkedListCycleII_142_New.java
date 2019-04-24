package com.github.leetcode.medium;

/**

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

 * @author Samuel
 *
 */
public class LinkedListCycleII_142_New {

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
		
//		ListNode result = detectCycle(node1);
//		System.out.println("Samuel Test detectCycle = " + (result != null ? result.val : "null"));

		// Special case to test NPE
		ListNode node10 = new ListNode(10);
		ListNode result = detectCycle(node10);
		System.out.println("Samuel Test detectCycle = " + (result != null ? result.val : "null"));
		
	}
	
	public static ListNode detectCycle(ListNode head) {
		ListNode slow = head;
        ListNode fast = head;
        // try to find the intersection point
        while (fast != null && fast.next != null && slow != fast) {
        	slow = slow.next;
        	fast = fast.next.next;
        	
        	if (slow == fast) {
        		ListNode p1 = head;
        		ListNode p2 = slow;
        		while (p1 != p2) {
        			p1 = p1.next;
        			p2 = p2.next;
        		}
        		return p1;
        	}
        }
        return null;
	}

	// Can you solve it without using extra space?
	// Floyd's Tortoise and Hare
	// My first solution
//	public static ListNode detectCycle(ListNode head) {
//		ListNode slow = head;
//        ListNode fast = head;
//        // try to find the intersection point
//        do {
//            slow = slow.next;
//            fast = fast.next.next; //As the NullPointerException, we can't use do while
//        } while (fast != null && fast.next != null && slow != fast);
//        
//        // since there exists intersection point, so there is a cycle
//        if (slow == fast) {
//            ListNode p1 = head;
//            ListNode p2 = slow;
//            while (p1 != p2) {
//                p1 = p1.next;
//                p2 = p2.next;
//            }
//            return p1;
//        }
//        
//        return null;
//    }
}