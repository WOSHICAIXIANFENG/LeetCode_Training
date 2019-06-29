package com.github.leetcode.medium;

public class SatisfiabilityOfEqualityEquations_990 {

	public static void main(String[] args) {
		SatisfiabilityOfEqualityEquations_990 obj = new SatisfiabilityOfEqualityEquations_990();
		String[] s1 = {"a==b","b!=a"};
		System.out.println("Cai Test = " + obj.equationsPossible(s1));
		String[] s2 = {"a==b","b==c","a==c"};
		System.out.println("Cai Test = " + obj.equationsPossible(s2));
		String[] s3 = {"a==b","b!=c","c==a"};
		System.out.println("Cai Test = " + obj.equationsPossible(s3));
	}
	
	// 1 ms, faster than 100.00%
	
	// Approach 1: UnionFindSet
	// TC: O(n)
	// SC: O(1)
	public boolean equationsPossible(String[] equations) {
        // step1: build parents forest
		int[] parents = new int[128];
		for (int i = 'a'; i < 'z'; i++) {
			parents[i] = i;// initial the parents array to put parent to itself
		}
		
		// Union/Merge the connection cluster into one cluster
		for (String equation : equations) {
			if (equation.charAt(1) == '=') {
				int u = equation.charAt(0);
				int v = equation.charAt(3);
				parents[find(u, parents)] = find(v, parents);
			}
		}
		
		for (String equation : equations) {
			int u = equation.charAt(0);
			int v = equation.charAt(3);
			// if the u & v are in the same cluster, but the operator is '!=', it's inconsistent
			if (equation.charAt(1) == '!' && find(u, parents) == find(v, parents)) {
				return false;
			}
		}
		return true;
    }
	
	// Find the cluster Id/root Id of 'u'
	// O(amortized(1))
	public int find(int u, int[] parents) {
		if (parents[u] != u) {
			parents[u] = find(parents[u], parents);// path compress, make tree becomes flat
		}
		return parents[u];
	}
}
