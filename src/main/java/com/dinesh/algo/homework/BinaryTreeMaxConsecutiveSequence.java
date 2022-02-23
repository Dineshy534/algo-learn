package com.dinesh.algo.homework;

import com.dinesh.algo.TreeNode;

public class BinaryTreeMaxConsecutiveSequence {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(4);
        int[] max = new int[1];

        maxConsecutiveSequence(root,0,0,max);
        System.out.println("Max Consecutive sequence possible "+ max[0] );
    }

    private static void maxConsecutiveSequence(TreeNode root, int count, int target, int[] max) {
        if(root==null){
            return ;
        }else if(count!=0 && root.value == target){
            count+=1;
        } else {
            count=1;
        }
        max[0] = Math.max(count,max[0]);
        maxConsecutiveSequence(root.left,count,root.value+1,max);
        maxConsecutiveSequence(root.right,count,root.value+1,max);

    }
}
