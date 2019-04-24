package com.github.leetcode.medium;

// Better means ---- easy to understand and catch it
// https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14435/Clever-idea-making-it-simple
public class SearchInRotatedSortedArray_34_better {

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
	
	/**
	 * 
	 * Two test cases help us to analyze：
	 * case1:  the pivot happened in the first half of original ascending array
	 * [1,2,3,4,5,6,7,8,9] --->  [3,4,5,6,7,8,9, 1,2]  
	 * find 5 ---> [3,4,5,6,7,8,9, 1,2] ---> not change
	 * find 1.5 ---> [3,4,5,6,7,8,9, 1,2]  ---> change --> [3,4,5,6,-inf,8,9, 1,2]
	 * 
	 * case2:  the pivot happened in the second half of original ascending array
	 * [1,2,3,4,5,6,7,8,9] --->  [8,9, 1,2,3,4,5,6,7]
	 * find 4 ---->  [8,9, 1,2,3,4,5,6,7] ----> not change
	 * find 8.5 ---->  [8,9, 1,2,3,4,5,6,7] ----> [8,9, 1,2,inf,4,5,6,7]
	 */
	// https://leetcode.windliang.cc/leetCode-33-Search-in-Rotated-Sorted-Array.html
	
	//Your algorithm's runtime complexity must be in the order of O(log n).
	// Tow key points: 
	// 1: the original array is in ascending order, only one time rotated.
	// 2: no duplicate exists in the array 
//	public static int search(int[] nums, int target) {
//		if (nums == null || nums.length == 0) return -1;
//		
//		int low = 0;
//		int high = nums.length - 1;
//		while (low <= high) {
//			int mid = low + (high - low) / 2;
//			
//			int num = nums[mid];
//			//nums [ mid ] 和 target 在同一段
//			// since target could == nums[0], in that case, 他们则不在同一段
//			// 所以这里只用!!!!! target < nums[0], 不能用两个 nums[mid] > nums[0] == target > nums[0]
//			// Note!!! You also could compare with nums[low]!!!
//			// 
//			if (nums[mid] < nums[0] == target < nums[0]) {
//				num = nums[mid];
//			} else {
//				//nums [ mid ] 和 target 不在同一段
//				num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//			}
//	        
//			// think the array is in ascending sort now
//	        if (num < target)
//	            low = mid + 1;// since low could == mid, we have to set 'low = mid + 1'
//	        else if (num > target)
//	            high = mid - 1;
//	        else
//	            return mid;
//		}
//        return -1;
//    }
	
	// Finally Practice Version!
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		
		int low = 0;
		int high = nums.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int num = nums[mid];
			
			// check if the target and mid value are in the same ascending sequence
			if (target < nums[low] == num < nums[low]) {
				// not change mid's value
			} else {
				if (target >= nums[low]) {
					// target will be in the first half (first ascending sequence)
					num = Integer.MAX_VALUE;
				} else {
					num = Integer.MIN_VALUE;
				}
			}
			
			// Now: the array looks like a pure ascending array
			if (target == num) {
				return mid;
			} else if (target > num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return -1;
	}
}
