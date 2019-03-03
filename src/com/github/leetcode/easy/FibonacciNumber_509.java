package com.github.leetcode.easy;

public class FibonacciNumber_509 {

	public static void main(String[] args) {
		System.out.println("Cai Test fib = " + fib(2));
		System.out.println("Cai Test fib = " + fib(3));
		System.out.println("Cai Test fib = " + fib(4));
		System.out.println("Cai Test fib = " + fib(5));
	}
	
	// 2 ms, faster than 100.00%
	public static int fib(int N) {
		if (N == 0) {
			return 0;
		} else if (N == 1) {
			return 1;
		}
		
		int[] fArray = new int[N + 1];
		fArray[0] = 0;
		fArray[1] = 1;
		for (int i = 2; i < N + 1; i ++) {
			fArray[i] = fArray[i - 1] + fArray[i - 2];
		}
		
        return fArray[N];
    }
	
//	// 17 ms, faster than 30.68% 
//	public static int fib(int N) {
//		if (N == 0) {
//			return 0;
//		} else if (N == 1) {
//			return 1;
//		}
//		
//        return fib(N - 1) + fib(N - 2);
//    }

}
