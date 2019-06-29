package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CopyListWithRandomPointer_138 {

	public static void main(String[] args) {
		CopyListWithRandomPointer_138 obj = new CopyListWithRandomPointer_138();
		Node n1 = new Node();
		Node n2 = new Node();
		n1.val = 1;
		n1.next = n2;
		n1.random = n2;
		n2.val = 2;
		n2.random = n2;
		System.out.println("Cai Test = " + obj.copyRandomList(n1));
	}
	
	
	// 1 ms, faster than 79.74% 
	// Approach 2:  Recursion + HashTable
	// TC: O(V + E)
	// SC: O(n) --- visitedMap
	private Map<Node, Node> map = new HashMap<Node, Node>();
	public Node copyRandomList(Node head) {
		if (head == null) return null;
		
		if (map.containsKey(head)) {
			return map.get(head);
		}
		Node cloneNode = new Node(head.val, null, null);
		map.put(head, cloneNode);
		if (head.next != null) {
			cloneNode.next = copyRandomList(head.next);
		}
		if (head.random != null) {
			cloneNode.random = copyRandomList(head.random);
		}
		return cloneNode;
	}
	
	// 2 ms, faster than 21.11%
	// Approach 1:  Queue + HashTable
	// TC: O(V + E)
	// SC: O(V + E)
	public Node copyRandomList2(Node head) {
		if (head == null) return null;
		
		// use queue to do BFS to go through all nodes
		Queue<Node> queue = new LinkedList<>();
		// use map to handle all relationships --- edges: next, random
		// origin node ---> clone node
		Map<Node, Node> map = new HashMap<>();
		queue.offer(head);//!!!
		map.put(head, new Node(head.val, null, null));
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			// BFS --- to handle edges
			if (cur.next != null) {
				if (!map.containsKey(cur.next)) {
					map.put(cur.next, new Node(cur.next.val, null, null));
					queue.offer(cur.next);
				}
				map.get(cur).next = map.get(cur.next);
			}
			if (cur.random != null) {
				if (!map.containsKey(cur.random)) {
					map.put(cur.random, new Node(cur.random.val, null, null));
					queue.offer(cur.random);
				}
				map.get(cur).random = map.get(cur.random);
			}
		}
        return map.get(head);
    }
}

//Definition for a Node.
class Node {
 public int val;
 public Node next;
 public Node random;

 public Node() {}

 public Node(int _val,Node _next,Node _random) {
     val = _val;
     next = _next;
     random = _random;
 }
};