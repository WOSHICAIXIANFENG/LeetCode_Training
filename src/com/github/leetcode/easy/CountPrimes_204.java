package com.github.leetcode.easy;

public class CountPrimes_204 {

	public static void main(String[] args) {
		System.out.println("Cai Test countPrimes = " + countPrimes(2));
		System.out.println("Cai Test countPrimes = " + countPrimes(3));
		System.out.println("Cai Test countPrimes = " + countPrimes(10));
		System.out.println("Cai Test countPrimes = " + countPrimes(499979));
	}
	
	// 14 ms, faster than 86.42%
	// Time Complexity: O(nlgN)
	// Space Complexity: O(n)
	public static int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i ++) {
			if (notPrime[i] == false) {
				count ++;
				for (int j = 2; i * j < n; j ++) {
					notPrime[i * j] = true;
				}
			}
		}
		return count;
	}

//	// 499979 --- Time Limit Exceeded --- because quite many duplicated calculating happened on check if i is prime
//	public static int countPrimes(int n) {
//        // prime list: 2,3,5,7,11,13
//		if (n <= 2) {
//			return 0;
//		}
//		
//		int count = 1;
//		for (int i = 3; i < n; i ++) {
//			if (isPrime(i)) {
//				count ++;
//			}
//		}
//		return count;
//    }
	
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i < n - 1; i ++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
