package com.github.leetcode.easy_top100;



public class MergeTwoSortedLists21_top2 {

	public static void main(String[] args) {
		MergeTwoSortedLists21_top2 obj = new MergeTwoSortedLists21_top2();
		
		// 1,3,5,7
		// 2, 4, 6
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node5 = new ListNode(5);
		ListNode node7 = new ListNode(7);
		node1.next = node3;
		node3.next = node5;
		node5.next = node7;
		
		ListNode node2 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		ListNode node6 = new ListNode(6);
		node2.next = node4;
		node4.next = node6;
		
		ListNode result = obj.mergeTwoLists(node1, node2);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
		System.out.println();
	}
	
	// Approach 1: Recursion
	// TC: O(min(len1, len2))
	// SC: O(min(len1, len2)) --- recursion depth
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.val >= l2.val) {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		} else {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
	}
	
	// Approach 2: Iterative Way
	// TC: O(min(len1, len2))
	// SC: O(1)
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		
		if (l1 == null) {
			cur.next = l2;
		} 
		if (l2 == null) {
			cur.next = l1;
		}
		return dummy.next;
	}
}

class ListNode implements Comparable<ListNode> {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

	@Override
	public int compareTo(ListNode o) {
		return val - o.val;
	}
}
