package com.github.leetcode.medium;

public class StringWithoutAAAOrBBB_984 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + strWithout3a3b(1, 2));
		System.out.println("Cai Test = " + strWithout3a3b(4, 1));
	}
	
	// 4 ms, faster than 94.29%
	// Approach 1: Use 'AAB' pattern --- make sure A > B
	public static String strWithout3a3b(int A, int B) {
		// !!! spark
		char a = 'a';
		char b = 'b';
		if (A < B) {
			// swap count value A,B, swap char a,b
			int C = A;
			A = B;
			B = C;
			
			char c = a;
			a = b;
			b = c;
		}
		
		String result = "";
		while (A > 0 || B > 0) {
			// A
			if (A > 0) {
				result += a; --A;
			}
			// A
			if (A > B) {
				result += a; --A;
			}
			// B pattern
			if (B > 0) {
				result += b; --B;
			}
		}
		
        return result;
    }

}
