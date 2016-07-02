package com.github.leetcode;

import java.util.*;
public class SecondLargestNumber{

	public static void main(String[] args) {
		int[] a = {5,4,4,9,1,10,10,2};
		int[] b = {1,1};
		int[] c = {};
		int[] d = {1};

		SecondLargestNumber obj = new SecondLargestNumber();
		System.out.println("Array a ---- The second largest integer is = " + obj.getSecondaryLargestInteger2(a));
		System.out.println("Array b ---- The second largest integer is = " + obj.getSecondaryLargestInteger2(b));
		System.out.println("Array c ---- The second largest integer is = " + obj.getSecondaryLargestInteger2(c));
		System.out.println("Array a ---- The second largest integer is = " + obj.getSecondaryLargestInteger2(d));
	}

	int getSecondaryLargestInteger2(int[] a) {
		int max1 = -1;
		int max2 = -1;
		for (int i = 0; i < a.length; i ++) {
			if (a[i] > max1) {
				max2 = max1;
				max1 = a[i];
			} else if (a[i] != max1 && a[i] > max2) {
				max2 = a[i];
			}
		}

		return max2;
	}

	int getSecondaryLargestInteger(int[] a) {
		if (a.length <= 1) return -1;

    	Arrays.sort(a);
		int largestOne = a[a.length-1];

		int i = a.length-1;
		
		while(a[i] >= largestOne && i > 0) {
			i --;
		}

		if (a[i] == largestOne) {
			return -1;
		}

		return a[i];
	}
}