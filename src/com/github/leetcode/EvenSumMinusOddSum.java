package com.github.leetcode;

/**
 * 
 * @author Samuel.Cai
 */
public class EvenSumMinusOddSum{

	public static void main(String[] args) {
		EvenSumMinusOddSum obj = new EvenSumMinusOddSum();

		int[] a = {1};
		int[] b = {1,2};
		int[] c = {1,2,3};
		int[] d = {1,2,3,4};
		int[] e = {3,3,4,4};
		int[] f = {3,2,3,4};
		int[] g = {4,1,2,3};
		int[] h = {1,1};
		int[] i = {};
		System.out.println("Array a ---- The result is = " + obj.getMinusResult(a));
		System.out.println("Array b ---- The result is = " + obj.getMinusResult(b));
		System.out.println("Array c ---- The result is = " + obj.getMinusResult(c));
		System.out.println("Array d ---- The result is = " + obj.getMinusResult(d));
		System.out.println("Array e ---- The result is = " + obj.getMinusResult(e));
		System.out.println("Array f ---- The result is = " + obj.getMinusResult(f));
		System.out.println("Array g ---- The result is = " + obj.getMinusResult(g));
		System.out.println("Array h ---- The result is = " + obj.getMinusResult(h));
		System.out.println("Array i ---- The result is = " + obj.getMinusResult(i));
	}

	int getMinusResult(int[] arrays) {
		int x = 0; // the sum of all even integers
		int y = 0; // the sum of all odd integers

		for (int a : arrays) {
			if (a % 2 == 0) {
				x += a;
			} else {
				y += a;
			}
		}

		return y - x;
	}
}