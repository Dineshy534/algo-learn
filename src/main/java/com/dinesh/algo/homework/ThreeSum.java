package com.dinesh.algo.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:

Input: nums = [0]
Output: []

 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        //First Let's sort it out then
        //Let's take one element at a time..and iterate it through both the ends
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<=2){
            return res;
        }

        //Now iterate through array
        Arrays.sort(nums);
        for(int i=0; i+2<nums.length; i++){
            //First let's handle basic case
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //Now declare other pair
            int j=i+1;
            int k = nums.length-1;

            int target = -nums[i];

            while(j<k){
                if(nums[j]+nums[k] == target)
                {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;
                    j++;
                    while(j<k && nums[j] == nums[j-1]){j++;}
                    while(j<k && nums[k] == nums[k+1]){k--;}
                } else if(nums[j]+nums[k] > target){
                    k--;
                } else{
                    j++;
                }

            }
        }
        return res;

    }
}
