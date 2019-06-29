package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs_677_s2 {

	public static void main(String[] args) {
		MapSum2 obj = new MapSum2();
//		obj.insert("apple", 3);
//		System.out.println("Cai Test = " + obj.sum("ap"));
//		obj.insert("app", 2);
//		System.out.println("Cai Test = " + obj.sum("ap"));
		
		obj.insert("a", 3);
		System.out.println("Cai Test = " + obj.sum("ap"));
		obj.insert("b", 2);
		System.out.println("Cai Test = " + obj.sum("a"));
	}

}

// 48 ms, faster than 99.55% 

//Approach 2: Trie Tree /  Prefix Tree
// TC: O(l) insert, O(l) sum
// SC: O(128* n*l) Trie Tree Nodes + O(n) hashMap key --> val
class MapSum2 {
	TrieNode root;
	private Map<String, Integer> map;
	
    /** Initialize your data structure here. */
    public MapSum2() {
        this.map = new HashMap<>();
        this.root = new TrieNode(0);
    }
    
    // TC: O(L). SC: O(L)
    public void insert(String key, int val) {
    	int diff = val - map.getOrDefault(key, 0);
        this.map.put(key, val);
        
        // insert key into the tree
        TrieNode p = root;
        for (char ch : key.toCharArray()) {
        	if (p.children[ch] == null) {
        		p.children[ch] = new TrieNode(val);
        	} else {
        		p.children[ch].val += diff;
        	}
        	p = p.children[ch];
        }
    }
    
    // TC: O(L)
    public int sum(String prefix) {
        // Find prefix value
    	TrieNode p = root;
    	for (char ch : prefix.toCharArray()) {
    		if (p.children[ch] == null) {
    			return 0;// doesn't have prefix
    		}
    		p = p.children[ch];
    	}
    	return p.val;
    }
    
    class TrieNode {
    	TrieNode[] children;
    	int val;
    	public TrieNode(int value) {
    		// standard ascii table size is 128
    		this.children = new TrieNode[128];
    		this.val = value;
    	}
    }
}
