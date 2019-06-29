package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock_752 {

	public static void main(String[] args) {
		OpenTheLock_752 obj = new OpenTheLock_752();
		String[] a1 = {"0201","0101","0102","1212","2002"};
		System.out.println("Cai Test = " + obj.openLock(a1, "0202"));
		String[] a2 = {"8888"};
		System.out.println("Cai Test = " + obj.openLock(a2, "0009"));
		String[] a3 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
		System.out.println("Cai Test = " + obj.openLock(a3, "8888"));
		System.out.println("Cai Test = " + obj.openLock(a3, "0000"));
	}

	// idea: shortest path in a undirected, unweighted graph. each node has at most 8 neighbors
	
	// 56 ms, faster than 82.07% --- You can use bidirectional BFS to speed up the process
	// Approach : BFS
	// TC: O(8 * 10000)
	// SC: O(10000 + D) ---- D is the deadends
	public int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> dead = new HashSet<>();
        for (String d : deadends) {
        	dead.add(d);
        }
        if (start.equals(target)) return 0;//!!!
        if (dead.contains(start)) return -1;//!!!
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        
        Set<String> visited = new HashSet<>();
        visited.add(start);
        
        int steps = 0;
        while (!queue.isEmpty()) {
        	++steps;
        	int size = queue.size();
        	for (int s = 0; s < size; s++) {
        		String node = queue.poll();
        		char[] chars = node.toCharArray();
        		for (int i = 0; i < 4; i++) {
        			char ch = chars[i];
        			// change one digit each time, increase/decrease 1
        			for (int j = -1; j <= 1; j += 2) {
        				chars[i] = (char) ((ch - '0' + j + 10) % 10 + '0');
        				String next = new String(chars);
        				if (next.equals(target)) return steps;
        				if (dead.contains(next) || visited.contains(next)) {
        					chars[i] = ch;
        					continue;
        				}
        					
        				visited.add(next);
        				queue.offer(next);
        				chars[i] = ch;
        			}
        		}
        	}
        }
        return -1;
    }
}
