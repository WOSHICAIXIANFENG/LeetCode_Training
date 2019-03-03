package com.github.leetcode.easy;

/**
 * https://leetcode.com/problems/first-bad-version/
 * 
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. 
 * You should minimize the number of calls to the API.
 * 
 * @author Samuel.Cai
 */
public class FirstBadVersion_278 extends VersionControl {

	public static void main(String[] args) {
		
	}
	
	//14 ms, faster than 33.22%
	// Time Complexity: O(log3^n)
	// Ternary Research
	public int firstBadVersion(int n) {
		int low = 1, high = n;
		while (low <= high) {
			int mid1 = low + (high - low) / 3;
			int mid2 = high - (high - low) / 3;
			if (isBadVersion(mid1)) {
				high = mid1 - 1;
				continue;
			} else {
				low = mid1 + 1;
			}
			
			if (isBadVersion(mid2)) {
				high = mid2 - 1;
			} else {
				low = mid2 + 1;
			}
		}
		return low;
	}

	// 12 ms, faster than 99.28%
	// 12 ms, faster than 99.28%  ---- after using int mid = low + (high - low) / 2;

	// My first solution
	// binary search solution ----- Time LimitExceeded for 2126753390, because (left + right) / 2
	// Time Complexity: O(log2^n)
//	2126753390
//	1702766719
//	public int firstBadVersion(int n) {
//		int left = 1, right = n;
//		while (left <= right) {
//			int middle = (left + right) / 2; //!!! Wrong!!! 
//			if (isBadVersion(middle)) {
//				right = middle - 1;
//			} else {
//				left = middle + 1;
//			}
//		}
//        return left;
//    }
	
//	// Time complexity: O(log2^n). The search space is halved each time, so, the TC is O(lgn)
//	// Space complexity: O(1).
//	public int firstBadVersion(int n) {
//		int left = 1, right = n;
//		while (left < right) {
//			int mid = (left + right) / 2; //!!! Wrong ---> Because in case of large numbers there is an integer overflow that causes the algorithm to get all messed up.
//			if (isBadVersion(mid)) {
//				right = mid;
//			} else {
//				left = mid + 1;
//			}
//		}
//		return left;
//	}
}

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */
class VersionControl {
	public boolean isBadVersion(int version) {
		return false;
	}
}