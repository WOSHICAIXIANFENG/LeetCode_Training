package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII_212 {

	public static void main(String[] args) {
		WordSearchII_212 obj = new WordSearchII_212();
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};

		String[] words = {"oath","pea","eat","rain"};
		System.out.println("Cai Test = " + obj.findWords(board, words));
		
		// special case --- need to remove duplicates from ans
		char[][] board2 = {{'a', 'a'}};
		String[] words2 = {"a"};
		System.out.println("Cai Test = " + obj.findWords(board2, words2)); // ["a"]
	}
	
	
	// My solution!!! ---- 266 ms 的解法，需要更好的solution
	
	// Approach 1: DFS search --- 4 directions
    // TC: O(row*col*k*4^l) ---k is the size of 'words', l = len(word)
    // SC: O(row*col) input data + O(l) --- l = len(word) the times of recursion
	
	private int row;
	private int col;
	private char[][] board;
	public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) return ans;
        
        // 266 ms, faster than 25.99%
        // Use HashSet to avoid duplicate answers
        Set<String> set = new HashSet<>();
        
        this.row = board.length;
        this.col = board[0].length;
        this.board = board;
        for (int i = 0; i < row; i++)
        	for (int j = 0; j < col; j++)
        		for (String word : words)
        			search(i, j, 0, word, set);
    
        for (String word : set) {
        	ans.add(word);
        }
        return ans;			
    }	
	
	// 如何优化呢？ 使用了HashSet并没有提高 时间！！！// 尝试用 boolean 返回值来 优化 --- 243 ms, faster than 26.24%，效果并不明显！
	public void search(int x, int y, int charIndex, String word, Set<String> ans) {
		// if x,y is out of range or char is not equals
		if (x < 0 || x >= row || y < 0 || y >= col || charIndex >= word.length() || word.charAt(charIndex) != board[x][y]) return;
		
		//!!!
		if (charIndex == word.length() - 1) {
			// 246 ms, faster than 26.21%
//			if (!ans.contains(word))
//				ans.add(word);
			ans.add(word);
			return;
		}
		
		// skill to avoid using another used array
		char ch = board[x][y];
		board[x][y] = '0';
		// 4 directions to search
		search(x + 1, y, charIndex + 1, word, ans);
		search(x - 1, y, charIndex + 1, word, ans);
		search(x, y + 1, charIndex + 1, word, ans);
		search(x, y - 1, charIndex + 1, word, ans);
		board[x][y] = ch;
	}
}
