package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class CountSmallerNumbersAfterSelf_315 {

	public static void main(String[] args) {
		CountSmallerNumbersAfterSelf_315 obj = new CountSmallerNumbersAfterSelf_315();
		int[] a1 = {5, 2, 6, 1};
		System.out.println("Cai Test = " + obj.countSmaller(a1));
		
		// special case
		int[] a2 = {};
		System.out.println("Cai Test = " + obj.countSmaller(a2));
	}

	// 15 ms, faster than 48.03%
	
	// !!! About Fenwick tree (Binary Indexed Tree), learn from the following link
	// https://www.youtube.com/watch?v=v_wj_mOAlig
	// For Fenwick Tree --- Add or Calculate PreSum TC is O(lgN)
	
	// !!! 注意，此题你必须将number 转成rank来解，不然你的 frequency table会非非常大，会Stack Overflow的!!!
	// Prefix sums of frequencies, convert the number to its rank as in sorted array
	// TC: O(nlogN)
	// SC: O(k) --- k is the # of unique elements. The # of nodes of Fenwick Tree
	//Approach 2: Fenwick Tree 
	public List<Integer> countSmaller(int[] nums) {
		// step1: sort the unique numbers
		// TC: O(n)*O(log n)
		// SC: O(k) -- k is the # of unique elements
		TreeSet<Integer> uniqueSet = new TreeSet<>();
		for (int num : nums) {
			uniqueSet.add(num);//TreeSet --- add --- O(log n)
		}
		//Integer[] sortedArray = new Integer[uniqueSet.size()];
		//uniqueSet.toArray(sortedArray);
		//System.out.println("Cai Test sorted unique array = " + Arrays.toString(sortedArray));
		
		// step2: map the number to its rank
		// TC: O(k) --- K is the # of unique elements
		// SC: O(k)
		Map<Integer, Integer> ranks = new HashMap<>();
		int rank = 0;
		Iterator<Integer> iterator = uniqueSet.iterator();
		while (iterator.hasNext()) {
			ranks.put(iterator.next(), ++rank);
		}
		//System.out.println("Cai Test sorted ranks = " + ranks);
		List<Integer> ans = new ArrayList<>();
		
		// use a fenwick tree to as the frequency tree
		FenwickTree ft = new FenwickTree(ranks.size());
		// step3: Scan the numbers in reversed order
		// TC: O(n (LgN + LgN))
		for (int i = nums.length - 1; i >= 0; i--) {
			// Increase the count of the rank of current number.
			ft.update(ranks.get(nums[i]), 1);
						
			// check how many numbers are smaller than the current number.
			ans.add(ft.query(ranks.get(nums[i]) - 1));
		}
		
		// TC: O(n)
		Collections.reverse(ans);
		return ans;
	}
	
	// 树状数组 
	class FenwickTree {
		private int[] sums;
		public FenwickTree(int n) {
			sums = new int[n + 1];
		}
		
		// O(lgN)
		public void update(int i, int delta) {
			while (i < sums.length) {
				sums[i] += delta;
				i += lowbit(i);
			}
		}
		
		// O(lgN)
		public int query(int i) {
			int sum = 0;
			while (i > 0) {
				sum += sums[i];
				i -= lowbit(i);
			}
			return sum;
		}
		// get last 1 bit
		private int lowbit(int x) {
			return x & -x;
		}
	}
	
	// 588 ms, faster than 7.76% 
	// Approach: Brute Force
	// TC: O(n^2)
	// SC: O(n)
//	public List<Integer> countSmaller(int[] nums) {
//        //List<Integer> ans = new ArrayList<>(nums.length);
//        //ans.add(0);
//		int[] ans = new int[nums.length];
//		// !!! 特别注意下面的一个编写 错误!!!
//		//ans[nums.length - 1] = 0;//[] --> ArrayIndexOutOfBoundsException
//		
//        for (int i = nums.length - 1; i >= 0; i--) {
//        	int j = i - 1;
//        	while (j >= 0) {
//        		if (nums[i] < nums[j]) {
//        			ans[j]++;
//        		}
//        		j--;
//        	}
//        }
//        
//        List<Integer> result = new ArrayList<>(nums.length);
//        for (int an : ans) {
//        	result.add(an);
//        }
//        return result;
//    }
}
