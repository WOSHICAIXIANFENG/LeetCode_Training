package com.github.leetcode.medium;

// best means ---- easy to understand and catch it

public class SearchInRotatedSortedArray_34_best {

	public static void main(String[] args) {
		int[] a1 = {4,5,6,7,0,1,2};
		System.out.println("Cai Test = " + search(a1, 0));//4
		System.out.println("Cai Test = " + search(a1, 3));//-1
		
		// !!! --- cases ---- the solution need to cover the original ascending array!!!
		int[] a2 = {1,3};
		System.out.println("Cai Test = " + search(a2, 3));//1
		System.out.println("Cai Test = " + search(a2, 1));//0
		System.out.println("Cai Test = " + search(a2, 2));//-1
		
		int[] a3 = {5,1,3};
		System.out.println("Cai Test = " + search(a3, 5));//0
	}
	
	// Time Complexity:  O(logN)
	
	// 这是最好的答案，易掌握，易理解！！！
	/**
	 * 
	 * Two test cases help us to analyze：
	 * case1:  the pivot happened in the first half of original ascending array
	 * [1,2,3,4,5,6,7,8,9] --->  [3,4,5,6,7,8,9, 1,2]  
	
	 * 
	 * case2:  the pivot happened in the second half of original ascending array
	 * [1,2,3,4,5,6,7,8,9] --->  [8,9, 1,2,3,4,5,6,7]
	 */
	// https://leetcode.windliang.cc/leetCode-33-Search-in-Rotated-Sorted-Array.html
	
	//Your algorithm's runtime complexity must be in the order of O(log n).
	// Tow key points: 
	// 1: the original array is in ascending order, only one time rotated.
	// 2: no duplicate exists in the array 
	
	// Finally Practice Version!
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		
		int low = 0;
		int high = nums.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (nums[mid] == target) {
				return mid;
			}
			
			// exists rotation: the mid element is in the left of pivot
			if (nums[mid] > nums[high]) {
				// 把不含有pivot的一半放在面判断，这样好掌握!
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] < nums[low]) {
				// exists rotation: the mid element is in the right of pivot
				// adjudge the half without pivot
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				// there is no rotation: it is just a normal ascending array
				if (target > nums[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		
		return -1;
	}
}
