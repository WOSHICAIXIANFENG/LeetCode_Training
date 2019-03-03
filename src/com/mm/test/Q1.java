package com.mm.test;

public class Q1 {
	public static void main(String[] args) {
		System.out.println("Samuel Test second largest integer = " + f(new int[]{1,2,3,4}));
		System.out.println("Samuel Test second largest integer = " + f(new int[]{4,1,2,3}));
		System.out.println("Samuel Test second largest integer = " + f(new int[]{1,1,2,2}));
		System.out.println("Samuel Test second largest integer = " + f(new int[]{1,1}));
		System.out.println("Samuel Test second largest integer = " + f(new int[]{1}));
		System.out.println("Samuel Test second largest integer = " + f(new int[]{}));
	}
	
	static int f(int[] a) {
		int max1 = -1;
		int max2 = -1;
		
		for (int i : a) {
			if (i > max1) {
				max2 = max1;
				max1 = i;
			} else if (i < max1 && i > max2) {
				max2 = i;
			}
		}
		
		return max2;
	}
	
//	static int f(int[] a) {
//		int max1 = -1;
//		int max2 = -1;
//		
//		for (int i : a) {
//			if (i > max1) {
//				max2 = max1;
//				max1 = i;
//			} else if (i < max1 && i > max2) {
//				max2 = i;
//			}
//		}
//		
//		return max2;
//	}
}
