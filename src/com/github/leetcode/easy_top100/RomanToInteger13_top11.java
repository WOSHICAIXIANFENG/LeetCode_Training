package com.github.leetcode.easy_top100;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13_top11 {

	public static void main(String[] args) {
		RomanToInteger13_top11 obj = new RomanToInteger13_top11();
		System.out.println("Cai Test = " + obj.romanToInt("III"));
		System.out.println("Cai Test = " + obj.romanToInt("IV"));// 4
		System.out.println("Cai Test = " + obj.romanToInt("IX"));// 9
		System.out.println("Cai Test = " + obj.romanToInt("LVIII"));// 58
		System.out.println("Cai Test = " + obj.romanToInt("MCMXCIV"));// 1994
	}

	// Approach 1: 
	// Idea: if the value of current letter is greater than the previous one, deduct twice of the previous value
	// TC: O(n)
	// SC: O(1)
	public int romanToInt(String s) {
		Map<Character, Integer> dict = new HashMap<>();
		dict.put('I', 1);
		dict.put('V', 5);
		dict.put('X', 10);
		dict.put('L', 50);
		dict.put('C', 100);
		dict.put('D', 500);
		dict.put('M', 1000);
		
		final char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            ans += dict.get(chars[i]);
            if (i > 0 && dict.get(chars[i]) > dict.get(chars[i - 1])) {
                ans -= 2 * dict.get(chars[i - 1]);
            }
        }
        return ans;
    }
	
	
}
