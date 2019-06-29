package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision_399_s2 {

	public static void main(String[] args) {
		EvaluateDivision_399_s2 obj = new EvaluateDivision_399_s2();
		List<String> p1 = new ArrayList<>();
		p1.add("a");
		p1.add("b");
		
		List<String> p2 = new ArrayList<>();
		p2.add("b");
		p2.add("c");
		List<List<String>> e1 = new ArrayList<>();
		e1.add(p1);
		e1.add(p2);
		double[] v1 = new double[]{2.0, 3.0};
		
		List<String> q1 = new ArrayList<>();
		q1.add("a");
		q1.add("c");
		List<String> q2 = new ArrayList<>();
		q2.add("b");
		q2.add("a");
		List<String> q3 = new ArrayList<>();
		q3.add("a");
		q3.add("e");
		List<String> q4 = new ArrayList<>();
		q4.add("a");
		q4.add("a");
		List<List<String>> qu1 = new ArrayList<>();
		qu1.add(q1);
		qu1.add(q2);
		qu1.add(q3);
		qu1.add(q4);
		System.out.println("Cai Test = " + Arrays.toString(obj.calcEquation(e1, v1, qu1)));
	}

	// 1 ms, faster than 94.50%
	// Approach 2 : UnionFind Forest/Set
	// TC: O(V + q)
	// SC: O(V)
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		UnionFindSet u = new UnionFindSet();
		
		final int n = equations.size();
		for (int i = 0; i < n; i++) {
			u.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
		}
		
		int i = 0;
		double[] ans = new double[queries.size()];
		for (List<String> query : queries) {
			Node rx = u.find(query.get(0));
			Node ry = u.find(query.get(1));
			if (rx == null || ry == null || !rx.parent.equals(ry.parent)) {
				ans[i] = -1.0d;
			} else {
				ans[i] = rx.ratio / ry.ratio;
			}
			i++;
		}
		return ans;
    }
	
	class Node {
		public String parent;
		public double ratio;
		public Node(String parent, double ratio) {
			this.parent = parent;
			this.ratio = ratio;
		}
	}
	
	// Union Find Forest/Set ---- Disjoint Set
	class UnionFindSet {
		private Map<String, Node> parents = new HashMap<>();
		
		// find the cluster Node/ Root Node of s
		// TC: O(amortized(1))
		public Node find(String s) {
			if (!parents.containsKey(s)) return null;
			Node n = parents.get(s);
			if (!n.parent.equals(s)) {
				// path compress
				Node p = find(n.parent);
				n.parent = p.parent;
				n.ratio *= p.ratio;//!!!
			}
			return n;
		}
		
		// Union/Merge two clusters into one
		// TC: O(amortized(1))
		public void union(String s, String p, double ratio) {
			boolean hasS = parents.containsKey(s);
			boolean hasP = parents.containsKey(p);
			if (!hasS && !hasP) {
				parents.put(s, new Node(p, ratio));
				parents.put(p, new Node(p, 1.0));
			} else if (!hasP) {
				parents.put(p, new Node(s, 1.0 / ratio));
			} else if (!hasS) {
				parents.put(s, new Node(p, ratio));
			} else {
				Node rs = find(s);
				Node rp = find(p);
				rs.parent = rp.parent;
				rs.ratio = ratio / rs.ratio * rp.ratio;
			}
		}
	}
}
