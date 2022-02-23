package com.dinesh.algo.homework;

import com.dinesh.algo.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
 */

public class PathSum2 {
    public static void main(String[] args)
    {
        int[][] grid = new int[2][4];

        System.out.println(grid[0][0]);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> results = new ArrayList<>();

        findCombinations(results,root,targetSum,new ArrayList<>());
        return results;

    }

    private void findCombinations(List<List<Integer>> results,TreeNode root,int targetSum,List<Integer> current){
        if(root==null){
            return;
        }
        current.add(root.value);
        if(root.value == targetSum && root.left==null && root.right==null){
            results.add(current);
        }

        findCombinations(results,root.left,targetSum-root.value,new ArrayList<>(current));
        findCombinations(results,root.right,targetSum-root.value,new ArrayList<>(current));


    }
}
