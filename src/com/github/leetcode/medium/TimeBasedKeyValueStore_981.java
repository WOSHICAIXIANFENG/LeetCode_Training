package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore_981 {

	public static void main(String[] args) {
		TimeMap obj = new TimeMap();
		obj.set("foo", "bar", 1);
		println(obj.get("foo", 1));
		println(obj.get("foo", 3));
		
		obj.set("foo", "bar2", 4);
		println(obj.get("foo", 4));
		println(obj.get("foo", 5));
		
		System.out.println("================================");
		TimeMap obj2 = new TimeMap();
		obj2.set("love", "high", 10);
		obj2.set("love", "low", 20);
		println(obj2.get("love", 5));
		println(obj2.get("love", 10));
		println(obj2.get("love", 15));
		println(obj2.get("love", 20));
		println(obj2.get("love", 25));
	}
	
	public static void println(String value) {
		System.out.println("Cai Test = " + value);
	}

}

// 219 ms, faster than 94.89%
// Approach 1: Hashtable + Treemap 

// 考查你对 数据结构的掌握程度:  Hashtable + Treemap
// set: map.get(key).put(timestamp, value)
// get: prev(map.get(key)).upper_bound(timestamp).value
// TC: set O(1)
// get: O(logN)
// SC: O(n)
class TimeMap {
	Map<String, TreeMap<Integer, String>> map;
	
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    // O(1)
    public void set(String key, String value, int timestamp) {
    	if (!map.containsKey(key)) {
    		// TreeMap is sorted, using the natural ordering of its keys.
    		 map.put(key, new TreeMap<>());
    	}
    	
    	map.get(key).put(timestamp, value);
    }
    
    // O(logN)
    public String get(String key, int timestamp) {
    	if (map.containsKey(key)) {
    		TreeMap<Integer, String> tree = map.get(key);
    		// find first entry <= timestamp
    		// can use TreeMap.floorKey(timestamp) to find the largest timestamp smaller than the given timestamp.
			// or use tree.floorEntry(key)
//    		Integer t = tree.floorKey(timestamp);
//	        return t != null ? tree.get(t) : "";
    		Map.Entry<Integer, String> entry = tree.floorEntry(timestamp);
    		return entry != null ? entry.getValue() : "";
    	}
        return "";
    }
}