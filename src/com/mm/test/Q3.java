package com.mm.test;

import java.util.Arrays;

public class Q3 {

	public static void main(String[] args) {
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},0,4)));
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},0,3)));
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},0,2)));
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},0,1)));
		
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},1,3)));
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},1,2)));
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},1,1)));
		
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},2,2)));
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},2,1)));
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},3,1)));
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},1,0)));
		
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},-1,2)));
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{'a','b','c'},-1,-2)));
		System.out.println("Samuel Test result = " + Arrays.toString(f(new char[]{},0,1)));
		
		System.out.println("Samuel Test result = " + Arrays.toString(f(null,0,1)));
	}
	
	static char[] f(char[] a, int start, int len) {
		if (a == null || a.length < 0 || start < 0 || start + len > a.length) {
			return null;
		}
		
		char[] result = new char[len];
		System.arraycopy(a, start, result, 0, len);
		return result;
	}
	
//	static char[] f(char[] a, int start, int len) {
//		if (a == null || a.length < 0 || start < 0 || len < 0 || start + len > a.length) {
//			return null;
//		}
//		
//		char[] result = new char[len];
//		System.arraycopy(a, start, result, 0, len);
//		return result;
//	}
	
	
}
