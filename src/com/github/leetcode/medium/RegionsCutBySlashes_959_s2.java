package com.github.leetcode.medium;

public class RegionsCutBySlashes_959_s2 {

	public static void main(String[] args) {
		System.out.println("Cai Test size = " + "\\".length());
		System.out.println("Cai Test size = " + "\\/".length());
		RegionsCutBySlashes_959_s2 obj = new RegionsCutBySlashes_959_s2();
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
	
	// Approach 3: Piexlation (Upscale 3 times) --- then 4 directions search
	// TC: O(n^2)
	// SC: O(n^2)
	public int regionsBySlashes(String[] grid) {
	   final int n = grid.length;
	   int[][] g = new int[3 * n][3 * n];
	   for (int i = 0; i < n; i++)
		   for (int j = 0; j < n; j++) {
			   if (grid[i].charAt(j) == '/') {
				   g[i * 3 + 0][j * 3 + 2] = 1;
				   g[i * 3 + 1][j * 3 + 1] = 1;
				   g[i * 3 + 2][j * 3 + 0] = 1;
			   } else if (grid[i].charAt(j) == '\\') {
				   g[i * 3 + 0][j * 3 + 0] = 1;
				   g[i * 3 + 1][j * 3 + 1] = 1;
				   g[i * 3 + 2][j * 3 + 2] = 1;
			   }
		   }
	   
	   // 
	   int ans = 0;
	   for (int i = 0; i < 3 * n; i++)
		   for (int j = 0; j < 3 * n; j++) {
			   if (g[i][j] == 1) continue;
			   visit(i, j, n * 3, g);
			   ans++;
		   }
		 
	   return ans;
    }
	
	// BFS 4 directions search --- (x, y) 
	public void visit(int x, int y, int n, int[][] g) {
		if (x < 0 || x >= n || y < 0 || y >= n) return;
		if (g[x][y] == 1) return;
		g[x][y] = 1;
		visit(x + 1, y, n, g);
		visit(x - 1, y, n, g);
		visit(x, y + 1, n, g);
		visit(x, y - 1, n, g);
	}
}