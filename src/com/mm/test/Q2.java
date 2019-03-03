package com.mm.test;

public class Q2 {

	public static void main(String[] args) {
		System.out.println("Samuel Test result = " + f(new int[]{1}));
		System.out.println("Samuel Test result = " + f(new int[]{1,2}));
		System.out.println("Samuel Test result = " + f(new int[]{1,2,3}));
		
		System.out.println("Samuel Test result = " + f(new int[]{1,2,3,4}));
		System.out.println("Samuel Test result = " + f(new int[]{3,3,4,4}));
		System.out.println("Samuel Test result = " + f(new int[]{3,2,3,4}));
		
		System.out.println("Samuel Test result = " + f(new int[]{4,1,2,3}));
		System.out.println("Samuel Test result = " + f(new int[]{1,1}));
		System.out.println("Samuel Test result = " + f(new int[]{}));
	}
	
	static int f(int[] a) {
		int x = 0;
		int y = 0;
		
		for (int i : a) {
			if (i %2 == 0) {
				y += i;
			} else {
				x += i;
			}
		}
		
		return x - y;
	}

//	static int f(int[] a) {
//		int x = 0;
//		int y = 0;
//		
//		for (int i : a) {
//			if (i % 2 == 0) {
//				y += i;
//			} else {
//				x += i;
//			}
//		}
//		
//		return x - y;
//	}
}
