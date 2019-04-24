package com.github.leetcode.medium;

public class MedianOfTwoSortedArrays_4 {

	public static void main(String[] args) {
		int[] a1 = {1, 3};
		int[] a2 = {2};
		System.out.println("Cai Test = " + findMedianSortedArrays(a1, a2));
		
		int[] b1 = {1, 2};
		int[] b2 = {3, 4};
		System.out.println("Cai Test = " + findMedianSortedArrays(b1, b2));
	}
	
	// 23 ms, faster than 99.17%
	// Median C[k] =  (n1 + n2 + 1) / 2 ---- right Median
	// k = m1 + m2 = Median = (n1 + n2 + 1) / 2
	// (left) Median value = C(k-1) = Max(A(m1 - 1), B(m2 - 1))
	// Right Median Value = C(k) = Min(A(m1), B(m2))
	// Time Complexity: O(log(Min(n1, n2)))
	// Space Complexity: O(1)
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		if (n1 > n2) {
			return findMedianSortedArrays(nums2, nums1);
		}
		
		int k = (n1 + n2 + 1) / 2;
		int left = 0;
		int right = n1;
		while (left < right) {// 特别注意里面没有 return 的情况，所以 这里必须 <，不然有数组越界问题!!!
			int m1 = left + (right - left) / 2;
			int m2 = k - m1;
			//System.out.println("Cai Test m1 = " + m1 + " , m2 = " + m2);
			if (nums1[m1] > nums2[m2 - 1]) {
				right = m1;//!!! 需要将m1位带入下次考虑
			} else {
				left = m1 + 1;// since m1 could == left, so we must pass m1 + 1 to avoid Over stack
			}
		}
		
		int m1 = left;
		int m2 = k - m1;
		// Ck-1 = Math.max(A[m1 -1], B[m2 - 1])
		int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], 
				m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
		
		if ((n1 + n2) % 2 != 0) {
			return c1;
		}
		
		int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
				m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
		
        return (c1 + c2) * 0.5;
    }

}
