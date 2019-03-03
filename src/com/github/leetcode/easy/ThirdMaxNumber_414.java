package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaxNumber_414 {

	public static void main(String[] args) {
		
//		Integer t = null;
//		System.out.println("Cai Test test crash = " + (5 > t)); // NPE will occur
		
		
		int[] a1 = {3,2,1};
		int[] a2 = {1,2};
		int[] a3 = {2,2,3,1};
		System.out.println("Cai Test = " + thirdMax(a1));//1
		System.out.println("Cai Test = " + thirdMax(a2));//2
		System.out.println("Cai Test = " + thirdMax(a3));//1
		
		int[] a4 = {Integer.MAX_VALUE,2,3,1};
		int[] a5 = {Integer.MAX_VALUE - 1, Integer.MAX_VALUE,3,1};
		System.out.println("Cai Test = " + thirdMax(a4));//2
		System.out.println("Cai Test = " + thirdMax(a5));//3
		int[] a6 = {1,2,2,2,2,1,1};
		System.out.println("Cai Test = " + thirdMax(a6));//2
		
		int[] a7 = {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
		System.out.println("Cai Test = " + thirdMax(a7));
		
		int[] a8 = {2,2,3,1};
		System.out.println("Cai Test = " + thirdMax(a8));
	}
	
	// 10 ms, faster than 21.65%
	// Approach 2: use PriorityQueue API， PriorityQueue is a 基于优先级堆的优先级队列。element can't be null
	// PriorityQueue: peek(), element() is O(1). add(), offer(), poll() is logN
	/**
	 *  O(log n) time for the enqueing and dequeing methods (offer, poll, remove() and add)
		O(n) for the remove(Object) and contains(Object) methods
		O(1) for the retrieval methods (peek, element, and size)
	 */
	// HashSet<> contains(),add(), remove()..  O(1).
//	public static int thirdMax(int[] nums) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		Set<Integer> set = new HashSet<>();// use set.contains() to reduce time complexity. 
//		for (int n : nums) {
//			if (!set.contains(n)) {
//				pq.offer(n);
//				set.add(n);
//				if (pq.size() > 3) {
//					set.remove(pq.poll());
//				}
//			}
//		}
//		
//		if (pq.size() < 3) {
//			while (pq.size() > 1) {
//				pq.poll();
//			}
//		}
//		return pq.peek();
//	}
	
	// 2 ms, faster than 98.48% 
	// Best solution ---- use primary type long to solve the initicalization issue.
	// Time Complexity: O(n)
	public static int thirdMax(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		// user primary type long to solve the initialization issue.
		long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
		for (int n : nums) {
			// !!! ignore the same element. e.g. [2,2,3,1] there are two max2 values, [3,3,2,1] -- two max1 value. 
			if (n == max1 || n == max2 || n == max3) continue;
			
			if (n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (n > max2) {
				max3 = max2;
				max2 = n;
			} else if (n > max3){
				max3 = n;
			}
		}
		
		if (max3 == Long.MIN_VALUE) {
			return (int) max1;
		} else {
			return (int) max3;
		}
	}
	
	// 3 ms, faster than 80.56% 
	// Use Integer to solve the initialization issue, we can set it to null
//	public static int thirdMax(int[] nums) {
//		if (nums == null || nums.length == 0) return 0;
//		
//		Integer max1 = null, max2 = null, max3 = null;
//		for (Integer n : nums) { // have to set the type to Obj Integer to avoid NPE of unboxing.
////			if (n == max1 || n == max2 || n == max3) continue; // a7 ran wrong
//			if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
//			
//			if (max1 == null || n > max1) {
//				max3 = max2;
//				max2 = max1;
//				max1 = n;
//			} else if (max2 == null || n > max2) { // 5 > null 
//				max3 = max2;
//				max2 = n;
//			} else if (max3 == null || n > max3){
//				max3 = n;
//			}
//		}
//		return max3 == null ? max1 : max3;
//	}

	// the challenge is how to initial the max1, max2, max3. How to solve this problem???
//	public static int thirdMax(int[] nums) {
//		if (nums == null || nums.length == 0) return 0;
//		
//		int max = Integer.MIN_VALUE;
//		int secondMax = Integer.MIN_VALUE;
//		int thirdMax = Integer.MIN_VALUE;
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] == max || nums[i] == secondMax || nums[i] == thirdMax) continue;
//			
//			if (nums[i] > max) {
//				thirdMax = secondMax;
//				secondMax = max;
//				max = nums[i];
//			} else if (nums[i] > secondMax) {
//				thirdMax = secondMax;
//				secondMax = nums[i];
//			} else if (nums[i] > thirdMax) {
//				thirdMax = nums[i];
//			}
//		}
//		
//		
//		if (thirdMax != secondMax && secondMax != max) {
//			return thirdMax;
//		} else {
//			return max;
//		}
//    }
}
