package com.github.leetcode.easy_top100;

public class LongestCommonPrefix14_top35 {

	// https://leetcode.com/articles/longest-common-prefix/ 
	// 5 solutions !!!
	public static void main(String[] args) {
		LongestCommonPrefix14_top35 obj = new LongestCommonPrefix14_top35();
		String[] s1 = {"flower","flow","flight"};
		System.out.println("Cai Test = " + obj.longestCommonPrefix(s1));// fl
		String[] s2 = {"dog","racecar","car"};
		System.out.println("Cai Test = " + obj.longestCommonPrefix(s2));
		
		// Test
		System.out.println("Cai Test StringStarWithEmptyStr = " + "abc".startsWith(""));// true!!!
	}

	// Approach 3: Divide and conquer
	// TC: O()
	
	
	// 1 ms, faster than 76.27% 
	// Approach 2: Vertical Scanning 
	// compare char from left to right
	// TC: O(S) 
	// In the worst case there will be n equal strings with length m and the algorithm performs S = m *n character comparisons. 
	// In the best case, it at most run n * minLen comparisons.
	// SC: O(1)
	public String longestCommonPrefix3(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char ch = strs[0].charAt(i);
			// the leftest char is ch
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != ch) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];//!!!
	}
	
	// !!!
	// 0 ms, faster than 100.00%
	// !!!! A Best solution  --- Use startWith API
	// TC: O(S) , where S is the sum of all characters in all strings.
	// SC: O(1)
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
	
	// Approach 1: Horizontal Scanning
	// TC: O(S) , where S is the sum of all characters in all strings.
	// the worst case, all n Strs are the same, so s1 will compare with all other strs.
	// SC: O(1)
	public String longestCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			// indexOf -- TC: O(m*n)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) return "";// 提前返回
			}
		}
		return prefix;
	}
}
