package com.samuel.test;

/**

Compare two strings A and B, determine whether A contains all of the characters in B.

The characters in string A and B are all Upper Case letters.

Example
For A = "ABCD", B = "ABC", return true.

For A = "ABCD" B = "AABC", return false.

 * @author Samuel
 *
 */
public class CompareStr {

	public static void main(String[] args) {
		String str1 = "ABCDA";
		String str2 = "ABC";
		String str3 = "AABC";
		
		System.out.println("Samuel Test compareStrings = " + compareStrings(str1, str2));//true
		System.out.println("Samuel Test compareStrings = " + compareStrings(str1, str3));//false
	}

	/**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public static boolean compareStrings(String A, String B) {
        int[] AA = new int[26];
        int[] BB = new int[26];
        for (int i=0; i<A.length(); i++) {
            AA[A.charAt(i) - 'A']++;
        }
        for (int i=0; i<B.length(); i++) {
            BB[B.charAt(i) - 'A']++;
            if (BB[B.charAt(i) - 'A'] > AA[B.charAt(i) - 'A']) return false;
        }
        return true;
    }
}
