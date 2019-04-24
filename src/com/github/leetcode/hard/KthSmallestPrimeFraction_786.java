package com.github.leetcode.hard;

import java.util.Arrays;

public class KthSmallestPrimeFraction_786 {

	public static void main(String[] args) {
		int[] a1 = {1, 2, 3, 5};
		System.out.println("Cai Test = " + Arrays.toString(kthSmallestPrimeFraction(a1, 3)));
	
		int[] a2 = {1, 7};
		System.out.println("Cai Test = " + Arrays.toString(kthSmallestPrimeFraction(a2, 1)));
	}
	
	// note: A is sorted array
	
	// 6 ms, faster than 99.19%
	// Approach 2: Binary Search
	// For each mid, compute # of pairs whose fraction <= mid
	// Create a virtual matrix to speed up the search process
	// Time Complexity: O(log(max)n^2) (without using virtualMatrix) -- O(log(max)n)  == 最优 O(log(3000)n) 
	// Space Complexity: O(1)
	public static int[] kthSmallestPrimeFraction(int[] A, int k) {
		if (A == null || A.length == 0) return new int[] {};
		
		int len = A.length;
		
		double low = 0;
		double high = 1;//since it is a fraction
		while (low <= high) {
			double mid = low + (high - low) / 2;
			
			// compute # of pairs whose fraction <= mid
			int x = 0, y = 0;
			int count = 0;
			double max_f = 0.0;
			// use Vertial metrix 
			int j = 1;//!!!
			for (int i = 0; i < len - 1; i++) {
				while (j < len && A[i] > mid * A[j]) {
					j++;
				}
				if (j == len) {
					break;
				}
				count += (len - j);
				double f = (double) A[i] / A[j];
				if (f > max_f) {
					max_f = f;
					x = A[i];
					y = A[j];
				}
			}
			
			if (count == k) {
				return new int[] {x, y};
			} else if (count > k) {
				high = mid;//因为mid 是double类型的，所以没有 bound问题
			} else {
				low = mid; //因为mid 是double类型的，所以没有 bound问题，每次都是不一样的。
			}
		}
		
		return new int[] {};
	}

	// Time Limit Exceeded
	// Approach 1: Brute Force ----- since A will have length between 2 and 2000. So TC == O(n^2) will exceeded time limit
	// Time Complexity: O(n^2) + n^2log(n^2)
	// Space Complexity: O(n^2)
//	public static int[] kthSmallestPrimeFraction(int[] A, int K) {
//		if (A == null || A.length == 0) {
//			return new int[]{};
//		}
//		int len = A.length;
//		Fraction[] fractionArray = new Fraction[len * (len - 1) / 2];
//		int index = 0;
//		for (int i = 0; i < len; i++) {
//			for (int j = i + 1; j < len; j++) {
//				fractionArray[index++] = new Fraction(A[i], A[j]);
//			}
//		}
//		
//		Arrays.sort(fractionArray);
//		//System.out.println(Arrays.toString(fractionArray));
//		
//        return new int[] {fractionArray[K - 1].x, fractionArray[K - 1].y};
//    }
}

class Fraction implements Comparable<Fraction> {
	int x, y;
	public Fraction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Fraction that) {
		return Double.compare((double)x/y, (double)that.x/that.y) ;
	}
	@Override
	public String toString() {
		return x + "/" + y;
	}
	
}
