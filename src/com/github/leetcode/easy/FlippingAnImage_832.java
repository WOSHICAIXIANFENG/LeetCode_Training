package com.github.leetcode.easy;

import java.util.Arrays;

public class FlippingAnImage_832 {

	public static void main(String[] args) {
		int[][] a1 = { {1,1,0}, {1,0,1}, {0,0,0} };
		int[][] a2 = { {1,1,0,0}, {1,0,0,1}, {0,1,1,1}, {1,0,1,0} };
		System.out.println("Cai Test = " + print(flipAndInvertImage(a1)));
		System.out.println("Cai Test = " + print(flipAndInvertImage(a2)));
		
		// special cases
		int[][] a3 = { {1} };
		System.out.println("Cai Test = " + print(flipAndInvertImage(a3)));
	}
	
	public static String print(int[][] A) {
		String result = "[ ";
		
		for (int[] a : A) {
			result += Arrays.toString(a);
		}
		
		return result += " ]";
	}

	// Simple and better solution
	public static int[][] flipAndInvertImage(int[][] A) {
		for (int[] a : A) {
			int length = a.length;
			
			for (int i = 0; i < (length + 1) / 2; i++) {
				// reverse and invert at the same time. 
				int temp = a[i] ^ 1;
				a[i] = a[length - 1 - i] ^ 1;
				a[length - 1 - i] = temp;
			}
 		}
		
        return A;
	}
	
	// 3 ms, faster than 100.00%
//	public static int[][] flipAndInvertImage(int[][] A) {
//		// 0, 1 ---> not change
//		// 1, 1 ---> invert to 0, 0
//		// 1, 0 ---> not change
//		// 0, 0 ---> inver to 1, 1
//		for (int[] a : A) {
//			int half = a.length / 2;
//			for (int i = 0; i < half; i++) {
//				if (a[i] == a[a.length - 1 - i]) {
//					a[i] ^= 1;
//					a[a.length - 1 - i] ^= 1;
//				}
//			}
//			
//			if (a.length % 2 == 1) {
//				a[half] ^= 1;
//			}
// 		}
//		
//        return A;
//    }
}
