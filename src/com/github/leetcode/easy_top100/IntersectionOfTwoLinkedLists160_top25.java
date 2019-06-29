package com.github.leetcode.easy_top100;

public class IntersectionOfTwoLinkedLists160_top25 {

	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists160_top25 obj = new IntersectionOfTwoLinkedLists160_top25();
		ListNode h1 = new ListNode(1);
		h1.next = new ListNode(2);
		
		ListNode h2 = new ListNode(3);
		h2.next = new ListNode(4);
		System.out.println("Cai Test = " + obj.getIntersectionNode(h1, h2));
	}

	// Approach 1: Brute Force ---- for each node A, traverse the entire list of B
	
	// Approach 1: Hash Set --- put all nodes of A into hash set, then traverse all node of B
	
	/**
	 * You may assume there are no cycles anywhere in the entire linked structure.
	 * 
	 * The linked lists must retain their original structure after the function returns.
	 * 
	 * If the two linked lists have no intersection at all, return null
	 * 
	 */
	// 1 ms, faster than 97.41%
	
	// Approach 2: Two Pointers
	// TC: O(m + n)
	// SC: O(1)
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//!!!
		if (headA == null || headB == null) return null;
		
		ListNode p1 = headA;
		ListNode p2 = headB;
		
		// !!! p1 != p2 --- has covered null == null situation!!!
		// A: 1->2->3->4
		// B: 6->7->8
		// while did at most m+n times iterations, then p1 become null, p2 become null.
		// Then we can figure out there is no intersection
		while (p1 != p2) {
			p1 = p1 != null ? p1.next : headB;
			p2 = p2 != null ? p2.next : headA;
		}
		
		return p1;
	}
}
