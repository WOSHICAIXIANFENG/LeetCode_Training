package com.github.leetcode.easy;

public class MonotonicArray_896 {

	public static void main(String[] args) {
		int[] a1 = {1,2,2,3};
		int[] a2 = {6,5,4,4};
		int[] a3 = {1,3,2};
		int[] a4 = {1,2,4,5};
		int[] a5 = {1,1,1};
		System.out.println("Cai Test = " + isMonotonic(a1));
		System.out.println("Cai Test = " + isMonotonic(a2));
		System.out.println("Cai Test = " + isMonotonic(a3));
		System.out.println("Cai Test = " + isMonotonic(a4));
		System.out.println("Cai Test = " + isMonotonic(a5));
		
		int[] a6 = {1,1,0};
		System.out.println("Cai Test = " + isMonotonic(a6));
	}
	
	// 11 ms, faster than 99.63% 
	//[3,2,1,1] --- store = 1, c = 1,1,0
	//[1,3,4,1] --- store = 0, c = -1,-1,1
	//[1,1,1] --- store = 0, c = 0,0
//	public static boolean isMonotonic(int[] A) {
//		if (A == null || A.length == 0) return false;
//		
//		int store = Integer.compare(A[0], A[A.length - 1]);
//		for (int i = 0; i < A.length - 1; i++) {
//			int c = Integer.compare(A[i], A[i + 1]);
//			if (c != 0 && c != store) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	// 12 ms, faster than 91.73%
	// Approach 3: One Pass(Simple Variant)
	public static boolean isMonotonic(int[] A) {
		boolean increasing = true;
		boolean decreasing = true;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1]) {
				increasing = false;
			} else if (A[i] < A[i + 1]) {
				decreasing = false;
			}
		}
		return increasing || decreasing;
	}
	
	// 13 ms, faster than 68.27%
	// Approach 2: One pass
	// O(n)
//	public static boolean isMonotonic(int[] A) {
//		int store = 0;
//		for (int i = 0; i < A.length - 1; i++) {
//			int c = Integer.compare(A[i], A[i + 1]);
//			if (c != 0) {// increase or decrease
//				if (store != 0 && c != store) { // changed
//					return false;
//				}
//				store = c;
//			}
//		}
//		return true;
//	}
	
	// Approach 1: two pass
	// Time Complexity: O(n)
//	public static boolean isMonotonic(int[] A) {
//		return increasing(A) || decreasing(A);
//	}

	// First solution --- not very clear
	// 12 ms, faster than 91.73%
//	public static boolean isMonotonic(int[] A) {
//		if (A == null || A.length == 0) return false;
//		
//		boolean increase = false;
//		boolean decrease = false;
//		for (int i = 0; i < A.length - 1; i++) {
//			if (!increase && !decrease && A[i] < A[i + 1]) {
//				increase = true;
//			} else if (!increase && !decrease && A[i] > A[i + 1]) {
//				decrease = true;
//			}
//			
//			if (increase && A[i] > A[i + 1]) {
//				return false;
//			} else if (decrease && A[i] < A[i + 1]) {
//				return false;
//			}
//		}
//        return true;
//    }
}
