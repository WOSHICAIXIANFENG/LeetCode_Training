package com.github.leetcode.easy;

import java.util.Arrays;

/**
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.


 * @author Samuel
 *
 */
public class MergeSortedArray_88 {

	public static void main(String[] args) {
		int[] nums1 = {1,3,5,7,9,-1,-1,-1,-1}; // -1 is flag
		int[] nums2 = {2,4,6,8};
		
		merge(nums1, 5, nums2, 4);
		
		System.out.println("Samuel Test MergeSortedArray_88 = " + Arrays.toString(nums1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i > -1 && j > -1) {
        	nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        	// why the following line compile error?
        	//nums1[i] > nums2[j] ? nums1[k--] = nums1[i--] : nums1[k--] = nums2[j--];
        }
        
        while (j > -1) {
        	nums1[k--] = nums2[j--];
        }
    }
}
