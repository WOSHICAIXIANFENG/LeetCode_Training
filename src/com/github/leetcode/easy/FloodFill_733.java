package com.github.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FloodFill_733 {

	public static void main(String[] args) {
		int[][] a1 = {{1,1,1},{1,1,0},{1,0,1}};
		FloodFill_733 obj = new FloodFill_733();
//		System.out.println("Cai Test = " + print(obj.floodFill(a1, 1, 1, 2)));
//		
//		int[][] a2 = {{0,0,0},{0,0,0}};
//		System.out.println("Cai Test = " + print(obj.floodFill(a2, 0, 0, 2)));
		
		// Special case newColor == color
		int[][] a3 = {{0,0,0},{0,1,1}};
		System.out.println("Cai Test = " + print(obj.floodFill(a3, 1, 1, 1)));
	}
	
	public static String print(int[][] values) {
		String result = "[ ";
		for (int[] a : values) {
			result += Arrays.toString(a);
		}
		return result + " ]";
	}

	// 7 ms, faster than 100.00%
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		 int color = image[sr][sc];
		 
		 // Avoid Stack Overflow of {{0,0,0},{0,1,1}}
	     if (color != newColor) {
	    	 dfs(image, sr, sc, color, newColor);
	     }
	     return image;
	}
	
	// Perfect solution with clean code
	public void dfs(int[][] image, int r, int c, int color, int newColor) {
		if (image[r][c] == color) {
			image[r][c] = newColor;
			if (r >= 1) dfs(image, r - 1, c, color, newColor);
			if (r < image.length - 1) dfs(image, r + 1, c, color, newColor);
			if (c >= 1) dfs(image, r, c - 1, color, newColor);
			
			//[[0,0,0][0,0,0]] it is not N*N grid. 
			if (c < image[0].length - 1) dfs(image, r, c + 1, color, newColor);
		}
	}
	
//	// Not perfect!!!
//	public void dfs(int[][] image, int sr, int sc, int color, int newColor) {
//        image[sr][sc] = newColor;
//        
//        if (sr != 0 && image[sr - 1][sc] == color) {
//            dfs(image, sr - 1, sc, color, newColor);
//        }
//        if (sr != image.length - 1 && image[sr + 1][sc] == color) {
//            dfs(image, sr + 1, sc, color, newColor);
//        }
//        if (sc != 0 && image[sr][sc - 1] == color) {
//            dfs(image, sr, sc - 1, color, newColor);
//        }
//        if (sc != image[0].length - 1 && image[sr][sc + 1] == color) {
//            dfs(image, sr, sc + 1, color, newColor);
//        }
//    }

	
	// My First Solution!!!  Time Limit Exceeded 
	// too complicated
//	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//		int value = image[sr][sc];
//		Pair<Integer, Integer> pair = new Pair<>(sr, sc);
//		Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
//		queue.offer(pair);
//		image[sr][sc] = newColor;
//		
//		while (!queue.isEmpty()) {
//			Pair<Integer, Integer> currPair = queue.poll();
//			System.out.println("Cai test = " + currPair.e1 + "," + currPair.e2);
//			
//			// find 4-direction connected same color coordinate
//			if (currPair.e1 != image.length - 1 && image[currPair.e1 + 1][currPair.e2] == value) {
//				queue.offer(new Pair<>(currPair.e1 + 1, currPair.e2));
//				image[currPair.e1 + 1][currPair.e2] = newColor;
//			}
//			
//			if (currPair.e1 != 0 && image[currPair.e1 - 1][currPair.e2] == value) {
//				queue.offer(new Pair<>(currPair.e1 - 1, currPair.e2));
//				image[currPair.e1 - 1][currPair.e2] = newColor;
//			}
//			
//			if (currPair.e2 != image[0].length - 1 && image[currPair.e1][currPair.e2 + 1] == value) {
//				queue.offer(new Pair<>(currPair.e1, currPair.e2 + 1));
//				image[currPair.e1][currPair.e2 + 1] = newColor;
//			}
//			
//			if (currPair.e2 != 0 && image[currPair.e1][currPair.e2 - 1] == value) {
//				queue.offer(new Pair<>(currPair.e1, currPair.e2 - 1));
//				image[currPair.e1][currPair.e2 - 1] = newColor;
//			}
//		}
//		
//        return image;
//    }
	
	class Pair<T, E> {
		private T e1;
		private E e2;
		
		public Pair(T e1, E e2) {
			this.e1 = e1;
			this.e2 = e2;
		}
	}
}
