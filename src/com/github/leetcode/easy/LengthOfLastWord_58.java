package com.github.leetcode.easy;

/**

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

 * @author Samuel
 *
 */
public class LengthOfLastWord_58 {

	public static void main(String[] args) {
		// trim ---- "   Hello  World  "
		// 
		String s = "Hello World  ha  ";
		System.out.println("Samuel Test lengthOfLastWord = " + lengthOfLastWord(s));
	}
	
    public static int lengthOfLastWord(String s) {
    	if (s == null) {
    		return 0;
    	}
    	
    	String temp = s.trim();
    	if (temp.lastIndexOf(" ") != -1) {
    		return temp.substring(temp.lastIndexOf(" ") + 1).length();
    	} else {
    		return temp.length();
    	}
    }
}
