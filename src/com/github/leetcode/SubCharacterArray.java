package com.github.leetcode;

public class SubCharacterArray{

	public static void main(String[] args) {
		SubCharacterArray obj = new SubCharacterArray();
		char[] a = new char[]{'a','b','c'};
		char[] b = new char[]{};

		System.out.println("Char array a ---- The result is = " + obj.subArray(a, 0, 4));
		System.out.println("Char array a ---- The result is = " + obj.subArray(a, 0, 3));
		System.out.println("Char array a ---- The result is = " + obj.subArray(a, 0, 2));
		System.out.println("Char array a ---- The result is = " + obj.subArray(a, 0, 1));

		System.out.println("Char array a ---- The result is = " + obj.subArray(a, 1, 3));
		System.out.println("Char array a ---- The result is = " + obj.subArray(a, 1, 2));
		System.out.println("Char array a ---- The result is = " + obj.subArray(a, 1, 1));

		System.out.println("Char array a ---- The result is = " + obj.subArray(a, 2, 2));
		System.out.println("Char array a ---- The result is = " + obj.subArray(a, 2, 1));
		System.out.println("Char array a ---- The result is = " + obj.subArray(a, 3, 1));

		System.out.println("Char array a ---- The result is = " + obj.subArray(a, 1, 0));
		System.out.println("Char array a ---- The result is = " + obj.subArray(a, -1, 2));
		System.out.println("Char array a ---- The result is = " + obj.subArray(a, -1, -2));
		System.out.println("Char array a ---- The result is = " + obj.subArray(b, 0, 1));
	}


	public String subArray(char[] a, int start, int len) {
		//if (start < 0 || len < 0 || a.length == 0 || (start + len) > a.length || start >= a.length) {
		if (len < 0 || start < 0 || start+len-1 >= a.length) {
			return null;
		}

		char[] result = new char[len];
		for (int i = 0; i < len; i ++) {
			result[i] = a[start + i];
		}

		return String.valueOf(result);
	}
}