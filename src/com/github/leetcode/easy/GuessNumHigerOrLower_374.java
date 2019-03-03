package com.github.leetcode.easy;

public class GuessNumHigerOrLower_374 extends GuessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//  0 ms, faster than 100.00%
	// Ternary Search 
	// Time Complexity: O(log3^n)
	// Note---> log3^n < log2^n
	public int guessNumber(int n) {
		int low = 1, high = n;
		while (low <= high) {
			int mid1 = low + (high - low) / 3;
			int mid2 = high - (high - low) / 3;
			if (guess(mid1) == 0) {
				return mid1;
			} else if (guess(mid1) < 0) {
				high = mid1 - 1;
			} else {
				low = mid1 + 1;
			}
			
			if (guess(mid2) == 0) {
				return mid2;
			} else if (guess(mid2) < 0) {
				high = mid2 - 1;
			} else {
				low = mid2 + 1;
			}
		}
		
		return -1;// not found
	}

	// 0 ms, faster than 100.00% 
	// Binary Search ---- 
	// Time Compleixty: O(log2^n)
//	public int guessNumber(int n) {
//        int left = 1, right = n;
//        while (left <= right) {
//        	int mid = left + (right - left) / 2;
//        	if (guess(mid) == 0) {
//        		return mid;
//        	} else if (guess(mid) > 0) {
//        		left = mid + 1;
//        	} else {
//        		right = mid - 1;
//        	}
//        }
//        return -1; // not found
//    }
}

class GuessGame {
    public int guess(int n) {
        return -1;
    }
}