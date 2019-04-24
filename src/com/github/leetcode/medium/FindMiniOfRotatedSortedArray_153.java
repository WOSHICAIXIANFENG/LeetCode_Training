package com.github.leetcode.medium;

public class FindMiniOfRotatedSortedArray_153 {

	public static void main(String[] args) {
		int[] a1 = {3,4,5,1,2};
		int[] a2 = {4,5,6,7,0,1,2};
		System.out.println("Cai Test = " + findMin(a1));//1
		System.out.println("Cai Test = " + findMin(a2));//0
		int[] a3 = {3,1,2};
		System.out.println("Cai Test = " + findMin(a3));//1
	}

	// 0 ms, faster than 100.00%
	public static int findMin(int[] nums) {
//		if (nums == null || nums.length == 0) {
//			return -1;
//		}
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			// exists rotation: the mid element is in the left side of pivot
			if (nums[mid] > nums[high]) {
				low = mid + 1;// since 'mid' could == 'low', we have to set 'mid + 1' to avoid endless loop
			} else if (nums[mid] < nums[low]) {
				// exists rotation: the mid element is in the right side of pivot
				high = mid; //!!! because the mid element could be the mini value
			} else {
				// no rotation: normal ascending array
				return nums[low];
			}
		}
        return -1;
    }
}
