package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarityII_737_s2 {

	public static void main(String[] args) {
		SentenceSimilarityII_737_s2 obj = new SentenceSimilarityII_737_s2();
		String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "drama", "talent"};
		String[][] pairs = {
				{"great", "good"},
				{"fine", "good"},
				{"acting","drama"},
				{"skills","talent"}
		};
		System.out.println("Cai Test = " + obj.areSentencesSimilarTwo(words1, words2, pairs));
	}

	// Approach 2: UnionFindSet
	// TC: O(pairs) + O(words)
	// SC: O(pairs)
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length) return false;
		
		// !!! -- how many vertexes? --- one pair is one edge, one edge has 2 vertexes
		// in the worst case, edges are not connected
		UnionFindSet3 s = new UnionFindSet3(pairs.length * 2);
		
		// word --> id
		// step2: create id mapping. --- convert word string to index
		Map<String, Integer> indies = new HashMap<>();
		for (String[] pair : pairs) {
			int u = createOrGetIndex(pair[0], indies);
			int v = createOrGetIndex(pair[1], indies);
			// use indexes to represent the two different words, do the union operate, because they are a pair
			s.union(u, v);
		}
		System.out.println("Cai Test unionFindSet = " + s);
		
		System.out.println("Cai Test indies = " + indies);
		
		// Now, each word has a different index, the cluster is in the UnionFindSet, it is a tree
		for (int i = 0; i < words1.length; i++) {
			if (words1[i] == words2[i]) continue;
			if (!indies.containsKey(words1[i]) || !indies.containsKey(words2[i])) {
				return false;
			}
			
			int u = indies.get(words1[i]);
			int v = indies.get(words2[i]);
			// convert the normal index to the cluster id/root
			if (s.find(u) != s.find(v)) return false;
		}
		
		return true;
	}

	public int createOrGetIndex(String word, Map<String, Integer> indies) {
		if (!indies.containsKey(word)) {
			int index = indies.size();
			indies.put(word, index);
			return index;
		}
		return indies.get(word);
	}
}

// 并查集的操作都是甚于 index 的，这样操作比较快 ，所以上列中我们需要建立一个indies的mapping表
class UnionFindSet3 {
	private int[] parents;
	private int[] ranks;
	public UnionFindSet3(int n) {
		this.parents = new int[n + 1];
		this.ranks = new int[n + 1];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
			ranks[i] = 1;
		}
	}
	
	// union/merge two clusters into one
	public boolean union(int u, int v) {
		int pu = find(u);
		int pv = find(v);
		if (pu == pv) {
			return false;// u, v are already in the same cluster
		}
		
		// merge lower rank cluster into the higher one
		if (ranks[pu] > ranks[pv]) {
			parents[pv] = pu;
		} else if (ranks[pu] < ranks[pv]) {
			parents[pu] = pv;
		} else {
			parents[pu] = pv;
			ranks[pv] += 1;
		}
		return true;
	}
	
	// find the root id/cluster id of u
	public int find(int u) {
		while (parents[u] != u) {
			parents[u] = parents[parents[u]];
			u = parents[u];
		}
		return u;
	}

	@Override
	public String toString() {
		return "UnionFindSet3 [parents=" + Arrays.toString(parents) + ", ranks=" + Arrays.toString(ranks) + "]";
	}
}
