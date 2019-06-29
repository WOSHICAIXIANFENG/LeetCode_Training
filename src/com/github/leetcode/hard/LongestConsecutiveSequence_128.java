package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence_128 {

	public static void main(String[] args) {
		LongestConsecutiveSequence_128 obj = new LongestConsecutiveSequence_128();
		int[] n1 = {100, 4, 200, 1, 3, 2};
		System.out.println("Cai Test = " + obj.longestConsecutive(n1));//4
	}

	/**
	 * Your algorithm should run in O(n) complexity.
	 *  -----> DP 
	 *  
	 *  Consecutive !!! ---> meain i = i-1 + 1
	 *  
	 *  http://zxi.mytechroad.com/blog/zoj/leetcode-longest-consecutive-sequence/
	 *  
	 */
	
	// 7 ms, faster than 56.55%
	
	// Approach 2: HashSet --- check if hashSet contains key - 1.
	// If not, key is a lower bound, check key + 1, key + 2, key + 3... until key +.. is not in hashSet
	// TC: O(n) ---- each element be accessed at most two times
	// SC: O(n)
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		Set<Integer> hashSet = new HashSet<>();
		for (int num : nums) {
			hashSet.add(num);
		}
		
		int ans = 0;
		for (int num : nums) {
			if (!hashSet.contains(num - 1)) {
				// num is the left bound
				int len = 0;
				while (hashSet.contains(num)) {
					len++;
					num++;
				}
				ans = Math.max(ans, len);
			}
		}
		return ans;
	}
	
	// 8 ms, faster than 42.89%
    // Approach 1: DP 
	// --- Use HashTable (key, len), update the boundry by its neighour
	// TC: O(n)
	// SC: O(n)
	public int longestConsecutive3(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
        // user hashMap to record key --> len
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;//!!! ignore duplicate nums
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int newLen = left + right + 1;
            // Update the left and right boundries
            map.put(num - left, newLen);
            map.put(num + right, newLen);
            // Update itself
            map.put(num, newLen);
            longest = Math.max(longest, newLen);
        }
        return longest;
    }
	
	// Approach 1: DP 
	// --- HashTable (key, len), update the boundry by its neighour
	// TC: O(n)
	// SC: O(n)
	public int longestConsecutive2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
        	if (map.containsKey(num)) continue;
        	if (map.containsKey(num - 1) && map.containsKey(num + 1)) {
        		// num has left/right neighour
        		int l = map.get(num - 1);
        		int r = map.get(num + 1);
        		int len = l + r + 1;
        		map.put(num, len);
        		map.put(num - l, len);
        		map.put(num + r, len);
        	} else if (map.containsKey(num - 1)) {
        		// cur num only have left neighbour
        		int l = map.get(num - 1);
        		map.put(num, l + 1);
        		map.put(num - l, l + 1);
        	} else if (map.containsKey(num + 1)) {
        		// cur num only have right neighbour
        		int r = map.get(num + 1);
        		map.put(num, r + 1);
        		map.put(num + r, r + 1);
        	} else {
        		map.put(num, 1);
        	}
        	ans = Math.max(ans, map.get(num));
        }
        return ans;
    }
}
