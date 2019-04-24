package com.github.leetcode.medium;

public class SearchInRotatedSortedArrayII_81 {
	/**
	 * Would this affect the run-time complexity?  How and Why? 
	 * Answer: Since we have some duplicate elements. 
	 * sometimes we cannot decide whether to go to the left side or right side. 
	 * Only in this case, the time complexity may be O(n), the rest cases are always O(logN)
	 */
	public static void main(String[] args) {
		int[] a1 = {2,5,6,0,0,1,2};
		System.out.println("Cai Test = " + search(a1, 0));//true
		System.out.println("Cai Test = " + search(a1, 3));//false
		
		int[] a2 = {1,3,1,1,1};
		System.out.println("Cai Test = " + search(a2, 3));// true
	}
	
	// 0 ms, faster than 100.00%
	// Best Answer!!! 
	public static boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return false;
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			// skip duplicates from head and tail
			while (low < high && nums[low] == nums[low + 1]) low++;
			// 注意如果你不放，或者放 low <= high，这里会出现 -1的 ArrayIndexOutOfBound Exception
			// 放 low < high 至少保证了处理后array中仍然有两个elements
			// [2,2,2,2,2,2] -----> [2,2] --- find 3 ---> normal ascending array ---> [2] ---> low > high --> exit
			while (low < high && nums[high] == nums[high - 1]) high--;
			
			
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				return true;
			}
			
			// exists rotation: the mid element in the left side of pivot
			if (nums[mid] > nums[high]) {
				// check the pure half first, check the half without pivot
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] < nums[low]) {
				// exists rotation: the mid element is in right side of pivot
				// check the half without pivot
				if (target <= nums[high] && target > nums[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				// there is no rotation in the array. Array is a pure ascending array
				if (target > nums[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		
        return false;
    }
}
