package com.github.leetcode.medium;

public class ImplementMagicDictionary_676 {

	public static void main(String[] args) {
		MagicDictionary dict = new MagicDictionary();
		String[] a1 = {"hello", "leetcode"};
		dict.buildDict(a1);
		System.out.println("Cai Test = " + dict.search("hello"));//false
		System.out.println("Cai Test = " + dict.search("hillo"));//true
		System.out.println("Cai Test = " + dict.search("hell"));//false
		System.out.println("Cai Test = " + dict.search("leetcoded"));//false
	}
}

// 49 ms, faster than 86.40%
// Approach 1: Trie Tree
// TC: O(n*l) build Dict + O(25*l * l) search
// SC: O(n*l) build Trie Tree
class MagicDictionary {
	TrieNode root;// a dummy root
	
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
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
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
    	char[] chars = word.toCharArray();
    	for (int i = 0; i < chars.length; i++) {
    		char ch = chars[i];
    		// try other 25 kinds of letters
    		for (char c = 'a'; c <= 'z'; c++) {
    			if (c != ch) {
    				chars[i] = c;
    				if (find(new String(chars))) {
    					return true;
    				}
    			}
    		}
    		chars[i] = ch;
    	}
    	return false;
    }
    
    public boolean find(String word) {
    	TrieNode p = root;
    	for (char ch : word.toCharArray()) {
    		int index = ch - 'a';
    		if (p.children[index] == null) {
    			return false;
    		}
    		p = p.children[index];
    	}
    	return p.isWord;
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