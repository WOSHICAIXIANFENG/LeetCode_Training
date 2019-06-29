package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak_II_140 {

	public static void main(String[] args) {
		WordBreak_II_140 obj = new WordBreak_II_140();
		List<String> w1 = new ArrayList<>();
		w1.add("apple");
		w1.add("pen");
		w1.add("applepen");
		w1.add("pine");
		w1.add("pineapple");
		System.out.println("Cai Test = " + obj.wordBreak("pineapplepenapple", w1));
		
		List<String> w2 = new ArrayList<>();
		w2.add("cat");
		w2.add("cats");
		w2.add("and");
		w2.add("sand");
		w2.add("dog");
		System.out.println("Cai Test = " + obj.wordBreak("catsanddog", w2));
	}
	
	// 6 ms, faster than 68.37% 
	// Approach 1: Memorized Recursion
	// TC: O(n^2)
	// SC: O(n^2)
	public List<String> wordBreak(String s, List<String> wordDict) {
		// Use hasSet to do fast query 
		Set<String> dict = new HashSet<>(wordDict);
		Map<String, List<String>> mem = new HashMap<>();
	    return wordBreak(s, dict, mem);
	}
	
	// >> append({"cats and", "cat sand"}, "dog");
    // {"cats and dog", "cat sand dog"}
	private List<String> append(List<String> prefixes, String word) {
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < prefixes.size(); i++) {
			ans.add(prefixes.get(i) + " " + word);
		}
		return ans;
	}
	
	// vs WordBreak I
    // I just need to find if s could break down. II need to do Union/Merge operation to return all the Ans!
	public List<String> wordBreak(String s, Set<String> dict, Map<String, List<String>> mem) {
		if (mem.containsKey(s)) return mem.get(s);
		
		List<String> ans = new ArrayList<>();
		if (dict.contains(s)) {
			ans.add(s);
			//!!! You can't return from here.
		}
		
		// Try all cut/split solutions!!! do Union/Merge/Append for all sub ans to cur ans.
		
		// s = "catsand" ---> i: "cat" append "sand" U i: "cats" append "and"
		// ---> {"cat"} append "sand" ---> {"cat sand"}; ---> {"cats"} append "and" ---> {"cats and"}
		// merge "cats"and, "cat"sand --->  {"cat sand", "cat sand"}
		//  ---> append dog ---> {"cat sand dog", "cats and dog"}
		for (int i = 1; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			if (!dict.contains(right)) {
				continue;
			}
			List<String> leftAns = append(wordBreak(left, dict, mem), right);
			ans.addAll(leftAns);
		}
		// 当所有sub Ans都合并成一个之后再 返回ans
		mem.put(s, ans);
		return ans;
	}
}
