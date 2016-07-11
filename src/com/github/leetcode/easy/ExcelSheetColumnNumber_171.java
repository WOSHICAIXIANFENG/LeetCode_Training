package com.github.leetcode.easy;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * @author Samuel
 */
public class ExcelSheetColumnNumber_171 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public class Solution {
	    public int titleToNumber(String s) {
	        int result = 0;
	        char[] chars = s.toCharArray();
	        for (int i = 0; i < chars.length; i ++) {
	        	result += (chars[i] % 65 + 1) * Math.pow(26, chars.length - 1 - i);
	        }
	        return result;
	    }
	}
}
