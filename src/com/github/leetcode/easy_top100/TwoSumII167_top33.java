package com.github.leetcode.easy_top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumII167_top33 {

	public static void main(String[] args) {
		TwoSumII167_top33 obj = new TwoSumII167_top33();
		int[] n1 = {2,7,11,15};
		System.out.println("Cai Test = " + Arrays.toString(obj.twoSum(n1, 9)));
	}
	
	// 1 ms, faster than 59.25%
	// Approach 2: Two pointers --- because the array is in asc order
	// TC: O(n)
	// SC: O(1)
	public int[] twoSum(int[] numbers, int target) {
		final int m = numbers.length;
		int[] ans = new int[2];
		
		int p1 = 0;
		int p2 = m - 1;
		while (p1 < p2) {
			// WRONG ---- CAN'T USE a1 + an --- it could out of Integer Range
			//double avg = numbers[p1] + numbers[p2] / 2;
			double avg = numbers[p1] + (numbers[p2] - numbers[p1]) / 2d;
			if (avg == target / 2d) {
				ans[0] = p1 + 1;
				ans[1] = p2 + 1;
				break;
			} else if (avg > target / 2d) {
				p2--;
			} else {
				p1++;
			}
 		}
		return ans;
	}

	// 2 ms, faster than 28.72% 
	
	// Approach 1: HashMap
	// TC: O(N)
	// SC: O(N)
	public int[] twoSum2(int[] numbers, int target) {
		// value --> index
		Map<Integer, Integer> map = new HashMap<>();
		int[] ans = new int[2];
		final int m = numbers.length;
		for (int i = 0; i < m; i++) {
			if (map.containsKey(target - numbers[i])) {
				ans[0] = map.get(target - numbers[i]) + 1;
				ans[1] = i + 1;
				break;
			} else {
				map.put(numbers[i], i);
			}
		}
		return ans;
	}
}
