package com.github.leetcode.easy_top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount811_top11 {

	public static void main(String[] args) {
		SubdomainVisitCount811_top11 obj = new SubdomainVisitCount811_top11();
		String[] s1 = {
				"9001 discuss.leetcode.com"
		};
		System.out.println("Cai Test = " + obj.subdomainVisits(s1));
		
		String[] s2 = {
				"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
		};
		System.out.println("Cai Test = " + obj.subdomainVisits(s2));
	}

	/**
	 * The length of cpdomains will not exceed 100. 
	 * The length of each domain name will not exceed 100.
	 */
	// 7 ms, faster than 98.87%
	// TC: O(n) where N is the length of cpdomains, and assuming the length of cpdomains[i] is fixed.
	// SC: O(n)
	public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cp : cpdomains) {
        	int index = cp.indexOf(' ');
        	int count = Integer.parseInt(cp.substring(0, index));
        	String domain = cp.substring(index + 1);
        	int val = map.getOrDefault(domain, 0);
        	map.put(domain, val + count);
        	//Each address will have either 1 or 2 "." characters.
        	while (domain.contains(".")) {
        		domain = domain.substring(domain.indexOf('.') + 1);
        		map.put(domain, map.getOrDefault(domain, 0) + count);
        	}
        }
        
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        	ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }
}
