package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarityII_737 {

	public static void main(String[] args) {
		SentenceSimilarityII_737 obj = new SentenceSimilarityII_737();
		String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "drama2", "talent"};
		String[][] pairs = {
				{"great", "good"},
				{"fine", "good"},
				{"acting","drama"},
				{"skills","talent"}
		};
		System.out.println("Cai Test = " + obj.areSentencesSimilarTwo(words1, words2, pairs));
	}

	// Approach 1: DFS --- Graph
	// TC: O(2 * pairs) build similar graph + O(2 * pairs)  build cluster id map + O(words)
	// SC: O(2 * pairs) graph, ids map
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length) return false;
		
		// step1: build the similar graph ---- double undirect
		Map<String, Set<String>> graph = new HashMap<>();
		for (String[] pair : pairs) {
			Set<String> smiliarSet = graph.getOrDefault(pair[0], new HashSet<>());
			smiliarSet.add(pair[1]);
			graph.put(pair[0], smiliarSet);
			
			Set<String> smiliarSet2 = graph.getOrDefault(pair[1], new HashSet<>());
			smiliarSet2.add(pair[0]);
			graph.put(pair[1], smiliarSet2);
		}
		
		// step2: build the cluster id map --- put all simliar words into one cluster, each cluster has a id
		Map<String, Integer> ids = new HashMap<>();
		int id = 0;
		for (String[] pair : pairs) {
			if (!ids.containsKey(pair[0])) {
				dfs(pair[0], id, ids, graph);
				id++;
			}
			if (!ids.containsKey(pair[1])) {
				dfs(pair[1], id, ids, graph);
				id++;
			}
		}
		
		// Step3: go through the word list to check if i-th words have the same cluster/root id
		for (int i = 0; i < words1.length; i++) {
			if (words1[i] == words2[i]) continue;
			
			// ignore those words are not in the simliar graph
			if (!ids.containsKey(words1[i]) || !ids.containsKey(words2[i])) {
				return false;
			}
			
			int id1 = ids.get(words1[i]);
			int id2 = ids.get(words2[i]);
			if (id1 != id2) {
				return false;
			}
		}
		
		return true;
	}
	
	// DFS alg to iterate all edge/similar next words
	// TC: O(n)
	public boolean dfs(String cur, int id, Map<String, Integer> ids, Map<String, Set<String>> graph) {
		ids.put(cur, id);
		for (String next : graph.get(cur)) {
			if (ids.containsKey(next)) continue;
			if (dfs(next, id, ids, graph)) return true;
		}
		return false;
	}
}
