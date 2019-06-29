package com.github.leetcode.easy_top100;

import java.util.Arrays;

public class MoveZeroes283_top27 {

	public static void main(String[] args) {
		MoveZeroes283_top27 obj = new MoveZeroes283_top27();
		int[] n1 = {0,1,0,3,12};
		obj.moveZeroes(n1);
		System.out.println("Cai Test = " + Arrays.toString(n1));
		
		int[] n2 = {0};
		obj.moveZeroes(n2);
		System.out.println("Cai Test = " + Arrays.toString(n2));
	}

	
	/**
	 * You must do this in-place without making a copy of the array.
	 * Minimize the total number of operations.
	 * 
	 */
	
	// 0 ms, faster than 100.00%
	// More Clean solution
	public void moveZeroes(int[] nums) {
		final int n = nums.length;
		int nonZeroIndex = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				if (nonZeroIndex != i) {
					// !!! put 0 to i position
					nums[nonZeroIndex++] = nums[i];
					nums[i] = 0;
				} else {
					nonZeroIndex++;
				}
			}
		}
	}
	
	
	// 0 ms, faster than 100.00%
	// Approach 1: one loop to solve the problem
	public void moveZeroes3(int[] nums) {
		final int n = nums.length;
		int nonZeroIndex = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				if (nonZeroIndex != i) {
					// swap two elements --- put 0 to i position
					int tmp = nums[nonZeroIndex];
					nums[nonZeroIndex++] = nums[i];
					nums[i] = tmp;
				} else {
					nonZeroIndex++;
				}
			}
		}
	}
	
	// 0 ms, faster than 100.00%
	
	// Approach 1: Use nonZeroIndex to put non zero number on head
	// TC: O(n)
	public void moveZeroes2(int[] nums) {
		final int n = nums.length;
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				// try to find first non-0 val
				while (i < n && nums[i] == 0) { //!!! 注意不能少了 i < n
					i++;
				}
			}
			if (i < n) { //!!! 注意不能少了 i < n
				nums[index++] = nums[i];
			}
		}
		
		for (int i = index; i< n; i++) {
			nums[i] = 0;
		}
	}
}
