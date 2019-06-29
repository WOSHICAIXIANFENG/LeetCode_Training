package com.github.leetcode.easy_top100;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202_top36 {

	public static void main(String[] args) {
		HappyNumber202_top36 obj = new HappyNumber202_top36();
		System.out.println("Cai Test = " + obj.isHappy(19));// true
		System.out.println("Cai Test = " + obj.isHappy(20));// false --- Iterative way will go into endless loop
	}

	// Approach 1: Recursion
	// TC: O(n)
	public boolean isHappy2(int n) {
		if (n < 10) {
			return n == 1 || n == 7;
		}
		int sum = 0;
		int m = n;
		while (m != 0) {
			int lastDigit = m % 10;
			sum += lastDigit * lastDigit;
			m = m /10;
		}
		return isHappy(sum);
	}
	
	// repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
	// How to avoid endlessly loop? --- case: 20
	
	// 2 ms, faster than 56.64% 
	// Approach 2: Iterative
	public boolean isHappy(int n) {
		// Use a Set to avoid endless loop
		Set<Integer> sweets = new HashSet<>();
		while (!sweets.contains(n)) {
			int m = n;
			int sum = 0;
			while (m != 0) {
				int lastDigit = m % 10;
				sum += Math.pow(lastDigit, 2);
				m = m / 10;
			}
			
			if (sum == 1) {
				return true;
			} else {
				sweets.add(n);//!!! before n = sum;
				n = sum;
			}
		}
		
		return false;
	}
}
