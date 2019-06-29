package com.github.leetcode.easy_top100;

public class ReverseInteger7_top7 {

	public static void main(String[] args) {
		System.out.println("Cai Test max_value = " + Integer.MAX_VALUE);// 2147483647
		System.out.println("Cai Test min_value = " + Integer.MIN_VALUE);// -2147483647
		
		System.out.println("Cai Test -123 % 10 = " + (-123 % 10)); // -3
		System.out.println("Cai Test -123 / 10 = " + (-123 / 10)); // -12
		
		ReverseInteger7_top7 obj = new ReverseInteger7_top7();
		int x = 123;
		int x2 = -123;
		int x3 = Integer.MAX_VALUE;
		int x4 = Integer.MIN_VALUE;
		int x5 = 2147483639;// reverse will overflows. max value is 2147483647
		int x6 = -47483639;
		
		System.out.println("Samuel Test reverse = " + obj.reverse(x));// 321
		System.out.println("Samuel Test reverse = " + obj.reverse(x2));// -321
		System.out.println("Samuel Test reverse = " + obj.reverse(x3));// overflow
		System.out.println("Samuel Test reverse = " + obj.reverse(x4));// overflow
		System.out.println("Samuel Test reverse = " + obj.reverse(x5));// overflow
		
		System.out.println("Samuel Test reverse = " + obj.reverse(x6));// -93638474
	}
	
	// 1 ms, faster than 100.00% 
	public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // integer max_value is 2147483647, last digit is 7
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            // integer min_value is -2147483647, last digit is -7
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            
            rev = rev * 10 + pop;
        }
        return rev;
    }
	
	public int reverse3(int x) {
		long result = 0;
		int m = Math.abs(x);
		while (m > 0) {
			int lastDigit = m % 10;
			// integer max_value is 2147483647, last digit if 7
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
				return 0;
			}
			result = result * 10 + lastDigit;			
			m = m / 10;
		}
		return x < 0 ? -1 * (int) result : (int) result;
	}

	public int reverse2(int x) {
		long result = 0;
		int m = Math.abs(x);
		while (m > 0) {
			int lastDigit = m % 10;
			result = result * 10 + lastDigit;
			m = m / 10;
		}
		if (result > Integer.MAX_VALUE) {
			return 0;
		}
		return x < 0 ? -1 * (int) result : (int) result;
	}
	
	
}
