package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII_212_bettter {

	public static void main(String[] args) {
		WordSearchII_212_bettter obj = new WordSearchII_212_bettter();
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};

		String[] words = {"oath","pea","eat","rain"};
		System.out.println("Cai Test = " + obj.findWords(board, words));
		
		// special case --- need to remove duplicates from ans
//		char[][] board2 = {{'a', 'a'}};
//		String[] words2 = {"a"};
//		System.out.println("Cai Test = " + obj.findWords(board2, words2)); // ["a"]
//		
		char[][] board3 = {{'a', 'b'}, {'a', 'a'}};
		String[] words3 = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
		System.out.println("Cai Test = " + obj.findWords(board3, words3)); // [aaa, aba, aaba, baa, aaab]
	}
	
	
	// My solution!!! ---- 266 ms 的解法，需要更好的solution --- 尝试利用字典树来解决。
	
	// 10 ms, faster than 96.20%
	// Approach 2: Word Tree (each leaf is a word) + DFS search --- 4 directions
    // TC: O(row*col*4^l) --- l = len(word)
    // SC: O(k*l) tree nodes +  O(row*col) input board data + O(l) --- l = len(word) the times of recursion
	
	class TrieNode {
		String word;
		TrieNode[] children;
		public TrieNode() {
			this.children = new TrieNode[26];
			word = null;
		}
	}
	
	private TrieNode root = new TrieNode();
	
	public void insert(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.word = word;
	}
	
	private int row;
	private int col;
	private char[][] board;
	public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) return ans;
        
        for (String word : words) 
            insert(word);
        
        // Use HashSet to avoid duplicate answers
        Set<String> set = new HashSet<>();
        
        this.row = board.length;
        this.col = board[0].length;
        this.board = board;
        for (int i = 0; i < row; i++)
        	for (int j = 0; j < col; j++)
        		search(i, j, root, set);
    
        for (String word : set) {
        	ans.add(word);
        }
        return ans;			
    }	
	
	public void search(int x, int y, TrieNode node, Set<String> ans) {
		// if x,y is out of range or char is not equals
		if (x < 0 || x >= row || y < 0 || y >= col) 
			return;
		
		char ch = board[x][y];
		if (ch == '0' || node.children[ch - 'a'] == null) return;
		
		TrieNode next = node.children[ch - 'a'];
		//!!! case --- 'big', 'bigger' --- hashSet can avoid add 'big' twice
		if (next.word != null) {
			ans.add(next.word);
			// 这里不可以!!! return！！！我们需要处理 bigger 在big 之后的情况。
		}
		
		// skill to avoid using another used array
		board[x][y] = '0';
		// 4 directions to search
		search(x + 1, y, next, ans);
		search(x - 1, y, next, ans);
		search(x, y + 1, next, ans);
		search(x, y - 1, next, ans);
		board[x][y] = ch;
	}
}
