package com.github.leetcode.medium;

public class SearchA2DMatrixII_240 {

	public static void main(String[] args) {
		int[][] a1 = {{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
		System.out.println("Cai Test = " + searchMatrix(a1, 5));// true
		System.out.println("Cai Test = " + searchMatrix(a1, 20));// false
	}
	
	// The best solution: Searching from bottom to top and from left to right
	// Time Complexity: O(N+M) --- N is row length, M is column length
	// The worst case: the target is in matrix[0][colLength - 1]
	// 5 ms, faster than 100.00%
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int coluCount = matrix[0].length;
		int row = matrix.length - 1;
		int col = 0;
		while (row >= 0 && col < coluCount) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] > target) {
				row--;
			} else {
				col++;
			}
		}
		
		return false;
	}
	
	// 6 ms, faster than 83.59% ---- My first solution!!!
	// Time Complexity --- NO(logN)
//	public static boolean searchMatrix(int[][] matrix, int target) {
//		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
//		
//		int low = 0;
//		int high = matrix.length - 1;
//		while (low <= high) {
//			int mid = low + (high - low) / 2;
//			if (matrix[mid][0] == target) {
//				return true;
//			} else if (matrix[mid][0] > target) {
//				high = mid - 1;
//			} else {
//				low = mid + 1;
//			}
//		}
//		
//		// searching scope will in 0 -- low
//		int maxTargetRow = low > 0 ? low - 1 : low;
//		if (maxTargetRow < matrix.length) {
//			int rowLength = matrix[0].length;
//			// from first line to max target row
//			for (int i = 0; i <= maxTargetRow; i++) {
//				if (matrix[i][rowLength - 1] >= target) {
//					int start = 0;
//					int end = rowLength - 1;
//					while (start <= end) {
//						int mid = start + (end - start) / 2;
//						if (matrix[i][mid] == target) {
//							return true;
//						} else if (matrix[i][mid] > target) {
//							end = mid - 1;
//						} else {
//							start = mid + 1;
//						}
//					}
//				}
//			}
//		}
//        return false;
//    }

}
