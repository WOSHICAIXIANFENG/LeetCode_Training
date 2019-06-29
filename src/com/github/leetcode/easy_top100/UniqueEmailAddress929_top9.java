package com.github.leetcode.easy_top100;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress929_top9 {

	public static void main(String[] args) {
		UniqueEmailAddress929_top9 obj = new UniqueEmailAddress929_top9();
		String[] e1 = {
				"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"
		};
		System.out.println("Cai Test = " + obj.numUniqueEmails(e1));// 2
	}

	/**
	 * 1 <= emails[i].length <= 100
     * 1 <= emails.length <= 100
	 * 
	 */
	
	// 15 ms, faster than 73.41% 
	// Approach 1: Set
	// TC: O(n)
	// SC: O(n)
	public int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet<>();
        
        for (String email : emails) {
        	int index = email.indexOf('@');
        	String local = email.substring(0, index);
        	String rest = email.substring(index);
        	if (local.contains("+")) {
        		local = local.substring(0, local.indexOf('+'));
        	}
        	local = local.replace(".", "");
        	seen.add(local + rest);
        }
        return seen.size();
    }
}
