package com.github.leetcode.easy_top100;

import java.util.Arrays;

public class CountPrimes204_top40_P {

	// Count the number of prime numbers less than a non-negative number, n.
	public static void main(String[] args) {
		CountPrimes204_top40_P obj = new CountPrimes204_top40_P();
		System.out.println("Cai Test countPrimes = " + obj.countPrimes(2));// 0  !!!
		System.out.println("Cai Test countPrimes = " + obj.countPrimes(3));// 1
		System.out.println("Cai Test countPrimes = " + obj.countPrimes(10));// 4
		System.out.println("Cai Test countPrimes = " + obj.countPrimes(499979));// 41537
	}

	// A better solution
	// 8 ms, faster than 96.32%
	
	// Approach 2: Sieve of Eratosthenes
	// TC: O(sqrt(n)*logNlogN) + O(n)
	// SC: O(n)
	
	// idea: if n is not a prime, it could be written as n = a * b, a <= b ==> a <= sqrt(n)
	public int countPrimes(int n) {
		// TODO
		// define a isPrime Array
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		// as we know, 0, 1 are not prime
		if (n > 0) isPrime[0] = false;
		if (n > 1) isPrime[1] = false;
		// 2 is the first prime.
		// if n is not a prime, it could be written as n = a * b, we make a <= b. So, we can get a <= Sqrt(n)
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isPrime[i]) {
				// if i-th ele is a prime, we sieve all it multiples as not prime
				for (int j = i * i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		// step2: accumulate all primes 
		int count = 0;
		for (boolean prime : isPrime) {
			count += prime ? 1 : 0;
		}
		return count;
	}
}
