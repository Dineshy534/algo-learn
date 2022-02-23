package com.dinesh.algo.homework;

import com.dinesh.algo.TreeNode;

public class BinaryTreeSumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left = null;
        //root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(4);
        int sum = sumOfLeftLeaves(root);
        System.out.println("Sum of Left Leaves"+ sum);

        /*
                 1
              2      3
          null  5  null  4
        * */
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        } else if(root.left!=null && root.left.left==null && root.left.right==null){
            return root.left.value+sumOfLeftLeaves(root.right);
        }else {
            return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        }
    }
}
