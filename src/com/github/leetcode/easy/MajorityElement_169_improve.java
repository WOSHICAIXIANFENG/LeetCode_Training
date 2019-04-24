package com.github.leetcode.easy;

public class MajorityElement_169_improve {

	public static void main(String[] args) {
		MajorityElement_169_improve obj = new MajorityElement_169_improve();
		int[] a1 = {3,2,3};
		int[] a2 = {2,2,1,1,1,2,2};
		System.out.println("Cai Test majorityElement = " + obj.majorityElement(a1));// 3
		System.out.println("Cai Test majorityElement = " + obj.majorityElement(a2));// 2
	}
	
	// 1 ms, faster than 100.00%
	// !!! If we had some way of counting instances of the major ele as +1 and instance of any other ele as -1.
	// summing them would make it obvious that the majority element is indeed the majority.
	// Approach 6: Boyer-Moore Voting Algorithm
	// TC: O(n) --- lineary time
	// SC: O(1)
	public int majorityElement(int[] nums) {
		int count = 0;
		int candidate = nums[0];
		for (int num : nums) {
			if (num == candidate) {
				count++;
			} else {
				count--;
				if (count == 0) {
					count = 1;
					candidate = num;
				}
			}
		}
		return candidate;
	}
	
	// !!! If we know the majority element in the left and right halves of an array, we can determine which is the global majority element in linear time.
	
	// 2 ms, faster than 88.94%
	// Approach 5: Divide And Conquer
	// TC: O(nlgN)
	// SC: O(lgN) ---- lgN 'cuts' occur, the times of recursion
//	public int majorityElement(int[] nums) {
//		return majorityElementRec(nums, 0, nums.length - 1);
//	}
	
	private int majorityElementRec(int[] nums, int lo, int hi) {
		if (lo == hi) {
			return nums[lo];
		}
		
		int mid = lo + (hi - lo) / 2;
		int ml = majorityElementRec(nums, lo, mid);
		int mr = majorityElementRec(nums, mid + 1, hi);// +1! Don't miss the mid element
		if (ml == mr) {
			return ml;
		}
		
		// otherwise, count each element and return the winner
		int leftCount = countInRange(nums, ml, lo, hi);
		int rightCount = countInRange(nums, mr, lo, hi);
		return leftCount > rightCount ? ml : mr;
	}
	
	private int countInRange(int[] nums, int sum, int lo, int hi) {
		int count = 0;
		for (int i = lo; i <= hi; i++) {
			if (nums[i] == sum) count++;
		}
		return count;
	}

}
