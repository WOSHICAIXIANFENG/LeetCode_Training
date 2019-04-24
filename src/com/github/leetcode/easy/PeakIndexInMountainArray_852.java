package com.github.leetcode.easy;

public class PeakIndexInMountainArray_852 {

	public static void main(String[] args) {
		int[] a1 = {0,1,0};
		int[] a2 = {0,2,1,0};
		System.out.println("Cai Test = " + peakIndexInMountainArray(a1));// 1
		System.out.println("Cai Test = " + peakIndexInMountainArray(a2));// 1
	}

	// 1 ms, faster than 100.00%
	// Approach 1: Linear Scan
	// Time Complexity: O(N)
	// Space Complexity: O(1)
//	public static int peakIndexInMountainArray(int[] A) {
//		if (A == null || A.length < 3) return 0;
//		
//		int index = 0;
//		while (A[index] < A[index + 1]) {
//			index++;
//		}
//        return index;
//    }
	
	// 1 ms, faster than 100.00%
	// Better Solution
	// Approach 2: Binary Search
	// Time Complexity: O(log2^N)
	public static int peakIndexInMountainArray(int[] A) {
		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return mid;
			} else if (A[mid] > A[mid - 1]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
