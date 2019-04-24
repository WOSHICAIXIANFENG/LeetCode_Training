package com.github.leetcode.medium;

public class SearchA2DMatrix_74 {

	public static void main(String[] args) {
		int[][] a1 = {{1,3,5,7},{10, 11, 16, 20},{23, 30, 34, 50}};
		System.out.println("Cai Test = " + searchMatrix(a1, 3));
		System.out.println("Cai Test = " + searchMatrix(a1, 13));
		
		// ArrayIndexOutOfBoundsException
		int[][] a2 = {{1}};
		System.out.println("Cai Test = " + searchMatrix(a2, 0));
		System.out.println("Cai Test = " + searchMatrix(a2, 2));// false
		System.out.println("Cai Test = " + searchMatrix(a2, 1));// true
	}

	// 4 ms, faster than 100.00%
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		
		// find row first by binary search 
		int low = 0;
		int high = matrix.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (matrix[mid][0] == target) {
				return true;
			} else if (matrix[mid][0] > target) {
				// find from first half
				high = mid - 1;
			} else {
				// find from second half
				low = mid + 1;
			}
		}
		
		// if M*1 matrix ---> low will 0. e.g. [[1]] find 0 ---> low = 0
		//System.out.println("Cai Test = low = " + low);
		//searching from 'low - 1' row
		int rowIndex = low > 0 ? low - 1 : low;
		int l = 0;
		int r = matrix[rowIndex].length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (matrix[rowIndex][mid] == target) {
				return true;
			} else if (matrix[rowIndex][mid] > target) {
				// find from first half
				r = mid - 1;
			} else {
				// find from second half
				l = mid + 1;
			}
		}
		return false;
    }
}
