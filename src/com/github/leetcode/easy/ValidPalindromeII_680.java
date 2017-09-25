package com.github.leetcode.easy;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII_680 {

	public static void main(String[] args) {
		String str1 = "abca";
		String str2 = "ababca";
		String str3 = "ababababa";
		String str4 = "aba";
		String str5 = "abba";
		System.out.println("Samuel Test str1 = " + validPalindrome(str1));
		System.out.println("Samuel Test str2 = " + validPalindrome(str2));
		System.out.println("Samuel Test str3 = " + validPalindrome(str3));
		System.out.println("Samuel Test str4 = " + validPalindrome(str4));
		System.out.println("Samuel Test str5 = " + validPalindrome(str5));
		
		// false case
		String str6 = "abcgdba";
		System.out.println("Samuel Test str6 = " + validPalindrome(str6));
	}
	
	/**
	 * Complexity Analysis:
	 * Time Complexity: O(N) where N is the length of the string. Each of two checks of whether some substring is O(N)
	 * Space Complexity: O(1) additional complexity. Only pointers were stored in memory. 
	 * 
	 * @param s
	 * @return
	 */
	public static boolean validPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i ++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				int j = s.length() - 1 - i;
				return (isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1));
			} else {
				// 
				if (i == s.length() / 2 - 1) {
					return true;
				}
			}
		}

		return false;
	}
	
	public static boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }

}
