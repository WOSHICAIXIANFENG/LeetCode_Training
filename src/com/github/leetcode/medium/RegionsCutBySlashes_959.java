package com.github.leetcode.medium;

public class RegionsCutBySlashes_959 {

	public static void main(String[] args) {
		System.out.println("Cai Test size = " + "\\".length());
		System.out.println("Cai Test size = " + "\\/".length());
		RegionsCutBySlashes_959 obj = new RegionsCutBySlashes_959();
		String[] g1 = {" /", "/ "};
		System.out.println("Cai Test = " + obj.regionsBySlashes(g1));//2
		String[] g2 = {" /", "  "};
		System.out.println("Cai Test = " + obj.regionsBySlashes(g2));//1
		String[] g3 = {"\\/", "/\\"};
		System.out.println("Cai Test = " + obj.regionsBySlashes(g3));//4
		String[] g4 = {"/\\", "\\/"};
		System.out.println("Cai Test = " + obj.regionsBySlashes(g4));//5
	}

	// 6 ms, faster than 80.63% 
	
	// Approach 1: Split grid into 4 triangles and Union Find Faces. DisjointFindSet/ UnionFindSet
	// TC: O(n^2)
	// SC: O(n^2) --- disjointFindSet
	public int regionsBySlashes(String[] grid) {
	   final int n = grid.length;
	   DisjointSetUnion dsu = new DisjointSetUnion(4 * n * n);
	   for (int r = 0; r < n; r++)
		   for (int c = 0; c < n; c++) {
			   int index = 4 * (r * n + c);
			   switch (grid[r].charAt(c)) {
			   case '/':
				   dsu.merge(index + 0, index + 3);
				   dsu.merge(index + 1, index + 2);
				   break;
			   case ' ':
				   dsu.merge(index + 0, index + 1);
				   dsu.merge(index + 1, index + 2);
				   dsu.merge(index + 2, index + 3);
				   break;
			   case '\\':
				   dsu.merge(index + 0, index + 1);
				   dsu.merge(index + 2, index + 3);
				   break;
			   }
			   
			   // it is not the last row
			   if (r < n - 1) {
				   dsu.merge(index + 2, index + 4 * n + 0);
			   }
			   // it is not the last col
			   if (c < n - 1) {
				   dsu.merge(index + 1, index + 4 + 3);
			   }
		   }
	   
	   int ans = 0;
	   for (int i = 0; i < 4 * n * n; i++) {
		   if (dsu.find(i) == i) {//!!! UnionFindSet Alg!!!
			   ans++;
		   }
	   }
		      
       return ans; 
    }
}

class DisjointSetUnion {
	private int[] parents;
	
	public DisjointSetUnion(int n) {
		parents = new int[n];
		// initial parent to itself
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	// TC: O(amortized(1))
	public int find(int x) {
		if (parents[x] != x) {
			parents[x] = find(parents[x]);// path compress
		}
		return parents[x];
	}
	
	// Find its root/cluster Id of 'u'
    // TC: O(amortized(1))
    public int find2(int u) {
        while (parents[u] != u) {
            parents[u] = parents[parents[u]];// path compress
            u = parents[u];
        }
        return parents[u];
    }
	
	// TC: O(1)
	public void merge(int x, int y) {
		parents[find(x)] = find(y);
	}
}