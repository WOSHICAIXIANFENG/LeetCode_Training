package com.github.leetcode.medium;

public class ImplementTrie_208 {

	public static void main(String[] args) {
		Trie obj = new Trie();
		obj.insert("apple");
		System.out.println("Cai Test = " + obj.search("apple"));//true
		System.out.println("Cai Test = " + obj.search("app"));//false
		System.out.println("Cai Test = " + obj.startsWith("app"));//true
		obj.insert("app");
		System.out.println("Cai Test = " + obj.search("app"));//true
	}
}

// !!! https://leetcode.com/articles/implement-trie-prefix-tree/
// 上面是完美的讲解 与 应用的场景介绍!!!

// 73 ms, faster than 99.82%

class Trie {
	private TrieNode root;
	
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();// dummy
    }
    
    // TC: O(L) ---- l is the len of word
    // SC: O(L) ---- in the worst case, newly inserted word doesn't share any trieNode with other words
    /** Inserts a word into the trie. */
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode node = find(prefix);
        return node != null;
    }
    
    // TC: O(L) ---- l is the len of prefix
    private TrieNode find(String prefix) {
    	TrieNode p = root;
    	for (char ch : prefix.toCharArray()) {
    		int index = ch - 'a';
    		if (p.children[index] == null) {
    			return null;
    		}
    		p = p.children[index];
    	}
    	return p;
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
