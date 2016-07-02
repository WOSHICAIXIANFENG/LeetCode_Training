package com.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 * @author Samuel
 */
public class CombinationSum_2_Solution {
	 public static void main(String[] args) {
        int[]  a = new int[]{10, 1, 2, 7, 6, 1, 5, 1};

        List<List<Integer>> results = new CombinationSum_2_Solution().combinationSum2(a, 8);
        System.out.println("CombinationSum_2_Solution  results222 = " + results);
    } 
      

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null) {
            return result;
        }
        
        ArrayList<Integer> array = new ArrayList<Integer>();
        int[] nums = Arrays.copyOf(candidates, candidates.length);
        Arrays.sort(nums);
        dfs(nums, 0, target, array, result);
        return result;
    }
    
    void dfs(int[] nums, int start, int target, ArrayList<Integer> array, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(array));
            return;
        }
        
        if (start >= nums.length || nums[start] > target) {
            return;
        }
        
        int i = start;
        while (i < nums.length) {
            if (nums[i] <= target) {
                array.add(nums[i]);
                dfs(nums, i + 1, target - nums[i], array, result);
                array.remove(array.size() - 1);
                while(i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    i ++;
                }
            }
            i ++;
        }
    }
}