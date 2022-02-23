package com.dinesh.algo;

public class MaxDepthOfABinaryTree {

    public static void main(String[] args) {
        //3,9,20,null,null,15,7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        /*root.right = new TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/
        //System.out.println(root);
        System.out.println("Maximum depth of the given binary tree is : " +maxDepth(root));
    }
//Learn the concept of tree traversal and recursive approach
    private static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth,rightDepth)+1;

    }


}

