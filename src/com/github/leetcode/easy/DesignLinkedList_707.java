package com.github.leetcode.easy;

public class DesignLinkedList_707 {

	public static void main(String[] args) {
		 MyLinkedList linkedList = new MyLinkedList();
//		 linkedList.addAtHead(1);
//		 linkedList.addAtIndex(1, 2);
//		 System.out.println("Cai Test = " + linkedList);//1 --> 2
//		 System.out.println("Cai Test = " + linkedList.get(1));// 2
//		 System.out.println("Cai Test = " + linkedList.get(0));// 1
//		 System.out.println("Cai Test = " + linkedList.get(2));// -1
		 //linkedList.deleteAtIndex(1);
		 
		 linkedList.addAtIndex(-1, 0);
		 System.out.println("Cai Test = " + linkedList.get(0));// -1
		 System.out.println("Cai Test = " + linkedList);
		 linkedList.deleteAtIndex(-1);
		 System.out.println("Cai Test = " + linkedList);
	}
}

// 54 ms, faster than 92.65%

// addAtHead: O(1)
// addAtTail: O(1)
// addAtIndex: O(n)
// deleteAtIndex: O(n)
// get: O(n)
class MyLinkedList {
	private int size;
	private Node head;
	private Node tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	if (index < 0 || index >= size) return -1;
    	
    	Node temp = head;
    	while (index > 0) {
    		temp = temp.next;
    		index--;
    	}
        return temp.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
        	head = new Node(val);
        	tail = head;
        } else {
        	Node newHead = new Node(val);
        	newHead.next = head;
        	head = newHead;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (tail == null) {
        	tail = new Node(val);
        	head = tail;
        } else {
        	Node newTail = new Node(val);
        	tail.next = newTail;
        	tail = newTail;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. 
     * If index equals to the length of linked list, the node will be appended to the end of linked list. 
     * If index is greater than the length, the node will not be inserted. */
    // if the index is less than the 0 index, the node will be inserted at the head
    public void addAtIndex(int index, int val) {
        if (index <= size) {
        	// if index is -1, -2 do addAtHead operation
        	if (index <= 0) {
        		addAtHead(val);
        	} else if (index == size) {
        		addAtTail(val);
        	} else {
        		Node previous = head;
        		//System.out.println("Cai Test index = " + index);
        		while (index > 1) {
        			previous = previous.next;
        			index--;
        		}
        		//System.out.println("Cai Test prev = " + previous + " ,index = " + index);
        		Node insertNode = new Node(val);
        		insertNode.next = previous.next;
        		previous.next = insertNode;
        		
        		size++;
        	}
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
        	if (index == 0) {
        		if (head == tail) {
        			head = head.next;
        			tail = head;
        		} else {
        			head = head.next;
        		}
        	} else {
        		Node previous = head;
        		while (index > 1) {
        			previous = previous.next;
        			index--;
        		}
        		previous.next = previous.next.next;
        		if (previous.next == null) {
        			tail = previous;
        		}
        	}
        	
        	size--;
        }
    }
    
    @Override
	public String toString() {
		return "MyLinkedList [size=" + size + ", head=" + head + ", tail=" + tail + "]";
	}

	class Node {
    	int val;
    	Node next;
    	public Node(int val) {
    		this.val = val;
    	}
		@Override
		public String toString() {
			return "Node [val=" + val + ", next=" + next + "]";
		}
    }
}