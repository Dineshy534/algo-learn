package com.dinesh.algo.homework;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfGivenNumArray {

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(" Permutations are "+ subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums){
        //Idea here is DFS and backtrack
        List<List<Integer>> subsets = new ArrayList<>();

        generateSubsets(nums,new ArrayList<>() , 0, subsets);
        return subsets;
    }

    private static void generateSubsets(int[] nums, List<Integer> current, int index, List<List<Integer>> subsets) {

        subsets.add(new ArrayList<>(current));
        for(int i=index; i<nums.length ; i++){
            //index =0;
            current.add(nums[i]);
            generateSubsets(nums,current,i+1,subsets);//will go for 3 times
            //current got added [],[1],[2],[3]
            //current will have 1,2,3


            current.remove(current.size()-1);
            //index =0, remove3 Now 1, 2
            //
        }


    }


}
