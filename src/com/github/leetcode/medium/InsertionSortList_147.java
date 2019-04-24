package com.github.leetcode.medium;

public class InsertionSortList_147 {

	public static void main(String[] args) {
		InsertionSortList_147 obj = new InsertionSortList_147();
		ListNode n1 = new ListNode(6);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(8);
		ListNode n6 = new ListNode(7);
		ListNode n7 = new ListNode(2);
		ListNode n8 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		System.out.println("Cai Test = " + obj.insertionSortList(n1));
	}

	// 3 ms, faster than 98.89%
	// 画图去练习，编熟
	
	// Approach 1: Use dummy/headN head to point sorted list. Maintain 2 part: sorted, unsorted.
	// Use 2 pointer, cur --> current ele, pre --> end of sorted list. 
	// insert cur into sorted list by comparing with dummy head
	// TC: O(N^2)
	// SC: O(1)
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0);
        ListNode cur = head;// pointer to current element (the first ele of unsorted list)
        ListNode pre = head;// pre pointer to the end of sorted list
        dummy.next = head;
        
        while (cur != null) {
            if (pre.val > cur.val) {
                // we need put cur ele into the sorted list
                pre.next = cur.next;
                
                // Find insert in-place
                ListNode headN = dummy;
                while (headN.next != null && headN.next.val < cur.val) {
                    headN = headN.next;
                }
                
                cur.next = headN.next;// headN.next > cur.val
                headN.next = cur;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
