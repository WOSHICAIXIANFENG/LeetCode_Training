package com.github.leetcode.easy_top100;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412_top16 {

	public static void main(String[] args) {
		FizzBuzz412_top16 obj = new FizzBuzz412_top16();
		System.out.println("Cai Test fizzBuzz = " + obj.fizzBuzz(105));
	}

	// TC: O(n)
	// SC: O(1)
	public List<String> fizzBuzz(int n) {
		List<String> ans = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			boolean divideBy3 = i % 3 == 0;
			boolean divideBy5 = i % 5 == 0;
			String str = "";
			if (divideBy3) {
				str += "Fizz";
			}
			
			if (divideBy5) {
				str += "Buzz";
			}
			
			if ("".equals(str)) {
				str += i;
			}
			ans.add(str);
		}
		return ans;
	}
}
