package com.github.leetcode.easy_top100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord819_top21 {

	public static void main(String[] args) {
		MostCommonWord819_top21 obj = new MostCommonWord819_top21();
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit" };
		System.out.println("Cai Test = " + obj.mostCommonWord(paragraph, banned)); // ball
	}

	// !!!! How to choose data structure? 
	// !!!! How to handle punctuations?
	
	// 4 ms, faster than 99.57% 
	
	// Approach 1: HashSet + HashMap
	// TC: O(P + B) where P is the size of paragraph and B is the size of banned.
	// SC: O(P + B)
	public String mostCommonWord(String paragraph, String[] banned) {
		// !!! Need to append one punctuaction to avoid can't extract the last word
        paragraph += ".";
        
		// Words in the list of banned words are given in lowercase, and free of punctuation. 
		Set<String> banDict = new HashSet<>();
		for (String word : banned) {
			banDict.add(word);
		}
		
		// word --> frequency
		Map<String, Integer> count = new HashMap<>();
		String maxWord = "";
		int frequency = 0;
		
		// Words in the paragraph are not case sensitive.  The answer is in lowercase.
		
		char[] chars = paragraph.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char ch : chars) {
			if (Character.isLetter(ch)) {
				sb.append(Character.toLowerCase(ch));// !!! toLowerCase()
			} else {
				// once we meet punctuaction, we extact one word
				String word = sb.toString();
				if (!banDict.contains(word)) {
					int times = count.getOrDefault(word, 0) + 1;
					if (times > frequency) {
						maxWord = word;
						frequency = times;
					}
					count.put(word, times);
				}
				sb = new StringBuilder();//!!! Need to reNew SB Obj
			}
		}
		
		return maxWord;
	}
}
