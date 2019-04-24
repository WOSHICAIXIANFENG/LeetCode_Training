package com.github.leetcode.medium;

public class WordSearch_79 {

	public static void main(String[] args) {
		WordSearch_79 obj = new WordSearch_79();
		char[][] board = new char[][]{
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
			};
		System.out.println("Cai Test = " + obj.exist(board, "ABCCED"));	
		System.out.println("Cai Test = " + obj.exist(board, "SEE"));	
		System.out.println("Cai Test = " + obj.exist(board, "ABCB"));	
	}
	
	// 3 ms, faster than 100.00%
	// Approach 1: DFS
	// TC: search: O(4^l) --- l = len(word)
	// total: O(m*n*4^l)
	// SC: O(m*n + l) --- l = len(word) --- the times of recursive
	private int row = 0;
	private int col = 0;
	private char[][] board;
	private String word;
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		
		this.board = board;
		this.word = word;
        this.row = board.length;
        this.col = board[0].length;
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (search(i, j, 0)) return true;
        	}
        }
        return false;
    }
	
	public boolean search(int x, int y, int charIndex) {
		if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != word.charAt(charIndex)) {
			return false;
		}
		
		if (charIndex == word.length() - 1) {
			return true;
		}
				
		// !!!The same letter cell may not be used more than once.
		char ch = board[x][y];
		board[x][y] = '0';
		// for direction searching
		boolean found = search(x - 1, y, charIndex + 1)
				|| search(x + 1, y, charIndex + 1)
				|| search(x, y - 1, charIndex + 1)
				|| search(x, y + 1, charIndex + 1);
		board[x][y] = ch;
		return found;
	}
}
