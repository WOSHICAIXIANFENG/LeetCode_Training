package com.github.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary_720 {

	public static void main(String[] args) {
		LongestWordInDictionary_720 obj = new LongestWordInDictionary_720();
		String[] a1 = {"w","wo","wor","worl", "world"};
		String[] a2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		System.out.println("Cai Test = " + obj.longestWord(a1));
		System.out.println("Cai Test = " + obj.longestWord(a2));
	}
	
	// Best Solution!
	// Approach 3: Trie + sorting
	// TC: O(SUM wi) ---- wi is the len of words[i].
	// SC: O(SUM wi) ---- the space used by the Trie
	public String longestWord(String[] words) {
		Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
		
		// put all words in a prefix tree
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
		
		for (String word : words) {
			if (trie.hasAllPrefixs(word)) {
				return word;
			}
		}
		
		return "";//never happen
	}
	
	class Trie {
		TrieNode root;// a dummy node
		public Trie() {
			this.root = new TrieNode();
		}
		
		// TC: O(L), SC: O(L)
		public void insert(String word) {
			TrieNode p = root;
			for (char ch : word.toCharArray()) {
				int index = ch - 'a';
				if (p.children[index] == null) {
					p.children[index] = new TrieNode();
				}
				p = p.children[index];
			}
			p.isWord = true;
		}
		
		// TC: O(L).  SC: O(1)
		public boolean hasAllPrefixs(String word) {
			TrieNode p = root;
			for (char ch : word.toCharArray()) {
				int index = ch - 'a';
				if (p.children[index] == null) {
					return false;
				}
				p = p.children[index];
				//!!! Pruning
				if (!p.isWord) {
					return false;
				}
			}
			return true;
		}
	}
	
	class TrieNode {
		boolean isWord;
		TrieNode[] children;
		public TrieNode() {
			this.isWord = false;
			this.children = new TrieNode[26];
		}
	}

	// 40 ms, faster than 16.91%
	// Approach 1: Brute Force + sorting
	public String longestWord3(String[] words) {
		Set<String> hashSet = new HashSet<>();
		for (String word : words) {
			hashSet.add(word);
		}
		
		// lambda has a bad performance in leetcode
		// make the words in descending sort
		Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
		//System.out.println("Cai Test array = " + Arrays.toString(words));
		
		for (String word : words) {
			boolean found = true;
			for (int i = 1; i < word.length(); i++) {
				String substr = word.substring(0, i);
				if (!hashSet.contains(substr)) {
					found = false;
					break;
				}
			}
			if (found) {
				return word;
			}
		}
		return "";
	}
	
	// 10 ms, faster than 81.91%
	// Approach 1: Brute Force + prune
	// TC: O(SUM wi^2) ---- wi is the len of words[i]. ---- HashSet.contains() TC increase by it's content
	// SC: O(SUM wi^2) ---- to create subString
	public String longestWord2(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet<>();
        for (String word : words) {
        	wordset.add(word);
        }
        for (String word : words) {
        	// !!! Prune
        	if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
        		boolean found = true;
        		for (int k = 1; k < word.length(); k++) {
        			if (!wordset.contains(word.substring(0, k))) {
        				found = false;
        				break;
        			}
        		}
        		if (found) {
        			ans = word;
        		}
        	}
        }
        return ans;
    }
}
