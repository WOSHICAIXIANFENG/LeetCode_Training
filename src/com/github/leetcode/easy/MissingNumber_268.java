package com.github.leetcode.easy;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * @author Samuel
 *
 */
public class MissingNumber_268 {

	public static void main(String[] args) {
		int[] nums = {0,1,2,4,5}; //{0,1,3};
		System.out.println("Samuel Test missingNumber = " + missingNumber(nums));
		
		System.out.println("Samuel Test missingNumber = " + missingNumber2(nums));
	}

	public static int missingNumber(int[] nums) {
		// xor have to be set 0 when been initialized
		int xor = 0, i = 0;
		
        for (i = 0; i < nums.length; i ++) {
        	xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
	
	// n+(n-1)+(n-2)+(n-3)+……+ 4 + 3 + 2 +1 = n(n+1)/2
	// O(1) space and O(n) in time
	public static int missingNumber2(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		
		// n(n+1)/2 - x = sum
		return (nums.length * (nums.length + 1)) / 2 - sum;	
	}
}
