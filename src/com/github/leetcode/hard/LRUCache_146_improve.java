package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146_improve {

	public static void main(String[] args) {
		LRUCache2 cache = new LRUCache2(2);
		cache.put(1, 1);
		cache.put(2, 2);
		print(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		print(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		print(cache.get(1));       // returns -1 (not found)
		print(cache.get(3));       // returns 3
		print(cache.get(4));       // returns 4
	}

	public static void print(int value) {
		System.out.println("Cai test = " + value);
	}
}

// Could you do both operations in O(1) time complexity?

// 57 ms, faster than 100%
// Use HashMap to save key - value pair.  Use double linked list to implement LRU algorithm under O(1) time complexity
class LRUCache2 {
	private Map<Integer, Node> map;
	private int capacity;
	private Node head, tail;
	
    public LRUCache2(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        
        // two dummy node for head and tail
        head = new Node(-1, 0);
        tail = new Node(-1, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
    	if (map.containsKey(key)) {
    		Node node = map.get(key);
    		
    		// remove node from linked list
    		remove(node);
    		// put the node as the new header
    		addToHead(node);
    		return node.val;
    	}
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
        	// replace the value, then put the node in head
        	Node node = map.get(key);
        	node.val = value;
        	
        	remove(node);
        	addToHead(node);
        } else {
        	if (map.size() >= capacity) {
        		map.remove(tail.prev.key);//!!! Don't forget
        		remove(tail.prev);
        	}
        	
        	Node node = new Node(key, value);
        	map.put(key, node);
        	addToHead(node);
        }
    }
    
    private void remove(Node node) {
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
    }
    
    // add a node after the head
    // use diagram to help yourself to implement
    private void addToHead(Node node) {
    	node.next = head.next;
    	node.prev = head;
    	head.next = node;
    	node.next.prev = node;
    }
    
    class Node {
    	int key;
    	int val;
    	Node prev;
    	Node next;
    	
    	public Node(int key, int val) {
    		this.key = key;
    		this.val = val;
    	}
    }
}



