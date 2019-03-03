package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord_819 {

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
				
		System.out.println("Cai Test = " + mostCommonWord(paragraph, banned));

	}
	
	// 6 ms, faster than 99.64%
	// Time complexity: O(P + B). P is the length of paragraph, B is the length of banned
	// Space Complexity: O(P + B). we need to store the counters and banned set.
	public static String mostCommonWord(String paragraph, String[] banned) {
		// Need to append one punctuaction to avoid can't extract the last word
		paragraph += ".";

		// Use HashSet to avoid duplicate banned words, contains() time takes O(1)
		// For HashSet, Elements are not ordered. The add, remove, and contains methods has constant time complexity O(1). 
		// TreeSet is implemented using a tree structure(red-black tree in algorithm book). The elements in a set are sorted, but the add, remove, and contains methods has time complexity of O(log (n))
        Set<String> banset = new HashSet<>();
        for (String word: banned) banset.add(word);
     
        
        Map<String, Integer> counter = new HashMap<>();

        // don't forget to initialize
        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
        	
        	// when c is a punctuation, it means we have accumulated a word, so we can handle it.
        	// otherwise, we append the letter
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                //System.out.println("Cai Test finalword = " + finalword);
                if (!banset.contains(finalword)) {
                	counter.put(finalword, counter.getOrDefault(finalword, 0) + 1);
                	
                    if (counter.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = counter.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }
}
