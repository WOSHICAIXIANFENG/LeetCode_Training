package com.github.leetcode.easy;

public class DesignHashSet_705 {

	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		print(hashSet.contains(1));    // returns true
		print(hashSet.contains(3));    // returns false (not found)
		hashSet.add(2);          
		print(hashSet.contains(2));    // returns true
		hashSet.remove(2);          
		print(hashSet.contains(2));    // returns false (already removed)

	}

	public static void print(int value) {
		System.out.println("Cai Test value = " + value);
	}
	
	public static void print(boolean value) {
		System.out.println("Cai Test value = " + value);
	}
}

// 73 ms, faster than 89.89%
class MyHashSet {
	final ListNode[] nodes = new ListNode[10000];

    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int idx = idx(key);
        if (nodes[idx] == null) {
        	nodes[idx] = new ListNode(-1);
        }
        ListNode prevNode = find(nodes[idx], key);
        if (prevNode.next == null) {
        	prevNode.next = new ListNode(key);
        }
    }
    
    public void remove(int key) {
    	int idx = idx(key);
        if (nodes[idx] == null) {
        	return;
        }
        ListNode prevNode = find(nodes[idx], key);
        if (prevNode.next == null) {
        	return;
        } else {
        	prevNode.next = prevNode.next.next;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = idx(key);
        if (nodes[idx] == null) {
        	return false;
        }
        
        ListNode prevNode = find(nodes[idx], key);
        return prevNode.next != null;
    }
    
    public int idx(int value) {
    	return Integer.hashCode(value) % nodes.length;
    }
    
    // Find possible prev node for value
    public ListNode find(ListNode bucket, int value) {
    	ListNode node = bucket, prev = null;
    	while (node != null) {
    		if (node.val == value) {
    			return prev;
    		}
    		prev = node;
    		node = node.next;
    	}
    	return prev;
    }
    
    class ListNode {
    	int val;
    	ListNode next;
    	public ListNode(int val) {
    		this.val = val;
    	}
    }
}