package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinIndexSumOfTwoList_599 {

	public static void main(String[] args) {
		MinIndexSumOfTwoList_599 test = new MinIndexSumOfTwoList_599();
		String[] array1 = new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] array2 = new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		
		System.out.println("Samuel Test output = " + Arrays.toString(test.findRestaurant(array1, array2)));
	
		String[] array3 = new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] array4 = new String[] {"KFC", "Shogun", "Burger King"};
		System.out.println("Samuel Test output = " + Arrays.toString(test.findRestaurant(array3, array4)));
	}
	
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();
		List<String> results = new ArrayList<>();
		for (int i = 0; i < list1.length; i ++) {
			map.put(list1[i], i);
		}
		
		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < list2.length; i ++) {
			if (map.containsKey(list2[i])) {
				if (i + map.get(list2[i]) < minSum) {
					minSum = i + map.get(list2[i]);
					results.clear();
					results.add(list2[i]);
				} else if (i + map.get(list2[i]) == minSum){
					results.add(list2[i]);
				}
			}
		}
		
        return results.toArray(new String[results.size()]);
    }
}
