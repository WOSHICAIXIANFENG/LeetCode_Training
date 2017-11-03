package com.github.leetcode.easy;

/**
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.

 * @author Samuel
 *
 */
public class ReverseInteger_7 {

	public static void main(String[] args) {
		int x = 123;
		int x2 = -123;
		int x3 = Integer.MAX_VALUE;
		int x4 = Integer.MIN_VALUE;
		int x5 = 2147483639;// reverse will overflows. max value is 2147483647
		int x6 = -47483639;
		
		System.out.println("Samuel Test reverse = " + reverse(x));
		System.out.println("Samuel Test reverse = " + reverse(x2));
		System.out.println("Samuel Test reverse = " + reverse(x3));// overflow
		System.out.println("Samuel Test reverse = " + reverse(x4));// overflow
		System.out.println("Samuel Test reverse = " + reverse(x5));// overflow
		
		System.out.println("Samuel Test reverse = " + reverse(x6));
	}

	/**
	 * 
	 * If overflow exists, the new result will not equal previous one.
     * No flags needed. No hard code like 0xf7777777 needed.
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int tail = x % 10;
			int newResult = 10 * result + tail;// for  --- possible overflows
			// if overflow, result value will be changed to other value, the following == will be false
			if ((newResult - tail) / 10 != result) {
				return 0;// overflow
			}
			result = newResult;
			x = x / 10;
		}
        return result;
    }
}
