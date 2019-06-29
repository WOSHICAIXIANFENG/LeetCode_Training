package com.github.leetcode.easy_top100;

import java.util.Arrays;

public class CountPrimes204_top39 {

	// Count the number of prime numbers less than a non-negative number, n.
	public static void main(String[] args) {
		CountPrimes204_top39 obj = new CountPrimes204_top39();
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
		// define isPrime array
		boolean[] isPrime = new boolean[n];
		// initial isPrime array to true
		Arrays.fill(isPrime, true);
		if (n > 0) {
			isPrime[0] = false;// 0 is not a prime
		}
		if (n > 1) {
			isPrime[1] = false;// 1 is not a prime
		}
		
		// i <= Sqrt(n)
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isPrime[i]) {
				// sieve all it multiple values
				for (int j = i * i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		int count = 0;
		for (boolean prime : isPrime) {
			count += prime ? 1 : 0;
		}
		return count;
	}
	
	
	// 2 ms, faster than 72.64% 
	// https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	// Approach 1: Sieve of Eratosthenes
	// TC: O(nlogNlogN) ---> ~ O(n)  --- 2^100 --- log2^100log2^100 < 7
	// SC: O(n)
	public int countPrimes2(int n) {
		int ans = 0;
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		// 0 is not a prime
		isPrime[0] = false;
		if (n > 0) {
			// 1 is not a prime
			isPrime[1] = false;
		}
		
		for (int i = 2; i < n; i++) {
			if (!isPrime[i]) continue;// if i is not a prime, we skip it
			ans++;
			// Sieve of Eratosthenes --- You can start from i*i !!!
			for (int j = 2 * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}
		return ans;
	}
}
