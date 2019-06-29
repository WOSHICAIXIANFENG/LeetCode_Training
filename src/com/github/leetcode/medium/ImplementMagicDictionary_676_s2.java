package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImplementMagicDictionary_676_s2 {

	public static void main(String[] args) {
		MagicDictionary2 dict = new MagicDictionary2();
		String[] a1 = {"hello", "leetcode"};
		dict.buildDict(a1);
		System.out.println("Cai Test = " + dict.search("hello"));//false
		System.out.println("Cai Test = " + dict.search("hillo"));//true
		System.out.println("Cai Test = " + dict.search("hell"));//false
		System.out.println("Cai Test = " + dict.search("leetcoded"));//false
	}
}

// 49 ms, faster than 86.40%

// https://zxi.mytechroad.com/blog/hashtable/leetcode-676-implement-magic-dictionary/
// Approach 2: Fuzzy Math
// TC: O(n*l) build Dict + O(l) search
// SC: O(n*l) build Dict
class MagicDictionary2 {
	private Map<String, Set<Character>> map;
	
    /** Initialize your data structure here. */
    public MagicDictionary2() {
        this.map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
        	char[] chars = word.toCharArray();
        	for (int i = 0; i < chars.length; i++) {
        		char ch = chars[i];
        		chars[i] = '*';
        		String fuzzyWord = new String(chars);
        		Set<Character> replaces = map.getOrDefault(fuzzyWord, new HashSet<>());
        		replaces.add(ch);
        		this.map.put(fuzzyWord, replaces);
        		chars[i] = ch;
        	}
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
    	char[] chars = word.toCharArray();
    	for (int i = 0; i < chars.length; i++) {
    		char ch = chars[i];
    		chars[i] = '*';
    		String fuzzyWord = new String(chars);
    		if (map.containsKey(fuzzyWord)) {
    			// !!! if hello, hallo in the dict, search for 'hello' will return true
    			// h*llo ---> {e, a}
    			if (!map.get(fuzzyWord).contains(ch) || map.get(fuzzyWord).size() > 1) {
    				return true;
    			}
    		}
    		chars[i] = ch;
    	}
    	return false;
    }
}