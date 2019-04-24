package com.github.leetcode.medium;

public class SortList_148 {

	public static void main(String[] args) {
		SortList_148 obj = new SortList_148();
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		System.out.println("Cai Test = " + obj.sortList(n1));
		
		//System.out.println("Cai Test = " + obj.split(n1, 1));
	}
	
	// Approach 2: Merge Sort ---- Dottom Up
	// TC: O(nlogN)
	// SC: O(1)
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;
		int len = 1;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			len++;
		}
		
		// len will be size + 1
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode left;//sorted list head
		ListNode right;// rest list head
		ListNode tail;
		// 1 --> 2 --> 4 --- logN
		for (int i = 1; i < len; i <<= 1) {
			cur = dummy.next;// the sorted list head --- list = [partial sorted + rest unsorted list]
			tail = dummy;
			// !!! 这里相当于花了 O(n)的时间，因为 while cost O(n/2i) * merge cost O(2i) 
			// {2,4},{1,3} ---- while 跑两次，每次merge 两个元素。 --- 相当于O(N)时间
			while (cur != null) {
				left = cur;
				right = split(left, i);
				cur = split(right, i);
				PairNode merged = merge(left, right);
				tail.next = merged.first;
				tail = merged.second;
				System.out.println("Cai Test merged = " + merged);
			}
		}
		return dummy.next;
	}
	
	// Splits the list into two parts, first n elements and the rest
	// Return the head of the rest
	ListNode split(ListNode head, int n) {
		while (n > 1 && head != null) {
			head = head.next;
			n--;
		}
		ListNode rest = head != null ? head.next : null;
		if (head != null) {
			head.next = null;
		}
		return rest;
	}
	
	private PairNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		if (l1 != null) {
			tail.next = l1;
		}
		if (l2 != null) {
			tail.next = l2;
		}
		while (tail.next != null) {
			tail = tail.next;
		}
		return new PairNode(dummy.next, tail);
	}

	class PairNode {
		ListNode first;
		ListNode second;
		public PairNode(ListNode f, ListNode s) {
			this.first = f;
			this.second = s;
		}
		@Override
		public String toString() {
			return "PairNode [first=" + first.val + ", second=" + second.val + "]";
		}
	}
	
	// 4 ms, faster than 74.57% 
	// Approach 1: Merge Sort
	// Top-down --- recursion
	// TC: O(nlgN)
	// SC: O(lgN)
//	public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        
//        ListNode slow = head;
//        ListNode fast = head.next;// 设置多一格的目的是为了让slow指向list1的尾部，方便断开!!!
//        while (fast != null && fast.next != null) {
//        	fast = fast.next.next;
//        	slow = slow.next;
//        }
//        ListNode mid = slow.next;
//        slow.next = null;// divide the linked list to two list
//        return merge(sortList(head), sortList(mid));
//    }
	
//	private ListNode merge(ListNode l1, ListNode l2) {
//		ListNode dummy = new ListNode(0);
//		ListNode tail = dummy;
//		while (l1 != null && l2 != null) {
//			if (l1.val > l2.val) {
//				tail.next = l2;
//				l2 = l2.next;
//			} else {
//				tail.next = l1;
//				l1 = l1.next;
//			}
//			tail = tail.next;
//		}
//		
//		if (l1 != null) {
//			tail.next = l1;
//		}
//		if (l2 != null) {
//			tail.next = l2;
//		}
//		return dummy.next;
//	}
}
