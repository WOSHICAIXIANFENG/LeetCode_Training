package com.github.leetcode.easy;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

 * @author Samuel
 *
 */
public class RemoveDuplicatesFromArray_26 {

	public static void main(String[] args) {
		// only for sorted array
		int[] t1 = {1,2,2};
		int[] t2 = {1,2,3,3};
		int[] t3 = {1,1,2,2,3,3,3};
		
		System.out.println("Samuel Test removeDuplicates = " + removeDuplicates(t1));
		System.out.println("Samuel Test removeDuplicates = " + removeDuplicates(t2));
		System.out.println("Samuel Test removeDuplicates = " + removeDuplicates(t3));
	}

	// time complexity: O(n), space complexity O(1) --- i
	public static int removeDuplicates(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i == 0 || n > nums[i-1]) // !!! Don't forget i == 0
	            nums[i++] = n;
	    return i;
	}
	
}
