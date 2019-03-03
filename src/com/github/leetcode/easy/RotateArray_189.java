package com.github.leetcode.easy;

import java.util.Arrays;

public class RotateArray_189 {

	public static void main(String[] args) {
		int[] a1 = {1,2,3,4,5,6,7};
		int[] a2 = {-1,-100,3,99};
		rotate(a1, 3);
		System.out.println("Cai Test rotate = " + Arrays.toString(a1));
		rotate(a2, 2);
		System.out.println("Cai Test rotate = " + Arrays.toString(a2));
	}
	
//	// 0 ms, faster than 100.00% 
//	//Approach #4 Using Reverse
//	// Time Complexity: O(n). n elements are reversed a total of three times
//	// Space Complexity: O(1). No extra space is used.
//	public static void rotate(int[] nums, int k) {
//		k = k % nums.length;
//		reverse(nums, 0, nums.length - 1);
//		reverse(nums, 0, k - 1);
//		reverse(nums, k, nums.length - 1);
//	}
//	
//	public static void reverse(int[] nums, int start, int end) {
//		while (start < end) {
//			int temp = nums[start];
//			nums[start] = nums[end];
//			nums[end] = temp;
//			start ++;
//			end --;
//		}
//	}
	
	// 0 ms, faster than 100.00%
	// Cyclic Replacements
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		int count = 0;
		for (int start = 0; count < nums.length; start ++) {
			int current = start;
			int prev = nums[start];
			do {
				int next = (current + k) % nums.length;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				count ++;
			} while (start != current);
		}
	}
	
//	// Using Extra Array
//	// Time Complexity: O(n).
//	// Space Complexity: O(n). Another array of the same size is used.
//	public static void rotate(int[] nums, int k) {
//		int[] a = new int[nums.length];
//		for (int i = 0; i < nums.length; i ++) {
//			a[(i + k) % nums.length] = nums[i];
//		}
//		for (int i = 0; i < nums.length; i ++) {
//			nums[i] = a[i];
//		}
//    }
	
//	// Brute Force
//	// Time Complexity: O(n*k). all the numbers are shifted by one step k times.
//	// Space Complexity: O(1). No extra space is used.
//	public static void rotate(int[] nums, int k) {
//		for (int i = 0; i < k; i ++) {
//			int previous = nums[nums.length - 1];
//			int temp = 0;
//			for (int j = 0; j < nums.length; j ++) {
//				temp = nums[j];
//				nums[j] = previous;
//				previous = temp;
//			}
//		}
//    }
	

}
