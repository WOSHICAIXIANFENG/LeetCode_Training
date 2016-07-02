package com.github.leetcode;
/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * @author Samuel
 */
class ExcelSheetColumnTitle {
	public static void main(String[] args) {
		ExcelSheetColumnTitle obj = new ExcelSheetColumnTitle();
		// for (int i = 1; i < 100; i ++) {
		// 	System.out.println("ExcelSheetColumnTitle i = " + i + "  , result = " + obj.convertToTitle(i));
		// }

		System.out.println("ExcelSheetColumnTitle result = " + obj.titleToNumber("A"));
		System.out.println("ExcelSheetColumnTitle result = " + obj.titleToNumber("Z"));
		System.out.println("ExcelSheetColumnTitle result = " + obj.titleToNumber("AA"));
		System.out.println("ExcelSheetColumnTitle result = " + obj.titleToNumber("AB"));
	}

	public String convertToTitle(int n) {
		String result = "";

		while(n != 0) {
			result = (char) ((n-1)%26 + 'A') + result;
			n = (n - 1)/26;
		}
		return result;
	}


	public int titleToNumber(String s) {
		int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
        	result += (chars[i] % 65 + 1)* Math.pow(26, chars.length - 1 - i);
        }
        return result;
    }
}