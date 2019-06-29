package com.github.leetcode.easy_top100;

public class SqrtX69_top24 {

	public static void main(String[] args) {
		SqrtX69_top24 obj = new SqrtX69_top24();
		System.out.println("Cai test = " + obj.mySqrt(4));// 2
		
		System.out.println("Cai test = " + obj.mySqrt(8));// 2, not 3!!!
		
		// special case 
		System.out.println("Cai test = " + obj.mySqrt(1));// 1
		System.out.println("Cai test = " + obj.mySqrt(0));// 0
		
		System.out.println("Cai test = " + obj.mySqrt(2147395599));// 46339
	}
	
	// 1 ms, faster than 100.00%
	// Approach 1:  Binary Search
	// TC: O(logN)
	public int mySqrt(int x) {
		int left = 1;//!!! have to start from 1
        int right = x;
        // Have to use <= as you return 'left - 1' as the answer
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Avoid using mid * mid which will out of Integer range
            // !!! Since here you do '/mid', so the left has to start from 1
            if (x / mid > mid) {
                left = mid + 1;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        
        return left - 1;//!!! -1 since the while process will make left > right
	}
	
	// Log(N) --- binary search solution: 
	// Approach 1:  Binary Search
	// TC: O(logN)
	// SC: O(1)
//	public int mySqrt(int x) {
//		int left = 1;// have to start from 1 !!!
//		int right = x;
//		//!!! <= !!! --- case 0
//		while (left <= right) {
//			int mid = left + (right - left) / 2;
//			if (x / mid > mid) { // can't use mid * mid, that will out of Integer Range
//				left = mid + 1;
//			} else if (x / mid < mid) {
//				right = mid - 1;
//			} else {
//				return mid;
//			}
//		}
//		return left - 1;
//	}
}
