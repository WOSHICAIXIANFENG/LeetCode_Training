package com.github.leetcode.easy;

public class IntersectionOfTwoLinkList_160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionOfTwoLinkList_160 icc = new IntersectionOfTwoLinkList_160();
		
		ListNode2 a1 = new ListNode2("a1");
		ListNode2 a2 = new ListNode2("a2");
		ListNode2 c1 = new ListNode2("c1");
		ListNode2 c2 = new ListNode2("c2");
		ListNode2 c3 = new ListNode2("c3");
		ListNode2 b1 = new ListNode2("b1");
		ListNode2 b2 = new ListNode2("b2");
		ListNode2 b3 = new ListNode2("b3");
		
		a1.next = a2;
		a2.next = c1;
		c1.next = c2;
		c2.next = c3;
		
		b1.next = b2;
		b2.next = b3;
		b3.next = c1;
		
		// a1 -> a2 -> c1 -> c2 -> c3
		// b1 -> b2 -> b3 -> c1
		ListNode2 sectionNode = icc.getIntersectionNode(a1, b1);
		System.out.println("Samuel Test section Node = " + sectionNode);
	}
	
	public ListNode2 getIntersectionNode(ListNode2 headA, ListNode2 headB) {
		// boundary check
		if (headA == null || headB == null) {
			return null;
		}
		
		ListNode2 a = headA;
		ListNode2 b = headB;
		
		while(a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		
		return a;
	}

}

class ListNode2 {
	String val;
	ListNode2 next;
	ListNode2 (String x) {
		val = x;
		next = null;
	}
	
	@Override
	public String toString() {
		return " Val = " + val + " ---> " + next;
	}
}