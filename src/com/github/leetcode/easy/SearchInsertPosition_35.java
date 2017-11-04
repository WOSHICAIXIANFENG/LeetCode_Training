package com.github.leetcode.easy;

/**
 
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

 * @author Samuel
 *
 */
public class SearchInsertPosition_35 {

	public static void main(String[] args) {
		int[] array1 = {1,3,5,6};
		int t1 = 5;
		int t2 = 2;
		int t3 = 7;
		int t4 = 0;
		
		System.out.println("Samuel Test searchInsert = " + searchInsert(array1, t1));
		System.out.println("Samuel Test searchInsert = " + searchInsert(array1, t2));
		System.out.println("Samuel Test searchInsert = " + searchInsert(array1, t3));
		System.out.println("Samuel Test searchInsert = " + searchInsert(array1, t4));
	}
	
	// Note: for Binary Search Time complexity: O(log(n))
	public static int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
	
		while (low <= high) { // !!! --- Don't forget = 
			int mid = (low + high) / 2;
			if (nums[mid] > target) {
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		
        return low; // !!! --- return low is right. return high is wrong!!!
    }

}
