package com.github.leetcode.easy;

public class HouseRobber_198 {

	public static void main(String[] args) {
		int[] a1 = {1,2,3,1};
		int[] a2 = {2,7,9,3,1};
		int[] a3 = {2,1,1,2};
		System.out.println("Cai Test rob = " + rob(a1));
		System.out.println("Cai Test rob = " + rob(a2));
		System.out.println("Cai Test rob = " + rob(a3));
	}
	
	// This algorithm will process the same i multiple times and it needs improvement. Time complexity: [n^2]
	public static int rob(int[] nums) {
	    return rob(nums, nums.length - 1);
	}
	
	private static int rob(int[] nums, int i) {
	    if (i < 0) {
	        return 0;
	    }
	    return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	}
	
//	// 3 ms, faster than 89.50% 
//	// DP solution, Time Complexity: O(n). Space Complexity: O(1).
//	public static int rob(int[] nums) {
//		int rob = 0; //max money if you rob current house
//		int notRob = 0;//max money if not rob current house
//		for (int i = 0; i < nums.length; i ++) {
//			int curRob = notRob + nums[i];// if rob current house, previous house must not be robbed
//			notRob = Math.max(notRob, rob);// if not rob ith house, take the max value of robbed i-1 th house and not rob i-1 th house
//			rob = curRob;
//		}
//		return Math.max(rob, notRob);
//    }

}
