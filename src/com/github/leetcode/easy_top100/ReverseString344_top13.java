package com.github.leetcode.easy_top100;

public class ReverseString344_top13 {

	public static void main(String[] args) {
		ReverseString344_top13 obj = new ReverseString344_top13();
		System.out.println("Cai Test = " + obj.reverseString("hello"));// 2
		System.out.println("Cai Test = " + obj.reverseString("Hannah"));// 3
	}

	// you must do this by modifying the input array in-place with O(1) extra memory.
	
	// TC: O(n)
	// SC: O(1)
	public String reverseString(String s) {
		char[] ch = s.toCharArray();
        int half = s.length() / 2;
        for (int i = 0; i < half; i++) {
        	char tmp = ch[i];
        	ch[i] = ch[s.length() - 1 - i];
        	ch[s.length() - 1 - i] = tmp;
        }
        return new String(ch);
	}
}
