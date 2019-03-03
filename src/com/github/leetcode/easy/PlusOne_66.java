package com.github.leetcode.easy;

import java.util.Arrays;

public class PlusOne_66 {

	public static void main(String[] args) {
		int[] a1 = {1,2,3};
		int[] a2 = {4,3,2,1};
		int[] a3 = {9};
		int[] a4 = {1,9,9,9,9};
		int[] a5 = {9,9};
		System.out.println("Cai Test plusOne = " + Arrays.toString(plusOne(a1)));
		System.out.println("Cai Test plusOne = " + Arrays.toString(plusOne(a2)));
		System.out.println("Cai Test plusOne = " + Arrays.toString(plusOne(a3)));
		System.out.println("Cai Test plusOne = " + Arrays.toString(plusOne(a4)));
		System.out.println("Cai Test plusOne = " + Arrays.toString(plusOne(a5)));
	}
	
	// 0 ms, faster than 100.00% 
	public static int[] plusOne(int[] digits) {
		if (digits[digits.length - 1] == 9) {
			digits[digits.length - 1] = 0;
			
			for (int i = digits.length - 2; i >= 0; i --) {
				if (digits[i] != 9) {
					digits[i] += 1;
					break;
				} else {
					digits[i] = 0;
				}
			}
			if (digits[0] == 0) {
				// return new array with one more digit e.g. [1,0,0]
				int[] newResult = new int[digits.length + 1];
				newResult[0] = 1;
				for (int i = 1; i < digits.length + 1; i ++) {
					newResult[i] = 0;
				}
				return newResult;
			}
		} else {
			digits[digits.length - 1] += 1; 
		}
		
		return digits;
    }

}
