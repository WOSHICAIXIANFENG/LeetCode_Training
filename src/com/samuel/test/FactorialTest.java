package com.samuel.test;

import java.math.BigInteger;

public class FactorialTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static BigInteger factorial(int n) {
	    // in order to avoid overflow. You can use BigInteger class to solve it. 
	     BigInteger result = BigInteger.ONE;
	     for (int i = 2; i <= n; i++) {
	         result = result.multiply(BigInteger.valueOf(i));    
	     }
	     return result;
	}

}
