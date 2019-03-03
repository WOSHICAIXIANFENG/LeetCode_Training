package com.github.leetcode.easy;

/**
 * https://leetcode.com/problems/ugly-number/
 * 
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 * @author Samuel.Cai
 */
public class UglyNumber_263 {

	public static void main(String[] args) {
		System.out.println("Cai Test isUgly = " + isUgly(0));//!!!
		System.out.println("Cai Test isUgly = " + isUgly(1));
		System.out.println("Cai Test isUgly = " + isUgly(14));
		System.out.println("Cai Test isUgly = " + isUgly(8));
	}
	
	// 1 ms, faster than 100.00%
	public static boolean isUgly(int num) {
		if (num == 0) {//!!!
			return false;
		}
		
		if (num == 1) {
			return true;
		}
		
		if (num % 2 == 0) {
			return isUgly(num / 2);
		} else if (num % 3 == 0) {
			return isUgly(num / 3);
		} else if (num % 5 == 0) {
			return isUgly(num / 5);
		}
		
        return false;
    }
}
