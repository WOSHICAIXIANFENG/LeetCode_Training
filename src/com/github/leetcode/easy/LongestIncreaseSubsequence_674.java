package com.github.leetcode.easy;

public class LongestIncreaseSubsequence_674 {

	public static void main(String[] args) {
		int[] a1 = {1,3,5,4,7};
		int[] a2 = {2,2,2,2,2};
		int[] a3 = {1,3,5,7};
		int[] a4 = {};
		System.out.println("Cai Test = " + findLengthOfLCIS(a1));
		System.out.println("Cai Test = " + findLengthOfLCIS(a2));
		System.out.println("Cai Test = " + findLengthOfLCIS(a3));
		System.out.println("Cai Test = " + findLengthOfLCIS(a4));
	}
	
	// 2 ms, faster than 100.00%
	// Time Complexity: O(n).
	// Space Complexity: O(1).
	public static int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0) {
            return 0;
        }
		
		int maxLength = 1;
		
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				count++;
			} else {
				if (count > maxLength) {
					maxLength = count;
				}
				count = 1;
			}
		}
        return Math.max(maxLength, count);
    }

}
