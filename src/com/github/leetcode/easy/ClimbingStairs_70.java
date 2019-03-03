package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs_70 {

	public static void main(String[] args) {
		System.out.println("Cai Test climbStairs = " + climbStairs(1));//1,2,3,5,8,13,21
		System.out.println("Cai Test climbStairs = " + climbStairs(2));
		System.out.println("Cai Test climbStairs = " + climbStairs(3));
		System.out.println("Cai Test climbStairs = " + climbStairs(6));
	}
	
	// 3 ms, faster than 98.81%
	public static int climbStairs(int n) {
		if (n < 1) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		// Fibonacci number
		int[] numbers = new int[n + 1];
		numbers[1] = 1;
		numbers[2] = 2;
		for (int i = 3; i <= n; i ++) {
			numbers[i] = numbers[i - 1] + numbers[i - 2]; 
		}
		return numbers[n];
    }
	
//	// 5 ms, faster than 13.59% of
//	static Map<Integer, Integer> dp = new HashMap();
//	// O(n) solution with memoization
//    public static int climbStairs(int n) {
//        if(n<0)
//            return 0;
//        if(n==0)
//            return 1;
//        if(dp.containsKey(n))
//            return dp.get(n);
//        int steps= climbStairs(n-1)+climbStairs(n-2);
//        dp.put(n, steps);
//        return steps; 
//    }
		
//	// 13465 ms, faster than 0.97%
//	public static int climbStairs(int n) {
//		if (n == 1) {
//			return 1;
//		} else if (n == 2) {
//			return 2;
//		} else {
//			return climbStairs(n - 1) + climbStairs(n - 2);
//		}
//    }
}
