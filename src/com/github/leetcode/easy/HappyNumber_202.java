package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

	public static void main(String[] args) {
		System.out.println("Cai Test isHappy = " + isHappy(19));
		System.out.println("Cai Test isHappy = " + isHappy(20));
	}
	
	// use set to avoid infinite loop
//	// 1 ms, faster than 96.21% 
//	public static boolean isHappy(int n) {
//		Set<Integer> inLoop = new HashSet<Integer>();
//		while (inLoop.add(n)) {
//			int squareSum = 0, digit;
//			while (n > 0) {
//				digit = n % 10;
//				squareSum += digit * digit;
//				n = n / 10;
//			}
//			
//			if (squareSum == 1) {
//				return true;
//			} else {
//				n = squareSum;
//			}
//		}
//		return false;
//	}

	// 0 ms, faster than 100.00% 
	// 1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100,.....
	public static boolean isHappy(int n) {
		if (n < 10) {
			if (n == 1 || n == 7) {
				return true;
			} else return false;
		}
		
		int digit; 
		int sum = 0;
		while (n > 0) {
			digit = n % 10;
			sum += Math.pow(digit, 2);
			n = n / 10;
		}
        return isHappy(sum);
    }
}
