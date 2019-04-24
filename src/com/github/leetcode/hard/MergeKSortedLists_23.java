package com.github.leetcode.hard;

import java.util.PriorityQueue;

public class MergeKSortedLists_23 {

	public static void main(String[] args) {
		MergeKSortedLists_23 obj = new MergeKSortedLists_23();
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
	
	// 2 ms, faster than 99.92% 
	// Approach 2: merge two pair lists each time
	// TC: O(kN)
	// SC: O(1) --- it's a tail-recursive
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
		if (lists.length == 1) return lists[0];
        
		return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start + 1 == end) return merge2Lists(lists[start], lists[end]);
        ListNode l1 = mergeKListsHelper(lists, start, (end + start) / 2);
        ListNode l2 = mergeKListsHelper(lists, (end + start) / 2 + 1, end);
        return merge2Lists(l1, l2);
    }
	
	// Approach 2: merge two lists each time
	// TC: O(KN) --- K is the number of linked lists
    // We can merge two sorted linked list in O(n) time where n is the toal number of nodes in two lists
    // Sum up the merge process we can get O(Sum(i * N/k + N/k) from [1, k-1] == O(KN)
	// SC: O(1) 
//	public ListNode mergeKLists(ListNode[] lists) {
//		if (lists == null || lists.length == 0) return null;
//		// for special case [[1]] --> [1]
//		if (lists.length == 1) return lists[0];
//		
//		int size = lists.length;
//		int i = 0;
//		ListNode merged = null;
//		while (i < size - 1) {
//			if (merged == null) {
//				merged = merge2Lists(lists[i], lists[i + 1]);
//			} else {
//				merged = merge2Lists(merged, lists[i + 1]);
//			}
//			i++;
//		}
//		return merged;
//	}
	
	public ListNode merge2Lists(ListNode l1, ListNode l2) {
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

	// 4 ms, faster than 94.88%
	// Approach 1 -- My solution
	// TC: O(NlgK)
	// SC: O(N) --- 可以优化成 O(K)
//	public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        
//        // TC: O(N)
//        for (ListNode list : lists) {
//        	ListNode head = list;
//        	while (head != null) {
//        		minHeap.offer(head.val);// O(logN)
//        		head = head.next;
//        	}
//        }
//        
//        //System.out.println("Cai Test size = " + minHeap.size());
//        //System.out.println("Cai Test peek = " + minHeap.peek());
//        
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        // O(1)
//        while (!minHeap.isEmpty()) {
//        	ListNode min = new ListNode(minHeap.poll());// O(logN)
//        	tail.next = min;
//        	tail = tail.next;
//        }
//        return dummy.next;
//    }
}

//class ListNode {
//	int val;
//	ListNode next;
//	ListNode(int x) { val = x; }
//	@Override
//	public String toString() {
//		return "ListNode [val=" + val + ", next=" + next + "]";
//	}
//}