package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak_139 {

	public static void main(String[] args) {
		WordBreak_139 obj = new WordBreak_139();
		List<String> w1 = new ArrayList<>();
		w1.add("leet");
		w1.add("code");
		System.out.println("Cai Test = " + obj.wordBreak("leetcode", w1));// true
		
		List<String> w2 = new ArrayList<>();
		w2.add("cats");
		w2.add("dog");
		w2.add("sand");
		w2.add("and");
		w2.add("cat");
		System.out.println("Cai Test = " + obj.wordBreak("catsandog", w2));// false
	}
	
	// http://zxi.mytechroad.com/blog/leetcode/leetcode-139-word-break/

	// 5 ms, faster than 65.44%
	
	// Approach 1: Memorized Recursion/DP
	// TC: O(n^2)
	// SC: O(n^2)
	public boolean wordBreak(String s, List<String> wordDict) {
		// Create a hashset of words for fast query.
        Set<String> dict = new HashSet<String>(wordDict);
        // You can use a Boolean[] as mem, use pos index to speed up!
        Map<String, Boolean> mem = new HashMap<String, Boolean>();
        return wordBreak(s, mem, dict);
    }
	
	public boolean wordBreak(String s, Map<String, Boolean> mem, Set<String> dict) {
		System.out.println("Cai Test s= " + s);
		if (mem.containsKey(s)) return mem.get(s);
		if (dict.contains(s)) {
			mem.put(s, true);
			return true;
		}
		for (int i = 1; i < s.length(); i++) {
			if (dict.contains(s.substring(i)) && wordBreak(s.substring(0, i), mem, dict)) {
				mem.put(s, true);
				return true;
			}
		}
		mem.put(s, false);
		return false;
	}
}
