package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs_677 {

	public static void main(String[] args) {
		MapSum obj = new MapSum();
//		obj.insert("apple", 3);
//		System.out.println("Cai Test = " + obj.sum("apple"));
//		obj.insert("app", 2);
//		System.out.println("Cai Test = " + obj.sum("ap"));
		obj.insert("a", 3);
		System.out.println("Cai Test = " + obj.sum("ap"));
		obj.insert("b", 2);
		System.out.println("Cai Test = " + obj.sum("a"));
	}
}

// 49 ms, faster than 93.95%
// Approach 1:  Using Two HashMap, key ---> val,  prefix ---> val
// TC: O(l^2) insert, O(1) sum
// SC: O(n) n is # of inserted key + O(n*l) -- l is len of key
// The space used by map and prefixMap is linear in the size of all input key and valvalues combined.

class MapSum {
	private Map<String, Integer> map;
	private Map<String, Integer> prefixMap;
	
    /** Initialize your data structure here. */
    public MapSum() {
        this.map = new HashMap<>();
        this.prefixMap = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);
        for (int i = 0; i < key.length(); i++) {
        	String prefixKey = key.substring(0, i + 1);
        	prefixMap.put(prefixKey, prefixMap.getOrDefault(prefixKey, 0) + diff);
        }
    }
    
    public int sum(String prefix) {
    	return prefixMap.getOrDefault(prefix, 0);
    }
}
