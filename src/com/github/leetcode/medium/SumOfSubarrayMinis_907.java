package com.github.leetcode.medium;

import java.util.Stack;

// !!! 这一题的解法异常 难以理解 !!!
// 你必须结合下面的link来理解!!! 下面是有关 Monotonous Stack 最好的归类与总结！
// https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
	
// https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/C++JavaPython-Stack-Solution
public class SumOfSubarrayMinis_907 {

	public static void main(String[] args) {
		SumOfSubarrayMinis_907 obj = new SumOfSubarrayMinis_907();
		int[] a1 = {3, 1, 2, 4};
		System.out.println("Cai Test obj = " + obj.sumSubarrayMins(a1));
		int[] a2 = {59, 91};
		System.out.println("Cai Test obj = " + obj.sumSubarrayMins(a2));
	}

	// 93 ms, faster than 45.85%
	// Approach 3: Use one Monotonous Increase Stack
	// PLE --- first Previous less element
	// NLE --- first Next Less element
	public int sumSubarrayMins(int[] A) {
		final int kMod = (int)1e9 + 7;
		final int n = A.length;
		// PLE array --- 记录在A[i]的左边有多少个比它大的数 ---- 即多少个以它为最小值的subArray
		int[] left = new int[n];
		// NLE array --- value is the # of right bigger(maybe strict) element after A[i] --- # of sub array in right side
		int[] right = new int[n];
		
		Stack<Pair> stack = new Stack<>();
		//[5,4,2,1]
		// O(n) to calculate PLE --- strict bigger >
		for (int i = 0; i < n; i++) {
			int len = 1;
			while (!stack.isEmpty() && stack.peek().val > A[i]) {
				len += stack.pop().len;//!!! use len of pop ele to speed up
			}
			stack.push(new Pair(A[i], len));
			left[i] = len;
		}
		
		stack.clear();
		
		//[1,2,4,5]
		// loop in the reverse sort to reuse previous result --- reuse len --- speed up --- dp idea
		for (int i = n - 1; i >= 0; i--) {
			int len = 1;
			// use non-strict bigger >= to solve duplicates
			while (!stack.isEmpty() && stack.peek().val >= A[i]) {
				len += stack.pop().len;//!!! use len of pop ele to speed up
			}
			stack.push(new Pair(A[i], len));
			right[i] = len;
		}
		
		int ans = 0;
		// calculate result == Sum(A[i] * # of subArray which min ele is A[i] )
		for (int i = 0; i < n; i++) {
			ans = (int) (ans + (long)A[i] * left[i] * right[i]) % kMod;
		}
		return ans;
	}
	
	// Approach 2: Two Monotonous increase stacks  ---- Previous Less Ele Array / Next Less Ele Array
	// Roughly speaking, the elements in the an monotonous increase stack keeps an increasing order.
	
	// https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/C++JavaPython-Stack-Solution
	
	// Use strict on one side to solve the duplicates issue for PLE/NLE issues
	// TC: O(n)
	// SC: O(n)
	public int sumSubarrayMins2(int[] A) {
		int kMod = 100_000_000_7;
		int n = A.length;
		// PLE array --- strict bigger
		int[] left = new int[n];
		// NLE array --- bigger
		int[] right = new int[n];
		
		// Use Stack<Pair> --- Pair: A[i] value, and len
		// or you can use int[]{val, len} as the element of Stack
		
		// PLE  Stack
		Stack<Pair> s1 = new Stack<>();
		for (int i = 0; i < n; i++) {
			int count = 1;// count itself, also means get empty sub array {} from previous part
			while (!s1.isEmpty() && s1.peek().val > A[i]) {
				count += s1.pop().len;//！！！真正比brute force快的地方
			}
			s1.push(new Pair(A[i], count));
			left[i] = count;
		}
		
		// NLE Stack
		Stack<Pair> s2 = new Stack<>();
		// !!! reverse sort --- to speed up!
		for (int i = n - 1; i >= 0; i--) {
			int count = 1;
			// use non-strict bigger in this side to solve duplicates issue
			while (!s2.isEmpty() && s2.peek().val >= A[i]) {
				count += s2.pop().len;//！！！真正比brute force快的地方
			}
			s2.push(new Pair(A[i], count));
			right[i] = count;
		}
		
		int result = 0;
		// Sum(A[i] * # of sub array) ---- # of sub array with min A[i] is left[i] * right[i]
		for (int i = 0; i < n; i++) {
			result = (int) (result + (long) A[i] * left[i] * right[i]) % kMod;
		}
		return result;
	}
	
	class Pair {
		int val;// A[i]
		int len;// How many element (strict) bigger ele before/after A[i]
		public Pair(int value, int len) {
			this.val = value;
			this.len = len;
		}
	}
	
	// 430 ms, faster than 14.55% 
	
	// https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
	
	// Approach 1: Brtue Force
	// TC: O(n^2)
	// SC: O(1)
//	public int sumSubarrayMins(int[] A) {
//        final int kMod = 1000000007;
//        final int n = A.length;
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//        	// 目标: 从i处位置两头找，寻找以A[i]为最小值的子序列的数量
//        	
//        	// PLE --- previous less element, count how many continues strict bigger ele before A[i]
//        	// 从i处向前找，找到第一个比A[i]小的元素
//        	// find how many eles > A[i] in the range of [0, i-1]
//        	int left = 0;
//        	for (int j = i - 1; j >= 0 && A[j] > A[i]; --j) {
//        		left++;
//        	}
//        	
//        	// NLE --- next less element, count how many continues bigger ele after A[i]
//        	// 从i处向后找，找到第一个比A[i]大的元素
//        	// find how many eles < A[i] in the range of [i+1, n)
//        	int right = 0;
//        	for (int j = i + 1; j < n && A[j] >= A[i]; j++) {
//        		right++;
//        	}
//        	
//        	// how many subArrays exists?   (left + 1) * (right + 1) --- 1 means {} empty chose
//        	// System.out.println("Cai Test A[i] = " + A[i] + " , left=" + left + " , right=" + right + " , ans = " + ans);
//        	ans = (int) ( (ans + (long) A[i] * (left + 1) * (right + 1)) % kMod );
//        }
//        return ans;
//    }
}
