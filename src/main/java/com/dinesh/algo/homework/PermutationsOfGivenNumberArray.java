package com.dinesh.algo.homework;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfGivenNumberArray {
    public static void main(String[] args) {
        PermutationsOfGivenNumberArray permutations = new PermutationsOfGivenNumberArray();
        int[] nums = {1,2,3};
        permutations.permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), nums);
        return results;
    }

    void dfs(List<List<Integer>> results, List<Integer> path, int[] nums) {
        if(path.size() == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }
        else {
            for(int i = 0; i < nums.length; i++) {
                if(path.contains(nums[i]))
                    continue;
                path.add(nums[i]);
                dfs(results, path, nums);
                //1st iteration it'll add {1,2,3} then {1,3,2} then {2,1,3}
                path.remove(path.size() - 1); //#backtracking
            }
        }
    }
}
