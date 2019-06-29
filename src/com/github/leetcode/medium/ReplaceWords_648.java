package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords_648 {

	public static void main(String[] args) {
		ReplaceWords_648 obj = new ReplaceWords_648();
		List<String> dict1 = new ArrayList<>();
		dict1.add("cat");
		dict1.add("bat");
		dict1.add("rat");
		System.out.println("Cai Test = " + obj.replaceWords(dict1, "the cattle was rattled by the battery"));
	}

	// 7 ms, faster than 98.65%
	// Approach 1 : Trie Tree
	// TC: O(n*l) -- n is # of words of sentence, l is the len of each word
	// SC: O(n*l)
	public String replaceWords(List<String> dict, String sentence) {
		Trie trie = new Trie();
		for (String word : dict) {
			trie.insert(word);
		}
		
		StringBuilder sb = new StringBuilder();
		String[] words = sentence.split(" ");
		for (String word : words) {
			sb.append(trie.findShortestRoot(word)).append(" ");
		}
		return sb.toString().trim();
    }
	
	class Trie {
		TrieNode root;// a dummy head
		public Trie() {
			this.root = new TrieNode();
		}
		
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
		
		public String findShortestRoot(String word) {
			TrieNode p = root;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				int index = ch - 'a';
				if (p.children[index] == null) {
					break;
				}
				p = p.children[index];
				// !!! 一定要放在付值语句下面
				if (p.isWord) {
					return word.substring(0, i + 1);
				}
			}
			return word;
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
}
