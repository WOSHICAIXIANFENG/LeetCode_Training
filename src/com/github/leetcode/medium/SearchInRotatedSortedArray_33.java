package com.github.leetcode.medium;

// 建议掌握最好的方法 SearchInRotatedSortedArray_33_best
public class SearchInRotatedSortedArray_33 {

	public static void main(String[] args) {
		int[] a1 = {4,5,6,7,0,1,2};
		System.out.println("Cai Test = " + search(a1, 0));//4
		System.out.println("Cai Test = " + search(a1, 3));//-1
		
		// !!! --- cases ---- the solution need to cover the original ascending array!!!
		int[] a2 = {1,3};
		System.out.println("Cai Test = " + search(a2, 3));//1
		System.out.println("Cai Test = " + search(a2, 1));//0
		
		int[] a3 = {5,1,3};
		System.out.println("Cai Test = " + search(a3, 5));//0
	}
	
	//5 ms, faster than 100%
	// Time Complexity:  O(logN)
	
	/**
	 * 
	 * Two test cases help us to analyze：
	 * case1:  the pivot happened in the first half of original ascending array
	 * [1,2,3,4,5,6,7,8,9] --->  [3,4,5,6,7,8,9, 1,2]
	 * 
	 * case2:  the pivot happened in the second half of original ascending array
	 * [1,2,3,4,5,6,7,8,9] --->  [8,9, 1,2,3,4,5,6,7]
	 * 
	 */
	
	// In standard binary search, we focus on the mid pointer/index, we have if else to cover ==, >, <
	// Here!!! ---- We focus on two pointers: the mid index and the low/high index
	// 1. Compare A[mid] and A[low] to get how the pivot occurred in original ascending array.
	// 2. Use target to compare with A[mid] and A[low] or A[high] to know the search is go back or go forth.
	// When you compare values for two indexs, you need cover >, <, == 

	//Your algorithm's runtime complexity must be in the order of O(log n).
	// Tow key points: 
	// 1: the original array is in ascending order, only one time rotated.
	// 2: no duplicate exists in the array 
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) return mid;
			
			// compare with the low element, to confirm the mid index is which ascending sequences
			// in the first ascending sequence. (pivot occurred in the first half)
			if (nums[mid] >= nums[low]) {//!! need >= 
				// !!! we need '>=' to cover everything
				if (target >= nums[low] && target < nums[mid]) {
					// searching goes to the first half, that's why compare with nums[low]
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				// there is no duplicate elements
				// here the mid index is in the second ascending sequence
				// !!! we need '<=' to cover everything 
				if (target > nums[mid] && target <= nums[high]) {
					// searching goes to the second half, that's why compare with nums[high]
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
        return -1;
    }
}
