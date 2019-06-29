package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII_503 {

	public static void main(String[] args) {
		NextGreaterElementII_503 obj = new NextGreaterElementII_503();
		int[] a1 = {1, 2, 1};
		System.out.println("Cai Test = " + Arrays.toString(obj.nextGreaterElements(a1)));
		int[] a2 = {1,2,3,4,3};
		System.out.println("Cai Test = " + Arrays.toString(obj.nextGreaterElements(a2)));
	}
	
	// 更易于理解 --- 但是！！！ 运行时间只有 
	// 148 ms, faster than 6.06%
	
	// Approach 2.1: Brute Force (using Double Length Array) 
    // The length of given array won't exceed 10000.
    // TC: O(n^2) The complete numsnums array of size nn is scanned for all the elements of numsnums in the worst case.
    // SC: O(2n) long array
//    public int[] nextGreaterElements(int[] nums) {
//        final int n = nums.length;
//        int[] ans = new int[n];
//        // create a double-size longArray
//        int[] longArray = new int[2 * n];
//        for (int i = 0; i < 2 * n; i++) {
//            longArray[i] = nums[i % n];
//        }
//        
//        // one pass to figure out the ans array
//        for (int i = 0; i < n; i++) {
//            // start from ele after nums[i] to iterate n elements
//            boolean found = false;
//            for (int j = 1; j < n; j++) {
//                if (longArray[i + j] > nums[i]) {
//                    found = true;
//                    ans[i] = longArray[i + j];
//                    break;
//                }
//            }
//            if (!found) {
//                ans[i] = -1;
//            }
//        }
//        
//        return ans;
//    }
	
	// 2 ms, faster than 100.00%
	// Approach 2: Double size index Array
	// TC: O(n)
	// SC: O(2n)
	public int[] nextGreaterElements(int[] nums) {
		final int n = nums.length;
		int[] ans = new int[n];
		// create a double size index array
		int[] index = new int[2 * n];
		for (int i = n; i < 2 * n; i++) {
			index[i] = i - n;
		}
		
		int cur = n;
		// find all next greater for each element in reverse sort
		for (int i = n - 1; i >= 0; i--) {
			while (cur < 2 * n && nums[index[cur]] <= nums[i]) {
				cur++;
			}
			ans[i] = (cur == 2 * n) ? -1 : nums[index[cur]];
			//!!! --- 不知道如何理解
			cur--;
			index[cur] = i;//!!!--- 不知道如何理解
		}
		
		return ans;
	}

	// !!! Animation Show: https://leetcode.com/articles/next-greater-element-ii/
	
	// 45 ms, faster than 39.03%
	// Approach 1: Monotonous decrease Stack
	// TC: O(2n). Only two pass, second pass is push or pop ele from stack
	// SC: O(n) stack
	public int[] nextGreaterElements2(int[] nums) {
        final int n = nums.length;
        // 2 passes can get all ans
        int[] ans = new int[n];
        
        // put the index into stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
        	// try to pop up all continuous smaller elements
        	while (!stack.isEmpty() && nums[i % n] >= nums[stack.peek()]) {
        		stack.pop();
        	}
        	ans[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
        	stack.push(i % n);
        }
        return ans;
    }
}
