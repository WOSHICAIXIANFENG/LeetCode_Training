package com.github.leetcode.easy_top100;

public class LicenseKeyFormatting482_top39 {

	public static void main(String[] args) {
		LicenseKeyFormatting482_top39 obj = new LicenseKeyFormatting482_top39();
		System.out.println("Cai Test = " + obj.licenseKeyFormatting("5F3Z-2e-9-w", 4));
		System.out.println("Cai Test = " + obj.licenseKeyFormatting("2-5g-3-J", 2));
	}

	/**
	 * The length of string S will not exceed 12,000, and K is a positive integer.
	 * 
	 */
	
	// 10 ms, faster than 93.98%
	//!!!!
	// Optimized -- Use StringBuilder!!! -- then reverse()
	// TC: O(n)
	public String licenseKeyFormatting(String S, int K) {
		char[] chars = S.toCharArray();
		final int m = chars.length;
		StringBuilder sb = new StringBuilder();
		int k = 0;//!!! 0
		for (int i = m - 1; i >= 0; i--) {
			if (chars[i] != '-') {
				if (k == K) {
					k = 0;
					sb.append('-');
				}
				k++;
				sb.append(Character.toUpperCase(chars[i]));
			}
		}
        return sb.reverse().toString();// O(n)
	}
	
	// 597 ms, faster than 5.25%  ----- !!! 使用是使用 Str + 操作.
	
	// Approach 1: Iterate S back to front!
	// TC: BIGGER THAN O(n) ----- 
	// On each concatenation a new copy of the string is created, 
	// so that the overall complexity is O(n^2).
	// In Java, the complexity of s1.concat(s2) or s1 + s2 is O(M1 + M2) where M1 and M2 are the respective String lengths. 
	// Fortunately in Java we could solve this with a StringBuffer, which has O(1) complexity for each append, then the overall complexity would be O(n).
	
	public String licenseKeyFormatting2(String S, int K) {
		char[] chars = S.toCharArray();
		final int m = chars.length;
		String ans = "";
		int k = 0;//!!! 0
		for (int i = m - 1; i >= 0; i--) {
			if (chars[i] != '-') {
				if (k == K) {
					k = 0;
					ans = '-' + ans;
				}
				k++;
				ans = Character.toUpperCase(chars[i]) + ans;
			}
		}
        return ans;
    }
}
