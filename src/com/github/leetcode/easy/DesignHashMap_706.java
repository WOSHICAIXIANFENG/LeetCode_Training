package com.github.leetcode.easy;


public class DesignHashMap_706 {

	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		print(hashMap.get(1));            // returns 1
		print(hashMap.get(3));            // returns -1 (not found)
		hashMap.put(2, 1);          // update the existing value
		print(hashMap.get(2));            // returns 1 
		hashMap.remove(2);          // remove the mapping for 2
		print(hashMap.get(2));            // returns -1 (not found) 
	}

	public static void print(int value) {
		System.out.println("Cai Test value = " + value);
	}
}

//  74 ms, faster than 94.81%
class MyHashMap {
	final ListNode[] nodes = new ListNode[10000];

    /** Initialize your data structure here. */
    public MyHashMap() {
   
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	int i = idx(key);
        if (nodes[i] == null)
            nodes[i] = new ListNode(-1, -1);
        
        ListNode prev = find(nodes[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	int i = idx(key);
        if (nodes[i] == null)
            return -1;
        ListNode node = find(nodes[i], key);
        return node.next == null ? -1 : node.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	int i = idx(key);
        if (nodes[i] == null) return;
        
        ListNode prev = find(nodes[i], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }
    
    //1%10000, 10001/10000
    int idx(int key) { return Integer.hashCode(key) % nodes.length;}

    ListNode find(ListNode bucket, int key) {
    	ListNode node = bucket, prev = null;
        while (node != null) {
            if (node.key == key) return prev;
            prev = node;
            node = node.next;
        }
        return prev;
    }
    
    class ListNode {
    	int key, val;
    	ListNode next;
    	
    	ListNode(int key, int val) {
    		this.key = key;
    		this.val = val;
    	}
    }
}

