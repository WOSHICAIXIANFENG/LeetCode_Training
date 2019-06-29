package com.github.leetcode.easy_top100;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones771_top10 {

	public static void main(String[] args) {
		JewelsAndStones771_top10 obj = new JewelsAndStones771_top10();
		System.out.println("Cai Test obj = " + obj.numJewelsInStones("aA", "aAAbbbb"));// 3
		System.out.println("Cai Test obj = " + obj.numJewelsInStones("z", "ZZ"));// 0
	}
	
	/**
	 * S and J will consist of letters and have length at most 50.
	 * 
	 * The characters in J are distinct.
	 */

	// 1 ms, faster than 96.72%
	
	// Approach 1: HashSet
	// TC: O(n)
	public int numJewelsInStones(String J, String S) {
		Set<Character> jewels = new HashSet<>();
		for (char ch : J.toCharArray()) {
			jewels.add(ch);
		}
		int ans = 0;
		for (char ch : S.toCharArray()) {
			if (jewels.contains(ch)) {
				ans++;
			}
		}
        return ans;
    }
	
	// TC: O(n*m*1)
	// Java: indexOf function complexity is O(n*m) where n is length of the text and m is a length of pattern
	public int numJewelsInStones2(String J, String S) {
        int count = 0;
        for (int i = 0; i< S.length(); i++) {
            if (J.indexOf(S.charAt(i)) >= 0) {
                count++;
            }
        }
        return count++;
    }
}
