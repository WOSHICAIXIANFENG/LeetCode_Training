package com.github.leetcode.easy;

import java.util.Arrays;

public class MiniSwapsToMakeSequencesIncrease_801 {

	public static void main(String[] args) {
		MiniSwapsToMakeSequencesIncrease_801 obj = new MiniSwapsToMakeSequencesIncrease_801();
		int[] a1 = {1, 3, 5, 4};
		int[] b1 = {1, 2, 3, 7};
		System.out.println("Cai Test = " + obj.minSwap(a1, b1));
	}
	
	/**
	 * A, B are arrays with the same length, and that length will be in the range [1, 1000].
	 * 
	 * ----> Your solution's TC should < O(2^n) --- 一般n到达30以后就会ExceedTimeLimit
	 * 
	 * We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
	 * ----> only A[i] and B[i] swap
	 * 
	 *  It is guaranteed that the given input always makes it possible.
	 *  -----> 4,2; 3,1; is a wrong case ---- since it couldn't become two strictly increase arrays
	 */
	
	// 2 ms, faster than 76.67%
	
	// A[i], B[i] --- either swap or keep
	// minimized the question: 2 * 2 == 4 elements could do it.
	// 4 elements will have 4 operations: keep[i], keep[i -1]; swap[i - 1], keep[i]; swap[i-1],swap[i]; keep[i - 1], swap[i];
	// A[i],A[i-1],B[i],B[i-1]. --- >, >; <, <;(this case can ignore by the question);  >, <; <, >;
	// Approach 1: DP
	// TC: O(n)
	// SC: O(n)
	// !!!! ---- Alg is just emulate the process, it didn't truely swap
	// 算法只是在模拟推算，它并没在交换元素。
	public int minSwap(int[] A, int[] B) {
        final int n = A.length;
        int[] keep = new int[n]; // keep[i] --- how many minimized swaps happened when you keep the i-th eles
        int[] swap = new int[n]; // swap[i] --- how many minimized swaped happened when you swap the i-th eles
        Arrays.fill(keep, Integer.MAX_VALUE); // or set it to max times 1001
        Arrays.fill(swap, Integer.MAX_VALUE);
        
        // initialize the index value
        keep[0] = 0;// no swap needed to keep 0th elements sorted
        swap[0] = 1;// you just need to swap the 0th elements
        
        for (int i = 1; i < n; i++) {
        	// case: <, <;  ---- two cases by i-1 state(check if i-1 is swaped or keeped)
        	// A -- 2,4; B -- 1,3;
        	if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
        		// if you want to keep it, you need to do it base on keep[i - 1]
        		keep[i] = keep[i - 1];
        		// if you want to do swap on ith, you need to do it base on swap[i - 1]
        		swap[i] = swap[i - 1] + 1;
        	}
        	
        	// case >, <; <, >; --- you have to swap one time to make sure two arrays are restrict increase
        	// the swap operation could happened in previous loop or prevoius block. --- emulated!!
        	if (B[i] > A[i - 1] && A[i] > B[i - 1]) {
        		// if you want to keep ith, you need to do swap on i-1
        		// keep[i] is possible be did in previous if block
        		keep[i] = Math.min(keep[i], swap[i - 1]);
        		
        		// if the i was swapped in the previous if block.  2,8;5,7; <,< case. You don't need to do
        		// if you want to do swap on ith, you had to do it base on keep[i -1], that's why +1
        		swap[i] = Math.min(swap[i], keep[i - 1] + 1);       		
        	}
        }
        
        return Math.min(keep[n - 1], swap[n - 1]);
    }
}
