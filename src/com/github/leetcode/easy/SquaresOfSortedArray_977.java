package com.github.leetcode.easy;

import java.util.Arrays;

public class SquaresOfSortedArray_977 {

	public static void main(String[] args) {
		SquaresOfSortedArray_977 obj = new SquaresOfSortedArray_977();
		
		int[] a1 = {-4, -1, 0, 3, 10};
		int[] a2 = {-7, -3, 2, 3, 11};
		System.out.println("Cai Test = " + Arrays.toString(obj.sortedSquares(a1)));
		System.out.println("Cai Test = " + Arrays.toString(obj.sortedSquares(a2)));
		
		// special cases
		int[] a3 = {-1};
		int[] a4 = {0, 2};
		System.out.println("Cai Test = " + Arrays.toString(obj.sortedSquares(a3)));
		System.out.println("Cai Test = " + Arrays.toString(obj.sortedSquares(a4)));
	}

	// 1 ms, faster than 100.00%
	// Approach 2: Two pointers
	// Algorithm:  We can use two pointers to read the positive and negative parts of the array.
	// j ---> for negative part ---> from j to 0
	// i ---> for positive part ---> from i to length - 1
	// TC: O(N) --- single pass
	// SC: O(N)
	public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        
        if (A == null || A.length == 0) return ans;
        // find first positive ele index
        int i = 0;
        while (i < len && A[i] < 0) { // !!! Don't forget 'i < len && '
        	i++;
        }
        int j = i - 1;
        
        int index = 0;// use to fill ans
        while (j >= 0 && i < len) {
        	if (A[j] * A[j] > A[i] * A[i]) {
        		ans[index++] = A[i] * A[i];
        		i++;
        	} else {
        		ans[index++] = A[j] * A[j];
        		j--;
        	}
        }
        
        while (j >= 0) {
        	ans[index++] = A[j] * A[j];
        	j--;
        }
        while (i < len) {
        	ans[index++] = A[i] * A[i];
    		i++;
        }
        return ans;
	}
	
	// Approach 1: Sort
	// TC: O(NlogN) ==== O(N) + O(NlogN)
	// SC: O(N)
//	public int[] sortedSquares(int[] A) {
//        int[] ans = new int[A.length];
//        if (A == null || A.length == 0) return ans;
//        
//        for (int i = 0; i < A.length; i++) {
//        	ans[i] = A[i] * A[i];
//        }
//        Arrays.sort(ans);
//        return ans;
//    }
}
