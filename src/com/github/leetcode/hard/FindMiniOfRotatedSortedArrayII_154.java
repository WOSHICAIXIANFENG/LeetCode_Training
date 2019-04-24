package com.github.leetcode.hard;

public class FindMiniOfRotatedSortedArrayII_154 {

	// Would allow duplicates affect the run-time complexity? How and why?
	// Answer:
	// the worst time complexity could be O(n)
	public static void main(String[] args) {
		int[] a1 = {4,5,6,7,0,1,2};
		System.out.println("Cai Test = " + findMin(a1));
		
		int[] a2 = {1,3,5};
		System.out.println("Cai Test = " + findMin(a2));
		int[] a3 = {2,2,2,0,1};
		System.out.println("Cai Test = " + findMin(a3));
	}
	
	// 0 ms, faster than 100.00%
	// !!! Amazing !!!
	public static int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			// skip the duplicated number from head and tail
			// put '<' to keep two elements left to avoid ArrayIndexOutOfBound
			while (low < high && nums[low] == nums[low + 1]) low ++;
			while (low < high && nums[high] == nums[high - 1]) high--;
			
			int mid = low + (high - low) / 2;
			// exists rotation: the mid element is in the left side of pivot
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else if (nums[mid] < nums[low]) {
				// exists rotation: the mid element is in the right side of pivot
				high = mid;// mid element could be the mini one
			} else {
				// no rotation
				return nums[low];
			}
		}
        return -1;
    }

}
