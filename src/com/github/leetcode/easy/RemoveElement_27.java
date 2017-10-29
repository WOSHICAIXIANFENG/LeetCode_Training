package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-element/
 * 
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

 * @author Samuel
 *
 */
public class RemoveElement_27 {

	public static void main(String[] args) {
		int[] t1 = {3,2,2,3};
		int v1 = 3;
		
		System.out.println("Samuel Test removeElement = " + removeElement(t1, v1));
	}
	
	// time complexity: O(n), space complexity: O(1)
	public static int removeElement(int[] nums, int val) {
		int m = 0;
		for (int i = 0; i < nums.length; i ++) {
			if (nums[i] != val) {
				nums[m] = nums[i];
				m ++;
			}
		}
		System.out.println("Samuel Test after array = " + Arrays.toString(nums));
        return m;
    }

}
