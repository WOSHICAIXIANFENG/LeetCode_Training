package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AccountsMerge_721 {

	public static void main(String[] args) {
		AccountsMerge_721 obj = new AccountsMerge_721();
		List<List<String>> a1 = new ArrayList<>();
		List<String> t1 = new ArrayList<>();
		t1.add("John");
		t1.add("johnsmith@mail.com");
		t1.add("john00@mail.com");
		
		List<String> t2 = new ArrayList<>();
		t2.add("John");
		t2.add("johnnybravo@mail.com");
		
		List<String> t3 = new ArrayList<>();
		t3.add("John");
		t3.add("johnsmith@mail.com");
		t3.add("john_newyork@mail.com");
		
		List<String> t4 = new ArrayList<>();
		t4.add("Mary");
		t4.add("mary@mail.com");
		
		a1.add(t1);
		a1.add(t2);
		a1.add(t3);
		a1.add(t4);
		System.out.println("Cai Test = " + obj.accountsMerge(a1));
	}
	
	// 31 ms, faster than 90.68%
	// Approach 1: UnionFind Set
	// TC: O(n*e) --- n is # of account, e is # of each account
	// SC: O(n*e)
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		// Save email-user relationships --- this will be used to construct the ans
		// email --> user
		Map<String, String> users = new HashMap<>();
				
		// step1: Construct email graph
		Map<String, String> parents = new HashMap<>();
		// initialize email graph, and save email-user map, 
		for (List<String> account : accounts) {
			for (int i = 1; i < account.size(); i++) {
				parents.put(account.get(i), account.get(i));
				users.put(account.get(i), account.get(0));// email --> user
			}
		}
		
		// step2: Union/Merge all emails under the 1st email --- build email tree -- flat
		// Find parent and union to the root node's parent in each group
		for (List<String> account : accounts) {
			String parent = find(account.get(1), parents);
			for (int i = 2; i < account.size(); i++) {
				String curParent = find(account.get(i), parents);
				// Union/Merge the first email and other emails --- merge them into the same cluster
				parents.put(curParent, parent);
			}
		}
		
		// step3: Prepare Sorted Email list in ascending sorting
		// Loop through groups and save the unions/clusters
		// email cluster root ---> email TreeSet
		Map<String, Set<String>> unions = new HashMap<>();
		for (List<String> account : accounts) {
			String parent = find(account.get(1), parents);
			if (!unions.containsKey(parent)) {
				unions.put(parent, new TreeSet<>());
			}
			for (int i = 1; i < account.size(); i++) {
				unions.get(parent).add(account.get(i));
			}
		}
		
		// step4: Output the ans with the format
		// Go through unions/clusters map and save to result
		List<List<String>> res = new ArrayList<>();
		for (String parent : unions.keySet()) {
			List<String> emails = new ArrayList<>(unions.get(parent));
			emails.add(0, users.get(parent));// put user name at the start pos
			res.add(emails);
		}
		
        return res;
    }
	
	// Find the cluster id/root id of 'email'
	// Iterative way
	// TC: O(amortized(1))
	private String find2(String email, Map<String, String> parents) {
		if (!parents.containsKey(email)) return null;
		while (!parents.get(email).equals(email)) {
			// parents[u] = parents[parents[u]];
			// u = parents[u];
			parents.put(email, parents.get(parents.get(email)));
			email = parents.get(email);
		}
		return email;
	}
	
	// Recursion way ---- Find the cluster id/root id of email tree --- with path compression
	// TC: O(amortized(1))
	private String find(String email, Map<String, String> parents) {
		if (!parents.containsKey(email)) return null;
		return parents.get(email) == email ? email : find2(parents.get(email), parents);
	}
}
