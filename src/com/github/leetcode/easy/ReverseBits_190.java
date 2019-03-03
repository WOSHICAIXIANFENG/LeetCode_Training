package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ReverseBits_190 {

	public static void main(String[] args) {
		System.out.println("Cai test = " + reverseBits(-3));// -1073741825

	}
	
	
	
	//cache ---- Byte ---> reversed value Integer
	private static final Map<Byte, Integer> cache = new HashMap<>();
	
	public static int reverseBits(int n) {
		byte[] bytes = new byte[4];
		for (int i = 0; i < 4; i++) {
			bytes[i] = (byte) ((n >> 8*i) & 0xFF);
			String byteStr = Integer.toBinaryString((bytes[i] & 0xFF) + 0x100).substring(1);
			System.out.println("Cai test byteStr = " + byteStr);
		}
		int result = 0;
		for (int i = 0; i < 4; i++) {
			String byteStr = Integer.toBinaryString((bytes[i] & 0xFF) + 0x100).substring(1);
			System.out.println("Cai test byteStr = " + byteStr);
			result += reverseByte(bytes[i]);
			if (i < 3) {
				result <<= 8;
			}
		}
		System.out.println("Cai Test final value = " + Integer.toBinaryString(result));
		return result;
	}
	
	private static int reverseByte(byte b) {
		Integer value = cache.get(b);
		System.out.println("Cai test 22222 byte = " + Integer.toBinaryString((b & 0xFF) + 0x100).substring(1) );
		
		if (value != null) {
			System.out.println("Cai test 22222 value = " + Integer.toBinaryString(value) + " byte = " + Integer.toBinaryString((b & 0xFF) + 0x100).substring(1) );
			return value;
		}
		value = 0;
		// reverse 8 bits
		byte temp = b;
		for (int i = 0; i < 8; i++) {
			value <<= 1;
			if ((temp & 1) == 1) {
				value++;
			}
			temp >>= 1; //!!! don't use b directly, because we need to cache b into hashMap.
		}
		cache.put(b, value);
		System.out.println("Cai test value = " + Integer.toBinaryString(value) + " byte = " + Integer.toBinaryString((b & 0xFF) + 0x100).substring(1) );
		return value;
	}
	
	// 1 ms, faster than 100.00% 
	// you need treat n as an unsigned value
	// How to optimize if this function is called multiple times? We can divide an int into 4 bytes, and reverse each byte then combine into an int.
	// For each byte, we can use cache to improve performance.
//    public static int reverseBits(int n) {
//        int result = 0;
//        for (int i = 0; i < 32; i++) {
//        	result <<= 1;
//        	if ((n & 1) == 1) {
//        		result++;
//        	}
//        	n >>= 1;
//        }
//        return result;
//    }
}
