package com.github.leetcode.easy_top100;

public class ConstructQuadTree427_top45 {

	public static void main(String[] args) {
		ConstructQuadTree427_top45 obj = new ConstructQuadTree427_top45();
	}

	// 1 ms, faster than 99.95%
	// Approach 1: Recursion
	// TC: O(logN * N ^ 2)
	// SC: O(N^2)
	public Node construct(int[][] grid) {
		final int N = grid.length;
        return construct(grid, 0, 0, N);
    }
	
	public Node construct(int[][] grid, int x, int y, int n) {
		if (n == 0) return null;
		boolean allZeros = true;
		boolean allOnes = true;
		//!!!! i -- row, j -- col.
		// 这里特别注意 i 取 y的值， j 取 x的值。
		for (int i = y; i < y + n; i++)
			for (int j = x; j < x + n; j++)
				if (grid[i][j] == 0) { //!!! grid[i][j]
					allOnes = false;
				} else {
					allZeros = false;
				}
		
		if (allOnes || allZeros) {
			// isLeaf is true if and only if the node is a leaf node. 
			// The val attribute for a leaf node contains the value of the region it represents.
			return new Node(allOnes, true, null, null, null, null);
		}
		
		// for non-leaf nodes, the val can be arbitrary. so, we set true in here
		return new Node(true, false,
				construct(grid, x, y, n / 2), //topLeft
				construct(grid, x + n / 2, y, n / 2), //topRight
				construct(grid, x, y + n / 2, n / 2), //bottomLeft
				construct(grid, x + n / 2, y + n / 2, n / 2) //bottomRight
				);
	}
}

//Definition for a QuadTree node.
class Node {
 public boolean val;
 public boolean isLeaf;
 public Node topLeft;
 public Node topRight;
 public Node bottomLeft;
 public Node bottomRight;

 public Node() {}

 public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
     val = _val;
     isLeaf = _isLeaf;
     topLeft = _topLeft;
     topRight = _topRight;
     bottomLeft = _bottomLeft;
     bottomRight = _bottomRight;
 }
};