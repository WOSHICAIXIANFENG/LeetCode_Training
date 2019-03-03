package com.github.leetcode.easy;

/**
 * Given a non-negative integer num, 
 * repeatedly add all its digits until the result has only one digit.
 * @author Samuel.Cai
 */
public class AddDigits_258 {

	public static void main(String[] args) {
		System.out.println("Cai Test countPrimes = " + addDigits(38));
	}

	// 1 ms, faster than 100.00%
	// O(1)
	// Could you do it without any loop/recursion in O(1) runtime?
	// // only one digit means the value is in [0,9], so we can use novenary
	public static int addDigits(int num) {
		if (num == 0){
            return 0;
        }
		
        if (num % 9 == 0){
            return 9;
        } else {
            return num % 9;
        }
	}
	
//	// 1 ms, faster than 100.00%
//	public static int addDigits(int num) {
//		int digit;
//		int sum = 0;
//		while (num > 0) {
//			digit = num % 10;
//			sum += digit;
//			num = num / 10;
//		}
//		
//		if (sum < 10) {
//			return sum;
//		} else {
//			return addDigits(sum);
//		}
//    }
}
