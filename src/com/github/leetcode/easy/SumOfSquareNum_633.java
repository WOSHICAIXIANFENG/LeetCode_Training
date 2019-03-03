package com.github.leetcode.easy;

public class SumOfSquareNum_633 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + judgeSquareSum(5));// true
		System.out.println("Cai Test = " + judgeSquareSum(3));
		System.out.println("Cai Test = " + judgeSquareSum(1));// true
		System.out.println("Cai Test = " + judgeSquareSum(4));// true
		System.out.println("Cai Test = " + judgeSquareSum(2147482647));
		System.out.println("Cai Test = " + judgeSquareSum(2147483646));
		System.out.println("Cai Test = " + judgeSquareSum(50));// true
		System.out.println("Cai Test = " + judgeSquareSum(85));// true
	}
	
	// The best solution --- only call Math.sqrt(c) one time, not int overflow issue
	// 5 ms, faster than 99.85%
	public static boolean judgeSquareSum(int c) {
		if (c < 0) return false;
		
		int left = 0, right = (int) Math.sqrt(c);
		while (left <= right) {
			int sum = left * left + right * right;
			if (sum < c) {
				left++;
			} else if (sum > c) {
				right--;
			} else {
				return true;
			}
		}
		return false;
	}
	
	// 65 ms, faster than 18.82% 
	// Time Complexity: O(sqrt(c) * log2^c)
	// Space complexity: O(log2(c)). Binary Search will take O(log(c)) space.
//	public static boolean judgeSquareSum(int c) {
//		for (long a = 0; a * a <= c; a++){
//			int b = c - (int) (a * a);
//			if (binary_search(0, b, b)) 
//				return true;
//		}
//		return false;
//	}
	
	// TC --- O(log2^n)
	// Space complexity: O(log(c)). Binary Search will take O(log(c)) space.
	public static boolean binary_search(long start, long end, int n) {
		if (start > end) {
			return false;
		}
		
		long mid = start + (end - start) / 2; 
		// !!! use long type to avoid integer overflow issue of mid * mid
		// also could avoid divide zero issue!!!
		if (mid * mid == n) {
			return true;
		} else if (mid * mid > n) {
			return binary_search(start, mid - 1, n);
		} else {
			return binary_search(mid + 1, end, n);
		}
	}
	
	// or using iterative way to avoid O(lg(c)) space usage. 
//	public boolean isQuareNum_binary_search(long start, long end, int n) {
//        while (start <= end) {
//            long mid = start + (end - start) / 2;
//            // use long type for mid to avoid mid*mid overflow integer range.
//            if (mid * mid == n) {
//                return true;
//            } else if (mid * mid > n) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        
//        return false;
//    }
	
	// !!! Wrong --- it has divide by zero issue!!!, because start could be 0, n could be 0.!!!
//	public static boolean binary_search(int start, int end, int n) {
//		if (start > end) {
//			return false;
//		}
//		
//		int mid = start + (end - start) / 2;
//		if (n % mid == 0 && mid == n / mid) { // avoid mid * mid overflow --- !!! but it has mid == 0 issue: divide by 0
//			return true;
//		} else if (mid > n / mid) {
//			return binary_search(start, mid - 1, n);
//		} else {
//			return binary_search(mid + 1, end, n);
//		}
//	}
	
	// 9 ms, faster than 71.10%
	// Faster than Approach 3, avoid using Math.pow(a, 2)
//	public static boolean judgeSquareSum(int c) {
//		for (long a = 0; a * a <= c; a++) {
//            double b = Math.sqrt(c - a * a);
//            if (b == (int) b)
//                return true;
//        }
//        return false;
//	}
	
	// 13 ms, faster than 39.13%
	// Approach 3: Using sqrt function
	// Time Complexity: O(sqrt(c) * log(c)). Iterate over sqrt(c) values for choosing a.
	// For every a chosen, finding square root of c - a^2 takes O(log(c)) time in the worst case.
	// Space Complexity: O(1). 
//	public static boolean judgeSquareSum(int c) {
//		for (int a = 0; Math.pow(a, 2) <= c; a++) {
//			double b = Math.sqrt(c - a * a);
//			if (b == (int) b) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	// 2147483646 ----> Time Limit Exceeded
	// Time Complexity: O(sqrtn) * O(sqrtn) = O(n)
//	public static boolean judgeSquareSum(int c) {
//		for (int a = 0; Math.pow(a, 2) <= c; a++) {
//			int left = (int) (c - Math.pow(a, 2));
//			// try to find another sqrt b
//			int i = 1, sum = 0;
//			while (sum < left) {
//				sum += i;
//				i += 2;
//			}
//			if (sum == left) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	// Error
	// integer overflow  --- Math.addExact(a * a, b * b)
//	public static boolean judgeSquareSum(int c) {
//		for (int a = 0; Math.pow(a, 2) <= c; a++) {
//			for (int b = 0; Math.pow(b, 2) <=c; b++) {
//				if (Math.addExact(a * a, b * b) == c) { // Integer over flow for 2147482647
//					return true;
//				}
//			}
//		}
//		return false;
//	}

	// 2147482647 ---- Time Limit Exceeded
	// 13190 ms, faster than 1.03% 
	// Time Complexity: O(c). == O( sqrt(c) * sqrt(c) ) Two loops upto sqrt(n). 
	// Space Complexity: O(1).
//	public static boolean judgeSquareSum(int c) {
//        for (long a = 0; a * a <= c; a++) {
//        	for (long b = 0; b * b <= c; b++) {
//        		if (a * a + b * b == c) {
//        			return true;
//        		}
//        	}
//        }
//        return false;
//    }
}
