package com.github.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23_best {

	public static void main(String[] args) {
		MergeKSortedLists_23_best obj = new MergeKSortedLists_23_best();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		
		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(3);
		ListNode b3 = new ListNode(4);
		b1.next = b2;
		b2.next = b3;
		
		ListNode c1 = new ListNode(2);
		ListNode c2 = new ListNode(6);
		c1.next = c2;
		
		ListNode[] t1 = new ListNode[] {a1, b1, c1};
		System.out.println("Cai Test = " + obj.mergeKLists(t1));
	}
	
	// Approach 2: Using BS + Merge Sort
	// TC: O(NlogK) --- K is the length of linked lists
	// We can merge two sorted linked list in O(n) time where n is the total number of nodes in two lists.
	// We use binary search algorithm to do logK times loop --- each loop do i -- i from k/2 to 1 times merge calculation
	// 2N/K * k/2 ---> 2N ----> logK * N 注意每次loop之后，下次loop时merge的node数量就变成2倍了 
	// 其他用平均的思想来计算，每次loop就是做了 O(N) merge calculation 消耗。
	// SC: O(1)
//	public ListNode mergeKLists(ListNode[] lists) {
//		if (lists == null || lists.length == 0) return null;
//		if (lists.length == 1) return lists[0];
//		
//		int len = lists.length;
//		while (len > 1) {
//			int mid = (len + 1) / 2; // case -- len == 3 --> 
//			for (int i = 0; i < len / 2; i++) {
//				lists[i] = merge(lists[i], lists[i + mid]);
//			}
//			len = mid;
//		}
//		return lists[0];
//	}
	
	public ListNode merge(ListNode l1, ListNode l2) {
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
		return dummy.next;
	}
	
	// 5 ms, faster than 93.52% 
	// Best solution!
	// Approach 1: Using Priority Queue 
	// TC: O(NlogK) ---- N is the total number of nodes, K is the lists' length
	// SC: O(K)
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		if (lists.length == 1) return lists[0];
		
		// in leetcode --- using lambda expression doesn't take good speed
		// Using lambda expression --- result is faster > 36.93%
		Comparator<ListNode> comparator = (o1, o2) -> o1.val - o2.val;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		
		// O(kLogK)
		for (ListNode head : lists) {
			if (head != null) { // !!! Don't forget --- it's very important!!! [[],[]]
				minHeap.offer(head);// O(logK/2)
			}
		}
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		// O(N-k)*logK
		while (!minHeap.isEmpty()) { // O(1)
			ListNode curNode = minHeap.poll();// mini value
			tail.next = curNode;
			tail = tail.next;
			
			if (curNode.next != null) {
				minHeap.offer(curNode.next);
			}
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