package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
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

// 63 ms, faster than 95.67%
// Use HashMap to save key - value pair.  Use double linked list to implement LRU algorithm under O(1) time complexity
class LRUCache {
	private Map<Integer, Node> map;
	private int capacity;
	private Node head, tail;
	
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	if (map.containsKey(key)) {
    		Node node = map.get(key);
    		
    		// remove node from linked list
    		remove(node);
    		// put the node as the new header
    		setHead(node);
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
        	setHead(node);
        } else {
        	if (map.size() >= capacity) {
        		// remove tail to have one more slot
        		map.remove(tail.key);//!!! Don't forget
        		remove(tail);
        	}
        	
        	Node node = new Node(key, value);
        	map.put(key, node);
    		setHead(node);
        }
    }
    
    private void remove(Node node) {
    	// remove next chain
    	if (node.prev != null) {
    		node.prev.next = node.next;
    	} else {
    		// node is the head
    		head = node.next;
    	}
    	
    	// remove previous chain
    	if (node.next != null) {
    		node.next.prev = node.prev;
    	} else {
    		// node is the tail
    		tail = node.prev;
    	}
    }
    
    // set a node to be head
    // !!! hard to implement, please practice more times
    private void setHead(Node node) {
    	if (head != null) {
    		head.prev = node;
    	}
    	node.next = head;//!!!Don't forget
    	node.prev = null;//!!!Don't forget to update chains of node
    	head = node;
    	// don't forget this case: set tail 
    	if (tail == null) {
    		tail = head;
    	}
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



