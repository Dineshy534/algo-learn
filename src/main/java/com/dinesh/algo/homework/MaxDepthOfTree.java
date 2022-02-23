package com.dinesh.algo.homework;

import com.dinesh.algo.TreeNode;

public class MaxDepthOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(4);
        System.out.println("Max depth of Binary Tree"+maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
