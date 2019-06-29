package com.github.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures_739 {

	public static void main(String[] args) {
		DailyTemperatures_739 obj = new DailyTemperatures_739();
		int[] a1 = {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println("Cai Test = " + Arrays.toString(obj.dailyTemperatures2(a1)));
	}
	
	/**
	 * The length of temperatures will be in the range [1, 30000]. 
	 * ---> Brute Force O(n^2) will time out
	 * Each temperature will be an integer in the range [30, 100].
	 * ---> It's unnecessary to convert the value to rank or diff
	 * 
	 * How to figure out the solution == O(n)?
	 * You need to figure out how to reuse the result of pre step 
	 * DP thinking!  ----- need to loop in reverse order
	 */
	
	// 4 ms, faster than 97.74%
	
	// Approach 2: Use DP array 
	// TC: O(n) --- one pass --- the inner while() could be thinking as O(1) time consume
	// SC: O(n) ans/dp
	public int[] dailyTemperatures2(int[] T) {
		// this is the ans, also could be dp array, value is the index diff
		// how many day you need to wait until the warmer day comes
        int[] ans = new int[T.length];
        final int n = T.length;
        // in reverse order to reuse the diff value
        for (int i = n - 1; i >= 0; i--) {
        	// from next ele to calculate/eat the 'diff' value
        	int j = i + 1;
        	while (j < n) {
        		// T[i] >= T[j] we need to move back to find the bigger one.
        		if (T[i] >= T[j]) {
        			if (ans[j] == 0) { // speed up!!! if next element doesnt have next warmer day
        				ans[i] = 0;
        				break;
        			} else {
        				j += ans[j];
        			}
        		} else {
        			ans[i] = j - i;//!!!
        			break;//!!!
        		}
        	}
        }
        return ans;
	}
	
	// 14 ms, faster than 85.91% 
	
	// Approach 1: Use Monotonous decrease Stack
	// TC: O(n) ---- each node could only be push or pop one time
	// SC: O(n) ---- stack --- in the worst case: array is in ascending sort
	public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        final int n = T.length;
        
        Deque<Pair> stack = new ArrayDeque<>();
        // in reverse order to reuse previous 'len' value
        for (int i = n - 1; i >= 0; i--) {
        	int count = 1;
    		// pop up the top ele and absorb its 'len' value
    		while (!stack.isEmpty() && stack.peek().val <= T[i]) {
    			count += stack.pop().len;
    		}
    		ans[i] = stack.isEmpty() ? 0 : count;
    		stack.push(new Pair(T[i], ans[i]));
        }
        
        return ans;
    }
	
	// use Pair or use int[2] {val, len}
	class Pair {
		int val;// daily temperature
		int len;// how many days you have to wait until a warmer temperature
		public Pair(int val, int len) {
			this.val = val;
			this.len = len;
		}
	}
}
