package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision_399 {

	public static void main(String[] args) {
		EvaluateDivision_399 obj = new EvaluateDivision_399();
		
	}

	// 1 ms, faster than 94.50%
	// Approach 1 : Graph + DFS
	// TC: O(V + q * E)
	// SC: O(V)
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        // build the graph:  expression --> value
        for (int i = 0; i < equations.size(); i++) {
        	String a = equations.get(i).get(0);
        	String b = equations.get(i).get(1);
        	double v = values[i];
        	Map<String, Double> mapB = graph.getOrDefault(a, new HashMap<>());
        	mapB.put(b, v);
        	graph.put(a, mapB);
        	
        	Map<String, Double> mapA = graph.getOrDefault(b, new HashMap<>());
        	mapA.put(a, 1.0 / v);
        	graph.put(b, mapA);
        }
        
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
        	String x = queries.get(i).get(0);
        	String y = queries.get(i).get(1);
        	if (!graph.containsKey(x) || !graph.containsKey(y)) {
        		ans[i] = -1.0;
        	} else {
        		Set<String> visited = new HashSet<>();
        		ans[i] = divide(x, y, visited, graph);
        	}
        }
        return ans;
    }
	
	// normal dfs alg --- this is not Topological Alg, because the visited array hold only one state
	// calculate x / y ---> (x / c) * (c / y)
	public double divide(String x, String y, Set<String> visited, Map<String, Map<String, Double>> graph) {
		if (x.equals(y)) return 1.0;
		// mark x is visited
		visited.add(x);
		
		for (String next : graph.get(x).keySet()) {
			// a/b ---> a, c ---> a, c, a? --> a, c, b ----> a/c * c/b
			// check if it has a cycle --- meet itself in the path
			if (visited.contains(next)) { //!!! to avoid dead loop
				continue;
			}
			double val = divide(next, y, visited, graph);
			if (val > 0) {
				//  calculate x / y ---> (x / c) * (c / y)
				return graph.get(x).get(next) * val;
			}
		}
		return -1.0;
	}
}
