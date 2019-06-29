package com.github.leetcode.easy_top100;

public class DesignHashMap706_top30 {

	public static void main(String[] args) {
		DesignHashMap706_top30 obj = new DesignHashMap706_top30();

	}

}

/**
 * The number of operations will be in the range of [1, 10000].
 * ----> by intuition --> the index array size will be 10000
 *
 * All keys and values will be in the range of [0, 1000000].
 * ----> by intuition --> you need to simulate the LinkedList structure. 
 * 
 */

// 62 ms, faster than 94.87%

// Approach 1: Use Array + LinkedList (self implementation singly linked list)
// TC: O(n)
class MyHashMap {
	// The number of operations will be in the range of [1, 10000].
	// indices == keys
	private ListNode[] keys = new ListNode[10000];
	
	/** Initialize your data structure here. */
    public MyHashMap() {
    	this.keys = new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	int index = idx(key);
    	if (keys[index] == null) {
    		// create a bucket/head node to find all nodes with the same idx value
    		keys[index] = new ListNode(-1, -1);
    	}
    	
    	ListNode pre = findPreNode(keys[index], key);
    	if (pre.next == null) {
    		pre.next = new ListNode(key, value);
    	} else {
    		// update the value for this node
    		pre.next.val = value;
    	}
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	int index = idx(key);
    	if (keys[index] == null) {
    		return -1;
    	}
    	
    	ListNode preNode = findPreNode(keys[index], key);
    	if (preNode.next == null) {
    		return -1;// this node possibly has been removed 
    	} else {
    		return preNode.next.val;
    	}
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	int index = idx(key);
    	if (keys[index] == null) {
    		return;
    	}
    	ListNode preNode = findPreNode(keys[index], key);
    	if (preNode.next == null) {
    		return;
    	} else {
    		preNode.next = preNode.next.next;
    	}
    }
    
    // Use hashCode as the index of indices array
    //1%10000 == 10001/10000
    private int idx(int key) {
    	return Integer.hashCode(key) & keys.length;
    }
    
    // find prev ListNode under this bucket Node which has the same key idx
    private ListNode findPreNode(ListNode bucket, int key) {
    	ListNode cur = bucket;
    	ListNode pre = bucket;
    	while (cur != null) {
    		if (cur.key == key) {
    			return pre;
    		} else {
    			pre = cur;
    		}
    		cur = cur.next;
    	}
    	return pre;
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