package com.github.leetcode.easy;

public class MaximumSubArray_53 {

	public static void main(String[] args) {
		int[] a1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 }; // 6 -- [4,-1,2,1]
		int[] a2 = { -2, 1, -3, 4, -1, 2, 1, -5, 6 }; // 7 -- [4,-1,2,1,-5,6]
		int[] a3 = { -2, -1, -3, -4, -1, 2, 1 }; // 3
		int[] a4 = { -2, -1, -3, -4, -1, -2, -1 }; // -1
		System.out.println("Cai Test " + maxSubArray(a1));
		System.out.println("Cai Test " + maxSubArray(a2));
		System.out.println("Cai Test " + maxSubArray(a3));
		System.out.println("Cai Test " + maxSubArray(a4));
	}
	
	public static int maxSubArray(int[] nums) {
		int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (curSum > 0) {
        		curSum += nums[i];
        	} else {
        		curSum = nums[i];
        	}
            maxSum = Math.max(maxSum, curSum);
        }
        
        return maxSum;
		
		// O(n^2) --- 89ms
//		int maxSum = Integer.MIN_VALUE;
//		for (int i = 0; i < nums.length; i ++) {
//			int sum = nums[i];
//			if (sum > maxSum) {
//				maxSum = sum;
//			}
//			
//			for (int j = i + 1; j < nums.length; j ++) {
//				sum += nums[j];
//				if (sum > maxSum) {
//					maxSum = sum;
//					//System.out.println("debug.... item = " + nums[i] + " , nums[j] = " + nums[j] +  " , maxSum = " + maxSum);
//				}
//			}
//		}
//        return maxSum;
		
//		// !!! O(n) solution  --- 14ms
//		int max = Integer.MIN_VALUE, sum = 0;
//	    for (int i = 0; i < nums.length; i++) {
//	        if (sum < 0) 
//	            sum = nums[i];
//	        else 
//	            sum += nums[i];
//	        if (sum > max)
//	            max = sum;
//	    }
//	    return max;
		
//		// !!! O(n) solution  --- 11ms
//		int maxSoFar = nums[0], maxEndingHere = nums[0];
//		for (int i = 1; i < nums.length; i ++) {
//			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
//			maxSoFar = Math.max(maxSoFar, maxEndingHere);
//		}
//		return maxSoFar;
    }
}
