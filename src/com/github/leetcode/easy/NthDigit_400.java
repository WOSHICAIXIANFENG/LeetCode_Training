package com.github.leetcode.easy;

public class NthDigit_400 {

	public static void main(String[] args) {
//		System.out.println("Cai Test = " + findNthDigit(3));
//		System.out.println("Cai Test = " + findNthDigit(11));//12345678910
//		System.out.println("Cai Test = " + findNthDigit(120));//6
//		System.out.println("Cai Test = " + findNthDigit(121));//5
//		System.out.println("Cai Test = " + findNthDigit(122));//6
//		System.out.println("Cai Test = " + findNthDigit(123));//6
//		System.out.println("Cai Test = " + findNthDigit(124));//6
//		System.out.println("Cai Test = " + findNthDigit(125));//6
		System.out.println("Cai Test = " + findNthDigit(2147483647));// 
	}
	
	// 3 ms, faster than 88.35%
	// change the type to long to avoid overflow issue!!!
	public static int findNthDigit(int n) {
		long m = n;
		long start = 1, len = 1, count = 9;
		while (m > count * len) {
			m -= count * len;
			len++;
			System.out.println("len = " + len + " , count * len = " + count * len);
			count *= 10;
			start *= 10;
		}
		
		// get the number which has the nth digit
		start += (m - 1) / len; // -1: because we start from 1,10,100,1000,10000...
		return String.valueOf(start).charAt((int)((m - 1) % len)) - '0';
	}
	
	// for n = 2147483647, it will overflow StringIndexOutOfBoundsException
	// Because count * len will overflow Integer range soon. 
//	public static int findNthDigit(int n) {
//		int m = n;
//		int start = 1, len = 1, count = 9;
//		
//		while (m > count * len) {
//			m -= count * len; // !!! Overflow
//			System.out.println("len = " + len + " , count * len = " + count * len);
//			len++;
//			count *= 10;
//			start *= 10;
//		}
//
//		start += (m - 1) / len;
//		return String.valueOf(start).charAt((m - 1) % len) - '0';
//    }

}
