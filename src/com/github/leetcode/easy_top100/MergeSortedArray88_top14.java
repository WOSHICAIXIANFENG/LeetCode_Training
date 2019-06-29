package com.github.leetcode.easy_top100;

import java.util.Arrays;

public class MergeSortedArray88_top14 {

	public static void main(String[] args) {
		MergeSortedArray88_top14 obj = new MergeSortedArray88_top14();
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;
		obj.merge(nums1, m, nums2, n);		
		System.out.println("Cai Test = " + Arrays.toString(nums1));
		
		int[] nums11 = {4,5,6,0,0,0};
		int[] nums22 = {1,2,3};
		obj.merge(nums11, 3, nums22, 3);		
		System.out.println("Cai Test = " + Arrays.toString(nums11));
	}

	// 0 ms, faster than 100.00%
	// Approach 1: iterate from end to start.
	// TC: O(m + n)
	// SC: O(1)
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		}
		
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}
}
