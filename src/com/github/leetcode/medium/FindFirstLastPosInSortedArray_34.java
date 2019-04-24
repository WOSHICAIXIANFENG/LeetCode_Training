package com.github.leetcode.medium;

import java.util.Arrays;

public class FindFirstLastPosInSortedArray_34 {

	public static void main(String[] args) {
		int[] a1 = {5,7,7,8,8,10};
		System.out.println("Cai Test = " + Arrays.toString(searchRange(a1, 8)));//[3,4]
		System.out.println("Cai Test = " + Arrays.toString(searchRange(a1, 6)));//[-1,-1]
	
		int[] a2 = {7,7};
		// Note !!! ---- care for IndexOutOfArray
		System.out.println("Cai Test = " + Arrays.toString(searchRange(a2, 7)));//[0,1]
		// Note !!! ---- null case still need to return [-1,-1]
		System.out.println("Cai Test = " + Arrays.toString(searchRange(null, 7)));//[-1,-1]
		
		//!!! Special case
		int[] a3 = {6};
		// Note !!! ---- Allow Special case, only one element
		System.out.println("Cai Test = " + Arrays.toString(searchRange(a3, 6)));//[0,0]
		System.out.println("Cai Test = " + Arrays.toString(searchRange(a3, 8)));//[0,0]
		
		int[] a4 = {1,2,5,5,5,5};
		System.out.println("Cai Test = " + Arrays.toString(searchRange(a4, 5)));//[2,5]
		System.out.println("Cai Test = " + Arrays.toString(searchRange(a4, 6)));//[-1,-1]
	}
	
	// 3 ms, faster than 100.00%
	// Use Binary Search 
	// Time Complexity: O(log2^N)
	// Space Complexity: O(1)
	public static int[] searchRange(int[] nums, int target) {
		int[] result = {-1, -1};
		if (nums == null || nums.length == 0) return result;
		
        int leftIndex = extremeInsertionIndex(nums, target, true);
        // check if the leftIndex is out of array bouds and check if the value is target
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            // [1,2,2] find 3 ---> leftIndex == 3
            // [1,3,3] find 2 ---> leftIndex == 1
            return result;
        }
        
        result[0] = leftIndex;
        result[1] = extremeInsertionIndex(nums, target, false) - 1; // since we borrowed one more index
		return result;
	}
	
	// returns leftmost (or rightmost) index at which 'target' should be inserted in sorted array 'nums' via binary search
	private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
		int low = 0;
        int high = nums.length;// !!! we need to borrow one more index. 
        // because we looking for a bigger value, the last element could be target.
        
        while (low < high) {// !!! the leftmost or rightmost index
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
	}

	// !!! Problem ----- the part to find first and last position is still O(n) time consume. [2,2,2,2,2,2] to find 2
	// 3 ms, faster than 100.00%
	// nums -- is sorted in ascending order
	// Your algorithm's runtime complexity must be in the order of O(log n).
//	public static int[] searchRange(int[] nums, int target) {
//		int[] result = {-1, -1};
//		if (nums == null || nums.length == 0) return result;
//		
//		int low = 0;
//		int high = nums.length - 1;
//		while (low <= high) {
//			int mid = low + (high - low) / 2;
//			if (nums[mid] == target) {
//				// try to find the first and last position around mid
//				int first = mid;
//				while (first > 0 && nums[first] == nums[first - 1]) {
//					first--;
//				}
//				result[0] = first;
//				
//				int last = mid;
//				while (last < nums.length - 1 && nums[last] == nums[last + 1]) {
//					last++;
//				}
//				
//				result[1] = last;
//				break;
//			} else if (nums[mid] > target) {
//				high = mid - 1;
//			} else {
//				low = mid + 1;
//			}
//		}
//        return result;
//    }
}
