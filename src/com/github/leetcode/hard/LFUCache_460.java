package com.github.leetcode.hard;

import java.util.LinkedHashSet;

public class LFUCache_460 {

	public static void main(String[] args) {
		LFUCache cache = new LFUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		print(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		print(cache.get(2));      // returns -1 (not found)
		print(cache.get(3));      // returns 3.
		cache.put(4, 4);    // evicts key 1.
		print(cache.get(1));      // returns -1 (not found)
		print(cache.get(3));      // returns 3
		print(cache.get(4));       // returns 4
	}

	public static void print(int value) {
		System.out.println("Cai test = " + value);
	}
}


// do both operations in O(1)
// Least Frequently Used (LFU) to evict. if multiple keys has the same frequency the least recently used 
class LFUCache {

    public LFUCache(int capacity) {
        
    }
    
    public int get(int key) {
        return 0;
    }
    
    public void put(int key, int value) {
        
    }
}

class Node {
	public Node prev, next;
	public int freq;
	public LinkedHashSet<Integer> keys;
	
	public Node () {
		
	}
}
