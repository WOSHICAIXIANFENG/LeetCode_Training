package com.github.leetcode.easy;

public class ValidPerfectSquare_367 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + isPerfectSquare(16));
		System.out.println("Cai Test = " + isPerfectSquare(14));
		System.out.println("Cai Test = " + isPerfectSquare(1));
		System.out.println("Cai Test = " + isPerfectSquare(2147483647));
		System.out.println("Cai Test = " + isPerfectSquare(5));
	}

	// Do not use any built-in library function such as sqrt.
	
	// 0 ms, faster than 100.00%
	// Another way to solve the overflow problem.  avoid (left + right) /2 overflow
	// we use >>> 1
//	public static boolean isPerfectSquare(int num) {
//		int left = 1, right = num;
//		while (left <= right) {
//			int mid = (left + right) >>> 1; // another way to avoid overflow
//            if (num % mid == 0 && mid == num / mid) {
//                return true;
//            } else if (mid > num / mid) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//		}
//		return false;
//	}
	
	// 0 ms, faster than 100.00% 
	// left = 1, right = 5, mid = 3 ---> right = 2, left = 1, mid = 1 ---> left = 2, right = 2, mid = 2 --> left = 3, right = 2
//	public static boolean isPerfectSquare(int num) {
//		int left = 1, right = num;
//		while (left <= right) {
//			int mid = left + (right - left) / 2; // avoid overflow
//			if (num % mid == 0 && mid == num / mid) { // avoid overflow !!! don't forget to use num % mid == 0
//				return true;
//			} else if (mid > num / mid) {
//				right = mid - 1;
//			} else {
//				left = mid + 1;
//			}
//		}
//		return false;
//	}
	
	// Binary search solution --- need to take care value: '1'
	// TIme Limit Exceeded 2147483647 --- how to solve?
	// for big number, (left + right) /2 could be overflow --- use left + (right - left) / 2 , or use >>> 1
	// for big number, mid * mid could be overflow  --- use num / % to solve problem, or use long type
//	public static boolean isPerfectSquare(int num) {
//		int left = 1; int right = num;
//		while (left <= right) {
//			int mid = (left + right) / 2;
//			if (mid * mid == num) {
//				return true;
//			} else if (mid * mid > num){
//				right = mid - 1;
//			} else {
//				left = mid + 1;
//			}
//		}
//        return false;
//    }
	
	// Use Newton–Raphson method
	// https://zh.wikipedia.org/wiki/%E7%89%9B%E9%A1%BF%E6%B3%95
	public static boolean isPerfectSquare(int num) {
		int n = num;
		while (n * n > num) {
			n = (n + num / n) >> 1;
		}
		return n * n == num;
	}
	
	// 1 ms, faster than 27.68%
	// Use O(sqrtn) solution ---- O(sqrt n) > O(log2^n)
	// A square number is 1 + 3 + 5 + 7 + 9 + 11 ....  sum == num
//	public static boolean isPerfectSquare(int num) {
//		int i = 1;
//		while (num > 0) {
//			num -= i;
//			i += 2;
//		}
//		return num == 0;
//	}
}
