package com.github.leetcode.easy;

public class BinarySearch_704 {

	public static void main(String[] args) {
		int[] a1 = {-1,0,3,5,9,12};
		System.out.println("Cai Test = " + search(a1, 9));//4
		System.out.println("Cai Test = " + search(a1, 2));//-1
		System.out.println("Cai Test = " + search(a1, 13));// -1
	}

	// 2 ms, faster than 100.00%
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int left = 0; 
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
        return -1;
    }
}
