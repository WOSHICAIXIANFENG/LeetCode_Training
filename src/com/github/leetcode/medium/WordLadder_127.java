package com.github.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder_127 {

	public static void main(String[] args) {
		WordLadder_127 obj = new WordLadder_127();
		List<String> wordList = new ArrayList<>();
		String[] temp = {"hot","dot","dog","lot","log","cog"};
		for (String str : temp) {
			wordList.add(str);
		}
		System.out.println("Cai Test = " + obj.ladderLength2("hit", "cog", wordList));
	}
	
	// 13 ms, faster than 98.96%
	// Approach 2: Bidirectional BFS
	// TC: O(n * 26^(l/2) ) --- l = len(word), n = |wordList|
	// SC: O(n) dict + O(n) HashSet
	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>();
		for (String word : wordList) dict.add(word);
		
		if (!dict.contains(endWord)) return 0;
		
		Set<String> q1 = new HashSet<>();
		Set<String> q2 = new HashSet<>();
		q1.add(beginWord);
		q2.add(endWord);
		
		int l = beginWord.length();
		int steps = 0;
		while (!q1.isEmpty() && !q2.isEmpty()) {
			++steps;
			if (q1.size() > q2.size()) {
				Set<String> tmp = q1;
				q1 = q2;
				q2 = tmp;
			}
			
			// Handle all the candidates of certain level comes from the smaller side
			Set<String> q = new HashSet<>();
			// handle the smaller hashSet
			for (String w : q1) {
				char[] chs = w.toCharArray();
				for (int i = 0; i < l; ++i) {
					char ch = chs[i];
					for (char c = 'a'; c <= 'z'; ++c) {
						// new str with 1 letter changed
						chs[i] = c;
						String changed = new String(chs);
						//!!! two trees across
						if (q2.contains(changed)) return steps + 1;
						if (!dict.contains(changed)) continue;
						// remove the candidate from dict to avoid be used again in the future
						dict.remove(changed);
						q.add(changed);
					}
					chs[i] = ch;
				}
			}
			q1 = q;
		}
		return 0;
	}
	
	// 60 ms, faster than 70.50%
	// Approach : BFS
	// TC: O(n*26^l). l = len(word), n = |wordList|
	// SC: O(n) dict
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 转成一个字典的经典做法!!!
		Set<String> dict = new HashSet<>();
        for (String word : wordList)
        	dict.add(word);
        
        if (!dict.contains(endWord)) return 0;
        
        // BSF 通法就是使用一个Queue然后按size 一次全取 
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int l = beginWord.length();
        int steps = 0;
        
        while (!q.isEmpty()) {
        	++steps;
        	for (int s = q.size(); s > 0; --s) {
        		String w = q.poll();
        		char[] chs = w.toCharArray();
        		for (int i = 0; i < l; ++i) {
        			// try to change i-th letter, push all candidates in Queue
        			char ch = chs[i];
        			for (char c = 'a'; c <= 'z'; ++c) {
            			if (c == ch) continue;
            			// change i-th letter to other letter
            			chs[i] = c;
            			String changed = new String(chs);
            			// since endWord is in the dict
            			if (changed.equals(endWord)) return steps + 1;
            			if (!dict.contains(changed)) continue;
            			// !!! we found a candidate, we need to remove it from dict to avoid use it again
            			dict.remove(changed);
            			q.offer(changed);
            		}
        			chs[i] = ch;
        		}
        	}
        }
        return 0;
    }
}
