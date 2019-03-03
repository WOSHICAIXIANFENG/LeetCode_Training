package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note: You must do this in-place without making a copy of the array. Minimize the total number of operations.
 * 
 * @author Samuel.Cai
 */
public class MoveZeroes_283 {

	public static void main(String[] args) {
		int[] a1 = {0,1,0,3,12};
		moveZeroes(a1);
		System.out.println("Cai Test = " + Arrays.toString(a1));
		
		int[] a2 = {3,3,0,1,0,3,12};
		moveZeroes(a2);
		System.out.println("Cai Test = " + Arrays.toString(a2));
	}
	
	// 1 ms, faster than 100.00%
	// Approach 3: 
	// Space Complexity: O(1).
	// Time Complexity: O(n). However, the total number of operations are optimal. The total operations (array writes) that code
	// does is Number of non-0 elements. This gives us a much better best-case(when most of the elements are 0) complexity that the last solution.
	// 
	public static void moveZeroes(int[] nums) {
		for (int curr = 0, lastNonZeroFoundIndex = 0; curr < nums.length; curr++) {
			if (nums[curr] != 0) {
				if (lastNonZeroFoundIndex != curr) {
					// do swap two elements
					int temp = nums[lastNonZeroFoundIndex];
					nums[lastNonZeroFoundIndex++] = nums[curr];
					nums[curr] = temp;
				} else {
					lastNonZeroFoundIndex++;
				}
			}
		}
	}

	
	// e.g. ---- [0, 0, 0, ..., 0, 1] ----
	// Approach 2: Optimal Space Complexity.
	// Time Complexity: O(n). However, the total number of operations are still sub-optimal. 
	//   The total operations (array writes) that code does is n. (Total number of elements).
	// Space Complexity: O(1).
//	public static void moveZeroes(int[] nums) {
//		int lastNonZeroFoundIndex = 0;
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] != 0) {
//				nums[lastNonZeroFoundIndex++] = nums[i];
//			}
//		}
//		
//		for (int i = lastNonZeroFoundIndex; i < nums.length; i++) {
//			nums[i] = 0;
//		}
//	}
	
	// Approach 1: 
	// Time Complexity: O(n). 
	// Space Complexity: O(n). Since we are creating the temp array to store results.
//	public static void moveZeroes(int[] nums) {
//        int numZeroes = 0;
//        for (int num : nums) {
//        	if (num == 0) {
//        		numZeroes++;
//        	}
//        }
//        
//        int[] temp = new int[nums.length - numZeroes];
//        int start = 0;
//        for (int num : nums) {
//        	if (num != 0) {
//        		temp[start++] = num;
//        	}
//        }
//        
//        for (int i = 0; i < nums.length; i++) {
//        	if (i < start) {
//        		nums[i] = temp[i];
//        	} else {
//        		nums[i] = 0;
//        	}
//        }
//    }
}
