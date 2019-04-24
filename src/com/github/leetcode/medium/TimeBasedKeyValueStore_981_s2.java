package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore_981_s2 {

	public static void main(String[] args) {
		TimeMap2 obj = new TimeMap2();
		obj.set("foo", "bar", 1);
		println(obj.get("foo", 1));
		println(obj.get("foo", 3));
		
		obj.set("foo", "bar2", 4);
		println(obj.get("foo", 4));
		println(obj.get("foo", 5));
		
		System.out.println("================================");
		TimeMap2 obj2 = new TimeMap2();
		obj2.set("love", "high", 10);
		obj2.set("love", "low", 20);
		println(obj2.get("love", 5));
		println(obj2.get("love", 10));
		println(obj2.get("love", 10));
		println(obj2.get("love", 20));
		println(obj2.get("love", 25));
	}
	
	public static void println(String value) {
		System.out.println("Cai Test = " + value);
	}

}

//Approach 2: Hashtable + Array + binary search 

// 考查你对 数据结构的掌握程度:  Hashtable + Array + binary search
// set: map.get(key).put(timestamp, value)
// get: prev(map.get(key)).upper_bound(timestamp).value
// TC: set O(1)
// get: O(logN)
// SC: O(n)

// 255 ms, faster than 77.02%
// Approach 2: Use Binary Search to solve it
class TimeMap2 {
	Map<String, List<Pair>> map;
	
    /** Initialize your data structure here. */
    public TimeMap2() {
        map = new HashMap<>();
    }
    
    // O(1)
    public void set(String key, String value, int timestamp) {
    	if (!map.containsKey(key)) {
    		 map.put(key, new ArrayList<>());
    	}
    	
    	map.get(key).add(new Pair(timestamp, value));
    }
    
    // O(logN)
    public String get(String key, int timestamp) {
    	if (map.containsKey(key)) {
    		List<Pair> pairs = map.get(key);
    		return searchInList(pairs, timestamp);
    		// Or using  Collections util class
    		
//	        int i = Collections.binarySearch(pairs, new Pair(timestamp, "{"),
//	                (a, b) -> Integer.compare(a.time, b.time));
//
//	        if (i >= 0)
//	            return pairs.get(i).value;
//	        else if (i == -1)
//	            return "";
//	        else
//	            return pairs.get(-i-2).value;
    	}
        return "";
    }
    
    class Pair {
    	int time;
    	String value;
    	public Pair(int time, String value) {
    		this.time = time;
    		this.value = value;
    	}
    }
    
    //!!!
	private String searchInList(List<Pair> list, int timestamp) {
		int left = 0, right = list.size() - 1;
		Pair cur = null;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			cur = list.get(mid);
			if (cur.time == timestamp) {
				return cur.value;
			} else if (cur.time > timestamp) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		if (left == 0) {
			return ""; // there is no value's time <= timestamp
		} else {
			return list.get(left - 1).value;//!!!
		}
	}
}